/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ListaC {

    private NodoC ultimo, cabeza;

    public void inserta(Cliente p) {
        NodoC nuevo = new NodoC(p);

        if (cabeza == null) {
            this.cabeza = this.ultimo = nuevo;

        } else if (p.getId() < this.cabeza.getDato().getId()) {
            nuevo.setNext(this.cabeza);
            this.cabeza.setBack(nuevo);
            this.cabeza = nuevo;

        } else if (p.getId() > this.ultimo.getDato().getId()) {
            nuevo.setBack(this.ultimo);
            this.ultimo.setNext(nuevo);
            this.ultimo = nuevo;

        } else {
            NodoC aux = this.cabeza;

            while (aux.getDato().getId() < p.getId()) {
                aux = aux.getNext();
            }

            nuevo.setNext(aux);
            nuevo.setBack(aux.getBack());
            aux.setBack(nuevo);
            nuevo.getBack().setNext(nuevo);

        }

        this.ultimo.setNext(cabeza);
        this.cabeza.setBack(ultimo);

    }

    public Cliente busquedaId(int id) {

        int nodos=1;
        if (this.cabeza == null || this.ultimo == null) {
            JOptionPane.showMessageDialog(null, "La Lista esta Vacia", "Error", JOptionPane.ERROR);
            return null;
        }

        NodoC aux = this.ultimo;
        
        
        if (this.cabeza == this.ultimo) { // Si solo hay un nodo
            if (aux.getDato().getId() == id) {
                return aux.getDato();
            } else {
                
                return null;
            }
        }
        
        

        while (aux != this.cabeza) 
        {
            if (aux.getDato().getId() == id) {
                return aux.getDato();
            }
            aux = aux.getBack();
        }
        
        if(aux==this.cabeza)
        {
            if (aux.getDato().getId() == id) {
                return aux.getDato();
            }
        }

        
        return null;
    }

    public void eliminar(int id) {

        //la lista esta vacia
        if (this.cabeza == null) {
            System.out.println("la lista esta vacia");
        } else {
            // Si el valor a eliminar esta en la cabeza de la lista o en el ultimo
            if (this.cabeza.getDato().getId() == id) {

                this.cabeza = this.cabeza.getNext();
                this.ultimo.setNext(this.cabeza);
                this.cabeza.setBack(this.ultimo);
                return;
            } else if (this.ultimo.getDato().getId() == id) {

                this.ultimo = this.ultimo.getBack();
                this.ultimo.setNext(this.cabeza);
                this.cabeza.setBack(this.ultimo);

                return;

            } else {
                //recorremos la lista y Buscamos el nodo que contiene el valor a eliminar 
                NodoC anterior = this.cabeza;
                NodoC actual = this.cabeza.getNext();

                while (actual != null) {
                    if (actual.getDato().getId() == id) {
                        anterior.setNext(actual.getNext());
                        actual.setNext((null));
                        return;
                    }
                    anterior = actual;
                    actual = actual.getNext();
                }
            }
        }

    }

    public Cliente extrae(int id) {
        // lo crea con 0  y "" porque sino peta al asignar un valor
        Cliente p = new Cliente();

        //Revisa si el nodo cabeza y ultimo estan vacios -> retorna null, sino empieza a buscar
        if (this.cabeza == null) {
            // La lista está vacía
            return null;
        }

        // Si la lista tiene un solo nodo
        if (this.cabeza == this.ultimo) {
            if (this.cabeza.getDato().getId() == id) {
                NodoC eliminado = this.cabeza;
                this.cabeza = null;
                this.ultimo = null;

                eliminado.setNext(null);
                eliminado.setBack(null);

                p.setId(eliminado.getDato().getId());
                p.setNombre(eliminado.getDato().getNombre());
                p.setCorreo(eliminado.getDato().getCorreo());
                p.setDireccion(eliminado.getDato().getDireccion());
                return p;
            }
            //si la id no se encontro entonces tira null
            return null;
        }

        // Si el valor a eliminar esta en la cabeza
        if (this.cabeza.getDato().getId() == id) {
            NodoC eliminado = this.cabeza;
            this.cabeza = this.cabeza.getNext();
            this.ultimo.setNext(this.cabeza);
            this.cabeza.setBack(this.ultimo);

            eliminado.setNext(null);
            eliminado.setBack(null);

            p.setId(eliminado.getDato().getId());
            p.setNombre(eliminado.getDato().getNombre());
            p.setCorreo(eliminado.getDato().getCorreo());
            p.setDireccion(eliminado.getDato().getDireccion());

            return p;
        }

        // Si el valor a eliminar está en el ultimo 
        if (this.ultimo.getDato().getId() == id) {
            NodoC eliminado = this.ultimo;
            this.ultimo = this.ultimo.getBack();
            this.ultimo.setNext(this.cabeza);
            this.cabeza.setBack(this.ultimo);

            eliminado.setNext(null);
            eliminado.setBack(null);

            p.setId(eliminado.getDato().getId());
            p.setNombre(eliminado.getDato().getNombre());
            p.setCorreo(eliminado.getDato().getCorreo());
            p.setDireccion(eliminado.getDato().getDireccion());

            return p;
        }

        // Busca el nodo que tiene el valor a eliminar
        NodoC anterior = this.cabeza;
        NodoC actual = this.cabeza.getNext();

        while (actual != this.cabeza) {
            if (actual.getDato().getId() == id) {
                NodoC eliminado = actual;
                NodoC despues = actual.getNext();

                anterior.setNext(actual.getNext());
                despues.setBack(anterior);

                eliminado.setNext(null);
                eliminado.setBack(null);

                p.setId(eliminado.getDato().getId());
                p.setNombre(eliminado.getDato().getNombre());
                p.setCorreo(eliminado.getDato().getCorreo());
                p.setDireccion(eliminado.getDato().getDireccion());

                return p;
            }
            anterior = actual;
            actual = actual.getNext();
        }

        return null; // El valor no se encontro

    }

    public void modificar(Cliente p) {

        // Revisa si la lista está vacía
        if (this.cabeza == null) {
            JOptionPane.showMessageDialog(null, "La Lista esta Vacia", "Error", JOptionPane.ERROR);
            System.out.println("la lista esta vacia");
        }

        // Si la lista tiene un solo nodo
        if (this.cabeza == this.ultimo) {
            if (this.cabeza.getDato().getId() == p.getId()) {
                this.cabeza.getDato().setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
                return;
            }
            // Si la id no se encontró, retorna falso
            return;
        }

        // Si el valor a modificar está en la cabeza
        if (this.cabeza.getDato().getId() == p.getId()) {
            this.cabeza.getDato().setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
            return;
        }

        // Si el valor a modificar está en el último
        if (this.ultimo.getDato().getId() == p.getId()) {
            this.ultimo.getDato().setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
            return;
        }

        // Busca el nodo que tiene el valor a modificar
        NodoC actual = this.cabeza.getNext();
        while (actual != this.cabeza) {
            if (actual.getDato().getId() == p.getId()) {
                actual.getDato().setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
                return;
            }
            actual = actual.getNext();
        }

        // Si el valor no se encontró, retorna falso
        return;
    }

    @Override //string con la informacion de la lista
    public String toString() {
        String s = "Lista Clientes: \n";
        System.out.println(this.cabeza);
        NodoC aux = this.cabeza;

        if (aux != null) {
            s += aux + ", \n";
            aux = aux.getNext();
            while (aux != this.cabeza) {
                s += aux + ", \n";
                aux = aux.getNext();
            }

        } else {
            s += "vacia";
        }

        return s;
    }

}
