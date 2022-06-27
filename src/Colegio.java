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
        
        Conexion conexion=new Conexion();
        AlumnoData ad=new AlumnoData(conexion);
        MateriaData md=new MateriaData(conexion);
        InscripcionData id=new InscripcionData(conexion);
        ArrayList<Materia> materias=id.inscripcionesDelAlumno(2);
        for(Materia m:materias){
            System.out.println("nombre:"+m.getNombre());
        }
       //Alumno al=ad.obtenerAlumnoXId(1);
       //Materia m1=md.obtenerMateriaXId(1);
        //Inscripcion inscrip=new Inscripcion(m1, al,9);
        //id.guardarInscripcion(inscrip);
        //ArrayList <Inscripcion>ins= id.obtenerInscripciones();
        //for(Inscripcion inscrip:ins){
        //    System.out.println("Alumno:"+inscrip.getAlumno().getNombre()+" Materia:"+inscrip.getMateria().getNombre());
        //}
        //id.modificarNota(al,m1, 9);
        //md.agregarMateria(m1);
       // ArrayList<Materia> materias=md.obtenerMateria();
        //for(Materia mat:materias){
        //    System.out.println("nombre:"+mat.getNombre()+" id=:"+mat.getIdMateria());
        //}
        //Materia materiaId=md.obtenerMateriaXId(3);
        //System.out.println("--------------Materia por id----------------");
        //System.out.println("Nombre:"+materiaId.getNombre());
        //System.out.println("--------------Modificar---------------------");
        //Materia m2=new Materia(3, "EDA", 1, true);
        //md.modificarMateria(m2);
        //Materia obma=md.obtenerMateriaXId(2);
        //System.out.println("materia:"+obma.getNombre());
        //Materia mat=md.obtenerMateriaXNombre("Web 1",1);
        //System.out.println("Materia:"+mat.getNombre());
        //md.eliminarMateria(10);
        //md.eliminarMateria(11);
        /*Alumno pepe=new Alumno("Leticia","Moreira",LocalDate.of(1973, Month.MARCH, 12),2344553,true);
        
        if(ad.agregarAlumno(pepe)){
        
            JOptionPane.showMessageDialog(null, "Alumno Agregado Exitosamente");
        }
*/
        
        /*List<Alumno> lista=ad.obtenerAlumnos();
        
        for(Alumno alu:lista){
        
            System.out.println("dni "+alu.getDni());
            System.out.println("apellido "+alu.getApellido());
            System.out.println("nombre "+alu.getNombre());
        }
        System.out.println("-------------Buscamos por id----------------");
        Alumno aEncontrado=ad.obtenerAlumnoXId(3);
        if(aEncontrado!=null){
        System.out.println("Apellido "+aEncontrado.getApellido());
        }else {
        
            System.out.println("Alumno no existe");
        }
        
        System.out.println("-------------Modificamos apellido--------------");
        //aEncontrado.setApellido("Zarate");
        
        //ad.modificarAlumno(aEncontrado);
        System.out.println("-------------Borrar alumno--------------");
        //ad.borrarAlumno(3);
        */
    }
}
