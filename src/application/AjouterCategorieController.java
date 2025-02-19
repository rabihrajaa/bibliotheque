  
package application;

//import java.awt.TextField;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

 


public class AjouterCategorieController implements Initializable {

      Connection cnx;
    @FXML
    private TextField nom_text;
    
     @FXML
    private ImageView img;

    
     //@FXML
  // private AnchorPane myanchor;

    @FXML
    
 public void Ajouter_categorie() {
 String  libelle  = nom_text.getText();
        
        String req="insert into  categories values (0,'"+libelle+"','image')";
        
        int a=0;       
         if (libelle.isEmpty()){
                 Alert alert = new Alert(Alert.AlertType.ERROR,"Remplire tous les champs",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
         }else{
         
         a =ConnexionMysql.ajouter(req);
          if(a==0){
        Alert alert = new Alert(Alert.AlertType.ERROR," la categorie n'est pas ajouter",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION," Categorie bien ajouter",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }
        
            
         }
         
         
        
         
        
    }

    @FXML
    void annuler() throws IOException {
        javafx.application.Platform.exit();
			
    }
      @FXML
    void brows(ActionEvent event) {

    }

     

 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
         try {
			cnx= ConnexionMysql.connexionDB();
		} catch (SQLException e) {
                       // TODO Auto-generated catch block

		}
    }    

   
    
     
    
}
