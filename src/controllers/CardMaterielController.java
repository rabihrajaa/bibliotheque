/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import application.ConnexionMysql;
import application.Controller;
import com.mysql.cj.protocol.Resultset;
import static controllers.CardCategorieController.idc;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Categorie;
import model.Materiel;

/**
 *
 * @author DELL
 */
public class CardMaterielController  implements Initializable {
      @FXML
    public static int idM;
    	   Connection cnx;
		public PreparedStatement st;
		public Resultset result; 
                
                    @FXML
    private Button btn_emprunter;

    @FXML
    private ImageView imageFx;

    @FXML
    private Label nom_Mat;

           @FXML
    void emprunter(ActionEvent event) throws IOException, SQLException {
     idM= Integer.parseInt(btn_emprunter.getId());
     System.out.println(idM);
     
       AjouterEmprute();
     
     
    }
	   
           private void AjouterEmprute() throws SQLException{
              
        int  i = 0;
        if(btn_emprunter.getText().equals("Emprunter")){
        LocalDateTime dateEm= LocalDateTime.now();  
          String mydate=dateEm.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(mydate);
        String req="insert into emprunts (`idPersonne`, `idUser`, `idCat`, `idMat`, `dateEmprunt`,`status`) "
                + "VALUES ("+Controller.idUser_test+","+Controller.idPersonne_test+","+idc+","+idM+",'"+mydate+"','En attent')";
            i =ConnexionMysql.ajouter(req);
          btn_emprunter.setText("Annuler");
        }else if (btn_emprunter.getText().equals("Annuler")){
        String req1 ="select max(idEmprunt) as  max from Emprunts";
         
          ResultSet  rs =ConnexionMysql.select(req1);
          if(rs.next()){
        String req="delete from emprunts where idEmprunt="+rs.getInt("max");
            i =ConnexionMysql.ajouter(req);
            btn_emprunter.setText("Emprunter");
        }
        
         
        
        
        
		   
	   }}
	    
	    
           	    public void setData(Materiel M) {
//	    	Image image = new Image(getClass().getResourceAsStream(C.getImageC()));
//	    	imageC.setImage(image);
	    	nom_Mat.setText(M.getNomMat());
                btn_emprunter.setId(String.valueOf(M.getIdMat()));
                if(M.Emprunt==0){
                 btn_emprunter.setText("Emprunter");
                
                }else{
                 btn_emprunter.setText("Annuler");
                }
                
                
	   
	    }
		
	    
	    @Override
	    
		 
	    public void initialize(URL arg0, ResourceBundle arg1) {
	        // TODO Auto-generated method stub
		   try {
			cnx= ConnexionMysql.connexionDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	    }
    
}
