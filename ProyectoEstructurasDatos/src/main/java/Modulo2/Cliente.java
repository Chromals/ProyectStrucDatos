/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo2;

/**
 *
 * @author andre
 */
public class Cliente {
    private String Nombre;
    private int id;
    private String correo;
    private String Direccion;
    
    
   
    
    //Constructor por defecto
    public Cliente (){
        this.Nombre = "";
        this.id = -1;
        this.correo = "";
        this.Direccion = "";
    }
    
    //Constructor con parametros
     public Cliente(String Nombre, int id, String correo, String Direccion) {
        this.Nombre = Nombre;
        this.id = id;
        this.correo = correo;
        this.Direccion = Direccion;
    }

    // sets y gets de los atributos

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

   

    
    
    @Override
    public String toString() {
        return "Cliente -> {" + "ID: " + id + ", Nombre: " + Nombre + ", Correo: " + correo + ", Direccion: " + Direccion + '}';
    }
}
