package com.ss.leetcode.LC2022.december;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    // https://leetcode.com/problems/single-threaded-cpu
    /** Algorithm
        1. Use one PriorityQueue enqueueQueue that will sort the tasks by enqueueTime, as this is a major sorting criteria
        2. Use a second PriorityQueue processingTime that will sort the tasks based on length and order.
            This second queue will hold the tasks that are eligible to be picked up (enqueu time < current time) and will take
            the top priority task based on length and order.
        3. Add all tasks in first queue and peek the first element as start time.
            Pull ALL tasks from firstQueue whose enqueueTime is = startTime
        4. Add these tasks into second queue that will sort them on length/order. Pick top from 2nd queue and adjust the startTime to be startTime + processingTime.
        5. As startTime has been adjusted, more tasks can be elibigle, whose enqueue time after current startTime.
            Again, pull from first queue into second queue where task.enqueue after current startTime.
            Pick top from 2nd queue.
            Repeat this.
        6. Pay attention to special case when there is a delay between tasks: eg: currentTime = 25 and next enqueue is 50.
            This time you can to poll the tasks that have enqueue time  = first queue.peek().
        7. Return the tasks ordered, as they have been pulled from 2nd queue.
     */
    public int[] getOrder(int[][] tasks) {
        int[] order = new int[tasks.length];
        PriorityQueue<Task> enqueueQueue = enqueueTasks(tasks);
        PriorityQueue<Task> processingTimeQueue = new PriorityQueue<>((a, b) -> a.processingTime == b.processingTime ? a.order - b.order : a.processingTime - b.processingTime);
        int timeToStart = enqueueQueue.peek().enqueueTime;
        Task currentTask;
        for (int i = 0; i < tasks.length; i++) {
            transferQueue(timeToStart, enqueueQueue, processingTimeQueue);
            currentTask = processingTimeQueue.poll();
            timeToStart = Math.max(currentTask.enqueueTime, timeToStart) + currentTask.processingTime;
            order[i] = currentTask.order;
        }
        return order;
    }

    private PriorityQueue<Task> enqueueTasks(int[][] tasks) {
        PriorityQueue<Task> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.enqueueTime));
        for (int i = 0; i < tasks.length; i++) {
            queue.add(new Task(tasks[i][0], tasks[i][1], i));
        }
        return queue;
    }

    private void transferQueue(int timeToStart, PriorityQueue<Task> source, PriorityQueue<Task> destination) {
        if (!source.isEmpty() && destination.isEmpty() && source.peek().enqueueTime > timeToStart) {
            timeToStart = source.peek().enqueueTime;
        }
        while (!source.isEmpty() && source.peek().enqueueTime <= timeToStart) {
            destination.add(source.poll());
        }
    }

    private static class Task {
        int enqueueTime;
        int processingTime;
        int order;

        public Task (int enqueueTime, int processingTime, int order) {
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.order = order;
        }
    }
}
