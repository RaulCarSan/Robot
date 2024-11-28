package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Objects;

public class Consola {

    private Consola() {

    }

    public static void mostrarMenu(){
        System.out.println("Menu:");
        System.out.println("1. Controlar un robot por defecto.");
        System.out.println("2. Controlar un robot con una zona para establecer.");
        System.out.println("3. Controlar un robot con una zona y orientación para establecer.");
        System.out.println("4. Controlar un robot con una zona, orientacion y coordenada inicial para establecer.");
        System.out.println("5. Ejecutar comando.");
        System.out.println("6. Salir.");
    }




    public static int elegirOpcion(){
        int eleccion = 0;
        Robot robot = new Robot();
        System.out.println("Elige unas de las opciones : ");
        do {
            Consola.mostrarMenu();
            System.out.print("Opción elegida: ");
            eleccion = Entrada.entero();
        } while (eleccion < 1 || eleccion > 6 );

        return eleccion;
    }

    public static Zona elegirZona(){
        System.out.println("Elige una zona para el robot: ");
        Zona zona = null;
        do {
            System.out.print("Elige el ancho: ");
            int ancho = Entrada.entero();
            System.out.print("Elige la altura: ");
            int altura = Entrada.entero();
            try {
                zona = new Zona(ancho,altura);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException();
            }

        } while (zona == null);

        return zona;
    }

    public static void mostrarMenuOrientacion(){
        System.out.println("Elige una orientacion: ");
        System.out.println("1.Norte");
        System.out.println("2.Noreste");
        System.out.println("3.Este");
        System.out.println("4.Sureste");
        System.out.println("5.Sur");
        System.out.println("6.Suroeste");
        System.out.println("7.Oeste");
        System.out.println("8.Noroeste");
    }

    public static Orientacion elegirOrientacion(){
        int eleccion;
        Orientacion orientacion = null;
        do {
            Consola.mostrarMenuOrientacion();
            System.out.print("Opción elegida: ");
            eleccion = Entrada.entero();
        } while (eleccion < 1 || eleccion > 8 );

        switch (eleccion){

            case 1 -> {
                orientacion = Orientacion.NORTE;
            }

            case 2 -> {
                orientacion = Orientacion.NORESTE;
            }

            case 3 -> {
                orientacion = Orientacion.ESTE;
            }

            case 4 -> {
                orientacion = Orientacion.SURESTE;
            }

            case 5 -> {
                orientacion = Orientacion.SUR;
            }

            case 6 -> {
                orientacion = Orientacion.SUROESTE;
            }

            case 7 -> {
                orientacion = Orientacion.OESTE;
            }

            case 8 -> {
                orientacion = Orientacion.NOROESTE;
            }

            default -> System.out.println("No has elegido ninguna opción.");
        }

        return orientacion;

    }

    public static Coordenada ElegirCoordenadas(){
        System.out.println("Elige unas coordenadas para el robot: ");
        System.out.print("Elige la coordenada x: ");
        int x = Entrada.entero();
        System.out.print("Elige la coordenada y: ");
        int y = Entrada.entero();

        return new Coordenada(x,y);
    }

    public static char elegirComando(){
        char comando;

        System.out.println("Elige uno de estos  comando: ");
        System.out.println("A - a, para avanzar");
        System.out.println("D - d, para girar a la derecha");
        System.out.println("I - i, para girar a la izquierda");
        do {
            System.out.print("Elige un comando: ");
            comando = Entrada.caracter();

        }while (comando != 'A' && comando !='a' && comando != 'D' && comando != 'd' && comando != 'I' && comando !='i');

        return comando;
    }

    public static void MostarRobot(ControladorRobot controladorRobot){
        Objects.requireNonNull(controladorRobot,"El robot no puede ser nulo.");
        System.out.println(controladorRobot.getRobot());
    }

    public static void despedirse(){
        System.out.println("Adios.");
    }



}
