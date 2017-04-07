/*
 * Implementacion de un nodo con atributos enlace y un elemento.
 */
package lineales.dinamicas;

/**
 *
 * @author Flavia
 */
public class NodoInt {

    private int elem;
    private NodoInt enlace;

    public NodoInt(int elem, NodoInt enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    public int getElem() {
        return elem;
    }

    public NodoInt getEnlace() {
        return enlace;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public void setEnlace(NodoInt enlace) {
        this.enlace = enlace;
    }
}
