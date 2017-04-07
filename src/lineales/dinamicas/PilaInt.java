/*
 * Implementacion de la pila dinamica.
 */
package lineales.dinamicas;

/**
 *
 * @author Flavia
 */
public class PilaInt {

    // Atributos
    private NodoInt tope;

    // Constructor
    /**
     * Crea y devuelve una pila vacia
     */
    public PilaInt() {
        tope = null;
    }

    //Modificadores
    /**
     * Pone el elemento en el tope de la pila
     *
     * @param numero valor a almacenar
     * @return true siempre
     */
    public boolean apilar(int numero) {
        /*
         Versión 1
         NodoInt nodoNuevo = new NodoInt(numero, null);
         nodoNuevo.setEnlace(tope);
         tope = nodoNuevo;
         Versión 2
         NodoInt nodoNuevo = new NodoInt(numero, tope);
         tope = nodoNuevo;
         Versión 3
         tope = new NodoInt(numero, tope);
         */
        NodoInt nodoNuevo = new NodoInt(numero, tope);
        tope = nodoNuevo;
        return true;
    }

    /**
     * Remueve un elemento de la pila
     *
     * @return true si el elemento se removío
     */
    public boolean desapilar() {
        boolean exito = false;
        if (!esVacia()) {
            tope = tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    /**
     * Remueve todos los elementos de la pila
     */
    public void vaciar() {
        tope = null;
    }

    // Observadoras
    /**
     * Devuelve el valor que contiene el tope de la pila.Precondicion: la pila
     * no está vacia.
     *
     * @return el elemento que se encuentra en el tope.
     */
    public int obtenerTope() {
        int elemento = Integer.MAX_VALUE;
        if (!esVacia()) {
            elemento = tope.getElem();
        }
        return elemento;
    }

    /**
     * Verifica si la pila contiene elementos.
     *
     * @return true si está vacia.
     */
    public boolean esVacia() {
        return tope == null;
    }

    /**
     * Muestra todos los elementos de la pila.
     *
     * @return un String con todos los valores de la pila
     */
    //Version Iterativa
    @Override
    public String toString() {
        String s = "";

        NodoInt aux = tope;
        while (aux != null) {
            s += aux.getElem();
            aux = aux.getEnlace();

            if (aux != null) {
                s += ",";
            }
        }
        return "[" + s + "]";
    }
        //Version Recursiva
//    public String toString() {
//        return "[" + mostrar(tope) + "]";
//    }
//
//    private String mostrar(NodoInt t) {
//         String c="";
//        if (t != null) {
//            if (t.getEnlace() == null) {
//                c += t.getElem();
//            } else {
//                c += t.getElem() +", "+ mostrar(t.getEnlace());
//            }
//        }
//        return c;
//    }

    //Propias del Tipo
    //Version Recursiva
    /**
     * Devuelve una copia de la pila original
     *
     * @return copia de la pila original
     */
    public PilaInt clonar() {
        PilaInt pilaNueva = new PilaInt();

        pilaNueva.tope = duplicar(tope);

        return pilaNueva;
    }

    private NodoInt duplicar(NodoInt aux) {
        NodoInt x;

        if (aux == null) {
            x = null;
        } else { // los nodos son creados en la etapa de composicion
            x = new NodoInt(aux.getElem(), duplicar(aux.getEnlace()));
        }

        return x;
    }
    //Version Iterativa
//    public PilaInt clonar() {
//        PilaInt nuevaPila = new PilaInt();
//        NodoInt original, copia;
//
//        if (tope != null) {
//            original = tope;
//            nuevaPila.tope = new NodoInt(original.getElem(), null);
//            copia = nuevaPila.tope;
//
//            while (original.getEnlace() != null) {
//                original = original.getEnlace();
//                copia.setEnlace(new NodoInt(original.getElem(), null));
//                copia = copia.getEnlace();
//            }
//        }
//
//        return nuevaPila;
//    }

}
