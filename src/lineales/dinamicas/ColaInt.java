/*
 * Implementacion de la Cola dinámica.
 */
package lineales.dinamicas;

/**
 *
 * @author Flavia
 */
public class ColaInt {

    //Atributos
    private NodoInt frente;
    private NodoInt fin;

    //Constructores
    /**
     * Crea y devuelve una cola vacia.
     */
    public ColaInt() {
        frente = null;
        fin = null;
    }

    //Modificadores
    /**
     * Inserta un elemento en la cola.
     *
     * @param numero valor a almacenar
     * @return true siempre
     */
    public boolean poner(int numero) {

        NodoInt nuevoNodo = new NodoInt(numero, null);

        if (esVacia()) {
            frente = nuevoNodo;
        } else {
            fin.setEnlace(nuevoNodo);
        }
        fin = nuevoNodo;
        return true;
    }

    /**
     * "Remueve" el elemento que se encuentra en la posicion frente de la cola.
     *
     * @return true si se eliminó, y falso si la cola está vacia.
     */
    public boolean sacar() {
        boolean exito;
        if (esVacia()) {
            exito = false;
        } else {
            exito = true;
            frente = frente.getEnlace();
            if (frente == null) {
                vaciar();
            }
        }
        return exito;
    }

    /**
     * Vacía la cola.
     */
    public void vaciar() {
        frente = null;
        fin = null;
    }

    //Observadores
    /**
     * Verifica si la cola se encuentra vacía.
     *
     * @return true si está vacía.
     */
    public boolean esVacia() {
        return frente == null;
    }

    /**
     * Obtiene el valor almacenado en la posicion frente de la cola. Si la cola
     * está vacía devuelve el maximo valor almacenable.
     *
     * @return un numero entero.
     */
    public int obtenerFrente() {
        int valor = Integer.MAX_VALUE;
        if (!esVacia()) {
            valor = frente.getElem();
        }
        return valor;
    }

    @Override

    //Version iterativa
    /**
     * Muestra todos los elementos de la cola.
     */
    public String toString() {
        NodoInt aux = frente;
        String cadena = "";
        while (aux != null) {
            cadena += aux.getElem();
            aux = aux.getEnlace();
            if (aux != null) {
                cadena += ", ";
            }
        }
        return "[" + cadena + "]";
    }
    //Version Recursiva
//    public String toString() {
//        return "[" + mostrar(frente) + "]";
//    }
//    private String mostrar(NodoInt x) {
//        String cadena = "";
//        if (!esVacia()) {
//            if (x.getEnlace() == null) {
//                cadena += x.getElem();
//            } else {
//                cadena += x.getElem() + ", " + mostrar(x.getEnlace());
//            }
//        }
//        return cadena;
//    }    

    //Propias del Tipo
    /**
     * Devuelve una copia de la cola original.
     *
     * @return copia de la cola original.
     */

    public ColaInt clonar() {
        ColaInt nuevaCola = new ColaInt();
        NodoInt aux;
        aux = frente;
        while (aux != null) {
            nuevaCola.poner(aux.getElem());
            aux = aux.getEnlace();
        }
        return nuevaCola;
    }
}
