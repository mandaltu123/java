package com.tuhin.javapreps.adapterPattern;

/**
 * Interface enemy attacker is the generic interface to create any type of
 * enemy
 * @author tuhinmandal on 09/08/16.
 */
public interface IEnemyAttacker {

    public void fireWeapon();

    public void driveForward();

    public void assignDriver(String name);
}
