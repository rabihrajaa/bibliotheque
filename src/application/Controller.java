package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller implements Initializable {
	Connection cnx;
	public PreparedStatement st;
	public Resultset result;
	
	
	 @FXML
	   private AnchorPane VBox;


	private Parent fxml;
	
	
	
  @FXML
  private void exit(ActionEvent event) {
	  System.exit(0);
  }
  @FXML
  private Button btn_login;

  @FXML
  private Hyperlink btn_paswordforgotten;

  @FXML
  private TextField txt_username;

  @FXML
  private PasswordField txtpassword;

  public static int idUser_test;
   public static int idPersonne_test;

  @FXML
  void openhome() throws IOException {
	 
	  String nom = txt_username.getText();
	  String pass = txtpassword.getText();
	  String sql="select u.idPersonne,idUser,login,password , libelleProfile from users u,profiles p, personnes pe where u.idProfile = p.idProfile  and pe.idPersonne = u.idpersonne ";
	  String admin="admin";
	  String uti="user";
	  boolean existe= true;
	  
	   if(nom.equals("")&&pass.equals("")) {
		   JOptionPane.showMessageDialog(null, "remplire tous les champs");
			  
	  }else if(nom.equals("")) {
		   JOptionPane.showMessageDialog(null, "entrer votre login");
		  
	  }else if(pass.equals("")) {
		   JOptionPane.showMessageDialog(null, "entrer votre mot de passe");
			  
	  }else {
	  
	  try {
		  
		  
	  st=cnx.prepareStatement(sql);
	  ResultSet rs = st.executeQuery(sql);
  
	
	  while(rs.next()) {	
                
               
		  if (nom.equals(rs.getString("login"))&&pass.equals(rs.getString("password"))&&admin.equals(rs.getString("libelleProfile"))) {
			
                      existe=true;

		      VBox.getScene().getWindow().hide();
		      Stage home = new Stage();
		      try {
			  fxml = FXMLLoader.load(getClass().getResource("/application/dashboard.fxml"));
			  Scene  scene = new Scene(fxml);
			  home.setScene(scene);
			  home.show();
			  break;
		      }catch(IOException e ) {
		    	  e.printStackTrace();
		      }
		  }else if(nom.equals(rs.getString("login"))&&pass.equals(rs.getString("password"))&&uti.equals(rs.getString("libelleProfile"))) {
			  idUser_test= rs.getInt("idUser");
                         idPersonne_test=rs.getInt("idPersonne");
                          System.out.println(idUser_test);
		           System.out.println(idPersonne_test);
                           existe=true;
			  System.out.println(" reussite");
			  VBox.getScene().getWindow().hide();
		      Stage home = new Stage();
		      try {

			  fxml = FXMLLoader.load(getClass().getResource("/interfaces/User_dashbord.fxml"));
			  Scene  scene = new Scene(fxml);
			  home.setScene(scene);
			  home.show();
			  break;
		      }catch(IOException e ) {
		    	  e.printStackTrace();
		      }
		  }else{
                existe=false;
			  
		  }
		    
	  }
	  
	  if(existe==false) {
		  Alert alert = new Alert(AlertType.ERROR,"nom de l'utilisateur ou mot de passe incorrect",javafx.scene.control.ButtonType.OK);
		  alert.showAndWait();
		 
	  }
	  
	  } catch (SQLException e1) {
		  e1.printStackTrace();
	  }
	  
	  
	  }
  }

  @FXML
  void sendpassword() {
	
 			 VBox.getScene().getWindow().hide();
      Stage home = new Stage();
      try {

	  fxml = FXMLLoader.load(getClass().getResource("/interfaces/ForggetPassword.fxml"));
	  Scene  scene = new Scene(fxml);
	  home.setScene(scene);
	  home.show();
	
      }catch(IOException e ) {
    	  e.printStackTrace();
      }
 	  

  }
	@Override
	 
	    public void initialize(URL arg0, ResourceBundle arg1) {
	        // TODO Auto-generated method stub
		   try {
			cnx= ConnexionMysql.connexionDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	    }
}
