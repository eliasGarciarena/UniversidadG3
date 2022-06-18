/*
    Main Colegio
 */
import entidades.Materia;
import data.Conexion;
import java.sql.*;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class Colegio {

    public static void main(String[] args) {
        HashSet<Materia> materias = new HashSet<>();
        Materia ingles = new Materia("Ingles", 1, true);
        Materia ingles2 = new Materia("Ingles", 1, true);
        Materia lengua = new Materia("Algo", 2, true);
        Materia ing = new Materia("Ingles",1, true);
        System.out.println(materias.add(ingles));
        System.out.println(materias.add(ingles2));
        System.out.println(materias.add(lengua) + "?");
        System.out.println(materias.add(ing));

        System.out.println("Son iguales " + ingles.equals(ing));
        materias.forEach((materia) -> {
            System.out.println(materia.getNombre() + " " + materia.getYear());
        });
    }
}
