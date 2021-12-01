package com.ss.leetcode.LC2021.october;

import java.util.Collections;
import java.util.List;

public class EmployeeImportance {
    // https://leetcode.com/problems/employee-importance/
    public int getImportance(List<Employee> employees, int id) {
        Employee[] employeesMap = new Employee[2001];
        for (Employee e : employees) {
            employeesMap[e.id] = e;
        }
        return getImportanceOf(id, employeesMap);
    }

    private int getImportanceOf(int id, Employee[] employeesMap) {
        int imp = employeesMap[id].importance;
        for (int subId : employeesMap[id].subordinates) {
            imp += getImportanceOf(subId, employeesMap);
        }
        return imp;
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        public Employee(int id, int importance) {
            this(id, importance, Collections.emptyList());
        }
    }
}
