/*
 * Utilizando las clases de Pila, Lista y Cola vistas en teoría, desarrollar el método revolverElementos
 que, dada una lista de enteros L y un valor k, devuelva una cola Q que contenga los elementos de L
 de la siguiente forma:
 • Los primeros k elementos deben estar en el mismo orden
 • Los siguientes k elementos deben estar en orden invertido
 • Repetir esta secuencia hasta finalizar la lista.
 Se debe utilizar una pila como estructura auxiliar y la cola debe estar implementada en forma
 estática. Realizar todas las validaciones necesarias.
 */
package trabajoObligtorio;

import lineales.estaticas.ColaInt;
import lineales.dinamicas.ListaInt;
import lineales.dinamicas.PilaInt;

/**
 *
 * @author Flavia
 */
public class TPObligatorio1 {

    /**
     * Dada una lista de enteros y un valor k, devuelva una cola que contiene
     * los k primeros elementos de la lista en el mismo orden y los siguientes k
     * elementos de la lista en orden invertido. Repetir esta secuencia hasta
     * finalizar con los elementos de la lista.
     *
     * @param lista etructura lista de números enteros.
     * @param k número entero.
     * @return una cola.
     */
    private static ColaInt revolverElementos(ListaInt lista, int k) {
        ColaInt cola = new ColaInt();
        ColaInt colaAux = new ColaInt();
        PilaInt pila = new PilaInt();

        //Copia los elemetos de la lista en una cola.
        for (int i = 1; i <= lista.longitud(); i++) {
            colaAux.poner(lista.recuperar(i));
        }

        /*Si cumple con la condicion del if, la cola seguramente no va a 
         tener el mismo orden que la lista. A menos que lista.longitud()=k+1
         */
        if (lista.longitud() > k && k > 1) {

            while (!colaAux.esVacia()) {
                int i = 1;
                while (!colaAux.esVacia() && i <= k) {//Pone los n elementos de la lista en la cola con el mismo orden.
                    cola.poner(colaAux.obtenerFrente());
                    colaAux.sacar();
                    i++;
                }
                
                i = 1;
                while (!colaAux.esVacia() && i <= k) {//Apila los siguientes n elemento de la lista en la pila.
                    pila.apilar(colaAux.obtenerFrente());
                    colaAux.sacar();
                    i++;
                }
                while (!pila.esVacia()) {//Pone los n elementos de la pila en la cola.
                    cola.poner(pila.obtenerTope());
                    pila.desapilar();
                }
            }

        } else {//Devuleve la cola con el mismo orden que la lista.
            cola = colaAux;
        }

        return cola;
    }

    public static void main(String[] args) {
        ListaInt l = new ListaInt();

        System.out.println("lista-------------------------------------------L=" + l.toString());
        System.out.println("aplicado el metódo revolverElementos(L, -1)-----R=" + revolverElementos(l, -1).toString());//NO cumple con la condicion del if
        System.out.println("aplicado el metódo revolverElementos(L, 0)------R=" + revolverElementos(l, 0).toString());//NO
        System.out.println("aplicado el metódo revolverElementos(L, 1)------R=" + revolverElementos(l, 1).toString());//NO

        l.insertar(1, 1);
        l.insertar(2, 2);
        l.insertar(3, 3);
        l.insertar(4, 4);
        l.insertar(5, 5);
        l.insertar(6, 6);

        System.out.println("Lista cargada-----------------------------L=" + l.toString());
        System.out.println("aplicado el metódo revolverElementos(L, 0)------R=" + revolverElementos(l, 0).toString());//NO cumple con la condicion del if
        System.out.println("aplicado el metódo revolverElementos(L, 1)------R=" + revolverElementos(l, 1).toString());//NO
        System.out.println("aplicado el metódo revolverElementos(L, 2)------R=" + revolverElementos(l, 2).toString());//SI cumple con la condicion del if
        System.out.println("aplicado el metódo revolverElementos(L, 3)------R=" + revolverElementos(l, 3).toString());//SI
        System.out.println("aplicado el metódo revolverElementos(L, 4)------R=" + revolverElementos(l, 4).toString());//SI
        System.out.println("aplicado el metódo revolverElementos(L, 5)------R=" + revolverElementos(l, 5).toString());//SI
        System.out.println("aplicado el metódo revolverElementos(L, 6)------R=" + revolverElementos(l, 6).toString());//NO cumple con la condicion del if
        System.out.println("aplicado el metódo revolverElementos(L, 7)------R=" + revolverElementos(l, 7).toString());//NO

    }

}
