package com.tuhin.javapreps.builderDesignPattern;

/**
 * Created by tuhinmandal on 31/07/16.
 */
public class RobotBuilderClient {

    public static void main(String[] args) {
        // Get a RobotBuilder of type OldRobotBuilder
        IRobotBuilder oldStyleRobot = new OldRobotBuilder();

        // Pass the OldRobotBuilder specification to the engineer
        RobotEngineer engineer = new RobotEngineer(oldStyleRobot);

        engineer.makeRobot();
        Robot firstRobot = engineer.getRobot();
        System.out.println("firstRobot is been built");
        System.out.println(firstRobot.getRobotHead());
        System.out.println(firstRobot.getRobotTorso());
        System.out.println(firstRobot.getRobotArms());
        System.out.println(firstRobot.getRobotLegs());

    }
}
