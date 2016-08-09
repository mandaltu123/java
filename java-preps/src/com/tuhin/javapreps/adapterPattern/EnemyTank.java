package com.tuhin.javapreps.adapterPattern;

import java.util.Random;

/**
 * This is how typically a enemyAttacker class will be created
 * @author tuhinmandal on 09/08/16.
 */
public class EnemyTank implements IEnemyAttacker {

    private Random random = new Random();

    @Override
    public void fireWeapon() {

        int damage = random.nextInt(10) + 1; // generating some random damage 10 to 1
        System.out.println("damaging : " + damage);
    }

    @Override
    public void driveForward() {

        int movement = random.nextInt(5) + 1; //moving forward 5 to 1
        System.out.println("moving : " + movement);
    }

    @Override
    public void assignDriver(String name) {

        System.out.println("driven by : " + name);
    }
}
