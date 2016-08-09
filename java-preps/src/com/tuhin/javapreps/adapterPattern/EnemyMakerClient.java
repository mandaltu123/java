package com.tuhin.javapreps.adapterPattern;

/**
 * @author  tuhinmandal on 09/08/16.
 */
public class EnemyMakerClient {

    public static void main(String[] args) {
        EnemyTank tank = new EnemyTank();
        tank.driveForward();
        tank.fireWeapon();
        tank.assignDriver("Muller");

        System.out.println("-------------------");
        RobotAdaptee zogTheRobot = new RobotAdaptee();
        RobotAdapter adapter = new RobotAdapter(zogTheRobot);
        zogTheRobot.reactToHuman("Drek");
        zogTheRobot.walkingForwad();
        zogTheRobot.smashWithHands();
    }
}
