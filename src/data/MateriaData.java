/*
    MateriaData
 */
package data;

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
public class MateriaData {

    private Connection con = null;

    public MateriaData(Conexion conexion) {
        con = conexion.getConexion();
    }

    public boolean agregarMateria(Materia materia) {
        boolean insert = true;
        String sql = "INSERT INTO materia (nombre, anio,activo)  VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getYear());
            ps.setBoolean(3, materia.isActivo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
            } else {
                // JOptionPane.showMessageDialog(null, "Error al intentar agregar al alumno");
                insert = false;
            }
            JOptionPane.showMessageDialog(null, "La materia fue agregada con exito", "Exito Al agregar", JOptionPane.INFORMATION_MESSAGE);
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis " + ex);

        }
        return insert;
    }

    public ArrayList<Materia> obtenerMateria() {
        ArrayList<Materia> mat = new ArrayList<Materia>();
        try {
            String sql = "SELECT * FROM materia WHERE activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Materia mate;
            while (resultSet.next()) {
                mate = new Materia();
                mate.setIdMateria(resultSet.getInt("idMateria"));
                mate.setNombre(resultSet.getString("nombre"));
                mate.setYear(resultSet.getInt("anio"));
                mate.setActivo(resultSet.getBoolean("activo"));
                mat.add(mate);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Materias", "Error Obtener materias", JOptionPane.ERROR_MESSAGE);
        }

        return mat;
    }

    public Materia obtenerMateriaXId(int id) {
        Materia mat = new Materia();
        try {
            String sql = "SELECT * FROM materia WHERE idMateria = ? AND activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                mat.setIdMateria(resultSet.getInt("idMateria"));
                mat.setNombre(resultSet.getString("nombre"));
                mat.setYear(resultSet.getInt("anio"));
                mat.setActivo(resultSet.getBoolean("activo"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener La Materia", "Error Obtenet", JOptionPane.ERROR_MESSAGE);
        }

        return mat;
    }

    public boolean modificarMateria(Materia mat) {
        boolean modificar = false;
        String sql = "UPDATE materia SET nombre = ?, anio = ?, activo=? WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat.getNombre());
            ps.setInt(2, mat.getYear());
            ps.setBoolean(3, mat.isActivo());
            ps.setInt(4, mat.getIdMateria());
            int resultset = ps.executeUpdate();
            ps.close();
            modificar = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar La Materia", " Error Modificar", JOptionPane.ERROR_MESSAGE);
        }

        return modificar;
    }

    public boolean eliminarMateria(int id) {
        boolean eliminar = false;
        try {
            String sql = "UPDATE materia SET activo=0 WHERE idMateria=?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int x = ps.executeUpdate();
            eliminar = true;
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar La Materia");
        }
        return eliminar;
    }
}
