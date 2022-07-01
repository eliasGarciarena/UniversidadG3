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

    private Connection con = null;
    AlumnoData ad;
    MateriaData md;

    public InscripcionData(Conexion con) {
        this.con = con.getConexion();
        ad = new AlumnoData(con);
        md = new MateriaData(con);

    }

    public boolean agregarInscripcion(Inscripcion inscripcion) {

        boolean insert = true;
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota)  VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            ps.setDouble(3, inscripcion.getNota());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
            } else {
                // JOptionPane.showMessageDialog(null, "Error al intentar agregar al alumno");
                insert = false;
            }

            ps.close();
        } catch (SQLException ex) {
            insert = false;
            JOptionPane.showMessageDialog(null, "Error de sintaxis " + ex);
        }
        return insert;

    }

    public ArrayList<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> curs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inscripcion ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion cur;
                Alumno al;
                Materia mt;
                al = ad.obtenerAlumnoXId(rs.getInt("idAlumno"));
                mt = md.obtenerMateriaXId(rs.getInt("idMateria"));
                cur = new Inscripcion(mt, al, rs.getDouble("nota"));
                curs.add(cur);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripcions", "Error Obtener inscripcions", JOptionPane.ERROR_MESSAGE);
        }

        return curs;
    }

    public Inscripcion obtenerInscripcionXId(int idAlumno) {
        Inscripcion cur = null;
        try {
            String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno al = null;
                Materia mt = null;
                al = ad.obtenerAlumnoXId(rs.getInt("idAlumno"));
                mt = md.obtenerMateriaXId(rs.getInt("idMateria"));
                cur = new Inscripcion(mt, al, rs.getDouble("nota"));
                System.out.println(al.getNombre() + " - " + mt.getNombre());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripcion\n" + ex);
        }

        return cur;
    }

    public boolean eliminarInscripcion(int idinscripcion) {
        boolean result = true;
        String sql = "DELETE FROM `inscripcion` WHERE `inscripcion`.`id` =" + idinscripcion;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int rs = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
            if (rs == 0) {
                result = false;
            }

            ps.close();
        } catch (SQLException ex) {
            result = false;
            JOptionPane.showMessageDialog(null, "Error de sintaxis\n" + ex);
        }

        return result;
    }

    public boolean modificarNota(Alumno al, Materia mat, int nota) {
        boolean modifi = false;
        try {
            String sql = "Update inscripcion Set nota=?   WHERE idAlumno=? AND idMateria=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nota);
            ps.setInt(2, al.getIdAlumno());
            ps.setInt(3, mat.getIdMateria());
            int resulset = ps.executeUpdate();
            if (resulset != 0) {
                modifi = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al modificar la nota", "Error Modificar", JOptionPane.ERROR_MESSAGE);
        }
        return modifi;
    }

    public double getNota(int idAlumno, int idMateria) {
        double nota = 0;
        try {
            String sql = "SELECT * FROM inscripcion WHERE idAlumno=? AND idMateria=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nota = rs.getInt("nota");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Nota No Encontrada\n" + ex, "Error Buscar", JOptionPane.ERROR_MESSAGE);
        }
        return nota;
    }

    public ArrayList<Materia> materiasInscriptoAlumno(Alumno alumno) {
        ArrayList<Materia> materias = new ArrayList();
        try {
            String sql = "SELECT * FROM inscripcion WHERE idAlumno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                materias.add(md.obtenerMateriaXId(rs.getInt("idMateria")));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones\n" + ex, "Error Obtener inscripciones", JOptionPane.ERROR_MESSAGE);
        }
        return materias;
    }

    public ArrayList<Materia> materiasNoIncriptoAlumno(Alumno alumno) {
         ArrayList<Materia> materias = new ArrayList<Materia>();
        try {
            String sql = "Select * from materia where idMateria not in "
                    + "(select idMateria from inscripcion where idAlumno =?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ResultSet resultSet = ps.executeQuery();
            Materia materia;
            while (resultSet.next()) {
                materia = new Materia();
                materia.setIdMateria(resultSet.getInt("idMateria"));
                materia.setNombre(resultSet.getString("nombre"));
                materia.setYear(resultSet.getInt("anio"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las Materias\n" + ex.getMessage());
        }
        return materias;

      
    }

    public ArrayList<Alumno> verInscriptosEn(int idMateria) {
        ArrayList<Alumno> inscriptos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inscripcion WHERE idMateria=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                inscriptos.add(ad.obtenerAlumnoXId(rs.getInt("idAlumno")));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones\n" + ex, "Error Obtener inscripciones", JOptionPane.ERROR_MESSAGE);
        }
        return inscriptos;
    }

    public boolean eliminarInscripcion(int idAlumno, int idMateria) {
        boolean result = true;
        String sql = "DELETE FROM `inscripcion` WHERE inscripcion.idAlumno =" + idAlumno+" and idMateria= "+idMateria;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int rs = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
            if (rs == 0) {
                result = false;
            }

            ps.close();
        } catch (SQLException ex) {
            result = false;
            JOptionPane.showMessageDialog(null, "Error de sintaxis\n" + ex);
        }

        return result;
    }

}
