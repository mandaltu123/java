package com.tuhin.javapreps.adapterPattern;

/**
 * Created by tuhinmandal on 09/08/16.
 */
public class RobotAdapter implements IEnemyAttacker {

    private RobotAdaptee robot;

    public RobotAdapter(RobotAdaptee robot) {
        this.robot = robot;
    }

    @Override
    public void fireWeapon() {
        robot.smashWithHands();
    }

    @Override
    public void driveForward() {
        robot.walkingForwad();
    }

    @Override
    public void assignDriver(String name) {
        robot.reactToHuman(name);
    }
}
