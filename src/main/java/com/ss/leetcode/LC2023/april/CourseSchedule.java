package com.ss.leetcode.LC2023.april;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    // https://leetcode.com/problems/course-schedule
    // Kahn topological sort with a clean queue of nodes
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] outgoing = new List[numCourses];
        generateGraph(prerequisites, inDegree, outgoing);
        int totalCourses = countDoableCourses(inDegree, outgoing);
        return totalCourses == numCourses;
    }

    private int countDoableCourses(int[] inDegree, List<Integer>[] outgoing) {
        Queue<Integer> doneCourses = getInitialCourses(inDegree);
        int totalCourses = 0, currentCourse;
        while(!doneCourses.isEmpty()) {
            currentCourse = doneCourses.poll();
            totalCourses++;
            if (outgoing[currentCourse] != null) {
                for (int nextCourse : outgoing[currentCourse]) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        doneCourses.offer(nextCourse);
                    }
                }
            }
        }
        return totalCourses;
    }

    private void generateGraph(int[][] prerequisites, int[] inDegree, List<Integer>[] outgoing) {
        for (int[] req : prerequisites) {
            inDegree[req[1]]++;
            if (outgoing[req[0]] == null) {
                outgoing[req[0]] = new ArrayList<>();
            }
            outgoing[req[0]].add(req[1]);
        }
    }

    private Queue<Integer> getInitialCourses(int[] inDegree) {
        Queue<Integer> doneCourses = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                doneCourses.offer(i);
            }
        }
        return doneCourses;
    }


    // Kahn's Topological Sort
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] outgoing = new List[numCourses];
        int[] inDegree = new int[numCourses];
        calculateInDegree(outgoing, inDegree, prerequisites);
        List<Integer> order = addFirstCourses(inDegree);
        int length, from = 0;
        while(order.size() < numCourses) {
            length = order.size();
            for (int i = from; i < length; i++) {
                if (inDegree[order.get(i)] != -1) {
                    List<Integer> outgoings = outgoing[order.get(i)];
                    if (outgoings != null) {
                        for (int out : outgoings) {
                            inDegree[out]--;
                            if (inDegree[out] == 0) {
                                order.add(out);
                            }
                        }
                    }
                    inDegree[order.get(i)] = -1;
                }
                from = i + 1;
            }
            if (length == order.size()) {
                break;
            }
        }
        return order.size() == numCourses;
    }

    private List<Integer> addFirstCourses(int[] inDegree) {
        List<Integer> order = new ArrayList<>(inDegree.length);
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                order.add(i);
            }
        }
        return order;
    }

    private void calculateInDegree(List<Integer>[] outgoing, int[] inDegree, int[][] prerequisites) {
        for (int[] prereq : prerequisites) {
            if (outgoing[prereq[1]] == null) {
                outgoing[prereq[1]] = new ArrayList<>();
            }
            outgoing[prereq[1]].add(prereq[0]);
            inDegree[prereq[0]]++;
        }
    }
}
