package com.tuhin.javapreps.adapterPattern;

import java.util.Random;

/**
 * Robot adaptee has behaviors which are not exactly like IEnemyAttacker.
 * This is the adaptee that client is looking at.
 * We are going to return implementations of this adaptee class to clients who
 * want some other type of behaviors
 *
 * @author tuhinmandal on 09/08/16.
 */
public class RobotAdaptee {

    private Random random = new Random();


    public void smashWithHands() {

        int damage = random.nextInt(5) + 1; // generating some random damage 5 to 1
        System.out.println("damaging : " + damage);
    }


    public void walkingForwad() {

        int movement = random.nextInt(3) + 1; //moving forward 3 to 1
        System.out.println("moving : " + movement);
    }


    public void reactToHuman(String name) {

        System.out.println("reacting to : " + name);
    }
}
