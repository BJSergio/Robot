package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public record Zona(int ancho, int alto) {

    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    public Zona {

        validarAncho(ancho);
        validarAlto(alto);
    }

    public Zona() {

        this(ANCHO_MINIMO, ALTO_MINIMO);
    }

    private void validarAncho(int ancho) {

        if (ancho < ANCHO_MINIMO) {
            throw new IllegalArgumentException("ERROR: El ancho introducido es menor que el mínimo mínimo.");
        }
        if (ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("ERROR: El ancho introducido es mayor que el máximo permitido.");
        }
    }

    private void validarAlto(int alto) {

        if (alto < ALTO_MINIMO) {
            throw new IllegalArgumentException("ERROR: El alto introducido es menor que el mínimo permitido.");
        }
        if (alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("ERROR: El alto introducido es mayor que el máximo permitido.");
        }
    }

    public Coordenada getCentro() {

        return new Coordenada(ancho() / 2, alto() / 2);
    }

    public boolean pertenece(Coordenada coordenada) {

        Objects.requireNonNull(coordenada, "ERROR: La coordenada no puede ser nula.");
        return (perteneceX(coordenada.x()) && perteneceY(coordenada.y()));
    }

    private boolean perteneceX(int x) {

        return (x < ANCHO_MINIMO || x > ANCHO_MAXIMO);
    }

    private boolean perteneceY(int y) {

        return (y < ALTO_MINIMO || y > ANCHO_MAXIMO);
    }
}
