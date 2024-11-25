package org.iesalandalus.programacion.robot.modelo;

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
        this.zona = zona;
    }

    public Robot(Zona zona, Coordenada coordenada){
        this.zona = zona;
        this.coordenada = coordenada;
    }

    public Robot(Zona zona, Coordenada coordenada, Orientacion orientacion){
        this.zona = zona;
        this.coordenada = coordenada;
        this.orientacion = orientacion;
    }

    public Robot(Robot robot){
        this.zona = new Zona(robot.getZona().ancho(), robot.getZona().alto());
        this.coordenada = new Coordenada(coordenada.x(), coordenada.y());
        this.orientacion = robot.getOrientacion();
    }

    public Zona getZona() {
        return zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }



}
