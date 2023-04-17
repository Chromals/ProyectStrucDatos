/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo4;

/**
 *
 * @author marflord
 */
public class NodoF {
    private Facturacion factura; // Facturacion que contiene el NodoF
    private NodoF siguiente; // El NodoF siguiente en la lista
    
    /**
     * Constructor de la clase NodoF.
     * @param factura La factura que se asigna a este NodoF.
     */
    public NodoF(Facturacion factura) {
        this.factura = factura;
        this.siguiente = null;
    }
    
    /**
     * Obtiene la factura contenida en este NodoF.
     * @return La factura contenida en este NodoF.
     */
    public Facturacion getFactura() {
        return factura;
    }
    
    /**
     * Obtiene el NodoF siguiente en la lista.
     * @return El NodoF siguiente en la lista.
     */
    public NodoF getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece el NodoF siguiente en la lista.
     * @param siguiente El NodoF siguiente en la lista.
     */
    public void setSiguiente(NodoF siguiente) {
        this.siguiente = siguiente;
    }
}
