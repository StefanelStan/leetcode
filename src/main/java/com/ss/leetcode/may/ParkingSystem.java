package com.ss.leetcode.may;

public class ParkingSystem {
    // https://leetcode.com/problems/design-parking-system/
    private final int[] maxCars = new int[4];
    private final int[] currentCars = new int[4];

    public ParkingSystem(int big, int medium, int small) {
        maxCars[1] = big;
        maxCars[2] = medium;
        maxCars[3] = small;
    }

    public boolean addCar(int carType) {
        if (currentCars[carType] + 1 > maxCars[carType]) {
            return false;
        } else {
            currentCars[carType]++;
            return true;
        }
    }
}
