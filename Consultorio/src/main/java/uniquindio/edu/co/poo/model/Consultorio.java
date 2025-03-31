package uniquindio.edu.co.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Consultorio {
    private String nombre;
    private String nit;
    private String ubicacion;
    private LinkedList<Paciente> listaPacientes;
    private LinkedList<Medico> listaMedicos;

    public Consultorio(String nombre, String nit, String ubicacion) {
        this.nombre = nombre;
        this.nit = nit;
        this.ubicacion = ubicacion;
        this.listaPacientes = new LinkedList<>();
        this.listaMedicos = new LinkedList<>();
    }

    public Medico buscarMedico(String idMedico){
        Medico medicoEncontrar =null;
        for (Medico medicoAux : listaMedicos){
            if(medicoAux.getId().equals(idMedico)){
                medicoEncontrar = medicoAux;
            }
        }
        return medicoEncontrar;
    }
    public Paciente buscarPaciente(String nhcPaciente){
        Paciente PacienteEncontrar =null;
        for (Paciente pacienteAux : listaPacientes){
            if(pacienteAux.nhc().equals(nhcPaciente)){
                PacienteEncontrar = pacienteAux;
            }
        }
        return PacienteEncontrar;
    }

    public boolean verificarExistenciaMedico (String idMedico){
        boolean existe = false;
        if (listaMedicos.contains(buscarMedico(idMedico))){
            existe = true;
        }
        return existe;
    }
    public boolean verificarExistenciaPaciente (String nhcPaciente){
        boolean existe = false;
        if (listaPacientes.contains(buscarPaciente(nhcPaciente))){
            existe = true;
        }
        return existe;
    }

    public String agregarMedico(String idMedico, String nombre, String ubicacion, Especialidad especialidad) {
        String mensaje = "";
        boolean agregacion = verificarExistenciaMedico(idMedico);
        if(agregacion == false){
            Medico medicoNuevo = new Medico(idMedico,nombre,ubicacion,especialidad);
            listaMedicos.add(medicoNuevo);
            mensaje+="Medico agregado exitosamente";
        }
        mensaje+="Error. No se pudo agregar el medico";
        return mensaje;
    }
    public String mostrarMedico(String idMedico){
        String mensaje = " ";
        boolean medico = verificarExistenciaMedico(idMedico);
        if(medico == false){
            mensaje+="Medico no existe";
            return mensaje;
        }
        Medico medicoAmostrar = buscarMedico(idMedico);
        mensaje += "Medico "+medicoAmostrar.getNombre()+"[ID:"
                +medicoAmostrar.getId()+"Especialidad:"+medicoAmostrar.getEspecialidad()+"]";
        return mensaje;
    }
    public String actualizarMedico(String id, String nuevoNombre, String nuevaLicencia, Especialidad nuevaEspecialidad){
        String mensaje = "";
        boolean medico = verificarExistenciaMedico(id);
        if(medico == true){
            Medico medicoActualizado = buscarMedico(id);
                medicoActualizado.setNombre(nuevoNombre);
                medicoActualizado.setNumeroLicencia(nuevaLicencia);
                medicoActualizado.setEspecialidad(nuevaEspecialidad);
            mensaje += " Médico actualizado correctamente.";
            return mensaje;
        }
        mensaje += "Error al actualizar el medico";
        return mensaje;
    }
    public String eliminarMedico(String idMedico){
        String mensaje = "";
        boolean medico = verificarExistenciaMedico(idMedico);
        if(medico == false){
            mensaje+="Medico no existe";
            return mensaje;
        }
        Medico medicoEliminado = buscarMedico(idMedico);
        listaMedicos.remove(medicoEliminado);
        mensaje += " Medico eliminado correctamente.";
        return mensaje;
    }
    public String agregarPaciente(String nhc, String nombre, byte edad,
                                  String telefono, String direccion,
                                  LocalDate fechaUltimaConsulta, byte cantidadTratamientos){
        String mensaje = "";
        if(verificarExistenciaPaciente(nhc) == false){
            Paciente nuevoPaciente = new Paciente(nombre, nhc, edad, telefono, direccion, fechaUltimaConsulta, cantidadTratamientos);
            listaPacientes.add(nuevoPaciente);
            mensaje += "Paciente "+nuevoPaciente.nombre() + " agregado correctamente.";
            return mensaje;
        }
        mensaje += "El Paciente ya existe en la base de datos";
        return mensaje;
    }
    public String mostrarPaciente(String nhcPaciente) {
        String mensaje = " ";
        boolean paciente = verificarExistenciaPaciente(nhcPaciente);
        if (paciente == false) {
            mensaje += "Paciente no existe";
            return mensaje;
        }
        Paciente pacienteAmostrar = buscarPaciente(nhcPaciente);
        mensaje += "Paciente " + pacienteAmostrar.nombre() + " [NHC: "
                + pacienteAmostrar.nhc() + " Edad: " + pacienteAmostrar.edad()
                + " Teléfono: " + pacienteAmostrar.telefono()
                + " Dirección: " + pacienteAmostrar.direccion()
                + " Última Consulta: " + pacienteAmostrar.fechaUltimaConsulta()
                + " Tratamientos: " + pacienteAmostrar.cantidadTratamientos() + "]";
        return mensaje;
    }

    public String eliminarPaciente(String nhcPaciente) {
        String mensaje = "";
        boolean paciente = verificarExistenciaPaciente(nhcPaciente);
        if (paciente == false) {
            mensaje += "Paciente no existe";
            return mensaje;
        }
        Paciente pacienteEliminado = buscarPaciente(nhcPaciente);
        listaPacientes.remove(pacienteEliminado);
        mensaje += " Paciente eliminado correctamente.";
        return mensaje;
    }

    public LinkedList<Paciente> obtenerPacientes5Tratamientod() {
        LinkedList<Paciente> listaPacientesTratamientos = new LinkedList<>();
        int CantidadMinimaTratamientos = 5;
        for (Paciente paciente : listaPacientes) {
            if (paciente.cantidadTratamientos()>= CantidadMinimaTratamientos){
                listaPacientesTratamientos.add(paciente);
            }
        }
        return listaPacientesTratamientos;
    }


    @Override
    public String toString() {
        return "Consultorio{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", listaPacientes=" + listaPacientes +
                ", listaMedicos=" + listaMedicos +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LinkedList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(LinkedList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public LinkedList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(LinkedList<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }
}