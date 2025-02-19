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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection cnx;
    int id=ListeMemberController.idu;
     @FXML
    private TextField cin;

    @FXML
    private TextField date_naissance;

    @FXML
    private TextField email;

    @FXML
    private TextField login;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    void modifier(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
            cnx = ConnexionMysql.connexionDB();
        } catch (SQLException ex) {
            Logger.getLogger(ModifierUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
       
        ResultSet rs = ConnexionMysql.select("SELECT * from users u join personnes p\n"
                + "on u.idPersonne=p.idPersonne where idUser='"+id+"'");
        
        try {
            if(rs.next()){
            cin.setText(rs.getString("cin"));
              email.setText(rs.getString("email"));
               nom.setText(rs.getString("nomPersonne"));
                prenom.setText(rs.getString("prenomPersonne"));
                 login.setText(rs.getString("login"));
               date_naissance.setText("dateNaissancePersonne");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModifierUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
