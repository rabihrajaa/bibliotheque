package application;

import static application.ListeMemberController.idu;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MaterielController implements Initializable{
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
    void ajouter(ActionEvent event) throws SQLException {
     
    }

    @FXML
    void modifier(ActionEvent event) {
    try {
			Parent root = FXMLLoader.load(getClass().getResource("ModifierMat.fxml"));
                        Stage stage=new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Modifier Matériel");
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
       
       RadioButton rb = (RadioButton)tg.getSelectedToggle();
                   idu=Integer.parseInt (rb.getId()) ;
    }

    @FXML
    void supprimer(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            cnx=ConnexionMysql.connexionDB();
        } catch (SQLException ex) {
            Logger.getLogger(MaterielController.class.getName()).log(Level.SEVERE, null, ex);
        }
     ResultSet rs = ConnexionMysql.select("select idMat,nomMat,descriptionMat,libelleCat,NomPersonne,libelleType from materiels m,\n" +
"categories c,typesmateriels t,personnes p WHERE\n" +
"m.idCat=c.idCat and m.idType=t.idType and m.idPersonne=p.idPersonne;");

        grid.getChildren().clear();
        //Member m;
        Label id = new Label("ID");
        id.maxWidth(Double.MAX_VALUE);
        id.setAlignment(Pos.CENTER);
        grid.add(id, 1, 0);
        Label login = new Label("nomMat");
        login.maxWidth(Double.MAX_VALUE);
        login.setAlignment(Pos.CENTER);
        grid.add(login, 2, 0);
        Label nom = new Label("Type");
        nom.maxWidth(Double.MAX_VALUE);
        nom.setAlignment(Pos.CENTER);
        grid.add(nom, 3, 0);
        Label prenom = new Label("Catégorie");
        prenom.maxWidth(Double.MAX_VALUE);
        prenom.setAlignment(Pos.CENTER);
        grid.add(prenom, 4, 0);
        Label email = new Label("description");
        email.maxWidth(Double.MAX_VALUE);
        email.setAlignment(Pos.CENTER);
        grid.add(email, 5, 0);
        
        Label auteur = new Label("Auteur");
        auteur.maxWidth(Double.MAX_VALUE);
        auteur.setAlignment(Pos.CENTER);
        grid.add(auteur, 6, 0);
        
        int i = 1;
        try {
            while (rs.next()) {
                RadioButton check_row = new RadioButton();
                check_row.maxWidth(Double.MAX_VALUE);
                check_row.setAlignment(Pos.CENTER);
                check_row.setId(String.valueOf(rs.getInt("idMat")));
                check_row.setToggleGroup(tg);
                grid.add(check_row, 0, i);
                Label id_row = new Label(String.valueOf(rs.getInt("idMat")));
                id_row.maxWidth(Double.MAX_VALUE);
                id_row.setAlignment(Pos.CENTER);
                grid.add(id_row, 1, i);
                Label login_row = new Label(rs.getString("nomMat"));
                login_row.maxWidth(Double.MAX_VALUE);
                login_row.setAlignment(Pos.CENTER);
                grid.add(login_row, 2, i);
                Label nom_row = new Label(rs.getString("libelleType"));
                nom_row.maxWidth(Double.MAX_VALUE);
                nom_row.setAlignment(Pos.CENTER);
                grid.add(nom_row, 3, i);
                Label prenom_row = new Label(rs.getString("libelleCat"));
                prenom_row.maxWidth(Double.MAX_VALUE);
                prenom_row.setAlignment(Pos.CENTER);
                grid.add(prenom_row, 4, i);
                Label email_row = new Label(rs.getString("descriptionMat"));
                email_row.maxWidth(Double.MAX_VALUE);
                email_row.setAlignment(Pos.CENTER);
                grid.add(email_row, 5, i);
                
                Label auteur_row = new Label(rs.getString("NomPersonne"));
                auteur_row.maxWidth(Double.MAX_VALUE);
                auteur_row.setAlignment(Pos.CENTER);
                grid.add(auteur_row, 6, i);
                
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterielController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

}
