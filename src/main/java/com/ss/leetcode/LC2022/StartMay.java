package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.may.LatestTimeByReplacingHiddenDigits;
import com.ss.leetcode.LC2022.may.MaxNumberOfKSumPairs;
import com.ss.leetcode.LC2022.may.SeatReservationManager;
import com.ss.leetcode.LC2022.may.ShortestUnsortedContinuousSubarray;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.latestTimeByReplacingHiddenDigits();
//        start.seatReservationManager();
//        start.shortestUnsortedContinuousSubarray();
        start.maxNumberOfKSumPairs();
    }

    public void latestTimeByReplacingHiddenDigits() {
        LatestTimeByReplacingHiddenDigits ltbrhd = new LatestTimeByReplacingHiddenDigits();

        System.out.println("23:50 == " + ltbrhd.maximumTime("2?:?0"));
        System.out.println("09:39 == " + ltbrhd.maximumTime("0?:3?"));
        System.out.println("19:22 == " + ltbrhd.maximumTime("1?:22"));
    }

    public void seatReservationManager() {
        SeatReservationManager srm = new SeatReservationManager(5);

        System.out.println("1 == " + srm.reserve());
        System.out.println("2 == " + srm.reserve());
        srm.unreserve(2);
        System.out.println("2 == " + srm.reserve());
        System.out.println("3 == " + srm.reserve());
        System.out.println("4 == " + srm.reserve());
        System.out.println("5 == " + srm.reserve());
        srm.unreserve(5);
    }

    public void shortestUnsortedContinuousSubarray() {
        ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();

        System.out.println("5 == " + sucs.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println("0 == " + sucs.findUnsortedSubarray(new int[]{1,2,3,4}));
        System.out.println("0 == " + sucs.findUnsortedSubarray(new int[]{1}));
    }

    public void maxNumberOfKSumPairs() {
        MaxNumberOfKSumPairs mnokps = new MaxNumberOfKSumPairs();

        System.out.println("2 == " + mnokps.maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println("1 == " + mnokps.maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}
