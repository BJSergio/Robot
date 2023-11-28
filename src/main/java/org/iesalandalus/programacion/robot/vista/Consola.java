package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Programa para controlar un robot mediante comandos.");
        System.out.println("---------------------------------------------------");
        System.out.println("1.- Controlar un robot por defecto.");
        System.out.println("2.- Controlar un robot indicando su zona.");
        System.out.println("3.- Controlar un robot indicando su zona y orientación.");
        System.out.println("4.- Controlar un robot indicando su zona, orientación y coordenada inicial.");
        System.out.println("5.- Ejecutar comando.");
        System.out.println("6.- Salir.");
    }

    public static int elegirOpcion() {

        int opcion;
        mostrarMenuPrincipal();

        do {
            System.out.print("Introduce una opción válida: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 6);

        return opcion;
    }

    public static Zona elegirZona() {

        int ancho;
        int alto;

        System.out.print("Introduce el ancho de la zona:");
        ancho = Entrada.entero();

        System.out.print("Introduce el alto de la zona:");
        alto = Entrada.entero();

        // Puede lanzar una excepción

        try {
            return new Zona(ancho, alto);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ERROR: " + e.getMessage());
        }
    }

    public static void mostrarOrientacion() {

        System.out.println("Orientaciones");
        System.out.println("-------------");
        System.out.println();
        System.out.println("0.- Norte");
        System.out.println("1.- Noreste");
        System.out.println("2.- Este");
        System.out.println("3.- Sureste");
        System.out.println("4.- Sur");
        System.out.println("5.- Suroeste");
        System.out.println("6.- Oeste");
        System.out.println("7.- Noroeste");
    }

    public static Orientacion elegirOrientacion() {

        Orientacion orientacionElegida;
        int opcion;

        mostrarOrientacion();
        System.out.print("Introduce una orientación: ");
        opcion = Entrada.entero();

        orientacionElegida = switch (opcion) {
            case 0 -> Orientacion.NORTE;
            case 1 -> Orientacion.NORESTE;
            case 2 -> Orientacion.ESTE;
            case 3 -> Orientacion.SURESTE;
            case 4 -> Orientacion.SUR;
            case 5 -> Orientacion.SUROESTE;
            case 6 -> Orientacion.OESTE;
            case 7 -> Orientacion.NOROESTE;
            default -> throw new IllegalArgumentException("No se ha elegido ninguna orientación.");
        };
        return orientacionElegida;
    }

    public static Coordenada elegirCoordenada() {

        int coordenadaX;
        int coordenadaY;

        System.out.print("Introduce la coordenada en el eje X: ");
        coordenadaX = Entrada.entero();
        System.out.print("Introduce la coordenada en el eje Y: ");
        coordenadaY = Entrada.entero();

        return new Coordenada(coordenadaX, coordenadaY);
    }

    public static char elegirComando() {

        System.out.print("Introduce un comando a ejecutar:");
        return Entrada.caracter();
    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {

        if (controladorRobot.getRobot() != null) {
            System.out.println(controladorRobot.getRobot());
        } else {
            throw new NullPointerException("Aún no se ha creado ningún robot.");
        }
    }

    public static void despedirse() {
        System.out.println("Ha salido del programa.");
    }
}
