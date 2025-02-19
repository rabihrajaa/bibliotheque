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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Autheur;
import model.Categorie;

/**
 *
 * @author DELL
 */
public class AutheurControllers  implements Initializable {

    Connection cnx;
    public PreparedStatement st;
    public Resultset result; 
            @FXML
    private GridPane AutheurContainer;
    private List<Autheur> recentlyAdded;
    int column =1;
    int row = 1;
    @Override
	 
    public void initialize(URL arg0, ResourceBundle arg1) {
          try {
              // TODO Auto-generated method stub

              recentlyAdded = new ArrayList<>(recentlyAdded());
          } catch (SQLException ex) {
              Logger.getLogger(CategorieController.class.getName()).log(Level.SEVERE, null, ex);
          }
    	try {
            
		for(int i=0 ;i<recentlyAdded.size();i++) {
			FXMLLoader fxmlLoader =new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/interfaces/cardAuteur.fxml"));
            
			VBox CardBox = fxmlLoader.load();
			cardAutheurController CardCController = fxmlLoader.getController();			
			CardCController.setData((Autheur)recentlyAdded.get(i));
                         if(column==3){
                         column=1;
                         ++row; }
                         AutheurContainer.add(CardBox,column++,row);
                         GridPane.setMargin(CardBox, new Insets (10));
                        
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException ex) {
            Logger.getLogger(AutheurControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
	   
	 
    }  
    private List<Autheur> recentlyAdded() throws SQLException{
        
        String req=" select * from personnes p join auteurs a where p.idpersonne=a.idpersonne";   
        ResultSet  rs =ConnexionMysql.select(req);
       
      List<Autheur> ls =new ArrayList<>();   
      while(rs.next()){	  
		   Autheur m = new Autheur(rs.getInt("idPersonne"),rs.getString("nomPersonne"),rs.getString("prenomPersonne"));
                   
		   ls.add(m);                   
	  };
		  return ls;
		   
	   }
 
    
}
