/*
    Conexion
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class Conexion {

    
    private String url = "jdbc:mysql://localhost/univeridad_g3";
    private String usuario = "root";
    private String password = "";

    private Connection conexion;

    public Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");            
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR DRIVER DE BD\n" + exc.toString());
            System.out.println("ERROR AL CARGAR DRIVER DE BD\n" + exc.toString());
        }
    }

    public Connection getConexion(){
        try {
            if (conexion == null) {
                // Setup the connection with the DB
                conexion = DriverManager
                        .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                                + "&user=" + usuario + "&password=" + password);
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTARSE A LA BASE DE DATOS\n" + exc.toString());
            System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS\n" + exc.toString());
        }
        return conexion;
    }
}
