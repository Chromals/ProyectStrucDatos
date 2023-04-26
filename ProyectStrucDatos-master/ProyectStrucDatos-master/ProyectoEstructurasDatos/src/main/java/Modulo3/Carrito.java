/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo3;

import Modulo1.NodosP;
import Modulo1.Producto;
import Modulo2.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author durrozx
 */
public class Carrito 
{
    List<NodosP> listaProductos;
    Cliente client;

    public Carrito(List<NodosP> listaProductos, Cliente client) 
    {
        this.listaProductos = listaProductos;
        this.client = client;
    }

    public Carrito() {
        
    }

    public Cliente getClient() 
    {
        return client;
    }

    public void setClient(Cliente client) 
    {
        this.client = client;
    }
    public void agregarProducto(NodosP producto){
        listaProductos.add(producto);
    }
   
    public void consultar() {
        if
                (listaProductos.isEmpty()) {
          JOptionPane.showMessageDialog(null, "El carrito esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String msg = "";   
            for(NodosP producto : listaProductos) {
                msg+= producto.toString()+ "\n";
            }
          
            JOptionPane.showMessageDialog(null, "Información del carrito \nCliente:  "+client.toString()+ "Productos: \n"+msg, "Información ", JOptionPane.INFORMATION_MESSAGE);
          
        }
    }
    public void eliminarProducto(int codigo) {
    NodosP productoEncontrado = null;
    for (NodosP producto : listaProductos) {
        if (producto.getCodigo() == codigo) {
            productoEncontrado = producto;
            break;
        }
    }
    if (productoEncontrado != null) {
        listaProductos.remove(productoEncontrado);
        JOptionPane.showMessageDialog(null, "Producto eliminado del carrito", "Información", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró el producto en el carrito", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   public Carrito finalizarCompra()
    {
        Carrito c = new Carrito(listaProductos,client);
        return c;
    }

    @Override
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Información del carrito:\n");
        sb.append("Cliente: ").append(client.toString()).append("\n");
        for(NodosP producto : listaProductos) {
            sb.append("Producto: ").append(producto.toString()).append("\n");
        }
        return sb.toString();
    }
}
