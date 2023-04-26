/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo1;

import java.time.LocalDate;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 *
 * @author DAVID
 */
public class NodosP 
{
    //variables
    private NodosP abajo;
    private Producto pila = new Producto();
    private String nombre;
    private int codigo;
    private LocalDate fechaVenc;
    private double precio;
    private String categ;
    
  

     //constructor  
    public NodosP(String nombre,int codigo, LocalDate fechaVenc,double precio, String categ, NodosP abajo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaVenc = fechaVenc;
        this.precio = precio;
        this.categ = categ;
        this.abajo = abajo;
    }

    public NodosP() {
      
    }

    

    /*Getter's y Setter's*/
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public LocalDate getFechaV() {
        return fechaVenc;
    }

    public void setFechaV(LocalDate fechaVenc) {
        this.fechaVenc = fechaVenc;
    }
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }
    

    
    //NodosP abajo
    public NodosP getAbajo() {
        return this.abajo;
    }

    public void setAbajo(NodosP abajo) {
        this.abajo = abajo;
    } 
    
    protected NodosP auxTop;
    protected NodosP topNodosP = pila.getTopNodosP();
    
   
  
    
    
    
    //agrega un nodo a la pila
    public void push(String nombre, int codigo, LocalDate fechaVenc, double precio, String categ) {

        //agrega el nodo
        auxTop = new NodosP(nombre, codigo, fechaVenc, precio, categ, null);

        // fijando que el top tenga como .abajo los demas elementos de la pila
        auxTop.setAbajo(topNodosP);
        //Cambiar cual es nuestro nuevo TOP
        this.topNodosP = auxTop;

    }

    public NodosP pop() {
        if (topNodosP == null) {
            throw new NoSuchElementException("La pila está vacía");
        }

        NodosP dato = topNodosP;
        topNodosP = topNodosP.getAbajo();
        return topNodosP;
    }
    
    
    
    
    
    
    
    
}
