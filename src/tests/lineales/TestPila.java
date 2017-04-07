/*
 * Tests para la implementacion de la pila estática y dinámica.
 */
package tests.lineales;

import lineales.dinamicas.PilaInt;
//import lineales.estaticas.PilaInt;

/**
 *
 * @author Flavia
 */
public class TestPila {

    public static void main(String[] args) {
        PilaInt p, c;
        p = new PilaInt();
        System.out.println("¿La Pila está vacia? " + p.esVacia() + ", Es P=" + p.toString());
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        p.apilar(2);
        p.apilar(1);
        p.apilar(6);//En la implementacion estatica este valor no se apila(PILA LLENA)cuando TAM=5, verificarlo

        System.out.println("Pila cargada----------------P=" + p.toString() + " con tope: " + p.obtenerTope());
        c = p.clonar();
        System.out.println("Se creó un clon de P------- C=" + c.toString() + " con tope: " + c.obtenerTope());

        System.out.println("¿Se desapilo la pila C ? " + c.desapilar() + ", Quedo C=" + c.toString() + " con tope:" + c.obtenerTope());

        System.out.println("¿Es capicua la pila P? " + esCapicua(p));
        System.out.println("¿Es capicua la pila C? " + esCapicua(c));

        c.vaciar();
        System.out.println("¿Se vacío la pila C? " + c.esVacia() + ", Quedo C=" + c.toString() + " con tope:" + c.obtenerTope());
        System.out.println("La Pila P no tuvo cambios-------P=" + p.toString() + " con tope: " + p.obtenerTope());
    }

    /**
     * Verifica si la pila es capicua
     *
     * @param pila
     * @return true si la pila es capicua
     */
    public static boolean esCapicua(PilaInt pila) {
        boolean esCapicua = true;

        PilaInt pilaAux = new PilaInt();
        PilaInt pilaClon = pila.clonar();

        while (!pilaClon.esVacia()) {
            pilaAux.apilar(pilaClon.obtenerTope());
            pilaClon.desapilar();
        }

        pilaClon = pila.clonar();

        while (esCapicua && !pilaClon.esVacia()) {
            if (pilaClon.obtenerTope() == pilaAux.obtenerTope()) {
                pilaClon.desapilar();
                pilaAux.desapilar();
            } else {
                esCapicua = false;
            }
        }
        return esCapicua;
    }
}
