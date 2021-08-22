package com.ss.leetcode.august;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RectangleAreaII {
    public int rectangleArea(int[][] rectangles) {

        List<RectangleEvent> events = getSortedRectangleEvents(rectangles);
        long area = parseEventsAndCalculateArea(events);
        area %= 1_000_000_007;
        return (int) area;
    }

    private List<RectangleEvent> getSortedRectangleEvents(int[][] rectangles) {
        // each rectangle has 2 events (open + close)
        List<RectangleEvent> events = new ArrayList<>(rectangles.length * 2);
        for (int[] rec : rectangles) {
            events.add(new RectangleEvent(rec[1], true, rec[0], rec[2]));
            events.add(new RectangleEvent(rec[3], false, rec[0], rec[2]));
        }
        events.sort(Comparator.comparingInt(a -> a.yPoint));
        return events;
    }

    private long parseEventsAndCalculateArea(List<RectangleEvent> events) {
        List<int[]> activeEvents = new ArrayList<>();
        int currentY = events.get(0).yPoint;
        long area = 0;
        for (RectangleEvent event : events) {
            long query = 0;
            int currentX = -1;
            for (int[] activeEvent : activeEvents) {
                currentX = Math.max(currentX, activeEvent[0]);
                query += Math.max(activeEvent[1] - currentX, 0);
                currentX = Math.max(currentX, activeEvent[1]);
            }

            area += query * (event.yPoint - currentY);

            if (event.isOpenState) {
                activeEvents.add(new int[] { event.x1, event.x2 });
                activeEvents.sort(Comparator.comparingInt(a -> a[0]));
            } else {
                for (int i = 0; i < activeEvents.size(); ++i)
                    if (activeEvents.get(i)[0] == event.x1 && activeEvents.get(i)[1] == event.x2) {
                        activeEvents.remove(i);
                        break;
                    }
            }

            currentY = event.yPoint;
        }
        return area;
    }

    private static class RectangleEvent {
        int yPoint;
        boolean isOpenState;
        int x1;
        int x2;

        public RectangleEvent(int yPoint, boolean isOpenState, int x1, int x2) {
            this.yPoint = yPoint;
            this.isOpenState = isOpenState;
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}
