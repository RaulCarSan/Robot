package org.iesalandalus.programacion.robot.modelo;

public enum Orientacion {
    NORTE("Norte"),
    NORESTE("Noreste"),
    ESTE("Este"),
    SURESTE("Sureste"),
    SUR("Sur"),
    SUROESTE("Suroeste"),
    OESTE("Oeste"),
    NOROESTE("Noroeste");


    private  String orientacion;

    private Orientacion(String orientacion){
        this.orientacion = orientacion;

    }

    @Override
    public String toString() {
        return orientacion;
    }


}
