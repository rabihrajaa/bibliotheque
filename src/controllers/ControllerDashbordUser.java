/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author DELL
 */
public class ControllerDashbordUser implements Initializable {
            @FXML
    private AnchorPane root;
    @FXML
    void nouveauxM(MouseEvent event) throws IOException{
        
       AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaces/NewDocument.fxml"));
       root.getChildren().setAll(pane);
    }
    
    
    @FXML
    void Document(MouseEvent event) throws IOException {
     AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaces/Materiel.fxml"));
       root.getChildren().setAll(pane);
    }

  
 
    
    
        @FXML
    void Autheur(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaces/Autheur.fxml"));
       root.getChildren().setAll(pane);
    }
    
         @FXML
   void emprunter(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaces/MaterielEmprunter.fxml"));
       root.getChildren().setAll(pane);
    }
    
    @FXML
    void favoris(MouseEvent event) throws IOException {
AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaces/favoris.fxml"));
       root.getChildren().setAll(pane);
    }
       
    
    

    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }

  
	
    
    
}
