/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modulo4;

/**
 *
 * @author marflord
 */
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

//***En esta sección se están importando las librerías necesarias para el correcto funcionamiento del programa. 
//***java.util.Arrays y java.util.List son necesarias para trabajar con listas en Java,
//***mientras que javax.swing.JOptionPane es necesaria para mostrar cuadros de diálogo en la interfaz gráfica del usuario.
public class EjemploFacturacion {
    public static void main(String[] args) {
        ColaFacturacion cola = new ColaFacturacion();
        
        //*** Se declara una variable entera opcion que se utiliza para almacenar la opción elegida por el usuario.
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                  Seleccione una opci\u00f3n:
                                                                  
                                                                  1. Agregar factura
                                                                  2. Consultar todas las facturas
                                                                  3. Consultar una factura por c\u00f3digo
                                                                  4. Eliminar una factura por c\u00f3digo
                                                                  5. Salir"""));
            
    ///Aquí se muestra un cuadro de diálogo para que el usuario elija una opción.
    //Se utiliza un do-while para que el cuadro de diálogo se muestre hasta que el usuario elija la opción de salir.
            switch (opcion) {
                case 1 -> {
                    Facturacion factura = crearFactura();
                    cola.agregarFactura(factura);
                    JOptionPane.showMessageDialog(null, "La factura se ha agregado correctamente.");
                }
                case 2 -> cola.consultarFacturas();
                case 3 -> {
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código de la factura a consultar:"));
                    cola.consultarFactura(codigo);
                }
                case 4 -> {
                    int codigoEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código de la factura a eliminar:"));
                    boolean eliminada = cola.eliminarFactura(codigoEliminar);
                    if (eliminada) {
                        JOptionPane.showMessageDialog(null, "La factura se ha eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró una factura con ese código.");
                    }
                }
                case 5 -> JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 5);
    }
    ///En función de la opción elegida por el usuario, se ejecuta un bloque de código diferente. 
    ///Si se elige la opción 1, se llama al método crearFactura para crear una nueva factura y se agrega a la cola.
    //Si se elige la opción 2, se muestra la lista de todas las facturas en la cola. 
    ///Si se elige la opción 3, se pide al usuario que ingrese un código de factura y se muestra la factura correspondiente. 
    ///Si se elige la opción 4, se pide al usuario que ingrese un código de factura y se elimina la factura correspondiente de la cola. 
    private static Facturacion crearFactura() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código de la factura:"));
        String encabezado = JOptionPane.showInputDialog("Ingrese el encabezado de la factura:");
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la factura:");
        String productosString = JOptionPane.showInputDialog("Ingrese los productos de la factura, separados por comas:");
        List<String> productos = Arrays.asList(productosString.split(","));
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto de la factura:"));
        double iva = monto * 0.13;
        double montoTotal = monto + iva;
        String medioPago = JOptionPane.showInputDialog("Ingrese el medio de pago de la factura:");
        return new Facturacion(codigo, encabezado, fecha, productos, monto, iva, montoTotal, medioPago);
    }
}
