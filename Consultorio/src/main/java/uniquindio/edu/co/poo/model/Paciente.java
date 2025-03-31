package uniquindio.edu.co.poo.model;

import java.time.LocalDate;

public record Paciente(String nombre , String nhc , byte edad ,
                       String telefono , String direccion ,
                       LocalDate fechaUltimaConsulta, byte cantidadTratamientos) {
    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public String nhc() {
        return nhc;
    }

    @Override
    public byte edad() {
        return edad;
    }

    @Override
    public String telefono() {
        return telefono;
    }

    @Override
    public String direccion() {
        return direccion;
    }

    @Override
    public LocalDate fechaUltimaConsulta() {
        return fechaUltimaConsulta;
    }

    @Override
    public byte cantidadTratamientos() {
        return cantidadTratamientos;
    }
}
