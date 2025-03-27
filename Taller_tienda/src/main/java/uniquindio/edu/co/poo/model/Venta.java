package uniquindio.edu.co.poo.model;

import java.util.Date;

public class Venta {
    private Date fecha;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private double montoTotal;

    public Venta(Date fecha, Cliente cliente, Producto producto, int cantidad) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.montoTotal = cantidad * producto.getStock();
        producto.actualizarStock(cantidad);
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Fecha: "+fecha+"\n Cliente"+cliente+"\nProducto: "+producto+"\nCantidad: "+cantidad+"\nTotal: "+montoTotal;
    }
}
