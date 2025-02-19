/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import application.ConnexionMysql;
import com.mysql.cj.protocol.Resultset;
import static controllers.CardCategorieController.idc;
import javafx.scene.control.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Autheur;
import model.Categorie;
import model.Materiel;

/**
 *
 * @author DELL
 */
public class cardAutheurController  implements Initializable{
    
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
    private Label text_nomAutheur;
		
	       @FXML
    private Button btnA;
   public static int  idA ; 
 
               
               
   @FXML
    void AfficherCardinfoAutheur(ActionEvent event) throws IOException {
      idA= Integer.parseInt(btnA.getId());
     System.out.println(idA);
    
      
                    Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AutheurInfo.fxml"));
                        Stage stage=new Stage();
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
                    stage.setScene(scene);
                  stage.setTitle("");
                      stage.show();

     
        
    }	   
	    
	    
	    public void setData(Autheur A) throws SQLException {
       
//              Image Imagee = new Image(getClass().getResourceAsStream(m.getImageSRC())) {
//	    	imageFx.setImage(null);
        
       String req=" select * from materiels where idPersonne="+A.getIdPersonne();   
        ResultSet  rs =ConnexionMysql.select(req);
        if(rs.next()){
         
         	nom_Mat.setText(rs.getString("nomMat"));
                btn_emprunter.setId(String.valueOf(rs.getInt("idMat"))); 
        }
                btnA.setId(String.valueOf(A.getIdPersonne()));
	    	text_nomAutheur.setText(A.getNomPersonne()+"  "+A.getPrenomPersonne());	        
               
                
                
	        
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
