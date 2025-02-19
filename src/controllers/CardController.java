package controllers;

import java.awt.Image;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.protocol.Resultset;

import application.ConnexionMysql;

import javafx.fxml.Initializable;

import javafx.scene.paint.Color;
import model.Autheur;
import model.Materiel;

public class CardController implements Initializable {
	   Connection cnx;
		public PreparedStatement st;
		public Resultset result; 
		
	    @FXML
	    private Label author;

	    @FXML
	    private ImageView image;
	    @FXML
	    private HBox box;

	    @FXML
	    private Label matNom;
	    private String[] colors = {"B9ESFF","BDB2FE","FB9AAB","FF5856"};
	    
	    
	    public void setData(Autheur m) {
//	    	Image Imagee = new Image(getClass().getResourceAsStream(m.getImageSRC()));
//	    	image.setImage(null);
//	    	matNom.setText(m.getName());
//	    	author.setText(m.getAuthor());
	    
	    
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
