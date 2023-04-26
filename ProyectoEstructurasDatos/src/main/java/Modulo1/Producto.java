/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo1;

import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Calendar;
import java.util.Date;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.NoSuchElementException;
import javax.swing.Box;

/**
 *
 * @author DAVID
 */
public class Producto {

    //variables
    private NodosP topNodosP = null;
    protected NodosP auxTop;

    //agarra el Top de nodosP
    public NodosP getTopNodosP() {
        return topNodosP;
    }

    //Settea el top de Nodos P
    public void setTopNodosP(NodosP topNodosP) {
        this.topNodosP = topNodosP;
    }

    //Fija el nuevo top y cambia los demas de abajo de la pila
    public void pushP(NodosP pTopNodosP) {

        pTopNodosP.setAbajo(topNodosP);

        this.topNodosP = pTopNodosP;
    }

    //agrega un nodo a la pila
    public void push() {

        /*              JOption panes para los inputs          */
        // Crear un panel personalizado
        JPanel panel = new JPanel(new GridLayout(10, 2));
        //JPanel panel2 = new JPanel(new GridLayout(0, 2));
        JTextField nombreText = new JTextField(10);
        JTextField codigoText = new JTextField(10);
        JDateChooser fechaPanel = new JDateChooser();
        JTextField precioText = new JTextField(10);
        JTextField categText = new JTextField(10);

        //variables para anadir
        String nombre;
        int codigo;
        Calendar fecha = Calendar.getInstance();
        LocalDate fechaVenc;
        double precio;
        String categ;

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreText);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));//espacios en blanco
        panel.add(new JLabel("Codigo:"));
        panel.add(codigoText);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));//espacios en blanco
        panel.add(new JLabel("Precio:"));
        panel.add(precioText);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));//espacios en blanco
        panel.add(new JLabel("Categoria:"));
        panel.add(categText);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));//espacios en blanco
        panel.add(new JLabel("Fecha de Vencimiento:"));
        panel.add(fechaPanel);

        // Muestra el panel personalizado
        int option = JOptionPane.showConfirmDialog(null, panel, "Introduzca los Datos Solicitados", JOptionPane.OK_CANCEL_OPTION);

        // Procesa los datos ingresados por el usuario
        if (option == JOptionPane.OK_OPTION) {
            if (nombreText.getText().isBlank() || codigoText.getText().isBlank() || precioText.getText().isBlank() || categText.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Hubo un error en la insercion de datos, porfavor vuelva a hacerlo", "Error", JOptionPane.ERROR_MESSAGE);
                push(); //si algo peta, entonces se repite el proceso de meter el nodo
            } else {
                nombre = nombreText.getText();                        //agarra el nombre
                codigo = Integer.parseInt(codigoText.getText());      //agarra el codigo
                fecha = fechaPanel.getCalendar();                  //crea un calendario
                //crea la fechavencimiento agarrando el anio, mes y dia del calendario, al mes le suma 1 porque esta creado para que enero sea el mes 0 (wtf)
                fechaVenc = LocalDate.of(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH) + 1, fecha.get(Calendar.DAY_OF_MONTH));
                precio = Double.parseDouble(precioText.getText());     //agarra el precio
                categ = categText.getText();                        //agarra la categoria

                //agrega el nodo
                auxTop = new NodosP(nombre, codigo, fechaVenc, precio, categ, null);

                // fijando que el top tenga como .abajo los demas elementos de la pila
                auxTop.setAbajo(topNodosP);
                //Cambiar cual es nuestro nuevo TOP
                this.topNodosP = auxTop;
            }
        } else {
            if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Saliste del form :c", "Gracias c:", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public NodosP pop(int id) {
        if (topNodosP == null) {
            throw new NoSuchElementException("La pila está vacía");
        }
        NodosP prev = null;
        NodosP current = topNodosP;
        NodosP correspondiente = null; // Nueva variable para almacenar el nodo correspondiente
        while (current != null) {
            if (current.getCodigo() == id) {
                if (prev == null) { // caso especial para el primer nodo
                    topNodosP = current.getAbajo();
                } else {
                    prev.setAbajo(current.getAbajo());
                }
                correspondiente = current; // Se almacena el nodo correspondiente
                break; // Se sale del bucle al encontrar el nodo correspondiente
            }
            prev = current;
            current = current.getAbajo();
        }

        return correspondiente; // Se devuelve el nodo correspondiente
    }

    // toString
    public void recorridoPila() {
        if (this.topNodosP != null) {
            JOptionPane.showMessageDialog(null, "Inicio de la impresion!", "Inicio Impresion", JOptionPane.INFORMATION_MESSAGE);
            rRecorridoPila(this.topNodosP);
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vacia!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    //recorre la pila
    private void rRecorridoPila(NodosP pTopNodosP) {
        if (pTopNodosP.getAbajo() == null) {

            JOptionPane.showMessageDialog(null, "Los elementos son los siguientes: \n"
                    + "\nNombre: " + pTopNodosP.getNombre()
                    + "\nCodigo: " + pTopNodosP.getCodigo()
                    + "\nFecha de Vencimiento: " + pTopNodosP.getFechaV()
                    + "\nPrecio: " + pTopNodosP.getPrecio()
                    + "\nCategoria: " + pTopNodosP.getCateg());
            JOptionPane.showMessageDialog(null, "Final de la lista y de la impresion!", "Final Impresion", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(null, "Los elementos son los siguientes: \n"
                    + "\nNombre: " + pTopNodosP.getNombre()
                    + "\nCodigo: " + pTopNodosP.getCodigo()
                    + "\nFecha de Vencimiento: " + pTopNodosP.getFechaV()
                    + "\nPrecio: " + pTopNodosP.getPrecio()
                    + "\nCategoria: " + pTopNodosP.getCateg());
            //System.out.println("El dato tiene un valor de :" + pTopNodosP.getFechaV());
            rRecorridoPila(pTopNodosP.getAbajo());
        }
    }

    public void ordenarPorFecha() {
        // Crear una copia de la pila original
        NodosP tempTopNodosP = this.topNodosP;

        // Contar los elementos de la pila para saber el largo
        int numElementos = 0;
        while (tempTopNodosP != null) {
            numElementos++;
            tempTopNodosP = tempTopNodosP.getAbajo();
        }

        // Convertir la pila a un array, esto para manipularla y ordenarla de manera sencilla
        NodosP[] nodosPArray = new NodosP[numElementos];
        tempTopNodosP = this.topNodosP;
        for (int i = 0; i < numElementos; i++) {
            nodosPArray[i] = tempTopNodosP;
            tempTopNodosP = tempTopNodosP.getAbajo();
        }

        // Ordenar el array por fecha de vencimiento
        for (int i = 0; i < numElementos - 1; i++) {
            for (int j = 0; j < numElementos - i - 1; j++) {
                if (nodosPArray[j].getFechaV().isAfter(nodosPArray[j + 1].getFechaV())) {
                    NodosP temp = nodosPArray[j];
                    nodosPArray[j] = nodosPArray[j + 1];
                    nodosPArray[j + 1] = temp;
                }
            }
        }

        // Crear la nueva pila ordenada
        Producto nuevaPila = new Producto();
        for (int i = numElementos - 1; i >= 0; i--) {
            nuevaPila.pushP(nodosPArray[i]);
        }

        // Encontrar el elemento TOP con la fecha de vencimiento más cercana
        NodosP topNodosPConFechaMasCercana = null;
        LocalDate fechaActual = LocalDate.now();
        tempTopNodosP = nuevaPila.topNodosP;
        while (tempTopNodosP != null) {
            if (tempTopNodosP.getFechaV().isAfter(fechaActual)) {
                topNodosPConFechaMasCercana = tempTopNodosP;
            }
            tempTopNodosP = tempTopNodosP.getAbajo();
        }

        // Establecer la nueva pila ordenada como la pila actual
        this.topNodosP = nuevaPila.topNodosP;
    }

    // toString
    public void recorridoPilaOrdenada() {
        if (this.topNodosP != null) {
            JOptionPane.showMessageDialog(null, "Inicio de la impresion!", "Inicio Impresion", JOptionPane.INFORMATION_MESSAGE);
            ordenarPorFecha();
            rRecorridoPilaOrdenada(this.topNodosP);
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vacia!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    //recorre la pila
    private void rRecorridoPilaOrdenada(NodosP pTopNodosP) {
        if (pTopNodosP.getAbajo() == null) {

            JOptionPane.showMessageDialog(null, "Los elementos son los siguientes: \n"
                    + "\nNombre: " + pTopNodosP.getNombre()
                    + "\nCodigo: " + pTopNodosP.getCodigo()
                    + "\nFecha de Vencimiento: " + pTopNodosP.getFechaV()
                    + "\nPrecio: " + pTopNodosP.getPrecio()
                    + "\nCategoria: " + pTopNodosP.getCateg());
            JOptionPane.showMessageDialog(null, "Final de la lista y de la impresion!", "Final Impresion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Los elementos son los siguientes: \n"
                    + "\nNombre: " + pTopNodosP.getNombre()
                    + "\nCodigo: " + pTopNodosP.getCodigo()
                    + "\nFecha de Vencimiento: " + pTopNodosP.getFechaV()
                    + "\nPrecio: " + pTopNodosP.getPrecio()
                    + "\nCategoria: " + pTopNodosP.getCateg());
            //System.out.println("El dato tiene un valor de :" + pTopNodosP.getFechaV());
            rRecorridoPila(pTopNodosP.getAbajo());
        }
    }

}
