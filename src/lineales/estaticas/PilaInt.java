/*
 * Implementacion de una pila estatica
 */
package lineales.estaticas;

//import java.util.Arrays;
/**
 *
 * @author Flavia
 */
public class PilaInt {

    // Atributos
    private int[] pila;
    private int tope;
    private static final int TAM = 5;

    //Constructor
    /**
     * Crea y devuelve una pila vacia
     */
    public PilaInt() {
        pila = new int[TAM];
        tope = -1;
    }

    //Modificadores
    /**
     * Apila un elemento en la pila
     *
     * @param numero valor a almacenar
     * @return falso si la pila esta llena y verdadero si se pudo apilar
     */
    public boolean apilar(int numero) {
        boolean exito = true;
        if (tope + 1 >= TAM) { //Pila llena
            exito = false;
        } else {
            tope++;
            pila[tope] = numero;
        }
        return exito;
    }

    /**
     * Remueve un elemento de la pila.
     *
     * @return verdadero si el elemento fue desapilado exitosamente
     */
    public boolean desapilar() {
        boolean exito = true;
        if (esVacia()) {
            exito = false;
        } else {
            tope--;
        }
        return exito;
    }

    /**
     * Remueve todos los elementos de la pila.
     */
    public void vaciar() {
        tope = -1;
    }

    //Observadores
    /**
     * Analiza si la pila contiene elementos.
     *
     * @return verdadero si la pila está vacía
     */
    public boolean esVacia() {
        return tope == -1;
    }

    /**
     * Devuelve el elemento en el tope de la pila. Precondición: la pila no está
     * vacía.
     *
     * @return elemento en la posición del tope.
     */
    public int obtenerTope() {
        int valor = Integer.MAX_VALUE;
        if (!esVacia()) {
            valor = pila[tope];
        }
        return valor;
    }

    /**
     * Muestra todos los elementos de la pila.
     *
     * @return cadena de caracteres formada por los elementos de la pila
     */
    @Override

    //VERSION ITERATIVA
    public String toString() {
        String cadena = "";
        for (int i = 0; i <= tope; i++) {
            cadena = pila[i] + cadena;
            if (i != tope) {
                cadena = ", " + cadena;
            }
        }
        return "[" + cadena + "]";
    }
    //VERSION DEL SISTEMA
//    public String toString() {
//        return Arrays.toString(pila);
//    }

     //VERSION RECURSIVA
//    public String toString() {
//        String cad="";
//        if (tope>=0) {
//          cad=mostrar(tope, cad);  
//        }
//        return "["+cad+"]";
//    }
//    private String mostrar(int t, String c) {
//        if (t<=0) {
//            c = c+pila[t];
//        }else{
//            c =c+ pila[t]+", "+mostrar(t-1, c);
//        }
//        return c;
//    }
    //Propias del Tipo
    /**
     * Devuelve una copia de la pila original.
     *
     * @return copia de la pila original
     */
    //CLONAR PILA VERSION ITERATIVA
    public PilaInt clonar() {
        PilaInt nuevaPila = new PilaInt();
        for (int i = 0; i <= tope; i++) {
            nuevaPila.apilar(pila[i]);
        }
        return nuevaPila;
    }

    //CLONAR PILA VERSION RECURSIVA
//     public PilaInt clonar() {
//        PilaInt nuevaPila = new PilaInt();
//        int[] array = new int[TAM];
//        duplicar(pila, tope, array);
//        nuevaPila.pila = array;
//        nuevaPila.tope = tope;
//        return nuevaPila;
//    }
//
//    private void duplicar(int[] p, int t, int[] a) {
//        if (t == 0) {
//            a[t] = p[t];
//        } else {
//            a[t] = p[t];
//            duplicar(p, t - 1, a);
//        }
//    }
}
