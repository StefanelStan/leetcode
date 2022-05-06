package com.ss.leetcode.LC2022.may;

public class MyCalendarI {
    // https://leetcode.com/problems/my-calendar-i/
    Booking preHead;
    public MyCalendarI() {
        preHead = new Booking(-2, -1);
    }

    public boolean book(int start, int end) {
        if (preHead.next == null) {
            preHead.next = new Booking(start, end);
            return true;
        } else {
            return tryToBook(preHead, start, end);
        }
    }

    private boolean tryToBook(Booking booking, int start, int end) {
        while(booking != null) {
            // check if current booking is overlapping the given interval
            if(isOverlapping(booking, start, end)) {
                return false;
            }
            //check if start and stop are between current and next booking;
            // if greater {
            if(booking.end <= start) {
                // check if smaller than next one.
                // If next one is null, OR smaller than next one: insert, return true,
                if (booking.next == null || end <= booking.next.start) {
                    // add it between this and next
                    addBooking(booking, start, end);
                    return true;
                } else {
                    booking = booking.next;
                }
                //if not, return false.
            } else { // move to next one
                booking = booking.next;
            }
        }
        return false;
    }

    private boolean isOverlapping(Booking booking, int start, int end) {
        return booking.start > end && end <= booking.end
            || start <= booking.start && end >= booking.end
            || start <= booking.start;
    }

    private void addBooking(Booking booking, int start, int end) {
        if (booking.next == null) {
            booking.next = new Booking(start, end);
        } else {
            Booking next = booking.next;
            booking.next = new Booking(start, end, next);
        }
    }

    private static class Booking {
        int start;
        int end;
        Booking next;

        public Booking(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Booking(int start, int end, Booking next) {
            this.start = start;
            this.end = end;
            this.next = next;
        }

    }
}
