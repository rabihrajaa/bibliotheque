package application;

import com.mysql.cj.protocol.Resultset;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ModifierUserController implements Initializable{
    Connection cnx;

    @FXML
    private TextField cin_text;

    @FXML
    private DatePicker date;

    @FXML
    private TextField email;

    @FXML
    private TextField nom_text;

    @FXML
    private TextField nom_u_text;


    @FXML
    private TextField prenom_text;
int id=ListeMemberController.idu;
    @FXML
    void Modifier_user(ActionEvent event) throws SQLException {
        if(nom_u_text.getText().isEmpty() || email.getText().isEmpty() || cin_text.getText().isEmpty() ||
         prenom_text.getText().isEmpty() || nom_text.getText().isEmpty()){  
        Alert alert = new Alert(Alert.AlertType.ERROR,"Remplir touts les champs",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }else{
        
        int b=0;
        
     int i=ConnexionMysql.ajouter("update users set login='"+nom_u_text.getText()+"',email='"+email.getText()+"',cin='"+cin_text.getText()+"' where idUser='"+id+"' ");
     ResultSet rs=ConnexionMysql.select("select idPersonne from users where idUser='"+id+"' ");
     if(rs.next()){
     b=ConnexionMysql.ajouter("update personnes set nomPersonne='"+nom_text.getText()+"',prenomPersonne='"+prenom_text.getText()+"' where idPersonne='"+rs.getInt("idPersonne")+"'");
     }
     
     if(i==0&& b==0){
        Alert alert = new Alert(Alert.AlertType.ERROR,"n'est pas modifier",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"bien modifier",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }
        }
     
     
    }

    @FXML
    void annuler(ActionEvent event) {

    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
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
            cin_text.setText(rs.getString("cin"));
              email.setText(rs.getString("email"));
               nom_text.setText(rs.getString("nomPersonne"));
                prenom_text.setText(rs.getString("prenomPersonne"));
                 nom_u_text.setText(rs.getString("login"));
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModifierUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

