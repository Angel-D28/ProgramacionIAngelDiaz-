package uniquindio.edu.co.poo.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Tienda {
    ArrayList<Producto> listaProductos;
    ArrayList<Cliente> listaClientes;
    ArrayList<Venta> listaVentas;

    public Tienda(){
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
    }

    public void agregarProducto(String nombre,String codigo, double precio, String categoria, int stock){
        for(int i=0;i<listaProductos.size();i++){
            if(listaProductos.get(i).getCodigo().equals(codigo)){
                JOptionPane.showMessageDialog(null,"Error: No se puede agregar un producto con codigo duplicado");
                return;
            }
        }
        listaProductos.add(new Producto(nombre, codigo, precio, categoria, stock));
        JOptionPane.showMessageDialog(null,"Producto agregado exitosamente");
    }
    
    //Añadí esta clase para que sea una mousquerramienta
    public void verProducto(String codigo) {	
    	for(int i=0; i<listaProductos.size(); i++){
            if(listaProductos.get(i).getCodigo().equals(codigo)){
            	JOptionPane.showMessageDialog(null, listaProductos.get(i).toString());            
            }
    	}
    }
    
    //otra mousquerramienta :V
    public Producto getProducto(String codigop) {
    	for(int i=0; i<listaProductos.size(); i++){
            if(listaProductos.get(i).getCodigo().equals(codigop)){
            	return listaProductos.get(i);
            }
            	//JOptionPane.showMessageDialog(null, "no se encontró ningún producto con ese código...");            
    	}
		return null;
    }

    public void mostrarProductos(){
        StringBuilder lista = new StringBuilder("Lista de Productos : \n");
        for(int i = 0; i<listaProductos.size(); i++){
            lista.append(i + 1).append(". ").append(listaProductos.get(i).toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null,lista.toString());
    }

    public void modificarProducto(String codigo){
        for(int i=0; i<listaProductos.size(); i++){
            if(listaProductos.get(i).getCodigo().equals(codigo)){
                String nuevoNombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del producto");
                double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el precio del producto"));
                String nuevaCategoria= JOptionPane.showInputDialog(null,"Ingrese el categoria del producto");
                int nuevoStock= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el stock del producto"));

                listaProductos.get(i).setNombre(nuevoNombre);
                listaProductos.get(i).setPrecio(nuevoPrecio);
                listaProductos.get(i).setCategoria(nuevaCategoria);
                listaProductos.get(i).setStock(nuevoStock);
                JOptionPane.showMessageDialog(null, "producto modificado corectamente");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado");
    }
    
    public void eliminarProducto(String codigo){
        for (int i = 0; i < listaProductos.size(); i++) {
            if(listaProductos.get(i).getCodigo().equals(codigo)) {
                listaProductos.remove(i);
                JOptionPane.showMessageDialog(null, "Producto modificado corectamente");
            }
        }
        JOptionPane.showMessageDialog(null, "Producto eliminado corectamente");
    }

    public void agregarCliente(String nombre, String identificacion, String direccion, String telefono, String correo){
        for(int i = 0; i<listaClientes.size(); i++){
            if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                JOptionPane.showMessageDialog(null,"Error: Cliente con identificacion duplicada");
            }
        }
        listaClientes.add(new Cliente(nombre, identificacion, direccion, telefono, correo));
    }

    public void mostrarClientes(){
        StringBuilder lista = new StringBuilder("Lista de Clientes : \n");
        for(int i = 0; i<listaClientes.size(); i++){
            lista.append(i+1).append(". ").append(listaClientes.get(i).toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null,lista.toString());
    }

    public void modificarCliente(String identificacion){
        for(int i=0; i<listaClientes.size(); i++){
            if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                String nuevoNombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del cliente: ");
                String nuevaIdentificacion = JOptionPane.showInputDialog(null,"Ingrese la identificacion del cliente: ");
                String nuevaDireccion= JOptionPane.showInputDialog(null,"Ingrese la direccion del cliente: ");
                String nuevoTelefono= JOptionPane.showInputDialog(null,"Ingrese telefono del cliente: ");
                String nuevoCorreo = JOptionPane.showInputDialog(null,"Ingrese el email del cliente: ");


                listaClientes.get(i).setNombre(nuevoNombre);
                listaClientes.get(i).setIdentificacion(nuevaIdentificacion);
                listaClientes.get(i).setDireccion(nuevaDireccion);
                listaClientes.get(i).setTelefono(nuevoTelefono);
                listaClientes.get(i).setCorreo(nuevoCorreo);
                JOptionPane.showMessageDialog(null, "Cliente modificado corectamente");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado");
    }

    public void mostrarHistorialCliente(String identificacion){
        for(int i=0; i<listaClientes.size(); i++){
            if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                listaClientes.get(i).mostrarHistorialVenta();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente no encontrado");
    }

    public void eliminarCliente(String identificacion){
        Cliente cliente = buscarCliente(identificacion);
        if(cliente != null){
            listaClientes.remove(cliente);
            JOptionPane.showMessageDialog(null, "Cliente eliminado corectamente");
        }else{
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    }

    public Cliente buscarCliente(String identificacion){
        for(int i=0; i<listaClientes.size(); i++){
            if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                return listaClientes.get(i) ;
            }
        }
        return null;
    }
    
    
   //sis 
    public void realizarVenta(Cliente cliente, Producto producto, int cantidad){
        if(producto.getStock()<cantidad){
            JOptionPane.showMessageDialog(null,"Error:Stock Insuficiente");
            return;
        }
        Venta nuevaVenta = new Venta(new Date(),cliente,producto,cantidad);
        listaVentas.add(nuevaVenta);
    }

    
    
    public void mostrarVentas(){
        StringBuilder lista = new StringBuilder("Lista de Ventas : \n");
        for(Venta venta: listaVentas){
            lista.append(venta.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null,lista.toString());
    }

    public String nombreMasLargo(){
        int contador = 0;
        String nombreLargo = "";

        for(Cliente clienteAux : listaClientes){
            String nombreAux = clienteAux.getNombre();
            if (nombreAux.length() > contador){
                contador = nombreAux.length();
                nombreLargo = nombreAux;
            }
        }
        return nombreLargo;
    }

    public ArrayList<Cliente>nombresPalindromos() {
        ArrayList<Cliente> palindromos = new ArrayList<>();
        for (Cliente clienteAux : listaClientes) {
            if (clienteAux != null) {
                String nombreCliente = clienteAux.getNombre();
                if (nombreCliente != null && esPalindromo(nombreCliente)) {
                    palindromos.add(clienteAux);
                }
            }
        }
        return palindromos;
    }

    public boolean esPalindromo (String nombre){
        String nombreNormal = nombre.toLowerCase();
        StringBuilder nombreInvertido = new StringBuilder();
        for (int i = nombreNormal.length()-1; i >= 0; i--) {
            nombreInvertido.append(nombreNormal.charAt(i));
            }
        if(nombreInvertido.equals(nombreNormal)){
            return true;
        }
        return false;
    }

    public ArrayList<Producto> StocksBajos(int stockIngresado){
        ArrayList<Producto> listaStocksBajos = new ArrayList<>();
         for(Producto productoAux : listaProductos){
             if(productoAux != null){
                 if(productoAux.getStock() < stockIngresado) {
                     listaStocksBajos.add(productoAux);
                 }
             }

         }
         return listaStocksBajos;
    }

    public ArrayList<Cliente> clienteConVariasCompras(){
        ArrayList<Cliente>listaClientesFrecuentes = new ArrayList<>();
        int ComprasMinima = 2;

        for(Cliente clienteAux : listaClientes){
            int contadorCompras = 0;

            for(Venta ventaAux : listaVentas){
                if(ventaAux != null){
                    if (ventaAux.getCliente().equals(clienteAux)) {
                        contadorCompras++;
                    }
                }
            }
            if(contadorCompras >= ComprasMinima){
                listaClientesFrecuentes.add(clienteAux);
            }

        }

        return listaClientesFrecuentes;
    }

    public ArrayList<Venta> obtenerVentasRR(){
        ArrayList<Venta> listaVentasClientesRR = new ArrayList<>();
        for(Venta ventaAux : listaVentas){
            if(ventaAux != null && tieneDosRR(ventaAux.getCliente())){
                listaVentasClientesRR.add(ventaAux);
            }
        }
        return listaVentasClientesRR;
    }

    public boolean tieneDosRR(Cliente cliente){
        int contador = 0;
        String nombreCliente = cliente.getNombre().toLowerCase();
            for (int i = 0 ; i < nombreCliente.length(); i++) {
                if(nombreCliente.charAt(i)=='r'){
                    contador++;
                }
                if (contador >= 2 ){
                    return true;
                }

            }
        return false;
    }

    public ArrayList<Cliente> obtenerClientesCompra(){
        ArrayList<Cliente> listaClientesCompra = new ArrayList<>();
        for(Cliente clienteAux : listaClientes){
            boolean clienteRevisado = obtenerCompraLeche(clienteAux);
            if(clienteRevisado == true){
                listaClientesCompra.add(clienteAux);
            }
        }
        return listaClientesCompra;
    }

    public ArrayList<Cliente> clientesQueCompraronMasDe20Leches() {
        ArrayList<Cliente> clientesFrecuentes = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            int totalLeches = 0;

            for (Venta venta : listaVentas) {
                if (venta.getCliente().equals(cliente)) {
                    for (DetalleVenta detalle : venta.getListaDetallesVenta()) {
                        if (detalle.getProductoComprado().getNombre().equalsIgnoreCase("leche")) {
                            totalLeches += detalle.getCantidad();
                        }
                    }
                }
            }

            if (totalLeches > 20) {
                clientesFrecuentes.add(cliente);
            }
        }

        return clientesFrecuentes;
    }

}

