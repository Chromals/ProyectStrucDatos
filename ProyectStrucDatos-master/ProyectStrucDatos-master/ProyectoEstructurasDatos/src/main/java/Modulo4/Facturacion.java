/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo4;

import java.util.List;

/**
 *
 * @author marflord
 */
public class Facturacion {
   // Variables miembro que almacenan los detalles de la factura
private int codigo;                 // código de la factura
private String encabezado;          // encabezado de la factura
private String fecha;               // fecha de la factura
private List<String> listadoProductos;  // lista de productos de la factura
private double monto;               // monto de la factura
private double iva;                 // impuesto del valor añadido (IVA) de la factura
private double montoTotal;          // monto total de la factura
private String medioPago;           // medio de pago utilizado

// Constructor de la clase Facturacion que inicializa todos los detalles de la factura
public Facturacion(int codigo, String encabezado, String fecha, List<String> listadoProductos, double monto, double iva1, double montoTotal1, String medioPago) {
    this.codigo = codigo;
    this.encabezado = encabezado;
    this.fecha = fecha;
    this.listadoProductos = listadoProductos;
    this.monto = monto;
    this.iva = monto * 0.13;        // Calcula el IVA del monto de la factura
    this.montoTotal = monto + this.iva; // Calcula el monto total de la factura
    this.medioPago = medioPago;
}

// Métodos para obtener los detalles de la factura
public int getCodigo() {
    return codigo;
}

public String getEncabezado() {
    return encabezado;
}

public String getFecha() {
    return fecha;
}

public List<String> getListadoProductos() {
    return listadoProductos;
}

public double getMonto() {
    return monto;
}

public double getIVA() {
    return iva;
}

public double getMontoTotal() {
    return montoTotal;
}

public String getMedioPago() {
    return medioPago;
}
    
}

///En resumen, la clase Facturacion es un objeto que representa una factura con todos los detalles relacionados con ella. 
///Los detalles incluyen el código de la factura, el encabezado de la factura, la fecha de la factura, la lista de productos de la factura, 
///el monto de la factura, el impuesto del valor añadido (IVA) de la factura, el monto total de la factura y el medio de pago utilizado. 
//El constructor de la clase inicializa todos los detalles de la factura y los métodos getter permiten obtener los detalles de la factura.