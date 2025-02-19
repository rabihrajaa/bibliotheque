/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ModifierMatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox<?> auteur;

    @FXML
    private ComboBox<?> categorie;

    @FXML
    private TextArea des;

    @FXML
    private TextField nom;

    @FXML
    private ComboBox<?> type;

    @FXML
    void ajouter_user(ActionEvent event) {

    }

    @FXML
    void annuler(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
