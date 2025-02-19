package application;

import static groovyjarjarantlr.build.ANTLR.root;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class dashboardController implements Initializable{

    @FXML
    private AnchorPane panel;
    
      
    @FXML
    private Label nom_admin;

    @FXML
    void admin_profile(MouseEvent event) {

    }

    @FXML
    void auteur(ActionEvent event) throws IOException {
     AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/Auteur.fxml"));
       panel.getChildren().setAll(pane);
    }

    @FXML
    void categorie(ActionEvent event) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/Categorie.fxml"));
       panel.getChildren().setAll(pane);
    }

    @FXML
    void dash(ActionEvent event) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
       panel.getChildren().setAll(pane);
    }

    @FXML
    void emprunt(ActionEvent event) throws IOException {
      AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/Emprunt.fxml"));
       panel.getChildren().setAll(pane);
    }

    @FXML
    void materiel(ActionEvent event) throws IOException {
     AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/Materiel.fxml"));
       panel.getChildren().setAll(pane);
    }

    @FXML
    void member(ActionEvent event) throws IOException {
     AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/ListeMember.fxml"));
       panel.getChildren().setAll(pane);
    }

    @FXML
    void message(ActionEvent event) throws IOException {
     AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/Message.fxml"));
       panel.getChildren().setAll(pane);
    }

    @FXML
    void param(ActionEvent event) throws IOException {
      AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/Edit_Password.fxml"));
       panel.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
         
    }

}
