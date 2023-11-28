package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.vista.Consola;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Main {

    private static ControladorRobot controladorRobot;

    public static void main(String[] args) {

        int opcionElegida;

        do {
            opcionElegida = Consola.elegirOpcion();
            if (opcionElegida != 6) {
                ejecutarOpcion(opcionElegida);
                Consola.mostrarRobot(controladorRobot);
            }
        } while (opcionElegida != 6);
        Consola.despedirse();
    }

    private static void ejecutarOpcion(int opcion) {

        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> Consola.despedirse();
            default -> throw new IllegalArgumentException("No se ha elegido ninguna opción.");
        }
    }

    private static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }

    private static void controlarRobotZona() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    private static void controlarRobotZonaOrientacion() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
    }

    private static void controlarRobotZonaOrientacionCoordenada() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.elegirCoordenada()));
    }

    private static void ejecutarComando() {

        Objects.requireNonNull(controladorRobot, "Aún no se ha creado ningún robot.");

        try {
            controladorRobot.ejecutar(Consola.elegirComando());
        } catch (OperationNotSupportedException e) {
            System.out.println((e.getMessage()));
        }
    }
}
