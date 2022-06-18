
import data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elias
 */
public class NewClass {
    try{
            //Establece conexion
            Conexion driver = new Conexion();
            Connection stablished = driver.getConexion();
            //Prepara y crea la sentencia
            PreparedStatement insert = stablished.prepareStatement("SELECT * FROM alumno");
            //Ejecuta una consulta
            //ResultSet resultado = insert.executeQuery("INSERT INTO `alumno` (`idAlumno`, `nombre`, `apellido`, `fechNac`, `dni`, `activo`) VALUES (NULL, 'Pepito', 'Perez', '1999-10-05', '40876283', NULL)");
            ResultSet resultado = insert.executeQuery();
            System.out.println(insert + "\n");
            while(resultado.next()){
                System.out.println(resultado.getString("nombre") + " " + resultado.getString("apellido") + ", nacio el " + resultado.getString("fechNac"));
            }
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(null, "ERROR AL EJECUTAR CONSULTA\n" + exc.toString());
            System.out.println("\nERROR AL EJECUTAR CONSULTA\n" + exc.toString());
        }
}
