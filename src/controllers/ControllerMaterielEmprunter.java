/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import application.ConnexionMysql;
import application.Controller;
import static application.Controller.idPersonne_test;
import com.mysql.cj.protocol.Resultset;
import static controllers.CardCategorieController.idc;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Categorie;
import model.Materiel;

/**
 *
 * @author DELL
 */
public class ControllerMaterielEmprunter implements Initializable {
        @FXML
    private GridPane BookContainer;
     Connection cnx;
		public PreparedStatement st;
		public Resultset result;
                private List<Materiel> recentlyAdded;
                                 @FXML
  

                int column =0;
                int row = 1;
                public static  int m ;
                
           String req="SELECT m.nomMat, m.photoMat ,m.idMat FROM Materiels m , emprunts e where  m.idMat= e.idMat and e.idPersonne="+idPersonne_test;
           String req2="SELECT m.nomMat, m.photoMat ,m.idMat FROM Materiels m , emprunts e where  m.idMat= e.idMat and e.idPersonne="+idPersonne_test+" and status = 'Refuser'";
           String req3="SELECT m.nomMat, m.photoMat ,m.idMat FROM Materiels m , emprunts e where  m.idMat= e.idMat and e.idPersonne="+idPersonne_test+" and status = 'Accepter'";
           String req4="SELECT m.nomMat, m.photoMat ,m.idMat FROM Materiels m , emprunts e where  m.idMat= e.idMat and e.idPersonne="+idPersonne_test+" and dateRetour is not null";
           String req5="SELECT m.nomMat, m.photoMat ,m.idMat FROM Materiels m , emprunts e where  m.idMat= e.idMat and e.idPersonne="+idPersonne_test+" and status ='En attent'";
        @Override
        public void initialize(URL arg0, ResourceBundle arg1)  { 
       
  
		   
	    }
        
    @FXML
    void Accepter(ActionEvent event) {
        upload(req3);
    }
       @FXML
    void Retourner(ActionEvent event) {
            upload(req4);
    }

    @FXML
    void attent(ActionEvent event) {
  upload(req5);
    }    
        
        @FXML
    void Refuser(ActionEvent event) {
         upload( req2);
    }    
            @FXML
    void tousLesMat(ActionEvent event) {
            upload( req);
    }
            
    void upload(String req) {
        
            	try {
            recentlyAdded = new ArrayList<>(recentlyAdded1( req));
              BookContainer.getChildren().clear();
		for(int i=0 ;i<recentlyAdded.size();i++) {
			FXMLLoader fxmlLoader =new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/interfaces/CardMateriel.fxml"));
			VBox CardBox = fxmlLoader.load();
			CardMaterielController CardCController = fxmlLoader.getController();			
			CardCController.setData((Materiel)recentlyAdded.get(i));
                        
                         if(column==3){
                         column=0;
                                 ++row;}
                        
                         BookContainer.add(CardBox,column++,row);
                         GridPane.setMargin(CardBox, new Insets (10));
                        
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   catch (SQLException ex) {
                Logger.getLogger(ControllerMaterielEmprunter.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
        
        
       private List<Materiel> recentlyAdded1(String req) throws SQLException{
            List<Materiel> ls =new ArrayList<>();   
        
        System.out.println(idPersonne_test+"dde");
        ResultSet  rs =ConnexionMysql.select(req);
        
       
      while(rs.next()){	  
          String req1;
     ResultSet  rs1 =ConnexionMysql.select(req);
     req1="select * from emprunts e , materiels m \n" +
"where e.idMat = "+rs.getInt("idMat")+"  and e.idPersonne="+Controller.idPersonne_test+" and e.idUser="+Controller.idUser_test;
	   ResultSet  rs2 =ConnexionMysql.select(req1);
                   Materiel m = new Materiel();
                   m.setIdMat(rs.getInt("idMat"));
		   m.setNomMat(rs.getString("nomMat"));
		   m.setPhotoMat(rs.getString("photoMat"));
              
     if(rs2.next()){ m.Emprunt = 1;}else{ m.Emprunt=0;}
		   ls.add(m);  
      
	  };
		  return ls;
		   
	   }    
        
}

