package com.ss.leetcode.LC2025.september;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignTaskManager {
    // https://leetcode.com/problems/design-task-manager
    /** Algorithm
        1. Use a TreeMap<Integer, TreeMap<Integer, Integer>> to group the tasks based on their priority.
            - Inside each group, the tasks will be sorted based on task Id.
        2. Also, for faster search, use a Map<Integer, Integer> to map each task to priority.
            - This way, you can find the priority of a task and you can query the treemaps based on the right priority
        3. Each add/edit/remove will update both maps.
     */
    private final Map<Integer, Integer> taskToPriority;
    private TreeMap<Integer, TreeMap<Integer, Integer>> allTasks;
    public DesignTaskManager(List<List<Integer>> tasks) {
        taskToPriority = new HashMap<>();
        initializeTasks(tasks);

    }

    public void add(int userId, int taskId, int priority) {
        taskToPriority.put(taskId, priority);
        allTasks.computeIfAbsent(priority, k -> new TreeMap<>()).put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        int oldPriority = taskToPriority.remove(taskId);
        TreeMap<Integer, Integer> tasks = allTasks.get(oldPriority);
        int userId = tasks.get(taskId);
        if (tasks.size() == 1) {
            allTasks.remove(oldPriority);
        } else {
            tasks.remove(taskId);
        }
        taskToPriority.put(taskId, newPriority);
        allTasks.computeIfAbsent(newPriority, k -> new TreeMap<>()).put(taskId, userId);
    }

    public void rmv(int taskId) {
        int currentPriority = taskToPriority.remove(taskId);
        TreeMap<Integer, Integer> tasks = allTasks.get(currentPriority);
        if (tasks.size() == 1) {
            allTasks.remove(currentPriority);
        } else {
            tasks.remove(taskId);
        }
    }

    public int execTop() {
        if (allTasks.isEmpty()) {
            return -1;
        }
        Map.Entry<Integer, Integer> topTask = allTasks.lastEntry().getValue().lastEntry();
        rmv(topTask.getKey());
        return topTask.getValue();
    }

    private void initializeTasks(List<List<Integer>> tasks) {
        allTasks = new TreeMap<>();
        for (List<Integer> task : tasks) {
            taskToPriority.put(task.get(1), task.get(2));
            allTasks.computeIfAbsent(task.get(2), k -> new TreeMap<>()).put(task.get(1), task.get(0));
        }
    }
}
