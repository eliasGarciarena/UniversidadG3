/*
    InscripcionData
 */
package data;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class InscripcionData {
    
     private Connection con = null;
    
    private AlumnoData alumData;
    private MateriaData materiaData;

    public InscripcionData(Conexion conexion) {
       
            this.con = conexion.getConexion();
            this.alumData=new AlumnoData(conexion);
            this.materiaData=new MateriaData(conexion);
            
        
    }
    
    public boolean  guardarInscripcion(Inscripcion inscripcion) {
        boolean insc=false;
        try {
            String sql = "INSERT INTO cursada (idAlumno, idMateria, nota) VALUES ( ? , ? , ? );";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            ps.setDouble(3, inscripcion.getNota());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt("id"));
               // JOptionPane.showMessageDialog(null, "Se inscribió al alumno correctamente");
               insc=true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar Inscripción");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El alumno ya está inscripto en esta materia " + ex.getMessage());
        }
        return insc;
    }
    
    public ArrayList<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList();
        try {
            String sql = "SELECT * FROM cursada;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet resultSet = ps.executeQuery();
            Inscripcion inscripcion;
            while (resultSet.next()) {
                inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(resultSet.getInt("id"));

                Alumno a = alumData.obtenerAlumnoXId(resultSet.getInt("idAlumno"));
                inscripcion.setAlumno(a);

                Materia m = materiaData.obtenerMateriaXId(resultSet.getInt("idMateria"));
                inscripcion.setMateria(m);

                inscripcion.setNota(resultSet.getDouble("nota"));

                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las inscripciones: " + ex.getMessage());
        }

        return inscripciones;
    }

    public boolean modificarNota(Alumno al,Materia mat,int nota){
        boolean modifi=false;
         try {
            String sql="Update cursada Set nota=?   WHERE idAlumno=? AND idMateria=?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, nota);
             ps.setInt(2, al.getIdAlumno());
             ps.setInt(3, mat.getIdMateria());
             int resulset=ps.executeUpdate();
             if(resulset!=0){
                 modifi=true;
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error Al modificar la nota","Error Modificar",JOptionPane.ERROR_MESSAGE);
         }
        return modifi;
    }
}
