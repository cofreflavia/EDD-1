/*
 * Implementacion de la lista de simple enlace dinámica.
 */
package lineales.dinamicas;

/**
 *
 * @author Flavia
 */
public class ListaInt {

    //Atributos
    private NodoInt cabecera;
    private int longitud;

    //Constructor
    /**
     * Crea y devuelve una lista vacía.
     */
    public ListaInt() {
        cabecera = null;
        longitud = 0;
    }

    //Modificadores
    /**
     * Añade un nuevo elemento en la lista.
     *
     * @param nuevoElem número entero
     * @param pos posición a insertar el elemento
     * @return verdadero si la inserción fue exitosa
     */
    public boolean insertar(int nuevoElem, int pos) {
        boolean exito = true;
        if (pos < 1 || pos > longitud + 1) {
            exito = false;
        } else {
            if (pos == 1) {
                cabecera = new NodoInt(nuevoElem, cabecera);
            } else {
                NodoInt aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                NodoInt nuevo = new NodoInt(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud++;
        }
        return exito;
    }

    /**
     * Elimina un elemento de la lista.
     *
     * @param pos posición del elemento a eliminar
     * @return verdadero si la eliminación fue exitosa
     */
    public boolean eliminar(int pos) {
        boolean exito = false;
        if (pos >= 1 && pos <= longitud) {
            if (pos == 1) {
                cabecera = cabecera.getEnlace();
            } else {
                NodoInt aux = cabecera;
                for (int i = 2; i < pos; i++) {
                    aux = aux.getEnlace();
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            exito = true;
            longitud--;
        }
        return exito;
    }

    /**
     * Vacía una Lista.
     *
     */
    public void vaciar() {
        cabecera = null;
        longitud = 0;
    }

    //Observadores
    /**
     * Determina la cantidad de elementos en una lista.
     *
     * @return cantidad de elementos de la lista
     */
    public int longitud() {
        return longitud;
    }

    /**
     * Verifica si una Lista está vacía.
     *
     * @return verdadero si la lista está vacía
     */
    public boolean esVacia() {
        return cabecera == null;
    }

    /**
     * Recupera el valor en la posición ingresada como parametro. Precondición:
     * la posición existe.
     *
     * @param pos posición del elemento en la lista
     * @return valor del elemento en la posición solicitada
     */
    public int recuperar(int pos) {
        int elemento = Integer.MAX_VALUE;
        if (pos >= 1 && pos <= longitud) {
            if (pos == 1) {
                elemento = cabecera.getElem();
            } else {
                NodoInt aux = cabecera;
                for (int i = 1; i < pos; i++) {
                    aux = aux.getEnlace();
                }
                elemento = aux.getElem();
            }
        }
        return elemento;
    }

    /**
     * Localiza la posición de un elemento.
     *
     * @param elemento número entero a localizar
     * @return posición en la lista, MIN_VALUE en caso de que no se encuentre
     */
    public int localizar(int elemento) {
        NodoInt aux = cabecera;
        int posicion = Integer.MIN_VALUE;
        if (!esVacia()) {
            for (int i = 1; i <= longitud(); i++) {
                if (aux.getElem() == elemento) {
                    posicion = i;
                    i = longitud() + 1;
                } else {
                    aux = aux.getEnlace();
                }
            }
        }
        return posicion;
    }

    /**
     * Muestra los elementos de una lista.
     *
     * @return elementos de la lista
     */
    @Override
    public String toString() {
        String cadena = "";
        NodoInt aux = cabecera;
        while (aux != null) {
            cadena += aux.getElem();
            aux = aux.getEnlace();
            if (aux != null) {
                cadena += ", ";
            }
        }
        return "[" + cadena + "]";
    }

    /**
     * Clona una lista.
     *
     * @return lista clonada
     */
    public ListaInt clonar() {
        ListaInt nuevaLista = new ListaInt();
        if (!esVacia()) {
            NodoInt aux = cabecera;
            int pos = 1;
            while (aux != null) {
                nuevaLista.insertar(aux.getElem(), pos);
                aux = aux.getEnlace();
                pos++;
            }
        }
        return nuevaLista;
    }

}
