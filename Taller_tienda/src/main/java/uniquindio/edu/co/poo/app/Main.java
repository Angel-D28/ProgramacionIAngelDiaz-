package uniquindio.edu.co.poo.app;

import javax.swing.JOptionPane;
import uniquindio.edu.co.poo.model.Producto;
import uniquindio.edu.co.poo.model.Tienda;

public class Main {
    public static void main(String[] args) {
    	Tienda tiendita= new Tienda();
        JOptionPane.showMessageDialog(null, "Buenos dias, para iniciar con el programa necesitas agregar\nprimero "
        		+ "al menos 3 productos...");
        byte contadorProductoInicial= 0;
        int stock, eleccion= 0, cantidadP= 0;
        String nombreC, identificacionC, direccionC, telefonoC, correoC, Ncliente, codigoP, salir;
        String nombre, codigo, categoria;
        double precio= 0;
        boolean repetir1= true, repetir2= true, repetir3= true, repetir4= true;
        while(repetir1) {
        	nombre= ingresarTexto("Ingresa el nombre del producto: ");
        	codigo= ingresarTexto("Ingresa el Codigo del producto: ");
        	precio= ingresarDouble("Ingresa el Precio del producto: ");
        	categoria= ingresarTexto("Ingresa la Categiria del producto: ");
        	stock= ingresarInt("Ingresa la Cantidad de producto disponible: ");
        	tiendita.agregarProducto(nombre, codigo, precio, categoria, stock);
        	contadorProductoInicial++;
        	if (contadorProductoInicial<3) {
        		JOptionPane.showMessageDialog(null, "cantidad de productos registrados: " + contadorProductoInicial
            			+ ", faltan " + (3-contadorProductoInicial));
        		
        	}else {repetir1= false;}}
        	JOptionPane.showMessageDialog(null, "listo, ya puedes iniciar con el programa...");
        	while (repetir2) {
        		eleccion= ingresarInt("¿Que acción desea hacer?:\n1) Atender una Compra\n2) Agregar un Producto\n"
        		+ "3) Rellenar Stocks\n4) Ver Producto\n5) Ver Todos los Productos\n6) Editar Producto\n"
        		+ "7) Eliminar Producto\n8) Ver las Ventas\n9) Ver Clientes\10) buscar cliente\n11) Editar Cliente\n"
        		+ "12) Eliminar Cliente\n13) Ver el Historial del Cliente\14) Agregar Cliente\n0) Finalizar Programa");
        		if (eleccion == 1) {
        			repetir3= true;
        			while (repetir3) {
        				Ncliente= ingresarTexto("¿El cliente que va a hacer la compra es nuevo? Si(y) o No(n): ");
        				if (!Ncliente.equalsIgnoreCase("Y") && !Ncliente.equalsIgnoreCase("N")) {
            				JOptionPane.showMessageDialog(null, "Debes de poner Si(y) o No(n), intenta de nuevo...");
            			}else {
            				repetir3= false;
            				if (Ncliente.equalsIgnoreCase("Y")) {
                    			nombreC= ingresarTexto("Ingresar el Nombre del Cliente: ");
                    			identificacionC= ingresarTexto("Ingresa la Identificación del Cliente: ");
                    			direccionC= ingresarTexto("Ingresa la Dirección");
                    			telefonoC= ingresarTexto("Ingresar el Telefono: ");
                    			correoC= ingresarTexto("Ingresa el Correo de Cliente");
                    			tiendita.agregarCliente(nombreC, identificacionC, direccionC, telefonoC, correoC);
                    			codigoP= ingresarTexto("Ingresa el Codigo del producto a vender");
                    			Producto productoSelec= tiendita.getProducto(codigoP);
                    			cantidadP= ingresarInt("¿Cuantas unidades de producto se va a llevar?: ");
                    			tiendita.realizarVenta(tiendita.buscarCliente(identificacionC), productoSelec, cantidadP);
            				}else {
            					identificacionC= ingresarTexto("Ingresa la Identificación del Cliente: ");
            					codigoP= ingresarTexto("Ingresa el Codigo del producto a vender");
            					Producto productoSelec= tiendita.getProducto(codigoP);
            					cantidadP= ingresarInt("¿Cuantas unidades de producto se va a llevar?: ");
            					tiendita.realizarVenta(tiendita.buscarCliente(identificacionC), productoSelec, cantidadP);
            				}
            			}
        			}
        		}else if(eleccion == 2) {
                	nombre= ingresarTexto("Ingresa el nombre del producto: ");
                	codigo= ingresarTexto("Ingresa el Codigo del producto: ");
                	precio= ingresarDouble("Ingresa el Precio del producto: ");
                	categoria= ingresarTexto("Ingresa la Categiria del producto: ");
                	stock= ingresarInt("Ingresa la Cantidad de producto disponible: ");
                	tiendita.agregarProducto(nombre, codigo, precio, categoria, stock);
        		}else if(eleccion == 3) {
        			codigo= ingresarTexto("Ingresa el Codigo del producto: ");
        			cantidadP= ingresarInt("Ingrese la cantidad de producto que va a rellenar: ");
        			tiendita.getProducto(codigo).setStock(cantidadP);
        		}else if(eleccion == 4) {
        			codigo= ingresarTexto("Ingresa el Codigo del producto: ");
        			tiendita.verProducto(codigo);
        		}else if(eleccion == 5) {
        			tiendita.mostrarProductos();
        		}else if(eleccion == 6) {
        			codigo= ingresarTexto("Ingresa el Codigo del producto: ");
        			tiendita.modificarProducto(codigo);
        		}else if(eleccion == 7) {
        			codigo= ingresarTexto("Ingresa el Codigo del producto: ");
        			tiendita.eliminarProducto(codigo);
        		}else if(eleccion == 8) {
        			tiendita.mostrarVentas();     			
        		}else if(eleccion == 9) {
        			tiendita.mostrarClientes();
        		}else if(eleccion == 10) {
        			identificacionC= ingresarTexto("Ingresa la Identificación del Cliente: ");
        			tiendita.buscarCliente(identificacionC);
        		}else if(eleccion == 11) {
        			identificacionC= ingresarTexto("Ingresa la Identificación del Cliente: ");
        			tiendita.modificarCliente(identificacionC);
        		}else if(eleccion == 12) {
        			identificacionC= ingresarTexto("Ingresa la Identificación del Cliente: ");
        			tiendita.eliminarCliente(identificacionC);
        		}else if(eleccion == 13) {
        			identificacionC= ingresarTexto("Ingresa la Identificación del Cliente: ");
        			tiendita.mostrarHistorialCliente(identificacionC);
        		}else if(eleccion == 14) {
        			nombreC= ingresarTexto("Ingresar el Nombre del Cliente: ");
        			identificacionC= ingresarTexto("Ingresa la Identificación del Cliente: ");
        			direccionC= ingresarTexto("Ingresa la Dirección");
        			telefonoC= ingresarTexto("Ingresar el Telefono: ");
        			correoC= ingresarTexto("Ingresa el Correo de Cliente");
        			tiendita.agregarCliente(nombreC, identificacionC, direccionC, telefonoC, correoC);
        		}else if(eleccion == 0) {
        			repetir4= true;
        			while (repetir4) {
        				salir= ingresarTexto("¿Está seguro de finalizar el programa? Si(y) o No(n): ");
        				if (!salir.equalsIgnoreCase("Y") && !salir.equalsIgnoreCase("N")) {
            				JOptionPane.showMessageDialog(null, "Debes de poner Si(y) o No(n), intenta de nuevo...");
            			}else {
            				repetir4= false;
            				if (salir.equalsIgnoreCase("Y")) {
            					repetir2= false;
            					JOptionPane.showMessageDialog(null, "Entendido, finalizando el Programa...");
            					System.exit(0);
            				}else {JOptionPane.showMessageDialog(null, "Entendido, prosiga con el programa...");}
        			}
            		}
        			
        		}
        	}
        
    }
    
    
    
    
    public static String ingresarTexto(String texto) {
    	boolean repetir= true, repetir2= true;
    	String mensaje= "", mensajeNull= "";
    	byte contadorNull= 0;
    	while (repetir) {
    		mensaje= JOptionPane.showInputDialog(null, texto);
    	if (mensaje == null) {
    		JOptionPane.showMessageDialog(null, "Error: no puede dejar el espacio vacio...");
    		contadorNull++;
    		if (contadorNull >= 5) {
    			while(repetir2) {
    			mensajeNull= JOptionPane.showInputDialog(null, "Demasiados errores seguidos, "
    					+ "¿desea terminar el programa? Si(y) o No(n): ");
    			if (!mensajeNull.equalsIgnoreCase("Y") && !mensajeNull.equalsIgnoreCase("N")) {
    				JOptionPane.showMessageDialog(null, "Debes de poner Si(y) o No(n), intenta de nuevo...");
    			}else {
    				if (mensajeNull.equalsIgnoreCase("Y")) {
    					repetir2= false;
    					System.exit(0);
    				}else {repetir2= false;}
    			}
    			}	
    		}
    	}else {repetir= false;}
    	}
    	return mensaje;
    }
    
    public static int ingresarInt(String texto) {
    	String numero= "";
    	int numero2= 0;
    	boolean repetir= true;
    	while (repetir) {
    		try { numero= JOptionPane.showInputDialog(null, texto);
    			numero2= Integer.parseInt(numero);
    			if (numero2<0) {
    				JOptionPane.showMessageDialog(null, "debes de ingresar un numero X>= 0...");
    			}else {repetir= false;}
    		}catch(NumberFormatException e) {
    			JOptionPane.showMessageDialog(null, "Error: debes de ingresar un número compatible...");
    	}}
    	return numero2;
    }
    
    public static double ingresarDouble(String texto) {
    	String numero= "";
    	double numero2= 0;
    	boolean repetir= true;
    	while (repetir) {
    		try { numero= JOptionPane.showInputDialog(null, texto);
    			numero2= Double.parseDouble(numero);
    			if (numero2<0) {
    				JOptionPane.showMessageDialog(null, "debes de ingresar un numero X>= 0...");
    			}else {repetir= false;}
    		}catch(NumberFormatException e) {
    			JOptionPane.showMessageDialog(null, "Error: debes de ingresar un número compatible...");
    	}}
    	return numero2;
    }
    

    
}