/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import static application.ConnexionMysql.rs;
import java.awt.BorderLayout;
import org.jfree.chart.ChartPanel;
import java.awt.Color;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection cnx;
       @FXML
    private Label nbr_materiel;

    @FXML
    private Label nbre_auteur;

    @FXML
    private Label nbre_categorie;

    @FXML
    private Label nbre_emp;

    @FXML
    private AnchorPane panel_emp;

    @FXML
    private AnchorPane panel_statu;
      @FXML
    private BarChart<String, Number> bar;
      @FXML
    private PieChart pie;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            // TODO
            cnx = ConnexionMysql.connexionDB();
        } catch (SQLException ex) {
            Logger.getLogger(ListeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
         String req1="select count(*) as nbre from materiels";
         ResultSet rs1=ConnexionMysql.select(req1);
        try {
            if(rs1.next()){
                nbr_materiel.setText(String.valueOf(rs1.getInt("nbre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         String req2="select count(*) as nbre from auteurs";
         ResultSet rs2=ConnexionMysql.select(req2);
        try {
            if(rs2.next()){
                nbre_auteur.setText(String.valueOf(rs2.getInt("nbre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String req3="select count(*) as nbre from categories";
         ResultSet rs3=ConnexionMysql.select(req3);
        try {
            if(rs3.next()){
                nbre_categorie.setText(String.valueOf(rs3.getInt("nbre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         String req4="select count(*) as nbre from emprunts";
         ResultSet rs4=ConnexionMysql.select(req4);
        try {
            if(rs4.next()){
                nbre_emp.setText(String.valueOf(rs4.getInt("nbre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String req5="select count(*) as nbre,libelleCat from materiels m join  categories c\n" +
"on m.idCat = c.idCat group by libelleCat;" ;
         ResultSet rs5=ConnexionMysql.select(req5);
               // Define the x-axis and y-axis
      CategoryAxis xAxis = new CategoryAxis();
      xAxis.setLabel("Catégories");
      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("Nombre des matériels");

      // Create the bar chart
      
      bar.setTitle("Nombre des matériels en fonction de catégories");

      // Create the data series
      XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
      dataSeries.setName("Catégories");
        try {
           
            while(rs5.next()){
           dataSeries.getData().add(new XYChart.Data<>(rs5.getString(2), rs5.getInt(1)));
            }
            
      // Add the data series to the bar chart
      bar.getData().add(dataSeries);      
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    
    
    
    
    
    
}
