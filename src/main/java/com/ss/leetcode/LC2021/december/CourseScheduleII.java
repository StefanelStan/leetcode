package com.ss.leetcode.LC2021.december;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII {
    // https://leetcode.com/problems/course-schedule-ii/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
