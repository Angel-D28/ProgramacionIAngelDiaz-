package uniquindio.edu.co.poo.model;

import javax.swing.*;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String correo;
    private ArrayList<Venta>listaVentas;

    public Cliente(String nombre, String identificacion, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.listaVentas = new ArrayList<>();
    }
    public void mostrarHistorialVenta(){
        StringBuilder historial= new StringBuilder();
        for (int i = 0; i < listaVentas.size(); i++) {
            historial.append(i+1).append(". ").append(listaVentas.get(i).toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, historial.toString());
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion(){
        return identificacion;
    }
    @Override
    public String toString() {
        return nombre + " - " + identificacion + " - " + direccion + " - " + telefono + " - " + correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
