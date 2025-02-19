/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Autheur;
import model.Categorie;

/**
 *
 * @author DELL
 */
public class ControllerCardInfoAutheur implements Initializable {
        
  @FXML 
  Label AutheurName;
  

     @FXML
    private TextArea descreption;

 
    @FXML 
    private ImageView imageAutheur;
    
 
     	    public void setData(Autheur A) {
//	    	Image image = new Image(getClass().getResourceAsStream(C.getImageC()));
//	    	imageC.setImage(image);
	    	AutheurName.setText(A.getNomPersonne()+" "+A.getPrenomPersonne());
              
                descreption.setText(A.getDescreption());
                descreption.setWrapText(true);
                
             
	   
	    }
    
    
    
    
    
    

      @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}
