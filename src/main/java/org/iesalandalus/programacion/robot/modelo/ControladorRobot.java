package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class ControladorRobot {
    private final Robot robot;

    public ControladorRobot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        this.robot = new Robot(robot); // Para evitar el aliasing creamos una copia del robot
    }

    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(char comando) throws OperationNotSupportedException {

        if (comando == 'A' || comando == 'a') {
            robot.avanzar();
        } else if (comando == 'D' || comando == 'd') {
            robot.girarALaDerecha();
        } else if (comando == 'I' || comando == 'i') {
            robot.girarALaIzquierda();
        } else {
            throw new OperationNotSupportedException("Comando desconocido.");
        }
    }
}
