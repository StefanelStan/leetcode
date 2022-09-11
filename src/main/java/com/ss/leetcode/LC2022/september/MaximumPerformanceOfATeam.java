package com.ss.leetcode.LC2022.september;

import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {
    // https://leetcode.com/problems/maximum-performance-of-a-team/
    // DOES NOT WORK
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PerformanceTeam pt = new PerformanceTeam(k);
        for (int i = 0; i < speed.length; i++) {
            pt.addEngineer(new int[]{speed[i], efficiency[i]});
            pt.trimToSizeOfPerformance();
        }
        return (int) (pt.getMaxPerformance() % 1_000_000_007);
    }

    private static class PerformanceTeam {
        private PriorityQueue<int[]> engineers = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        private long totalSpeed = 0;
        private int maxTeamSize;

        public PerformanceTeam(int teamSize) {
            this.maxTeamSize = teamSize;
        }

        public void addEngineer(int[] engineer) {
            engineers.add(engineer);
            totalSpeed += engineer[0];
        }

        public void trimToSizeOfPerformance() {
            trimToSize();
            trimToPerformance();
        }

        public long getMaxPerformance() {
            return totalSpeed * engineers.peek()[1];
        }

        private void trimToSize() {
            while (engineers.size() > maxTeamSize) {
                totalSpeed -= engineers.poll()[0];
            }
        }

        private void trimToPerformance() {
            boolean trimmedToPerformance = false;
            while (!trimmedToPerformance && engineers.size() > 1) {
                trimmedToPerformance = true;
                int[] last = engineers.poll();
                long currentPerformance = getMaxPerformance();
                long nextPossiblePerformance = (currentPerformance - last[0]) * engineers.peek()[1];
                if (nextPossiblePerformance > currentPerformance) {
                    totalSpeed -= last[0];
                    trimmedToPerformance = false;
                } else {
                    engineers.add(last);
                }
            }
        }
    }
}
