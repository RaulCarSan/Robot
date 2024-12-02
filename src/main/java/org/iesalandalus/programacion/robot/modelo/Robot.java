package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {



    private Zona zona;
    private Coordenada coordenada;
    private Orientacion orientacion;




    public Robot(){
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona){
        this.zona = Objects.requireNonNull(zona,"La zona no puede ser nula.");
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion){
        this.zona = Objects.requireNonNull(zona,"La zona no puede ser nula.");
        this.orientacion = Objects.requireNonNull(orientacion,"La orientación no puede ser nula.");
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada){
        this.coordenada = Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        this.zona = Objects.requireNonNull(zona,"La zona no puede ser nula.");
        if (!zona.pertenece(coordenada)){
            throw  new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.orientacion = Objects.requireNonNull(orientacion,"La orientación no puede ser nula.");
    }

    public Robot(Robot robot){
        Objects.requireNonNull(robot,"El robot no puede ser nulo.");
        this.zona = robot.getZona();
        this.coordenada = robot.getCoordenada();
        this.orientacion = robot.getOrientacion();

    }

    public Zona getZona() {
        return zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) throws RobotExcepcion {
        if (zona.pertenece(coordenada) == false){
            throw new RobotExcepcion("Las coordenadas no pueden estar fuera de la zona");
        }
        this.coordenada = coordenada;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void avanzar()throws RobotExcepcion{

        int nuevaX = coordenada.x();
        int nuevaY = coordenada.y();

        switch (orientacion){

            case NORTE -> nuevaY ++;

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
            setCoordenada(new Coordenada(nuevaX,nuevaY));
        } catch (RobotExcepcion e) {
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
        }
    }

    public void girarALaDerecha(){
        switch (orientacion){

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


    public void girarALaIzquierda(){
        switch (orientacion){

            case NORTE -> orientacion = Orientacion.NOROESTE;

            case NOROESTE -> orientacion = Orientacion.OESTE;

            case OESTE -> orientacion = Orientacion.SUROESTE;

            case SUROESTE -> orientacion = Orientacion.SUR;

            case SUR -> orientacion = Orientacion.SURESTE;

            case SURESTE -> orientacion = Orientacion.ESTE;

            case ESTE -> orientacion = Orientacion.NORESTE;

            case NORESTE -> orientacion = Orientacion.NORTE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(zona, robot.zona) && Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, coordenada, orientacion);
    }

    @Override
    public String toString() {
        return String.format("[Zona: Ancho=%s,Alto=%s, Coordenadas: X=%s, Y=%s, Orientacion=%s]", zona.alto(),zona.ancho(), coordenada.x(), coordenada.y(), orientacion);
    }

}
