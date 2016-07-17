package com.tuhin.javapreps.misc;

/**
 * Created by tuhinmandal on 17/07/16.
 */
public class Tmpclass {

    private int[] data = {1, 2, 4, 5, 7, 30};
    public static void main(String args[]) {
        int removed = new Tmpclass().remove(2);
        new Tmpclass().swap(10, 20);
    }

    public int remove(int index) {
        if(index > data.length) {
            throw  new ArrayIndexOutOfBoundsException();
        } else {
            int element = data[index];
            int temp = index;
            data[temp] = data[temp + 1];
            data[temp] = 0;
            temp++;
            return  element;
        }
    }

    public void swap(int x, int y) {
        x = x + y;
        y = x -y;
        x = x -y;
        System.out.println("swapped values x = " + x + " and y = " + y);
    }
}
