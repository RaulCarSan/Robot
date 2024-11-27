package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {

    private Robot robot;


    public  ControladorRobot(Robot robot){
        this.robot = new Robot(robot);
    }

    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(char comando) throws RobotExcepcion {
        switch (comando){
            case 'i', 'I' -> robot.girarALaIzquierda();

            case 'd','D' -> robot.girarALaDerecha();

            case 'a', 'A' -> robot.avanzar();

            default -> throw new RobotExcepcion("Comando desconocido.");
        }
    }

}
