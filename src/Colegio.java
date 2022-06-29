/*
    Main Colegio
 */
import data.AlumnoData;
import entidades.Materia;
import data.Conexion;
import data.InscripcionData;
import data.MateriaData;
import entidades.Alumno;
import entidades.Inscripcion;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class Colegio {

    public static void main(String[] args) {
        //Establece conexion con BD
        Conexion conexion = new Conexion();
        //Crea objetos Data
        AlumnoData ad = new AlumnoData(conexion);
        MateriaData md = new MateriaData(conexion);
        InscripcionData id = new InscripcionData(conexion);
        //Crea un Alumno y lo obtiene por ID
        Alumno al = ad.obtenerAlumnoXId(1);
        //Obtiene las materias en las que esta inscripto dicho alumno
        ArrayList<Materia> materias = id.materiasInscriptoAlumno(al);
        //Imprime listado
        System.out.println("ALUMNO: " + al.getNombre() + " " + al.getApellido() + "\n\nLISTADO DE INSCRIPCIONES\n------------------------");
        for (Materia m : materias) {
            System.out.println(m.getIdMateria() + " - " +  m.getNombre());
        }
        
        //Regenera materia por ID
        Materia mat = md.obtenerMateriaXId(1);
        //Obtiene lista de inscriptos a partir del ID de una materia, y los imprime
        ArrayList<Alumno> inscriptos = id.verInscriptosEn(mat.getIdMateria());
        System.out.println("\n***************************************");
        System.out.println("\nALUMNOS INSCRIPTOS EN " + mat.getNombre() + "\n");
        for (Alumno alu : inscriptos) {
            System.out.println(alu.getNombre() + " " +  alu.getApellido() + " - NOTA: " + id.getNota(alu.getIdAlumno(), mat.getIdMateria()));
        }
    }
}
