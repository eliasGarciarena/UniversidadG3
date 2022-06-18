/*
    Materia
 */
package entidades;

/**
 *
 * @author Grupo3_LabI
 */
public class Materia {

    private int idMateria;
    private String nombre;
    private int year;
    private boolean activo;

    public Materia(int idMateria, String nombre, int year, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.year = year;
        this.activo = activo;
    }

    public Materia(String nombre, int year, boolean activo) {
        this.nombre = nombre;
        this.year = year;
        this.activo = activo;
    }

    public Materia() {
    }

    public int getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getYear() {
        return year;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        return 41 * 3 + this.idMateria;
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
        final Materia other = (Materia) obj;
        if (this.idMateria != other.idMateria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", year=" + year + ", activo=" + activo + '}';
    }

}
