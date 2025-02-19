/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

   
import application.ConnexionMysql;
import application.Controller;
import static controllers.CardCategorieController.idc;
import java.io.IOException;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Categorie;
import model.Materiel;
import model.TypeMateriel;

public class ControllerTypeMateriel implements Initializable{
  ObservableList<TypeMateriel> options = FXCollections.observableArrayList();
  	private List<Materiel> recentlyAdded;
            @FXML
    private GridPane BookContainer;
  int column =0;
            int row = 1;
   public static  int m ;
    @FXML
    private ComboBox<TypeMateriel> TypeM ;

         @FXML
    void setEventOnM() {
         TypeM.setOnKeyReleased(event -> {
        if (event.getCode().equals(KeyCode.ENTER)) {
            TypeMateriel M = TypeM.getSelectionModel().getSelectedItem();
            m=M.getIdType();
            System.out.println(M.getIdType());
              try {
              // TODO Auto-generated method stub

              recentlyAdded = new ArrayList<>(recentlyAdded());
          } catch (SQLException ex) {
              Logger.getLogger(CategorieController.class.getName()).log(Level.SEVERE, null, ex);
          }
    	try {
            BookContainer.getChildren().clear();
             
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
    });
    }
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      try {
          
          
          TypeM.setItems(fillcombobox());
          setEventOnM();
       
      } catch (SQLException ex) {
          Logger.getLogger(ControllerTypeMateriel.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
     public ObservableList<TypeMateriel>  fillcombobox() throws SQLException{
        String req=" select * from typesmateriels";
        ResultSet  rs =ConnexionMysql.select(req);
           while(rs.next()){	  
		 options.add(new TypeMateriel(rs.getInt("idType"),rs.getString("libelleType"))) ;
	  };
          return options;
      }
         private List<Materiel> recentlyAdded() throws SQLException{
        
        
        String req="select * from materiels where idCat="+idc+" and idType="+m;
        ResultSet  rs =ConnexionMysql.select(req);
      List<Materiel> ls =new ArrayList<>(); 
      String req1;
      while(rs.next()){	  
        
      req1="select * from emprunts e , materiels m, typesmateriels t \n" +
"where m.idType = t.idType and e.idMat = "+rs.getInt("idMat")+" and m.idCat="+idc+" and e.idPersonne="+Controller.idPersonne_test+" and e.idUser="+Controller.idUser_test+" and t.idType="+m; 
     ResultSet  rs1 =ConnexionMysql.select(req1);
		   Materiel m = new Materiel();
                   m.setIdMat(rs.getInt("idMat"));
		   m.setNomMat(rs.getString("nomMat"));
		   m.setPhotoMat(rs.getString("photoMat"));
                     if(rs1.next()){ m.Emprunt = 1;}else{ m.Emprunt=0;}
		   ls.add(m);  
      
	  };
		  return ls;
		   
	   }
}
