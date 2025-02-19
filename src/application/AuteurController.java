/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AuteurController implements Initializable {

    /**
     * Initializes the controller class.
     */
     Connection cnx;
       @FXML
    private Button ajouter;

    @FXML
    private GridPane grid;

    @FXML
    private Button modifier;

    @FXML
    private TextField rechercher;

    @FXML
    private Button supprimer;
     private ToggleGroup tg = new ToggleGroup();

    @FXML
    void ajouter(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           try {
               // TODO
               cnx = ConnexionMysql.connexionDB();
           } catch (SQLException ex) {
               Logger.getLogger(AuteurController.class.getName()).log(Level.SEVERE, null, ex);
           }
         ResultSet rs=ConnexionMysql.select("SELECT \n" +
"\n" +
"u.idPersonne,\n" +
"p.nomPersonne,\n" +
"p.prenomPersonne,\n" +
"p.dateNaissancePersonne\n" +
"\n" +
"from auteurs u join personnes p on u.idPersonne=p.idPersonne;");
           
        grid.getChildren().clear();
        Label id = new Label("ID");
        id.maxWidth(Double.MAX_VALUE);
        id.setAlignment(Pos.CENTER);
        grid.add(id, 1, 0);
        Label nom = new Label("Nom");
        nom.maxWidth(Double.MAX_VALUE);
        nom.setAlignment(Pos.CENTER);
        grid.add(nom, 2, 0);
        Label prenom = new Label("Prenom");
        prenom.maxWidth(Double.MAX_VALUE);
        prenom.setAlignment(Pos.CENTER);
        grid.add(prenom, 3, 0);
        Label date = new Label("Date Naissance");
        date.maxWidth(Double.MAX_VALUE);
        date.setAlignment(Pos.CENTER);
        grid.add(date, 4, 0);
        int i = 1;
           try {
               while (rs.next()) {
                   RadioButton check_row = new RadioButton();
                   check_row.maxWidth(Double.MAX_VALUE);
                   check_row.setAlignment(Pos.CENTER);
                   check_row.setId(String.valueOf(rs.getInt("idPersonne")));
                   check_row.setToggleGroup(tg);
                   grid.add(check_row, 0, i);
                   Label id_row = new Label(String.valueOf(rs.getInt("idPersonne")));
                   id_row.maxWidth(Double.MAX_VALUE);
                   id_row.setAlignment(Pos.CENTER);
                   grid.add(id_row, 1, i);
                   Label nom_row = new Label(rs.getString("nomPersonne"));
                   nom_row.maxWidth(Double.MAX_VALUE);
                   nom_row.setAlignment(Pos.CENTER);
                   grid.add(nom_row, 2, i);
                   Label prenom_row = new Label(rs.getString("prenomPersonne"));
                   prenom_row.maxWidth(Double.MAX_VALUE);
                   prenom_row.setAlignment(Pos.CENTER);
                   grid.add(prenom_row, 3, i);
                   Label date_row = new Label(rs.getString("dateNaissancePersonne"));
                   date_row.maxWidth(Double.MAX_VALUE);
                   date_row.setAlignment(Pos.CENTER);
                   grid.add(date_row, 4, i);
                 
                   i++;
               }  } catch (SQLException ex) {
               Logger.getLogger(AuteurController.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        
    }


    @FXML
    void afficher(ActionEvent event) {

    }

    
    
}

