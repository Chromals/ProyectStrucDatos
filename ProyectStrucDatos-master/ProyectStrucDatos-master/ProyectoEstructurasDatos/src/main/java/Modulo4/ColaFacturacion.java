/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo4;

/**
 *
 * @author marflord
 */
/**
 * Agrega una nueva factura al final de la lista.
 *
 * @param factura La factura a agregar.
 */
import java.util.List;
import javax.swing.JOptionPane;

public class ColaFacturacion {

    private NodoF primero;
    private NodoF ultimo;
    private int size;

    // Constructor de la clase ColaFacturacion.
    public ColaFacturacion() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

// Método para verificar si la cola está vacía.
    public boolean estaVacia() {
        return primero == null;
    }

// Método para obtener el tamaño de la cola.
    public int getSize() {
        return size;
    }

// Método para agregar una factura a la cola.
    public void agregarFactura(Facturacion factura) {
        NodoF nuevoNodo = new NodoF(factura);
        if (estaVacia()) { // Si la cola está vacía, se agrega el nodo como primer y último elemento.
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else { // Si la cola no está vacía, se agrega el nodo al final de la cola.
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        size++; // Se incrementa el tamaño de la cola.
    }

// Método para consultar todas las facturas de la cola.
    public void consultarFacturas() {
        if (estaVacia()) { // Si la cola está vacía, se muestra un mensaje de que no hay facturas registradas.
            JOptionPane.showMessageDialog(null, "No hay facturas registradas.");
            return;
        }
        String mensaje = "Lista de facturas: \n\n";
        NodoF actual = primero;
        while (actual != null) { // Se recorre la cola y se agrega la información de cada factura al mensaje.
            mensaje += "Código: " + actual.getFactura().getCodigo() + "\n";
            mensaje += "Encabezado: " + actual.getFactura().getEncabezado() + "\n";
            mensaje += "Fecha: " + actual.getFactura().getFecha() + "\n";
            mensaje += "Listado de productos: \n";
            List<String> productos = actual.getFactura().getListadoProductos();
            for (String producto : productos) { // Se recorre la lista de productos de cada factura y se agrega al mensaje.
                mensaje += "- " + producto + "\n";
            }
            mensaje += "Monto: " + actual.getFactura().getMonto() + "\n";
            mensaje += "IVA: " + actual.getFactura().getIVA() + "\n";
            mensaje += "Monto total: " + actual.getFactura().getMontoTotal() + "\n";
            mensaje += "Medio de pago: " + actual.getFactura().getMedioPago() + "\n\n";
            actual = actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, mensaje); // Se muestra el mensaje con la información de todas las facturas.
    }

// Método para consultar una factura por su código.
    public void consultarFactura(int codigo) {
        NodoF actual = primero;
        while (actual != null) { // Se recorre la cola buscando la factura con el código dado.
            if (actual.getFactura().getCodigo() == codigo) {
                int camposFaltantes = 0;
                Facturacion factura = actual.getFactura();
                if (factura.getEncabezado() == null || factura.getEncabezado().equals("")) {
                    camposFaltantes++;
                }
                if (factura.getFecha() == null || factura.getFecha().equals("")) {
                    camposFaltantes++;
                }
                if (factura.getListadoProductos() == null || factura.getListadoProductos().isEmpty()) {
                    camposFaltantes++;
                }
                if (factura.getMedioPago() == null || factura.getMedioPago().equals("")) {
                    camposFaltantes++;
                }
                String mensaje = "La factura con código " + codigo + " existe.\n";
                if (camposFaltantes > 0) {
                    mensaje += "Faltan " + camposFaltantes + " campos por completar.";
                } else {
                    mensaje += "Todos los campos están completos.";
                }
                JOptionPane.showMessageDialog(null, mensaje);
                return;
            }
            actual = actual;
        }
    }

    boolean eliminarFactura(int codigoEliminar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}