package com.ss.leetcode.LC2021.may;

public class DesignParkingSystem {
    // https://leetcode.com/problems/design-parking-system/
    int[] carParks;
    public DesignParkingSystem(int big, int medium, int small) {
        carParks = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        carParks[carType] = Math.max(-1, carParks[carType] - 1);
        return carParks[carType] >= 0;
    }


    private final int[] maxCars = new int[4];
    private final int[] currentCars = new int[4];

    public void DesignParkingSystem2(int big, int medium, int small) {
        maxCars[1] = big;
        maxCars[2] = medium;
        maxCars[3] = small;
    }

    public boolean addCar2(int carType) {
        if (currentCars[carType] + 1 > maxCars[carType]) {
            return false;
        } else {
            currentCars[carType]++;
            return true;
        }
    }
}
