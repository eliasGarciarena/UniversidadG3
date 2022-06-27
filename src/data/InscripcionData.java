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
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class InscripcionData {
    private Connection con=null;
    AlumnoData ad;
        MateriaData md;
    public InscripcionData(Conexion con){
      this.con=con.getConexion();
      ad=new AlumnoData(con);
      md= new MateriaData(con);
      
    }
    public boolean agregarInscripcion(Inscripcion cursada) {

        boolean insert = true;
        String sql = "INSERT INTO cursada (idAlumno, idMateria, nota)  VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, cursada.getAlumno().getIdAlumno());
            ps.setInt(2, cursada.getMateria().getIdMateria());
            ps.setDouble(3, cursada.getNota());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                cursada.setIdInscripcion(rs.getInt(1));
            } else {
                // JOptionPane.showMessageDialog(null, "Error al intentar agregar al alumno");
                insert = false;
            }

            ps.close();
        } catch (SQLException ex) {
            insert=false;
            JOptionPane.showMessageDialog(null, "Error de sintaxis "+ex );
        }
        return insert;

    }
    public ArrayList<Inscripcion> obtenerInscripciones(){
            ArrayList<Inscripcion> curs = new ArrayList<>();
            try {
            String sql = "SELECT * FROM cursada ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Inscripcion cur;
                Alumno al;
                Materia mt;
                al=ad.obtenerAlumnoXId(rs.getInt("idAlumno"));
                mt=md.obtenerMateriaXId(rs.getInt("idMateria"));
                cur= new Inscripcion(mt,al,rs.getDouble("nota"));
               curs.add(cur);
               
            }
            ps.close();
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al obtener Cursadas","Error Obtener Cursadas",JOptionPane.ERROR_MESSAGE);
            }
            
            return curs;
        }
    public Inscripcion obtenerCursadaXId(int idAlumno,int idMateria){
        Inscripcion cur=null;
        try {
            String sql = "SELECT * FROM cursada WHERE idAlumno = ? AND idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alumno al=null;
                Materia mt=null;
                al=ad.obtenerAlumnoXId(rs.getInt("idAlumno"));
                mt=md.obtenerMateriaXId(rs.getInt("idMateria"));
                cur= new Inscripcion(mt,al,rs.getDouble("nota"));    
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener alumnos");
        }
        
        return cur;
    }
    public boolean eliminarCursada(int idCursada){
        boolean result=true;
         String sql = "DELETE FROM `cursada` WHERE `cursada`.`id` ="+idCursada;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int rs=ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, " Se agregó al alumno " + alumno + " correctamente");
            if (rs==0){
                result=false;
            } 

            ps.close();
        } catch (SQLException ex) {
            result=false;
            JOptionPane.showMessageDialog(null, "Error de sintaxis "+ex );
        }
        
        return result;
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
    public ArrayList<Materia>materiasInscriptoAlumno(Alumno alumno){
        ArrayList<Materia> materias = new ArrayList();
        try {
            String sql = "SELECT * FROM cursada WHERE idAlumno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               materias.add(md.obtenerMateriaXId(rs.getInt("idMateria")));
               
            }
            ps.close();
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al obtener Cursadas","Error Obtener Cursadas",JOptionPane.ERROR_MESSAGE);
            }
       return materias;        
    }
    public ArrayList<Materia>materiasNoIncriptoAlumno(Alumno alumno){
        ArrayList<Materia> materias = new ArrayList();
        for (Materia materia : md.obtenerMateria()) {
            for (Materia mat : materiasInscriptoAlumno(alumno)) {
                if(!materia.equals(mat)){
                    materias.add(materia);
                }
            }
        }
        
        return materias;
    }
    
    


}
