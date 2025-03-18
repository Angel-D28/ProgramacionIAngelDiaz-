package org.uniquindio.edu.co.poo.model;

public class Estudiante {
    private String nombres;
    private String apellidos;
    private String numeroIdentificacion;
    private String correo;
    private String telefono;
    private byte edad;


    //constructor
    public Estudiante(String nombres, String apellidos, String numeroIdentificacion,
                      String correo, String telefono, byte edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setEdad(byte edad){
        this.edad=edad;
    }


    @Override
    public String toString(){
        return "Estudiante{ID= "+numeroIdentificacion+", Nombres= "+nombres+", Apellidos= "+apellidos+
                ", Correo= "+correo+", telefono= "+telefono+", edad= "+edad+'}';
    }
}