package com.ss.leetcode.LC2023.july;

import java.util.LinkedList;

public class AsteroidCollision {
    // https://leetcode.com/problems/asteroid-collision
    /** Algorithm
        1. Use a LinkedList<Integer> to keep track of what asteroids you have collected so far (not destroyed).
        2. For each asteroid from int[] asteroids, check if it collides with the last one from LinkedList.
            While they are colliding (lastOne > 0 and current < 0), resolve the collision
            - if lastOne > current, return immediately (current asteroid gets destroyed)
            - if their abs is equal, both get destroyed: remove the last asteroid from list and return
            - if current > lastOne, then lastOne gets destroyed (/removeLast()) and check again (lastOne -1, current)
            - if not returned from if #1 and #if2, then add current to LinkedList(.addLast())
                as either it's on the same sign OR it has destroyed all the asteroids from LinkedList
        3. Move the asteroids from LinkedList into an int[].
     */
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int asteroid : asteroids) {
            resolveCollisions(result, asteroid);
        }
        int[] answer = new int[result.size()];
        int index = 0;
        for (int asteroid : result) {
            answer[index++] = asteroid;
        }
        return answer;
    }

    private boolean areColliding(LinkedList<Integer> asteroids, int asteroid) {
        return !asteroids.isEmpty() && asteroids.peekLast() > 0 && asteroid < 0;
    }

    private void resolveCollisions(LinkedList<Integer> asteroids, int next) {
        while(areColliding(asteroids, next)) {
            if (Math.abs(asteroids.peekLast()) > Math.abs(next)) {
                return;
            } else if(Math.abs(asteroids.peekLast()) < Math.abs(next)) {
                asteroids.removeLast();
            } else {
                asteroids.removeLast();
                return;
            }
        }
        asteroids.add(next);
    }
}
