package com.ss.leetcode.LC2023.august;

public class WalkingRobotSimulationII {
    // https://leetcode.com/problems/walking-robot-simulation-ii
    /** Algorithm
        1. As an overall idea, the robot will keep track of its position[]{x,y} and its current orientation.
            (0,1,2,3 - East, North, West, South).
        2. The robot can only walk on the edges of the imaginary grid, thus we only need to know x/y
        3. The robot can be given a high number of steps to walk, but, if those steps > perimeter of grid,
            the robot will only walk in circles.
            Thus, a full walk cycle = 2 * width + 2 * (height -1).
            The real number of steps = steps % fullCycle.
            If steps == 0 (x full cycles), the robot actually stays in place (does x circles arriving on same pot)
        4. Edge case: if x full cycle are given from the first time, the robot should make full cycles,
            arriving at 0,0, with orientation S. However, as we skip full cicles, the robot will be fixed pointing East, although it needs to point south.
            Ths, this needs to be fixed with a set direction that will make robot point south if at 0,0
        5. In a while loop,
            - orientate robot to correct walking direction. EG: if robot @ [5,0], the robot should steer to north as it can only walk there.
            - after steering, determine possibleSteps it can make (until it reaches the edge or the given number of totalSteps)
            - deduct the possibleSteps from totalnumber of steps
            - stop when total number of steps becomes 0.
     */
    private final int width, height;
    private final int[] position;
    private final String[] orientation = {"East", "North", "West", "South"};
    private int currentOrientation = 0;
    private final int fullCycle;
    public WalkingRobotSimulationII(int width, int height) {
        this.width = width;
        this.height = height;
        fullCycle = 2 * width + 2 * (height - 2);
        position = new int[]{0, 0};
    }

    public void step(int num) {
        num = num % fullCycle;
        while(num > 0) {
            orientateRobot();
            num -= moveRobot(num);
        }
        setDirection();
    }

    public int[] getPos() {
        return position;
    }

    public String getDir() {
        return orientation[currentOrientation];
    }

    private int moveRobot(int steps) {
        int possibleSteps = currentOrientation % 2 == 0
            ? currentOrientation == 0 ? (width -1 - position[0]) : position[0]
            : currentOrientation == 1 ? (height -1 - position[1]) : position[1];
        walkSteps(Math.min(possibleSteps, steps));
        return Math.min(possibleSteps, steps);
    }

    private void walkSteps(int steps) {
        if (currentOrientation % 2 == 0) {
            position[0] = currentOrientation == 0 ? position[0] + steps : position[0] - steps;
        } else {
            position[1] = currentOrientation == 1 ? position[1] + steps : position[1] - steps;
        }
    }

    private void setDirection() {
        if (position[1] == 0) {
            currentOrientation = position[0] == 0 ? 3 : 0;
        } else if (position[1] == height - 1) {
            currentOrientation = position[0] == width -1 ? 1 : 2;
        } else {
            currentOrientation = position[0] == 0 ? 3 : 1;
        }
    }

    private void orientateRobot() {
        if (currentOrientation == 0) {
            currentOrientation = position[0] == width -1 ? 1 : 0;
        } else if (currentOrientation == 1) {
            currentOrientation = position[1] == height -1 ? 2 : 1;
        } else if (currentOrientation == 2) {
            currentOrientation =  position[0] == 0 ? 3 : 2;
        } else {
            currentOrientation = position[1] == 0 ? 0 : 3;
        }
    }
}
