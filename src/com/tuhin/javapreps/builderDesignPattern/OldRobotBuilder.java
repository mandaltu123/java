package com.tuhin.javapreps.builderDesignPattern;

/**
 * Created by tuhinmandal on 31/07/16.
 */
public class OldRobotBuilder implements IRobotBuilder {

    private Robot robot;

    public OldRobotBuilder() {
        this.robot = new Robot();
    }

    @Override
    public void buildRobotHead() {
        this.robot.setRobotHead("Tin head");
    }

    @Override
    public void buildRobotTorso() {
        this.robot.setRobotTorso("Tin torso");
    }

    @Override
    public void buildRobotArms() {
        this.robot.setRobotArms("Torch arms");
    }

    @Override
    public void buildRobotLegs() {
        this.robot.setRobotLegs("Roller skate legs");
    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }
}
