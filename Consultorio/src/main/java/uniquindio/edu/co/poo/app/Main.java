package uniquindio.edu.co.poo.app;

import uniquindio.edu.co.poo.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio("OdontoSalud", "123456789", "Calle 10 #5-30");

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "\uD83C\uDFE5 MENÚ CONSULTORIO ODONTOLÓGICO \uD83C\uDFE5\n\n" +
                            "1- Agregar paciente\n" +
                            "2- Mostrar paciente\n" +
                            "3- Eliminar paciente\n" +
                            "4- Agregar médico\n" +
                            "5- Mostrar médico\n" +
                            "6- Actualizar médico\n" +
                            "7- Eliminar médico\n" +
                            "8- Pacientes con consulta gratis\n" +
                            "9- Salir\n\n" +
                            "Seleccione una opción:");

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente:");
                    String nhc = JOptionPane.showInputDialog("Ingrese el NHC único del paciente:");
                    byte edad = Byte.parseByte(JOptionPane.showInputDialog("Ingrese la edad del paciente:"));
                    String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del paciente:");
                    String direccion = JOptionPane.showInputDialog("Ingrese la dirección del paciente:");
                    LocalDate fechaConsulta = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de última consulta (AAAA-MM-DD):"));
                    byte tratamientos = Byte.parseByte(JOptionPane.showInputDialog("Ingrese la cantidad de tratamientos realizados:"));
                    String mensaje = consultorio.agregarPaciente(nhc, nombre, edad, telefono, direccion, fechaConsulta, tratamientos);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "2":
                    String nhcMostrar = JOptionPane.showInputDialog("Ingrese el NHC del paciente a mostrar:");
                    mensaje = consultorio.mostrarPaciente(nhcMostrar);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "3":
                    String nhcEliminar = JOptionPane.showInputDialog("Ingrese el NHC del paciente a eliminar:");
                    mensaje = consultorio.eliminarPaciente(nhcEliminar);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "4":
                    String idMedico = JOptionPane.showInputDialog("Ingrese el ID del médico:");
                    String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico:");
                    String licencia = JOptionPane.showInputDialog("Ingrese el número de licencia:");

                    // Lista interactiva de especialidades
                    Especialidad[] especialidades = Especialidad.values();
                    Especialidad especialidad = (Especialidad) JOptionPane.showInputDialog(
                            null,
                            "Seleccione la especialidad del médico:",
                            "Especialidad",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            especialidades,
                            especialidades[0]
                    );

                    if (especialidad != null) {
                        mensaje = consultorio.agregarMedico(idMedico, nombreMedico, licencia, especialidad);
                    } else {
                        mensaje = "No se seleccionó una especialidad.";
                    }

                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "5":
                    String idMostrarMedico = JOptionPane.showInputDialog("Ingrese el ID del médico a mostrar:");
                    mensaje = consultorio.mostrarMedico(idMostrarMedico);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "6":
                    String idActualizar = JOptionPane.showInputDialog("Ingrese el ID del médico a actualizar:");
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del médico:");
                    String nuevaLicencia = JOptionPane.showInputDialog("Ingrese el nuevo número de licencia:");
                    Especialidad nuevaEspecialidad = Especialidad.valueOf(JOptionPane.showInputDialog("Ingrese la nueva especialidad (ODONTOLOGIA_GENERAL, ORTODONCIA, ENDODONCIA, CIRUGIA_ORAL):"));
                    mensaje = consultorio.actualizarMedico(idActualizar, nuevoNombre, nuevaLicencia, nuevaEspecialidad);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "7":
                    String idEliminarMedico = JOptionPane.showInputDialog("Ingrese el ID del médico a eliminar:");
                    mensaje = consultorio.eliminarMedico(idEliminarMedico);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "8":
                    LinkedList<Paciente> pacientesTratamiento = consultorio.obtenerPacientes5Tratamientod();
                    StringBuilder listaPacientes = new StringBuilder("Pacientes con más de 5 tratamientos:\n\n");
                    for (Paciente p : pacientesTratamiento) {
                        listaPacientes.append("- ").append(p.nombre()).append(" (NHC: ").append(p.nhc()).append(")\n");
                    }
                    JOptionPane.showMessageDialog(null, listaPacientes.toString());
                    break;

                case "9":
                    JOptionPane.showMessageDialog(null, "🚪 Saliendo del sistema...");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "⚠ Opción inválida, intente de nuevo.");
            }
        }
    }
}
