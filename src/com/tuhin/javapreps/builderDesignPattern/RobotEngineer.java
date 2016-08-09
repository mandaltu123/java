package com.tuhin.javapreps.builderDesignPattern;

/**
 * Created by tuhinmandal on 31/07/16.
 * <p>
 * This is the director class who will actually build the robot object
 */
public class RobotEngineer {

    private IRobotBuilder robotBuilder;

    // OldRobotBuilder specification is sent to the engineer

    public RobotEngineer(IRobotBuilder robotBuilder) {
        this.robotBuilder = robotBuilder;
    }

    public Robot getRobot() {
        return this.robotBuilder.getRobot();
    }

    // Execute the methods specific to the RobotBuilder that implements RobotBuilder (OldRobotBuilder)
    public void makeRobot() {
        this.robotBuilder.buildRobotHead();
        this.robotBuilder.buildRobotTorso();
        this.robotBuilder.buildRobotArms();
        this.robotBuilder.buildRobotLegs();
    }

}
