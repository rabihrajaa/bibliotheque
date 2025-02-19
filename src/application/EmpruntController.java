/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class EmpruntController implements Initializable {
     private ToggleGroup tg = new ToggleGroup();
     public static int idu;
 Connection cnx;
   @FXML
    private GridPane grid;
    @FXML
    private TextField rechercher;

    @FXML
    void ajouter(ActionEvent event) {
      RadioButton rb = (RadioButton)tg.getSelectedToggle();
                   idu=Integer.parseInt (rb.getId()) ;
      int i =ConnexionMysql.ajouter("update emprunts set status='accepter' where idEmprunt="+idu);
      if(i==0){
        Alert alert = new Alert(Alert.AlertType.ERROR," erreur ",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION," l'emprunt est accepter",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }
    }

    @FXML
    void modifier(ActionEvent event) {
     RadioButton rb = (RadioButton)tg.getSelectedToggle();
                   idu=Integer.parseInt (rb.getId()) ;
      int i =ConnexionMysql.ajouter("update emprunts set status='refuser' where idEmprunt="+idu);
      if(i==0){
        Alert alert = new Alert(Alert.AlertType.ERROR," erreur ",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION," l'emprunt est refuser",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
         // TODO
         cnx = ConnexionMysql.connexionDB();
     } catch (SQLException ex) {
         Logger.getLogger(EmpruntController.class.getName()).log(Level.SEVERE, null, ex);
     }
        ResultSet rs = ConnexionMysql.select("select idEmprunt,nomPersonne,libelleCat,nomMat,status from emprunts e,personnes p,\n" +
"categories c,materiels m where\n" +
"p.idPersonne=e.idPersonne AND c.idCat= e.idCat AND\n" +
"m.idMat=e.idMat;");

        grid.getChildren().clear();
        //Member m;
        Label id = new Label("ID");
        id.maxWidth(Double.MAX_VALUE);
        id.setAlignment(Pos.CENTER);
        grid.add(id, 1, 0);
        Label login = new Label("Personne");
        login.maxWidth(Double.MAX_VALUE);
        login.setAlignment(Pos.CENTER);
        grid.add(login, 2, 0);
        Label nom = new Label("Catégorie");
        nom.maxWidth(Double.MAX_VALUE);
        nom.setAlignment(Pos.CENTER);
        grid.add(nom, 3, 0);
        Label prenom = new Label("Matériel");
        prenom.maxWidth(Double.MAX_VALUE);
        prenom.setAlignment(Pos.CENTER);
        grid.add(prenom, 4, 0);
        
        Label preno = new Label("Status");
        preno.maxWidth(Double.MAX_VALUE);
        preno.setAlignment(Pos.CENTER);
        grid.add(preno, 5, 0);
       
        int i = 1;
     try {
         while (rs.next()) {
             RadioButton check_row = new RadioButton();
             check_row.maxWidth(Double.MAX_VALUE);
             check_row.setAlignment(Pos.CENTER);
             check_row.setId(String.valueOf(rs.getInt("idEmprunt")));
             check_row.setToggleGroup(tg);
             grid.add(check_row, 0, i);
             Label id_row = new Label(String.valueOf(rs.getInt("idEmprunt")));
             id_row.maxWidth(Double.MAX_VALUE);
             id_row.setAlignment(Pos.CENTER);
             grid.add(id_row, 1, i);
             Label login_row = new Label(rs.getString("nomPersonne"));
             login_row.maxWidth(Double.MAX_VALUE);
             login_row.setAlignment(Pos.CENTER);
             grid.add(login_row, 2, i);
             Label nom_row = new Label(rs.getString("libelleCat"));
             nom_row.maxWidth(Double.MAX_VALUE);
             nom_row.setAlignment(Pos.CENTER);
             grid.add(nom_row, 3, i);
             Label prenom_row = new Label(rs.getString("nomMat"));
             prenom_row.maxWidth(Double.MAX_VALUE);
             prenom_row.setAlignment(Pos.CENTER);
             grid.add(prenom_row, 4, i);
             
             Label st = new Label(rs.getString("status"));
             st.maxWidth(Double.MAX_VALUE);
             st.setAlignment(Pos.CENTER);
             grid.add(st, 5, i);
             
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(EmpruntController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }    
    
}
