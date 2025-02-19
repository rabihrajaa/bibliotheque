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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class CategorieController implements Initializable {
    
     private ToggleGroup tg = new ToggleGroup();

     @FXML
    private GridPane grid;
     Connection cnx;

    @FXML
    void ajouter(ActionEvent event) {
         try {
			Parent root = FXMLLoader.load(getClass().getResource("AjouterCategorie.fxml"));
                        Stage stage=new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("ajouter Catégorie");
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void modifier(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            cnx = ConnexionMysql.connexionDB();
        } catch (SQLException ex) {
            Logger.getLogger(ListeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rs = ConnexionMysql.select("SELECT * from categories;");

        grid.getChildren().clear();
        //Member m;
        Label id = new Label("ID");
        id.maxWidth(Double.MAX_VALUE);
        id.setAlignment(Pos.CENTER);
        grid.add(id, 1, 0);
        Label login = new Label("Libelle");
        login.maxWidth(Double.MAX_VALUE);
        login.setAlignment(Pos.CENTER);
        grid.add(login, 2, 0);
       
        int i = 1;
         try {
             while (rs.next()) {
                 RadioButton check_row = new RadioButton();
                 check_row.maxWidth(Double.MAX_VALUE);
                 check_row.setAlignment(Pos.CENTER);
                 check_row.setId(String.valueOf(rs.getInt("idCat")));
                 check_row.setToggleGroup(tg);
                 grid.add(check_row, 0, i);
                 Label id_row = new Label(String.valueOf(rs.getInt("idCat")));
                 id_row.maxWidth(Double.MAX_VALUE);
                 id_row.setAlignment(Pos.CENTER);
                 grid.add(id_row, 1, i);
                 Label login_row = new Label(rs.getString("libelleCat"));
                 login_row.maxWidth(Double.MAX_VALUE);
                 login_row.setAlignment(Pos.CENTER);
                 grid.add(login_row, 2, i);
                 
                 i++;
             }} catch (SQLException ex) {
             Logger.getLogger(CategorieController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
}
