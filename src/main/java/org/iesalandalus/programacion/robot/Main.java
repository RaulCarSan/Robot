package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.vista.Consola;




public class Main {

    private static void ejecutarOpcion(int opcion) {


        switch (opcion) {
            case 1 -> {
                Consola.MostarRobot(controladorRobotDefecto());
            }

            case 2 -> {
                ControladorRobot robot = controladorRobotZona();
                Consola.MostarRobot(robot);
            }

            case 3 -> {
                ControladorRobot robot = controladorRobotZonaOrientacion();
                Consola.MostarRobot(robot);

            }

            case 4 -> {
                ControladorRobot robot = controlarRobotZonaOrientacionCoordenadas();
                Consola.MostarRobot(robot);
            }

            case 5 -> {
                Consola.elegirComando();
            }

            case 6 -> {
                Consola.despedirse();
            }
        }
    }

    private static ControladorRobot controlarRobotZonaOrientacionCoordenadas() {
        ControladorRobot controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.ElegirCoordenadas()));
        return controladorRobot;
    }

    private static ControladorRobot controladorRobotZonaOrientacion() {
        ControladorRobot controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
        return controladorRobot;
    }

    private static ControladorRobot controladorRobotZona() {
        ControladorRobot controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
        return controladorRobot;
    }

    private static ControladorRobot controladorRobotDefecto(){

        ControladorRobot controladorRobot = new ControladorRobot(new Robot());
        
        return controladorRobot;
    }

    public static void main(String[] args) {

        ejecutarOpcion(Consola.elegirOpcion());
    }
}
