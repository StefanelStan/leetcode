package com.ss.leetcode.LC2024.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RobotCollisions {
    /** Algorithm
        1. Use a class Robot to encapsulate each robot properties: position on line, health, direction and ORDER in the given array
        2. Sort the robots by position on the line
        3. Traverse the robots and use a list/dequeue/stack to put the robots
            - if robot is going R, put it on the top of stack
            - if robot is going L, check the stack for other robots facing R: they will collide. Collide the L robot until the queue is empty current L robot dies.
        4. Sort the surviving robots by their order and return a list of their remaining health.
     */
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = getInitialRobots(positions, healths, directions);
        List<Robot> survivors = collideRobots(robots);
        return getSurvivors(survivors);
    }

    private List<Robot> collideRobots(List<Robot> robots) {
        List<Robot> queue = new ArrayList<>();
        for (Robot r : robots) {
            if (r.direction == 'R') {
                queue.add(r);
            } else {
                while(!queue.isEmpty() && queue.get(queue.size() - 1).direction == 'R' && r.health > 0) {
                    if (r.health == queue.get(queue.size() - 1).health) {
                        queue.remove(queue.size() - 1);
                        r.health = 0;
                        break;
                    } else if (r.health > queue.get(queue.size() - 1).health) {
                        r.health--;
                        queue.remove(queue.size() - 1);
                    } else {
                        queue.get(queue.size() - 1).health--;
                        r.health = 0;
                    }
                }
                if (r.health > 0) {
                    queue.add(r);
                }
            }
        }
        return queue;
    }

    private List<Integer> getSurvivors(List<Robot>robots) {
        List<Integer> survivors = new ArrayList<>(robots.size());
        Collections.sort(robots, Comparator.comparingInt(r -> r.order));
        for (Robot r : robots) {
            survivors.add(r.health);
        }
        return survivors;
    }

    private List<Robot> getInitialRobots(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>(positions.length);
        new ArrayList<>(positions.length);
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
        }
        Collections.sort(robots, Comparator.comparingInt(r -> r.position));
        return robots;
    }

    private static class Robot {
        char direction;
        int health;
        int order;
        int position;

        public Robot(int order, int position, int health, char direction) {
            this.order = order;
            this.position = position;
            this.health = health;
            this.direction =  direction;
        }
    }
}
