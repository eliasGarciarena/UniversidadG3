/*
    Alumno
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author Grupo3_LabI
 */
public class Alumno {

    private int idAlumno;
    private String nombre;
    private String apellido;
    private LocalDate fechNac;
    private long dni;
    private boolean activo;

    public Alumno(int idAlumno, String nombre, String apellido, LocalDate fechNac, long dni, boolean activo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechNac = fechNac;
        this.dni = dni;
        this.activo = activo;
    }

    public Alumno(String nombre, String apellido, LocalDate fechNac, long dni, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechNac = fechNac;
        this.dni = dni;
        this.activo = activo;
    }

    public Alumno() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public long getDni() {
        return dni;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", activo=" + activo + '}';
    }

    @Override
    public int hashCode() {
        return 67 * 3 + this.idAlumno;
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
        final Alumno other = (Alumno) obj;
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        return true;
    }

}
