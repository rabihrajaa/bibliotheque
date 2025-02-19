/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import application.ConnexionMysql;
import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Categorie;
import model.Materiel;

/**
 *
 * @author DELL
 */
public class CardCategorieController implements Initializable{
   
    @FXML
    public static int idc;

     Connection cnx;
		public PreparedStatement st;
		public Resultset result; 
		
	       @FXML
               private ImageView imageC;

                @FXML
                private Label libelle_cat;
                
    @FXML
    private Button afficher;
    
        @FXML
    void afficherC(ActionEvent event) throws IOException {
     idc= Integer.parseInt(afficher.getId());
     System.out.println(idc);
    
    
       try {
                    Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Type_materiel.fxml"));
                        Stage stage=new Stage();
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
                    stage.setScene(scene);
                  stage.setTitle("");
                      stage.show();

} catch(Exception e) {
e.printStackTrace();
}
     
 
     
     
    }
	   
	    
	    
	    public void setData(Categorie C) {
//	    	Image image = new Image(getClass().getResourceAsStream(C.getImageC()));
//	    	imageC.setImage(image);
	    	libelle_cat.setText(C.getLibelle());
                afficher.setId(String.valueOf(C.getId()));
             
	   
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

