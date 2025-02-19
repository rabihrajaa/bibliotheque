package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.cj.protocol.Resultset;

import application.ConnexionMysql;
import application.Controller;
import static controllers.CardCategorieController.idc;
import static controllers.ControllerTypeMateriel.m;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Materiel;

public class ControllerNewDocument implements Initializable {
   Connection cnx;
	public PreparedStatement st;
	public Resultset result; 
	@FXML
    private VBox cardLayouth;
	private List<Materiel> recentlyAdded;
           @FXML
    private GridPane BookContainer;
             int column =0;
            int row = 1;
  
    
    @Override
	 
    public void initialize(URL arg0, ResourceBundle arg1) {
       try {
           // TODO Auto-generated method stub

           recentlyAdded = new ArrayList<>(recentlyAdded());
       } catch (SQLException ex) {
           Logger.getLogger(ControllerNewDocument.class.getName()).log(Level.SEVERE, null, ex);
       }
    	try {
		for(int i=0 ;i<recentlyAdded.size();i++) {
			FXMLLoader fxmlLoader =new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/interfaces/CardMateriel.fxml"));
			VBox CardBox = fxmlLoader.load();
			CardMaterielController CardCController = fxmlLoader.getController();
			
			CardCController.setData((Materiel)recentlyAdded.get(i));
                         if(column==4){
                         column=0;
                                 ++row;}
                         BookContainer.add(CardBox,column++,row);
                         GridPane.setMargin(CardBox, new Insets (10));
                 
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	 
    }  
    private List<Materiel> recentlyAdded() throws SQLException{
		 String req=" SELECT m.photoMat, m.idMat,m.nomMat,COUNT(*) AS Count FROM materiels m INNER JOIN   emprunts e GROUP BY m.nomMat ORDER BY Count DESC LIMIT 5";
                   ResultSet  rs =ConnexionMysql.select(req);
                   String req1;
                   List<Materiel> ls =new ArrayList<>();
                   while(rs.next()){	
                 req1="select * from emprunts e , materiels m \n" +
"where e.idMat = "+rs.getInt("idMat")+"  and e.idPersonne="+Controller.idPersonne_test+" and e.idUser="+Controller.idUser_test; 
                
                  
		   Materiel m = new Materiel();
                   ResultSet  rs1 =ConnexionMysql.select(req1);
	
                   m.setIdMat(rs.getInt("idMat"));
		   m.setNomMat(rs.getString("nomMat"));
		   m.setPhotoMat(rs.getString("photoMat"));
                     if(rs1.next()){ m.Emprunt = 1;}else{ m.Emprunt=0;}
                  
	
		   ls.add(m); }
		  return ls;
                  
                  
                  
   
}
}
