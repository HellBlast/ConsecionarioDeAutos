package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexcionOracle {

    private Connection conexion = null;
    String login = "system";
    String clave = "1234";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(url, login, clave);
            conexion.setAutoCommit(false);
            if (conexion != null) {
                System.out.println("Conecion Exitosa");
            } else {
                System.out.println("Conecion es erronnea");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conecion Erronea"+e.getMessage());
        }
        return conexion;
    }

    public void deconexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar " + e.getMessage());
        }
    }

    public static void main(String[] args) {
     ConexcionOracle c=new ConexcionOracle();
     c.getConnection();
    }
    
    
}
