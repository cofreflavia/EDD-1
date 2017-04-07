/*
 *Implementación de la Cola estática.
 */
package lineales.estaticas;

/**
 *
 * @author Flavia
 */
public class ColaInt {

    //Atributos
    private final int[] cola;
    private static final int TAM = 100;
    private int frente;
    private int fin;

    //Constructor
    /**
     * Crea y devuelve una cola vacía.
     */
    public ColaInt() {
        cola = new int[TAM];
        frente = 0;
        fin = 0;
    }

    //Modificadores
    /**
     * Agrega un elemento a la cola.
     *
     * @param numero elemento a almacenar en la cola.
     * @return verdadero si el elemento se pudo poner en la cola.
     */
    public boolean poner(int numero) {
        boolean exito;

        if (frente == (fin + 1) % TAM) {
            exito = false;
        } else {
            cola[fin] = numero;
            fin = (fin + 1) % TAM;
            exito = true;
        }

        return exito;
    }

    /**
     * Elimina un elemento de la cola (el que se encuentra primero en la cola)
     *
     * @return verdadero si la operación fue exitosa.
     */
    public boolean sacar() {
        boolean exito;

        if (esVacia()) {
            exito = false;
        } else {
            frente = (frente + 1) % TAM;
            exito = true;
        }

        return exito;
    }

    /**
     * Elimina todos los elementos de la cola.
     */
    public void vaciar() {
        frente = fin;
    }

    //Observadores
    /**
     * Verifica si la cola esta vacia.
     *
     * @return true si la cola no contiene elementos.
     */
    public boolean esVacia() {
        return frente == fin;
    }

    /**
     * Devuelve el primer elemento que está en la cola. PRECONDICIÓN: la cola no
     * está vacía.
     *
     * @return primer elemento de la cola o -1 si está vacía.
     */
    public int obtenerFrente() {
        int elemento;

        if (esVacia()) {
            elemento = Integer.MAX_VALUE;
        } else {
            elemento = cola[frente];
        }
        return elemento;
    }

    /**
     * Muestra todos los elementos de la cola.
     *
     * @return un String formada por los elementos de la cola.
     */
    @Override
    public String toString() {
        String c = "";
        int aux;
        aux = frente;
        while (aux != fin) {
            c += cola[aux];
            aux = (aux + 1) % TAM;
            if (aux != fin) {
                c += ", ";
            }
        }
        return "[" + c + "]";
    }

    //Propias del Tipo
    /**
     * Devuelve una copia de la cola original.
     *
     * @return copia de la pila original
     */
    public ColaInt clonar() {
        ColaInt colaCopia = new ColaInt();

        colaCopia.fin = fin;
        colaCopia.frente = frente;

        for (int i = 0; i < TAM; i++) {
            colaCopia.cola[i] = cola[i];
        }

        return colaCopia;
    }

}
