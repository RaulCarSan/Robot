package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public record Zona(int ancho, int alto) {
    public static final int ANCHO_MAXIMO = 100;
    public static final int ANCHO_MINIMO = 10;
    public static final int ALTURA_MAXIMA = 100;
    public static final int ALTURA_MINIMA = 10;


    public Zona(){
        this(ANCHO_MINIMO, ALTURA_MINIMA);
    }

    public Zona{
        validarAncho(ancho);
        validarAlto(alto);
    }

    private void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }

    }

    private void validarAlto(int alto){
        if (alto > ALTURA_MAXIMA || alto < ALTURA_MINIMA ) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    public Coordenada getCentro(){
           return new Coordenada(ancho / 2, alto / 2);
    }

    public boolean pertenece(Coordenada coordenada){
        if (coordenada == null){
            throw new NullPointerException("La coordenada no puede ser nula.");
        }
        int y = coordenada.y();
        int x = coordenada.x();
        return (perteneceY(y) && perteneceX(x));
    }

    public boolean perteneceX(int x){
        return (x >= 0 && x < ancho);
    }

    public boolean perteneceY(int y){
        return (y >= 0 && y < alto);
    }

}
