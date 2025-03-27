package uniquindio.edu.co.poo.model;

public class Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private String categoria;
    private int stock;

    public Producto(String nombre, String codigo, double precio, String categoria, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getStock() {
        return stock;
    }

    public void actualizarStock(int cantidad){
        this.stock -= cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return nombre+" - "+codigo+" - "+precio+" - "+categoria+" - "+stock;
    }
}
