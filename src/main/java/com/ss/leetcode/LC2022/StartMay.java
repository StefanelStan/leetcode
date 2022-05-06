package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.may.ImplementStackUsingQueues;
import com.ss.leetcode.LC2022.may.LatestTimeByReplacingHiddenDigits;
import com.ss.leetcode.LC2022.may.MaxNumberOfKSumPairs;
import com.ss.leetcode.LC2022.may.MyCalendarI;
import com.ss.leetcode.LC2022.may.SeatReservationManager;
import com.ss.leetcode.LC2022.may.ShortestUnsortedContinuousSubarray;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.latestTimeByReplacingHiddenDigits();
//        start.seatReservationManager();
//        start.shortestUnsortedContinuousSubarray();
//        start.maxNumberOfKSumPairs();
//        start.implementStackUsingQueues();
        start.myCalendarI();
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

    public void implementStackUsingQueues() {
        ImplementStackUsingQueues isuq = new ImplementStackUsingQueues();

        isuq.push(1);
        isuq.push(2);
        System.out.println("2 == " + isuq.top());
        System.out.println("2 == " + isuq.pop());
        System.out.println("false == " + isuq.empty());
    }

    public void myCalendarI() {
        MyCalendarI mci = new MyCalendarI();
        System.out.println("true == " + mci.book(10, 20));
        System.out.println("false == " + mci.book(15, 25));
        System.out.println("true == " + mci.book(20, 30));

        mci = new MyCalendarI();
        System.out.println("true == " + mci.book(47, 50));
        System.out.println("true == " + mci.book(33,41));
        System.out.println("false == " + mci.book(39,45));
        System.out.println("false == " + mci.book(33,42));
        System.out.println("true == " + mci.book(25,32));
        System.out.println("false == " + mci.book(26,35));
        System.out.println("true == " + mci.book(19,25));
        System.out.println("true == " + mci.book(3,8));
        System.out.println("true == " + mci.book(8,13));
        System.out.println("false == " + mci.book(18,27));
    }
}
