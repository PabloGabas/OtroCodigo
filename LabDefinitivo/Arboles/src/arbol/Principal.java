package arbol;

import utilidades.Archivo;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Arbol arbol = Archivo.cargarDatos();// este es nuestro mega constructor de la clase, para usar alguna funcion de los arboles es arbol. y ahi salen todas
        arbol.obtenerProvincia(102260430);

        NodoArbol raiz = arbol.retornaraiz();
        if (raiz != null && raiz.persona != null) {
            System.out.println("La mera raiz es " + raiz.persona.getCedula());
        } else {
            System.out.println("no sirve porque raiz y persona estan nulos en "
                    + "codigo.");
        }

    
        System.out.println("Lista en preorden ");
        arbol.getPreOrden(raiz);
        System.out.println("\n");

//        System.out.println("Lista inOrder antes de la modificación:");
//        arbol.getInOrden(raiz);
//        System.out.println("\n");

        System.out.println("Lista PostOrden ");
        arbol.getPostOrden(raiz);
        System.out.println("\n");

  

         System.out.println("Cedula modificada (linea 39)");
         arbol.editarDato(603570694, 0);
        System.out.println("Lista en preorden despues de modificar la cedula:");
        arbol.getPreOrden(raiz);
        System.out.println("\n");

//        System.out.println("Lista inOrder despues de la modificar la cedula:");
//        arbol.getInOrden(raiz);
//        System.out.println("\n");

        System.out.println("Lista PostOrden despues de la modificar la cedula:");
        arbol.getPostOrden(raiz);
        System.out.println("\n");

        // Eliminar cedula
        System.out.println("Eliminar cedula (se cambia en la 54)");
        arbol.eliminar(102260431);

        // aqui van despues de eliminarlos 
        System.out.println("Lista en preorden y postOrden despues de eliminar la cedula");
        arbol.getPreOrden(raiz);
        System.out.println("\n");
        arbol.getPostOrden(raiz);
    }

}
