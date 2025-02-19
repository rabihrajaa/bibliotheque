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
import model.Categorie;

/**
 *
 * @author DELL
 */
public class CategorieController implements Initializable {
      Connection cnx;
	public PreparedStatement st;
	public Resultset result; 

  
            @FXML
    private GridPane categorieContainer;
	private List<Categorie> recentlyAdded;
  int column =0;
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
			fxmlLoader.setLocation(getClass().getResource("/interfaces/CardCategorie.fxml"));
			HBox CardBox = fxmlLoader.load();
			CardCategorieController CardCController = fxmlLoader.getController();
			
			CardCController.setData((Categorie)recentlyAdded.get(i));
                         if(column==3){
                         column=0;
                                 ++row;}
                         categorieContainer.add(CardBox,column++,row);
                         GridPane.setMargin(CardBox, new Insets (10));
                        
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	 
    }  
    private List<Categorie> recentlyAdded() throws SQLException{
        
        
        String req=" select * from categories";
        ResultSet  rs =ConnexionMysql.select(req);
      List<Categorie> ls =new ArrayList<>();   
      while(rs.next()){	  
		   Categorie m = new Categorie();
                   m.setId(rs.getInt("idCat"));
		   m.setImageC(rs.getString(3));
		   m.setLibelle(rs.getString(2));
		   ls.add(m);                   
	  };
		  return ls;
		   
	   }
}
