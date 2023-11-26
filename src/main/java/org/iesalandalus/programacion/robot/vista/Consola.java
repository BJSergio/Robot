package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class Consola {

    private Consola() {

    }

    public static void mostrarMenuPrincipal() {

        System.out.println("1.Controlar un robot por defecto.");
        System.out.println("2.Controlar un robot indicando su zona.");
        System.out.println("3.Controlar un robot indicando su zona y orientación");
        System.out.println("4.Controlar un robot indicando su zona, orientación y coordenada");
    }

    public static int elegirOpcion() {

        int opcion;
        mostrarMenuPrincipal();

        do {
            System.out.print("Introduce una opción válida [1-4]: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 4);

        return opcion;
    }

    public static Zona elegirZona() throws OperationNotSupportedException {

        int ancho;
        int alto;

        System.out.print("Introduce el ancho de la zona:");
        ancho = Entrada.entero();

        System.out.println("Introduce el alto de la zona:");
        alto = Entrada.entero();

        try {
            return new Zona(ancho, alto);
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("No se ha podido crear la zona.");
        }
    }

    public static void mostrarOrientacion() {

        System.out.println("0.Norte");
        System.out.println("1.Noreste");
        System.out.println("2.Este");
        System.out.println("3.Sureste");
        System.out.println("4.Sur");
        System.out.println("5.Suroeste");
        System.out.println("6.Oeste");
        System.out.println("7.Noroeste");
    }

    public static Orientacion elegirOrientacion() {

        Orientacion orientacionElegida;
        int opcion;

        mostrarOrientacion();

        System.out.print("Introduce una orientación: ");
        opcion = Entrada.entero();

        switch (opcion) {

            case 0 -> orientacionElegida = Orientacion.NORTE;
            case 1 -> orientacionElegida = Orientacion.NORESTE;
            case 2 -> orientacionElegida = Orientacion.ESTE;
            case 3 -> orientacionElegida = Orientacion.SURESTE;
            case 4 -> orientacionElegida = Orientacion.SUR;
            case 5 -> orientacionElegida = Orientacion.SUROESTE;
            case 6 -> orientacionElegida = Orientacion.OESTE;
            case 7 -> orientacionElegida = Orientacion.NOROESTE;
            default -> throw new IllegalArgumentException("Orientación no válida.");
        }

        return orientacionElegida;
    }

    public static Coordenada elegirCoordenada() {

        int coordenadaX;
        int coordenadaY;

        System.out.print("Introduce la coordenada en el eje X: ");
        coordenadaX = Entrada.entero();
        System.out.print("Introduce la coordenada en el eje Y: ");
        coordenadaY = Entrada.entero();

        try {
            return new Coordenada(coordenadaX, coordenadaY);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se ha podido crear la coordenada.");
        }
    }

    public static char elegirComando() {

        char comando;
        System.out.print("Introduce un comando a ejecutar:");
        comando = Entrada.caracter();
        return comando;
    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {

        if (controladorRobot != null) {

            System.out.println(controladorRobot.getRobot());
        } else {
            throw new NullPointerException("Aún no se ha creado ningún robot.");
        }
    }

    public static void despedirse() {

        System.out.println("Ha salido del programa.");
    }
}
