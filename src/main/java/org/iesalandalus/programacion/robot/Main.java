package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.modelo.RobotExcepcion;
import org.iesalandalus.programacion.robot.vista.Consola;



public class Main {

    private static void ejecutarOpcion(int opcion) {

        ControladorRobot controladorRobot = null;

            switch (opcion) {
                case 1 -> {

                    controladorRobot = controladorRobotDefecto();
                    Consola.MostarRobot(controladorRobot);

                    System.out.println("___________________________________________________");

                    Main.ejecutarOpcion(Consola.elegirOpcion());
                }

                case 2 -> {
                    try {
                        controladorRobot = controladorRobotZona();
                        Consola.MostarRobot(controladorRobot);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    System.out.println("___________________________________________________");

                    ejecutarOpcion(Consola.elegirOpcion());
                }

                case 3 -> {
                    try {
                        controladorRobot = controladorRobotZonaOrientacion();
                        Consola.MostarRobot(controladorRobot);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("___________________________________________________");
                    ejecutarOpcion(Consola.elegirOpcion());
                }

                case 4 -> {
                    try {
                        controladorRobot = controlarRobotZonaOrientacionCoordenadas();
                        Consola.MostarRobot(controladorRobot);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }


                    System.out.println("___________________________________________________");


                    ejecutarOpcion(Consola.elegirOpcion());

                }


                case 5 -> {

                    ejecutarComando(Consola.elegirComando());

                    System.out.println("___________________________________________________");

                    ejecutarOpcion(Consola.elegirOpcion());

                }

                case 6 -> {
                    Consola.despedirse();
                }
            }
    }

    private static ControladorRobot controlarRobotZonaOrientacionCoordenadas() {
        return new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.ElegirCoordenadas()));
    }

    private static ControladorRobot controladorRobotZonaOrientacion() {
        return new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
    }

    private static ControladorRobot controladorRobotZona() {
        return new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    private static ControladorRobot controladorRobotDefecto(){

        return new ControladorRobot(new Robot());
    }

    private static void ejecutarComando(char comando){

        try {
             controladorRobot.ejecutar(comando);
        } catch (IllegalArgumentException | RobotExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        ejecutarOpcion(Consola.elegirOpcion());
    }
}
