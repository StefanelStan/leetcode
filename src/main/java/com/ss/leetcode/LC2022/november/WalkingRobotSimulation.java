package com.ss.leetcode.LC2022.november;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class WalkingRobotSimulation {
    // Note: You can somply just use a hashSet<String> and inject the obstacles (eg: "3/-1") and with each move (x/y) coord check if x/y string exists in blocked set.
    // https://leetcode.com/problems/walking-robot-simulation
    public int robotSim(int[] commands, int[][] obstacles) {
        int maxEuclideanDistance = 0;
        // 0 - N, 1 - E, 2 - S, 3 - W
        int orientation = 0;
        int[][] directions = {{0, 1}, {1, 0},{0, -1}, {-1, 0}};
        int[] xy = {0,0};
        Map<Integer, TreeSet<Integer>> xObstacles = new HashMap<>();
        Map<Integer, TreeSet<Integer>> yObstacles = new HashMap<>();
        markObstacles(obstacles, xObstacles, yObstacles);
        for (int command : commands) {
            if (command < 0) {
                orientation = getNextOrientation(command, orientation);
            } else {
                moveRobot(command, xy, orientation, directions[orientation], xObstacles, yObstacles);
                maxEuclideanDistance = Math.max(maxEuclideanDistance, xy[0] * xy[0] + xy[1] * xy[1]);
            }
        }
        return maxEuclideanDistance;
    }

    private int getNextOrientation(int direction, int orientation) {
        direction = direction == -1 ? 1 : -1;
        orientation += direction;
        return orientation < 0 ? 3 : orientation % 4;
    }

    private void markObstacles(int[][] obstacles, Map<Integer, TreeSet<Integer>> xObstacles, Map<Integer, TreeSet<Integer>> yObstacles) {
        for (int[] obstacle : obstacles) {
            xObstacles.computeIfAbsent(obstacle[0], k -> new TreeSet<>()).add(obstacle[1]);
            yObstacles.computeIfAbsent(obstacle[1], k -> new TreeSet<>()).add(obstacle[0]);
        }
    }

    private void moveRobot(int steps, int[] xy, int orientation, int[] coeff, Map<Integer, TreeSet<Integer>> xObstacles, Map<Integer, TreeSet<Integer>> yObstacles) {
        Map<Integer, TreeSet<Integer>> target;
        int directionValue, axisOrientation, axisDestination;
        if (orientation == 0 || orientation == 2) {
            target = xObstacles;
            directionValue = coeff[1];
            axisOrientation = xy[0];
            axisDestination = xy[1];
        } else {
            target = yObstacles;
            directionValue = coeff[0];
            axisOrientation = xy[1];
            axisDestination = xy[0];
        }
        TreeSet<Integer> obstacles = target.get(axisOrientation);
        if (obstacles == null) {
            if (orientation == 0 || orientation == 2) {
                xy[1] += (steps * coeff[1]);
            } else {
                xy[0] += (steps * coeff[0]);
            }
            return;
        }
        if (orientation <= 1) { // you are going into a positive direction, so you need to fetch the ceiling
            Integer nextHighPosition = obstacles.ceiling(axisDestination + directionValue);
            if (nextHighPosition == null) {
                makeSteps(steps, orientation,directionValue, xy);
            } else {
                int allowedSteps = Math.abs(Math.min(nextHighPosition + -directionValue, axisDestination + steps * directionValue) - axisDestination);
                makeSteps(allowedSteps, orientation, directionValue, xy);
            }
        } else { // you are going into a negative direction, so you need to fetch the floor.
            Integer nextLowerPosition = obstacles.floor(axisDestination + directionValue);
            if (nextLowerPosition == null) {
                makeSteps(steps, orientation,directionValue, xy);
            } else {
                int allowedSteps = Math.abs(Math.max(nextLowerPosition + -directionValue , axisDestination + steps * directionValue) - axisDestination);
                makeSteps(allowedSteps, orientation, directionValue, xy);
            }
        }
    }

    private void makeSteps(int steps, int orientation, int directionValue, int[] xy) {
        if (orientation == 0 || orientation == 2) {
            xy[1] += (steps * directionValue);
        } else {
            xy[0] += (steps * directionValue);
        }
    }
}
