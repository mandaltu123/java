package com.tuhin.javapreps.builderDesignPattern;

/**
 * Created by tuhinmandal on 31/07/16.
 */
public interface IRobotPlan {

    public void setRobotHead(String head);

    public void setRobotTorso(String torso);

    public void setRobotArms(String arms);

    public void setRobotLegs(String legs);
}
