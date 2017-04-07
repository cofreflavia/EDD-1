/*
 * Tests para la implementacion de la Lista.
 */
package tests.lineales;

import lineales.dinamicas.ListaInt;
import lineales.dinamicas.PilaInt;

/**
 *
 * @author Flavia
 */
public class TestLista {

    public static void main(String[] args) {
        ListaInt nueva = new ListaInt();
        System.out.println("¿lista L vacia? " + nueva.esVacia() + ", L=" + nueva.toString() + " longitud: " + nueva.longitud());

        nueva.insertar(3, 1);
        nueva.insertar(14, 2);
        nueva.insertar(100, 3);
        System.out.println("Se cargó la lista----------------------------L=" + nueva.toString() + " de longitud: " + nueva.longitud());

        System.out.println("posicion 2-----------------------------------elemento: " + nueva.recuperar(2));
        System.out.println("elemento 1002--------------------------------posicion: " + nueva.localizar(1002));
        System.out.println("elemento 100---------------------------------posicion: " + nueva.localizar(100));

        ListaInt listaClon = nueva.clonar();
        System.out.println("Se clonó la lista L--------------------------C=" + listaClon.toString());
        nueva.eliminar(2);
        System.out.println("Eliminar el elemento de la posicion 2--------L=" + nueva.toString() + " longitud: " + nueva.longitud());
        nueva.eliminar(2);
        System.out.println("Eliminar el elemento de la posicion 2--------L=" + nueva.toString() + " longitud: " + nueva.longitud());

        System.out.println("La Lista clonada no se modificó--------------C=" + listaClon.toString());

        ListaInt concatenado = concatenar(nueva, listaClon);
        System.out.println("Se concatenó la lista L=" + nueva.toString() + " y C=" + listaClon.toString() + "------Concatenado=" + concatenado.toString());

        ListaInt invertida = invertir(concatenado);
        System.out.println("Invertir Concatenada------------------------------Invertida=" + invertida.toString());
        nueva.vaciar();
//        nueva.insertar(0, 1);
//        nueva.insertar(0, 2);

//        nueva.insertar(1, 1);
//        nueva.insertar(0, 2);
//        nueva.insertar(1, 3);
//        nueva.insertar(0, 4);
//        nueva.insertar(1, 5);
        nueva.insertar(9, 1);
        nueva.insertar(6, 2);
        nueva.insertar(5, 3);
        nueva.insertar(0, 4);
        nueva.insertar(9, 5);
        nueva.insertar(6, 6);
        nueva.insertar(5, 7);
        nueva.insertar(0, 8);
        nueva.insertar(5, 9);
        nueva.insertar(6, 10);
        nueva.insertar(9, 11);
        System.out.println("L=" + nueva.toString() + " tiene el orden[cadena,0,cadena,0,cadena']: " + comprobar(nueva));

        nueva.vaciar();
        nueva.insertar(9, 1);
        nueva.insertar(6, 2);
        nueva.insertar(5, 3);
        nueva.insertar(6, 4);
        nueva.insertar(9, 5);
        System.out.println("L=" + nueva.toString() + " es capicua: " + esCapicua(nueva));

        System.out.println("cant de 9 en L: " + contarIterativo(nueva, 9));
        System.out.println("cant de 2 en L: " + contarIterativo(nueva, 2));

        nueva.vaciar();
        nueva.insertar(1, 1);
        nueva.insertar(3, 2);
        nueva.insertar(5, 3);

        listaClon.vaciar();
        listaClon.insertar(2, 1);
        listaClon.insertar(4, 2);
        listaClon.insertar(6, 3);
        listaClon.insertar(7, 4);
        ListaInt intercalada = intercalar(nueva, listaClon);
        System.out.println("Intercalar L=" + nueva.toString() + " y C=" + listaClon + "-------------Intercalada=" + intercalada.toString());
    }

    /**
     * Concatena dos listas.
     *
     * @param L1 primer lista
     * @param L2 segunda lista
     * @return lista con elementos de L1 y L2 concatenados
     */
    public static ListaInt concatenar(ListaInt L1, ListaInt L2) {
        ListaInt union = L1.clonar();
        if (!L2.esVacia()) {
            for (int i = 1; i <= L2.longitud(); i++) {
                union.insertar(L2.recuperar(i), union.longitud() + 1);
            }
        }
        return union;
    }

    /**
     * Toma una lista y la invierte.
     *
     * @param lista una lista de enteros
     * @return una lista invertida
     */
//    public static ListaInt invertir(ListaInt lista) {
//        ListaInt invertida = new ListaInt();
//        PilaInt pila = new PilaInt();
//        if (!lista.esVacia()) {
//            for (int i = 1; i <= lista.longitud(); i++) {
//                pila.apilar(lista.recuperar(i));
//            }
//            for (int i = 1; i <= lista.longitud(); i++) {
//                invertida.insertar(pila.obtenerTope(), i);
//                pila.desapilar();
//            }
//        }
//        return invertida;
//    }
    public static ListaInt invertir(ListaInt lista) {
        ListaInt invertida = new ListaInt();
        PilaInt pila = new PilaInt();
        if (!lista.esVacia()) {
            invertida = lista.clonar();
            while (!invertida.esVacia()) {
                pila.apilar(invertida.recuperar(1));
                invertida.eliminar(1);
            }
            while (!pila.esVacia()) {
                invertida.insertar(pila.obtenerTope(), invertida.longitud() + 1);
                pila.desapilar();
            }
        }
        return invertida;
    }

    /**
     * Recibe una lista l1 cargada con dígitos enteros (de 0 a 9) y verifica si
     * los elementos que contiene tienen la forma cadena0cadena0cadena' (donde
     * cadena' es la cadena invertida).
     *
     * @param lista lista con dígitos entre 0 y 9
     * @return verdadero si cumple la forma cadena0cadena0cadena'
     */
    public static boolean comprobar(ListaInt lista) {
        boolean exito = false;
        PilaInt pila = new PilaInt();
        int lonList = lista.longitud();

        if (!lista.esVacia() && lonList > 1) {
            int n = (lonList - 2) / 3;//longitud de la cadena
            int ini3 = (2 * n) + 3, fin3 = lonList;//inicio y fin de la ultima cadena invertida
            int posCero1 = n + 1, posCero2 = (2 * n) + 2;//posiciones donde se deben encontrar los ceros

            if (lista.recuperar(posCero1) == 0 && lista.recuperar(posCero2) == 0) {
                if (lonList != 2) {
                    for (int i = 1; i <= n; i++) {
                        if (lista.recuperar(i) == lista.recuperar(i + posCero1)) {//compara los elementos de las dos primeras cadenas
                            exito = true;
                            pila.apilar(lista.recuperar(i));
                        } else {
                            exito = false;
                        }
                    }
                    if (exito) {
                        for (int i = ini3; i <= fin3; i++) {
                            if (lista.recuperar(i) == pila.obtenerTope()) {//compara si los elementos de la ultima cadena son iguales y tienen el mismo orden que la primer cadena invertida.
                                pila.desapilar();
                                exito = true;
                            } else {
                                exito = false;
                                i = fin3 + 1;
                            }
                        }
                    }
                } else {
                    exito = true;
                }
            }
        }
        return exito;
    }

    /**
     * Dadas dos listas l1 y l2, devuelve una lista nueva con los elementos de
     * l1 y l2 intercalados.
     *
     * @param l1 una lista de enteros.
     * @param l2 una lista de enteros.
     * @return una lista nueva con los elementos de l1 y l2 intercalados
     */
    public static ListaInt intercalar(ListaInt l1, ListaInt l2) {
        ListaInt nueva = new ListaInt();
        int x, i = 0, m = 0;
        int lonNueva = l1.longitud() + l2.longitud();
        if (l1.longitud() <= l2.longitud()) {
            x = l1.longitud();
        } else {
            x = l2.longitud();
        }
        while (x > i) {
            nueva.insertar(l1.recuperar(++i), ++m);
            nueva.insertar(l2.recuperar(i), ++m);
        }
        for (int j = m + 1; j <= lonNueva; j++) {
            if (l1.longitud() > l2.longitud()) {
                nueva.insertar(l1.recuperar(++i), j);
            } else {
                nueva.insertar(l2.recuperar(++i), j);
            }
        }
        return nueva;
    }

    /**
     * Verifica si los elementos de una lista son capicúa.Nota utilizar una
     * estructura Pila para facilitar la operacion.
     *
     * @param lista a verificar.
     * @return true si la lista es capicúa.
     */
    public static boolean esCapicua(ListaInt lista) {
        PilaInt pila = new PilaInt();
        boolean exito = true;

        if (lista.esVacia()) {
            exito = false;
        } else {
            for (int i = 1; i <= lista.longitud(); i++) {
                pila.apilar(lista.recuperar(i));
            }
            for (int i = 1; i <= lista.longitud(); i++) {
                if (lista.recuperar(i) == pila.obtenerTope()) {
                    pila.desapilar();
                } else {
                    exito = false;
                    i = lista.longitud() + 1;
                }
            }
        }
        return exito;
    }

    /**
     * Dada una lista que admite elementos repetidos, cuenta cuántas veces
     * aparece un elemento dado dentro de la misma.
     *
     * @param lista lista con números repetidos
     * @param elemento número a contar
     * @return cantidad de veces en que el número aparece
     */
    //version Iterativa
    public static int contarIterativo(ListaInt lista, int elemento) {
        int contador = 0;
        for (int i = 1; i <= lista.longitud(); i++) {
            if (lista.recuperar(i) == elemento) {
                contador++;
            }
        }
        return contador;
    }

    //Version Recursiva

    public static int contarRecursivo(ListaInt lista, int elemento) {
        return contar(lista, elemento, 1);
    }

    private static int contar(ListaInt l, int elem, int pos) {
        int contador = 0;
        if (pos <= l.longitud()) {
            if (l.recuperar(pos) == elem) {
                contador = contar(l, elem, pos + 1) + 1;
            } else {
                contador = contar(l, elem, pos + 1);
            }
        }
        return contador;
    }

}
