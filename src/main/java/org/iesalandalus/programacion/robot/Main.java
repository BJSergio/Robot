package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class Main {

    private static ControladorRobot controladorRobot;

    public static void main(String[] args) {

        try {

            ejecutarOpcion(Consola.elegirOpcion());
            Consola.mostrarRobot(controladorRobot);
            ejecutarComando();
            Consola.mostrarRobot(controladorRobot);
            ejecutarOpcion(Consola.elegirOpcion());
            Consola.mostrarRobot(controladorRobot);
            ejecutarComando();
            Consola.mostrarRobot(controladorRobot);
            ejecutarOpcion(Consola.elegirOpcion());
            Consola.mostrarRobot(controladorRobot);
            ejecutarComando();
            Consola.mostrarRobot(controladorRobot);

        } catch (IllegalArgumentException | OperationNotSupportedException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {

        switch (opcion) {

            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> Consola.despedirse();
            default -> throw new IllegalArgumentException("No se ha elegido ninguna opción.");
        }
    }

    private static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }

    private static void controlarRobotZona() throws OperationNotSupportedException {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    private static void controlarRobotZonaOrientacion() throws OperationNotSupportedException {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
    }

    private static void controlarRobotZonaOrientacionCoordenada() throws OperationNotSupportedException {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.elegirCoordenada()));
    }

    private static void ejecutarComando() throws OperationNotSupportedException {
        controladorRobot.ejecutar(Consola.elegirComando());
    }
}
