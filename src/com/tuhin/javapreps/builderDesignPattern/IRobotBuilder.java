package com.tuhin.javapreps.builderDesignPattern;

/**
 * Created by tuhinmandal on 31/07/16.
 */
public interface IRobotBuilder {

    public void buildRobotHead();

    public void buildRobotTorso();

    public void buildRobotArms();

    public void buildRobotLegs();

    public Robot getRobot();

}
