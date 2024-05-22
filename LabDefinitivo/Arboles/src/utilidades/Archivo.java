/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;
import arbol.Arbol;
import arbol.Persona;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pablonoguera
 */
public class Archivo {
    public static Arbol cargarDatos() {
        Arbol arbol = new Arbol();
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("Datos.txt");//este es el txt grande, ya esta en el proyecto 
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String[] datos = sc.nextLine().split(",");
                int cedula = Integer.parseInt(datos[0].trim());//Diego, esa vara la volvi un int porque cambie el atributo en Persona de cedula, ahora es int
                Persona nuevaPersona = new Persona(cedula);
                arbol.insertarNodo(nuevaPersona);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
        return arbol;
    }
    
}
