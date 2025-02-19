package application;

import net.sf.jasperreports.engine.JasperFillManager;
 
import net.sf.jasperreports.engine.JasperPrint;
 
import net.sf.jasperreports.engine.JasperReport;
 
import net.sf.jasperreports.engine.JasperCompileManager;
 
import net.sf.jasperreports.view.JasperViewer;


import application.Report.Print;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static javax.swing.UIManager.getString;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ListeMemberController implements Initializable {

    Connection cnx;
    public static int idu; 
    @FXML
    private GridPane grid;

    @FXML
    private TextField recherche;

    @FXML
    private Label la;

    private ToggleGroup tg = new ToggleGroup();

    @FXML
    void utilisateurbtn(ActionEvent event) throws SQLException {

     
        ResultSet rs = ConnexionMysql.select("SELECT * from users u join personnes p\n"
                + "on u.idPersonne=p.idPersonne;");

        grid.getChildren().clear();
        //Member m;
        Label id = new Label("ID");
        id.maxWidth(Double.MAX_VALUE);
        id.setAlignment(Pos.CENTER);
        grid.add(id, 1, 0);
        Label login = new Label("Login");
        login.maxWidth(Double.MAX_VALUE);
        login.setAlignment(Pos.CENTER);
        grid.add(login, 2, 0);
        Label nom = new Label("Nom");
        nom.maxWidth(Double.MAX_VALUE);
        nom.setAlignment(Pos.CENTER);
        grid.add(nom, 3, 0);
        Label prenom = new Label("Prenom");
        prenom.maxWidth(Double.MAX_VALUE);
        prenom.setAlignment(Pos.CENTER);
        grid.add(prenom, 4, 0);
        Label email = new Label("Email");
        email.maxWidth(Double.MAX_VALUE);
        email.setAlignment(Pos.CENTER);
        grid.add(email, 5, 0);
        Label date = new Label("Date Naissance");
        date.maxWidth(Double.MAX_VALUE);
        date.setAlignment(Pos.CENTER);
        grid.add(date, 6, 0);
        Label cin = new Label("CIN");
        cin.maxWidth(Double.MAX_VALUE);
        cin.setAlignment(Pos.CENTER);
        grid.add(cin, 7, 0);
        int i = 1;
        while (rs.next()) {
            RadioButton check_row = new RadioButton();
            check_row.maxWidth(Double.MAX_VALUE);
            check_row.setAlignment(Pos.CENTER);
            check_row.setId(String.valueOf(rs.getInt("idUser")));
            check_row.setToggleGroup(tg);
            grid.add(check_row, 0, i);
            Label id_row = new Label(String.valueOf(rs.getInt("idUser")));
            id_row.maxWidth(Double.MAX_VALUE);
            id_row.setAlignment(Pos.CENTER);
            grid.add(id_row, 1, i);
            Label login_row = new Label(rs.getString("login"));
            login_row.maxWidth(Double.MAX_VALUE);
            login_row.setAlignment(Pos.CENTER);
            grid.add(login_row, 2, i);
            Label nom_row = new Label(rs.getString("nomPersonne"));
            nom_row.maxWidth(Double.MAX_VALUE);
            nom_row.setAlignment(Pos.CENTER);
            grid.add(nom_row, 3, i);
            Label prenom_row = new Label(rs.getString("prenomPersonne"));
            prenom_row.maxWidth(Double.MAX_VALUE);
            prenom_row.setAlignment(Pos.CENTER);
            grid.add(prenom_row, 4, i);
            Label email_row = new Label(rs.getString("email"));
            email_row.maxWidth(Double.MAX_VALUE);
            email_row.setAlignment(Pos.CENTER);
            grid.add(email_row, 5, i);
            Label date_row = new Label(rs.getString("dateNaissancePersonne"));
            date_row.maxWidth(Double.MAX_VALUE);
            date_row.setAlignment(Pos.CENTER);
            grid.add(date_row, 6, i);
            Label cin_row = new Label(rs.getString("cin"));
            cin_row.maxWidth(Double.MAX_VALUE);
            cin_row.setAlignment(Pos.CENTER);
            grid.add(cin_row, 7, i);
            i++;
        }

    }

    @FXML
    void exporterbtn() throws FileNotFoundException, JRException {
        
  
    JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\DELL\\Documents\\NetBeansProjects\\MyMiniProject\\src\\application\\report1.jrxml");
                String query = "select * from personnes p join users u  on p.idPersonne= u.idPersonne ";
                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);
               jdesign.setQuery(updateQuery);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null,cnx);
            
           JasperViewer.viewReport(jprint);  
    

    }
    @FXML
    void adminbtn() {

    }

    @FXML
    void afficherbtn() throws IOException {
                   RadioButton rb = (RadioButton)tg.getSelectedToggle();
                   idu=Integer.parseInt (rb.getId()) ; 
                   
                   Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
                        Stage stage=new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Profile de l'utlisateur");
			stage.show();

    }

    @FXML
    void ajouterbtn() {
        
     try {
			Parent root = FXMLLoader.load(getClass().getResource("Add_user.fxml"));
                        Stage stage=new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("ajouter utlisateur");
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void modifierbtn() {
       try {
			Parent root = FXMLLoader.load(getClass().getResource("ModifierUser.fxml"));
                        Stage stage=new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Modifier utilisateur");
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
       
       RadioButton rb = (RadioButton)tg.getSelectedToggle();
                   idu=Integer.parseInt (rb.getId()) ;
    }

    @FXML
    void rechercher() {

    }

    @FXML
    void supprimerbtn() throws SQLException {
         RadioButton rb = (RadioButton)tg.getSelectedToggle();
                   idu=Integer.parseInt (rb.getId()) ;
        int idd=0;
        ResultSet rs=ConnexionMysql.select("select idPersonne from users where idUser='"+idu+"' ");
       
        if(rs.next()){
        idd=rs.getInt("idPersonne");
        }
        int i= ConnexionMysql.ajouter("delete from users where idUser="+idu);
        int b= ConnexionMysql.ajouter("delete from personnes where idPersonne='"+idd+"'");
       if(i==0&& b==0){
        Alert alert = new Alert(Alert.AlertType.ERROR,"n'est pas supprimé",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"bien supprimer",javafx.scene.control.ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        }
    }

    @FXML
    void table() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            cnx = ConnexionMysql.connexionDB();
        } catch (SQLException ex) {
            Logger.getLogger(ListeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
