package org.iesalandalus.programacion.robot.modelo;

public record Coordenada(int x, int y) {

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
