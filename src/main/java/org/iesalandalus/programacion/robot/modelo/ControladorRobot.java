package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public record ControladorRobot(Robot robot) {

    public ControladorRobot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        this.robot = new Robot(robot); // Para evitar el aliasing creamos una copia del robot
    }

    @Override
    public Robot robot() {
        return new Robot(robot);
    }

    public void ejecutarSecuenciaComandos(String comandos) throws OperationNotSupportedException {

        for (int i = 0; i < comandos.length(); i++) {
            if (comandos.charAt(i) == 'a' || comandos.charAt(i) == 'A') {
                robot.avanzar();
            } else if (comandos.charAt(i) == 'd' || comandos.charAt(i) == 'D') {
                robot.girarALaDerecha();
            } else if (comandos.charAt(i) == 'i' || comandos.charAt(i) == 'I') {
                robot.girarALaIzquierda();
            } else {
                throw new OperationNotSupportedException("Comando desconocido.");
            }
        }
    }
}
