/*
    Inscripcion
 */
package entidades;

/**
 *
 * @author Grupo3_LabI
 */
public class Inscripcion {
    private int idInscripcion;
    private Materia materia;
    private Alumno alumno;
    private double nota;

    public Inscripcion(int idInscripcion, Materia materia, Alumno alumno, double nota) {
        this.idInscripcion = idInscripcion;
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion(Materia materia, Alumno alumno, double nota) {
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion() {
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public Materia getMateria() {
        return materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        return 29 * 7 + this.idInscripcion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        if (this.idInscripcion != other.idInscripcion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", materia=" + materia + ", alumno=" + alumno + ", nota=" + nota + '}';
    }
}
