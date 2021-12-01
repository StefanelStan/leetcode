package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.december.WateringPlants;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

        start.wateringPlants();
    }

    public void wateringPlants() {
        WateringPlants wp = new WateringPlants();

        System.out.println("14 == " + wp.wateringPlants(new int[]{2,2,3,3}, 5));
        System.out.println("30 == " + wp.wateringPlants(new int[]{1,1,1,4,2,3}, 4));
        System.out.println("49 == " + wp.wateringPlants(new int[]{7,7,7,7,7,7,7}, 8));
    }
}
