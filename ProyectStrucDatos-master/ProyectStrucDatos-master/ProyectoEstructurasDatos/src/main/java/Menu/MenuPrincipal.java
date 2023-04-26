package Menu;

import Modulo1.NodosP;
import Modulo1.Producto;
import Modulo2.Cliente;
import Modulo2.ListaC;
import Modulo3.Carrito;
import Modulo4.*;
import java.time.LocalDate;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DAVID
 */
public class MenuPrincipal {

    //variables estaticas
    //productos
    static Producto pruebaPila = new Producto();
    static NodosP productoSeleccionado = new NodosP();

    //clientes
    static ListaC laLista = new ListaC();
    static Cliente clienteSeleccionado = new Cliente();

    //carrito
    static Carrito carrito = new Carrito ();
    
    //facturacion
    static ColaFacturacion fact= new ColaFacturacion ();
    static Facturacion factura = new Facturacion ();
    
    
    
    public static void main(String[] args) {
        /*MAIN MENU*/
        menuPrincipal();
         //variables
        
    }

    public static void menuPrincipal() {
        String[] opcionesMenu = {"1 - Productos", "2 - Clientes", "3 - Carrito", "4 - Facturacion", "5 - Reportes", "6 - Salir"};

        //el opciones es el arreglo de opciones que tenemos y el opciones[0] es el default si el usuario presiona enter 
        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesMenu, opcionesMenu[0]);
        switch (seleccion) {
            case 0: //productos
            {
                SubMenuProductos();

                break;
            }
            case 1: // Clientes
            {
                SubMenuClientes();
                break;
            }
            case 2: //Carrito
            {
                break;
            }
            case 3: //Facturacion
            {
                break;
            }
            case 4: //reportes
            {
                break;
            }
            default: //salir
            {
                System.exit(0);
            }
        }
    }

    private static void SubMenuProductos() {

        String[] opciones = {"1 - Agregar Productos", "2 - Ver Productos Disponibles", "3 - Seleccionar Productos", "4 - Regresar"};
        System.out.println("TEST");
        int seleccionProd = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        
        
        
        switch (seleccionProd) {
            case 0: {
                
                int resp;
                do
                {
                    pruebaPila.push();
                     resp= JOptionPane.showOptionDialog(null,"Agregar Otro producto?" ,"Confirmacion" ,JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE ,null ,new Object[]{"Si","No"} ,"Si" );
                }while (resp!=JOptionPane.NO_OPTION );
                SubMenuProductos();
                break;
            }
            case 1: 
            {
                
                pruebaPila.recorridoPila();
                SubMenuProductos();
                break;
            }
            case 2: 
            {
                String respuesta = JOptionPane.showInputDialog(null, "Digite el Codigo del Producto a Seleccionar: ", "Busqueda De Cliente ", JOptionPane.PLAIN_MESSAGE);
                productoSeleccionado = pruebaPila.pop(Integer.parseInt(respuesta));
                if(productoSeleccionado == null )
                {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun producto con el codigo: " + respuesta);
                }
            }
            default: {
                menuPrincipal();
                break;
            }
        }

    }
    
     private static void SubMenuClientes() {
        String[] opciones = {"1 - Agregar Clientes", "2 - Ver Clientes", "3 - Seleccionar Cliente", "4 - Regresar"};

        int seleccionProd = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        switch (seleccionProd) {
            case 0: {

                int resp;
                do {
                    JTextField nombreField = new JTextField(10);
                    JTextField idField = new JTextField(10);
                    JTextField correoField = new JTextField(10);
                    JTextField direccionField = new JTextField(10);
                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("Nombre:"));
                    myPanel.add(nombreField);
                    myPanel.add(Box.createHorizontalStrut(15)); // Una separación horizontal
                    myPanel.add(new JLabel("ID:"));
                    myPanel.add(idField);
                    myPanel.add(Box.createHorizontalStrut(15)); // Una separación horizontal
                    myPanel.add(new JLabel("Correo:"));
                    myPanel.add(correoField);
                    myPanel.add(Box.createHorizontalStrut(15));
                    myPanel.add(new JLabel("Dirección:"));
                    myPanel.add(direccionField);

                    // Mostramos el cuadro de diálogo de entrada de texto personalizado
                    int result = JOptionPane.showConfirmDialog(null, myPanel, "Ingrese los datos:", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        // Obtenemos los valores ingresados por el usuario

                        if (nombreField.getText().isEmpty() || idField.getText().isEmpty() || correoField.getText().isEmpty() || direccionField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Envio campos vacios, porfavor intente agregar un Cliente Valido");
                            SubMenuClientes();
                            return;
                        } else {
                            String nombre = nombreField.getText();
                            int id = Integer.parseInt(idField.getText());
                            String correo = correoField.getText();
                            String direccion = direccionField.getText();

                            laLista.inserta(new Cliente(nombre, id, correo, direccion));
                        }

                    } else {
                        SubMenuClientes();
                        return;
                    }

                    //repite el ciclo
                    resp = JOptionPane.showOptionDialog(null, "Agregar Otro Cliente?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
                } while (resp != JOptionPane.NO_OPTION);
                SubMenuClientes();
                break;
            }
            case 1: {//mostrarclientes

                JOptionPane.showMessageDialog(null, laLista);
                SubMenuClientes();
                break;
            }
            case 2: { //seleccionar cliente

                //busca un cliente que existe
                String respuesta = JOptionPane.showInputDialog(null, "Digite el ID del Cliente a Seleccionar: ", "Busqueda De Cliente ", JOptionPane.PLAIN_MESSAGE);
                Cliente cBusq = laLista.busquedaId(Integer.parseInt(respuesta));
                if (cBusq != null) {
                    JOptionPane.showMessageDialog(null, "Cliente encontrado: \n" + cBusq + "\nSe procedera a usar este Cliente para el Carrito");
                    clienteSeleccionado = cBusq;
                    System.out.println(clienteSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                    SubMenuClientes();
                    return;
                }
                SubMenuClientes();
                break;
            }
            default: {
                menuPrincipal();
                break;
            }
        }
    }
     private static void SubMenuCarrito() {

        String[] opciones = {"1 - Consultar Carrito", "2 - Eliminar Producto", "3 - Finalizar Compra", "4 - Regresar"};
        
        int seleccionProd = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        
        
        
        switch (seleccionProd) {
            case 0: {//consultar
                
                carrito.consultar();
                SubMenuCarrito();
                break;
            }
            case 1: // eliminar
            {
                String respuesta = JOptionPane.showInputDialog(null, "Digite el Codigo del Producto a Eliminar: ", "Busqueda De Producto ", JOptionPane.PLAIN_MESSAGE);
                
                carrito.eliminarProducto(Integer.parseInt(respuesta));
                
                SubMenuCarrito();
                break;
            }
            case 2: //Finalizar Compra
            {
               Carrito c = carrito.finalizarCompra();
               factura.setClient(c.getClient()); 
               factura.setListadoProductos(c.getListaProductos());
               //facturacion.agregarFactura(c);
                SubMenuCarrito();
                break;
            }
            default: {
                menuPrincipal();
                break;
            }
        }

    }
     private static void SubMenuFacturacion() {

        String[] opciones = {"1 - Consultar Facturas ", "2 - Consultar Facturas Especificas", "3 - Proceder Con el Pago", "4 - Regresar"};
        System.out.println("TEST");
        int seleccionProd = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        
        
        
        switch (seleccionProd) {
            case 0: {
                
                
                
                SubMenuFacturacion();
                break;
            }
            case 1: 
            {
                
                pruebaPila.recorridoPila();
                SubMenuFacturacion();
                break;
            }
            case 2: 
            {
                String respuesta = JOptionPane.showInputDialog(null, "Digite el Codigo del Producto a Seleccionar: ", "Busqueda De Cliente ", JOptionPane.PLAIN_MESSAGE);
                productoSeleccionado = pruebaPila.pop(Integer.parseInt(respuesta));
                if(productoSeleccionado == null )
                {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun producto con el codigo: " + respuesta);
                }
            }
            default: {
                menuPrincipal();
                break;
            }
        }

    }

}
