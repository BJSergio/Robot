package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {

    private Orientacion orientacion;
    private Coordenada coordenada;
    private Zona zona;

    public Robot() {
        this.zona = new Zona();
        this.coordenada = zona.getCentro();
        this.orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona) {
        setZona(zona);
        this.coordenada = zona.getCentro();
        this.orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        setZona(zona);
        this.coordenada = zona.getCentro();
        setOrientacion(orientacion);
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        setZona(zona);
        setOrientacion(orientacion);
        setCoordenada(coordenada);
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        this.zona = robot.zona;
        this.orientacion = robot.orientacion;
        this.coordenada = robot.coordenada;
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) { // La propia clase lo válida.
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    public void avanzar() throws OperationNotSupportedException {

        int nuevaX = coordenada.x();
        int nuevaY = coordenada.y();

        switch (orientacion) {
            case NORTE -> nuevaY++;
            case NORESTE -> {
                nuevaX++;
                nuevaY++;
            }
            case ESTE -> nuevaX++;
            case SURESTE -> {
                nuevaX++;
                nuevaY--;
            }
            case SUR -> nuevaY--;
            case SUROESTE -> {
                nuevaX--;
                nuevaY--;
            }
            case OESTE -> nuevaX--;
            case NOROESTE -> {
                nuevaX--;
                nuevaY++;
            }
        }
        try {
            setCoordenada(new Coordenada(nuevaX, nuevaY));
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        }
    }

    public void girarALaDerecha() {

        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NORESTE;
            case NORESTE -> orientacion = Orientacion.ESTE;
            case ESTE -> orientacion = Orientacion.SURESTE;
            case SURESTE -> orientacion = Orientacion.SUR;
            case SUR -> orientacion = Orientacion.SUROESTE;
            case SUROESTE -> orientacion = Orientacion.OESTE;
            case OESTE -> orientacion = Orientacion.NOROESTE;
            case NOROESTE -> orientacion = Orientacion.NORTE;
        }
    }

    public void girarALaIzquierda() {

        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NOROESTE;
            case NORESTE -> orientacion = Orientacion.NORTE;
            case ESTE -> orientacion = Orientacion.NORESTE;
            case SURESTE -> orientacion = Orientacion.ESTE;
            case SUR -> orientacion = Orientacion.SURESTE;
            case SUROESTE -> orientacion = Orientacion.SUR;
            case OESTE -> orientacion = Orientacion.SUROESTE;
            case NOROESTE -> orientacion = Orientacion.OESTE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        return orientacion == robot.orientacion && Objects.equals(coordenada, robot.coordenada) && Objects.equals(zona, robot.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientacion, coordenada, zona);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "orientacion=" + orientacion +
                ", coordenada=" + coordenada +
                ", zona=" + zona +
                '}';
    }
}
