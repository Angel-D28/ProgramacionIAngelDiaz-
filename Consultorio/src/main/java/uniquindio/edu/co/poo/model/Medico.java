package uniquindio.edu.co.poo.model;

public class Medico {
    private String id;
    private String nombre;
    private String numeroLicencia;
    private Especialidad especialidad;

    public Medico(String id, String nombre, String numeroLicencia, Especialidad especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.numeroLicencia = numeroLicencia;
        this.especialidad = especialidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numeroLicencia='" + numeroLicencia + '\'' +
                ", especialidad=" + especialidad +
                '}';
    }
}







