package com.ss.leetcode.LC2023.april;

import java.util.Arrays;

public class DestroyingAsteroids {
    // https://leetcode.com/problems/destroying-asteroids
    /** Algorithm
        1. Sort the asteroids by mass
        2. Iterate and add the asteroid to mass or deduct it, depending on mass and asteroid.
        3. Stop when mass is <= 0 OR mass >= heaviest asteroid. If it's heavier than the heaviest asteroid, then it will smash all asteroids.
        4. Return mass >= 0 (true or false)
     */
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int i = 0; i < asteroids.length && mass >= 0 && mass < asteroids[asteroids.length -1]; i++) {
            mass += mass >= asteroids[i] ? asteroids[i] : -asteroids[i];
        }
        return mass >= 0;
    }
}
