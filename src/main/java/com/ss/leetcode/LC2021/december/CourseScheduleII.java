package com.ss.leetcode.LC2021.december;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII {
    // https://leetcode.com/problems/course-schedule-ii/
    // Kahn's Topological Sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];
        List[] outgoing = new List[numCourses];
        calculateInDegree(inDegree, outgoing, prerequisites);
        addFirstCourses(inDegree, order);
        int length, from = 0;
        while (order.size() < numCourses) {
            length = order.size();
            for (int i = from; i < length; i++) {
                if (inDegree[order.get(i)] != -1) {
                    reduceIncomingDegreeOfOutgoingNodes(order, inDegree, outgoing, i);
                    inDegree[order.get(i)] = -1;
                }
                from = i + 1;
            }
            if (length == order.size()) {
                return new int[0];
            }
        }
        return toArray(order);
    }

    private void reduceIncomingDegreeOfOutgoingNodes(List<Integer> order, int[] inDegree, List[] outgoing, int i) {
        List<Integer> outgoings = outgoing[order.get(i)];
        if (outgoings != null) {
            for (int out : outgoings) {
                inDegree[out]--;
                if (inDegree[out] == 0) {
                    order.add(out);
                }
            }
        }
    }

    private void addFirstCourses(int[] inDegree, List<Integer> order) {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                order.add(i);
            }
        }
    }

    private void calculateInDegree(int[] inDegree, List[] outgoing, int[][] prerequisites) {
        for (int[] prereq : prerequisites) {
            if (outgoing[prereq[1]] == null) {
                outgoing[prereq[1]] = new ArrayList<>();
            }
            outgoing[prereq[1]].add(prereq[0]);
            inDegree[prereq[0]]++;
        }
    }

    private int[] toArray(List<Integer> order) {
        int[] inOrder =  new int[order.size()];
        int insertIndex = 0;
        for (int course : order) {
            inOrder[insertIndex++] = course;
        }
        return inOrder;
    }


    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseMap = getCourseMap(prerequisites);
        Set<Integer> orderedCourses = getOrderedCourses(courseMap);
        if (orderedCourses == null) {
            return new int[0];
        }
        int[] reqCourses = new int[numCourses];
        int index = 0;
        for (int course : orderedCourses) {
            reqCourses[index++] = course;
        }
        for (int i = 0; i < reqCourses.length; i++) {
            if (!orderedCourses.contains(i)) {
                reqCourses[index++] = i;
            }
        }
        return reqCourses;
    }

    private Set<Integer> getOrderedCourses(Map<Integer, Set<Integer>> courseMap) {
        final Set<Integer> courses = new LinkedHashSet<>();
        boolean impossibleToFinish = false;
        while (!courseMap.isEmpty() && !impossibleToFinish) {
            impossibleToFinish = true;
            Iterator<Map.Entry<Integer, Set<Integer>>> it = courseMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Set<Integer>> entry = it.next();
                if (entry.getValue().isEmpty()) {
                    it.remove();
                    courses.add(entry.getKey());
                    impossibleToFinish = false;
                } else {
                    boolean prerequisitesDone = true;
                    for (Integer course : entry.getValue()) {
                        if (courseMap.containsKey(course)) {
                            prerequisitesDone = false;
                            break;
                        }
                    }
                    if (prerequisitesDone) {
                        courses.add(entry.getKey());
                        it.remove();
                        impossibleToFinish = false;
                    }
                }
            }
        }
        if (impossibleToFinish) {
            return null;
        }
        return courses;
    }

    private Map<Integer, Set<Integer>> getCourseMap(int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseMap = new HashMap<>();
        for (int[] course : prerequisites) {
            courseMap.putIfAbsent(course[1], new HashSet<>());
            courseMap.computeIfAbsent(course[0], k -> new HashSet<>()).add(course[1]);
        }
        return courseMap;
    }
}
