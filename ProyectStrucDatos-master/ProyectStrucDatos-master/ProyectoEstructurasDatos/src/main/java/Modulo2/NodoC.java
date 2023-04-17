/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo2;

/**
 *
 * @author andre
 */
public class NodoC {
    private Cliente dato;
    private NodoC next;
    private NodoC back;

    //Constructor con parametros
    public NodoC(Cliente pDato) {
        this.dato = pDato;
        this.next = null;
        this.back = null;
    }

    public NodoC() {
       
    }

    // sets y gets de los atributos
    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente pDato) {
        this.dato = pDato;
    }

    public NodoC getNext() {
        return next;
    }

    public void setNext(NodoC pNext) {
        this.next = pNext;
    }

    public NodoC getBack(){
        return back;
    }
    
    public void setBack(NodoC pBack){
        this.back = pBack;
    }
    
    @Override // string con la informacion del objeto
    public String toString() {
        return dato.toString();
    }
    //+ "Cliente: "
}
