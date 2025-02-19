package application;
import java.sql.*;
import javax.swing.JOptionPane;


public class ConnexionMysql {
    private static Connection conn = null;
    private static Statement stmt = null;
        public static ResultSet rs=null;
        
	public static Connection connexionDB() throws SQLException{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
		
		System.out.println("connexion reussite");
		return conn; 
		}catch(ClassNotFoundException e){
	JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
			return null;
		}
	}
         public static int ajouter(String query) {

        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(query);
           
        }
        catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return 0;
        }
    }
         
         public static ResultSet select(String query) {

        try {
            stmt = conn.createStatement();
            rs= stmt.executeQuery(query);
            return rs;
        }
        catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        }
    }
       
}