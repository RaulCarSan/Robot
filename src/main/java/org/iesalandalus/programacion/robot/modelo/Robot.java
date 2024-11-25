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


}
