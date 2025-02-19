package application;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Add_userController implements Initializable{
    Connection cnx;

    @FXML
    private TextField cin_text;

    @FXML
    private DatePicker dateN;

    @FXML
    private TextField email_text;

    @FXML
    private TextField nom_text;

    @FXML
    private TextField nom_u_text;

    @FXML
    private TextField prenom_text;
     @FXML
    private PasswordField con_password;
      @FXML
    private PasswordField password;

    @FXML
    void ajouter_user(ActionEvent event) throws SQLException {
        String cin = cin_text.getText();
        String nom = nom_text.getText();
        String prenom = prenom_text.getText();
        String email = email_text.getText();
        String nom_ut= nom_u_text.getText();
        String mot=password.getText();
        String mot_cn=con_password.getText();
        LocalDate date_n=dateN.getValue();
       String mydate=date_n.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        
        if(nom_u_text.getText().isEmpty() ||email_text.getText().isEmpty()  || cin_text.getText().isEmpty() ||
         prenom_text.getText().isEmpty() || nom_text.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR,"Remplire tous les champs",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        
        }else{
        /*
        if(!mot.equals(mot_cn)){
        Alert alert = new Alert(Alert.AlertType.ERROR,"les deux mot de passe n'est pas le meme",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        return;
        }
*/
        String req="insert into personnes values (0,'"+nom+"','"+prenom+"','"+mydate+"','photo')";
        int i=ConnexionMysql.ajouter(req);
        int b=0;
        String req2 ="select max(idPersonne) as max from personnes" ;
       ResultSet rs=ConnexionMysql.select(req2);
     
       if(rs.next()){
        String req3="insert into users values (0,'"+rs.getInt("max")+"',2,'"+nom_ut+"','123rajaa','"+email+"','"+cin+"')";
          b=ConnexionMysql.ajouter(req3);
       }
        if(i==0&& b==0){
        Alert alert = new Alert(Alert.AlertType.ERROR,"n'est pas ajouter",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"bien ajouter",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }
        }

    }

    @FXML
    void annuler(ActionEvent event) {
 
    }
    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	        // TODO Auto-generated method stub
		   try {
			cnx= ConnexionMysql.connexionDB();
		} catch (SQLException e) {
                       // TODO Auto-generated catch block

		}
		   
	    }
}
