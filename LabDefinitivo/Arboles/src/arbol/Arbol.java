package arbol;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Arbol {

    private NodoArbol nodoar;

    public Arbol() {
        nodoar = null;
    }

    public ArrayList<String> obtenerProvincia(int cedula) {
        ArrayList<String> lista = new ArrayList<>();
        if (nodoar != null) {
            nodoar.busquedaProvincia(lista, cedula);
        }
        return lista;
    }

    public NodoArbol retornaraiz() {
        return nodoar;
    }

    public synchronized void insertarNodo(Persona nuevaPersona) {
        if (nodoar == null) {
            nodoar = new NodoArbol(nuevaPersona);
            System.out.println("\nInsertado en la Raiz...");
        } else {
            nodoar.insertar(nuevaPersona);
        }
    }

    /**
     * Fragmento tomado del proyecto algoritmos compartido por usted profe
     *
     * @param raiz
     */
    public synchronized void getInOrden(NodoArbol raiz) {
        if (raiz != null) {
            getInOrden(raiz.li); // Visita en Orden árbol izquierdo
            System.out.print(" " + raiz.persona.getCedula()); // Visita nodo
            getInOrden(raiz.ld); // Visita EnOrden árbol derecho
        }
    }

    public synchronized void getPreOrden(NodoArbol raiz) {
        if (raiz != null) {
            System.out.print(" " + raiz.persona.getCedula()); // Visita nodo
            getPreOrden(raiz.li); // Visita en Orden árbol izquierdo
            getPreOrden(raiz.ld); // Visita EnOrden árbol derecho
        }
    }

    public synchronized void getPostOrden(NodoArbol raiz) {
        if (raiz != null) {
            getPostOrden(raiz.li); // Visita en Orden árbol izquierdo
            getPostOrden(raiz.ld); // Visita EnOrden árbol derecho
            System.out.print(" " + raiz.persona.getCedula()); // Visita nodo
        }
    }

    /**
     * metodo para elimnar datos en un arbol
     *
     * @param cedula recibe de parametro la cedula Video del codigo:
     * https://youtu.be/Q_0h4iALDfY?si=GoEnLzguSXEjT1pE modificado por el manudo
     * mayor
     */
    public synchronized void eliminar(int cedula) {
        nodoar = eliminarN(nodoar, cedula);
    }

    public NodoArbol eliminarN(NodoArbol aux, int cedula) {
        if (aux == null) {
            System.out.println("Nodo no encontrado");
        } else if (cedula < aux.persona.getCedula()) {
            NodoArbol iz = eliminarN(aux.li, cedula);
            aux.li = iz;
        } else if (cedula > aux.persona.getCedula()) {
            NodoArbol der = eliminarN(aux.ld, cedula);
            aux.ld = der;
        } else {
            NodoArbol p = aux;
            if (p.ld == null) {
                aux = p.li;
            } else if (p.li == null) {
                aux = p.ld;
            } else {
                p = cambiar(p);
            }
            p = null;
        }
        return aux;
    }

    protected NodoArbol cambiar(NodoArbol aux) {
        NodoArbol p = aux;
        NodoArbol a = aux.li;
        while (a.ld != null) {
            p = a;
            a = a.ld;
        }
        aux.persona = a.persona;
        if (p == aux) {
            p.li = a.li;
        } else {
            p.ld = a.li;
        }
        return a;
    }

    public void editarDato(int viejaCedula, int cedula2) {
        nodoar = editar(nodoar, viejaCedula, cedula2);
    }

    private NodoArbol editar(NodoArbol nodo, int viejaCedula, int cedula2) {
        if (nodo == null) {
            System.out.println("Nuevo dato insertado en el árbol.");
            return new NodoArbol(new Persona(cedula2));
        }
        if (viejaCedula == nodo.persona.getCedula()) {
            nodo.persona.setCedula(cedula2);
            System.out.println("Dato editado correctamente.");
        } else if (viejaCedula < nodo.persona.getCedula()) {
            nodo.li = editar(nodo.li, viejaCedula, cedula2);
        } else {
            nodo.ld = editar(nodo.ld, viejaCedula, cedula2);
        }

        return nodo;
    }

}
