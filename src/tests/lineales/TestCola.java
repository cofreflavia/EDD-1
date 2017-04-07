/*
 * Tests para la implementacion de la Cola estática y dinámica 
 */
package tests.lineales;

import lineales.estaticas.ColaInt;
//import lineales.dinamicas.ColaInt;

/**
 *
 * @author fcofre
 */
public class TestCola {

    public static void main(String[] args) {
        ColaInt cola = new ColaInt();
        ColaInt colaClon;
        System.out.println("La cola está vacia? " + cola.esVacia() + "--------C=" + cola.toString()+" el frente lo identifico con: " + cola.obtenerFrente());
        cola.poner(1);
        cola.poner(2);
        cola.poner(3);
        cola.poner(4);
        cola.poner(5);//En la implementacion estática este valor no se carga(COLA LLENA) por que TAM=4, verificarlo
        System.out.println("cola cargada--------------------C=" + cola.toString() + " el frente es: " + cola.obtenerFrente());

        colaClon = cola.clonar();
        System.out.println("Se clonó la cola C-----------Clon=" + colaClon.toString());

        colaClon.sacar();
        colaClon.sacar();
        colaClon.sacar();
        System.out.println("Sacar 3 elementos------Quedo Clon=" + colaClon.toString() + " el frente es: " + colaClon.obtenerFrente());
        colaClon.poner(6);
        colaClon.poner(7);
        System.out.println("poner 2 elementos------Quedo Clon=" + colaClon.toString());

        colaClon.vaciar();
        System.out.println("Se vació la cola Clon? " + colaClon.esVacia() + ", Quedó Clon=" + colaClon.toString() + " el frente lo identifico con: " + colaClon.obtenerFrente());
        System.out.println("La cola C no tinene cambios-----C="+ cola.toString() + " el frente es: " + cola.obtenerFrente());
    }

}
