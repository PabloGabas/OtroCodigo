package arbol;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
import java.util.ArrayList;

public class NodoArbol {

    Persona persona;
    NodoArbol li; // Nodo izquierdo
    NodoArbol ld; // Nodo derecho

    public NodoArbol(Persona nuevaPersona) {
        this.persona = nuevaPersona;
        li = null;
        ld = null;
    }

    public void busquedaProvincia(ArrayList<String> lista, int cedula) {
        if (this.persona.getCedula() == cedula) {
            lista.add(String.valueOf(this.persona.getCedula()));
            System.out.println("Cedula encontrada " + cedula + "(La cedula a buscar se cambia en la linea 14 de principal)");
        }
        if (li != null) {
            li.busquedaProvincia(lista, cedula);
        }
        if (ld != null) {
            ld.busquedaProvincia(lista, cedula);
        }
        if (!lista.contains(String.valueOf(cedula))) {
            System.out.println("Cedula no encontrada.");
        }
    }

    public synchronized void insertar(Persona nuevaPersona) {
        int comparacion = Integer.compare(this.persona.getCedula(), nuevaPersona.getCedula());

        if (comparacion == 0) {
            return;
        }
        if (comparacion > 0) {
            if (li == null) {
                li = new NodoArbol(nuevaPersona);
                System.out.println("\nInsertado a la izquierda...");
            } else {
                li.insertar(nuevaPersona);
            }
        } else {
            if (ld == null) {
                ld = new NodoArbol(nuevaPersona);
                System.out.println("\nInsertado a la derecha...");
            } else {
                ld.insertar(nuevaPersona);
            }
        }
    }

}