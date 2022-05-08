package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.may.FlattenNestedListIterator;
import com.ss.leetcode.LC2022.may.FlattenNestedListIterator.MyNestedInteger;
import com.ss.leetcode.LC2022.may.ImplementStackUsingQueues;
import com.ss.leetcode.LC2022.may.LatestTimeByReplacingHiddenDigits;
import com.ss.leetcode.LC2022.may.MaxNumberOfKSumPairs;
import com.ss.leetcode.LC2022.may.MyCalendarI;
import com.ss.leetcode.LC2022.may.OneThreeTwo132Pattern;
import com.ss.leetcode.LC2022.may.SeatReservationManager;
import com.ss.leetcode.LC2022.may.ShortestUnsortedContinuousSubarray;
import java.util.List;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.latestTimeByReplacingHiddenDigits();
//        start.seatReservationManager();
//        start.shortestUnsortedContinuousSubarray();
//        start.maxNumberOfKSumPairs();
//        start.implementStackUsingQueues();
//        start.myCalendarI();
//        start.oneThreeTwo132Pattern();
        start.flattenNestedListIterator();
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

    public void oneThreeTwo132Pattern() {
        OneThreeTwo132Pattern ott132p = new OneThreeTwo132Pattern();

        System.out.println("false == " + ott132p.find132pattern(new int[]{1,2,3,4}));
        System.out.println("true == " + ott132p.find132pattern(new int[]{3,1,4,2}));
        System.out.println("true == " + ott132p.find132pattern(new int[]{-1,3,2,0}));
        System.out.println("true == " + ott132p.find132pattern(new int[]{1,3,2,4,5,6,7,8,9,10}));
        System.out.println("true == " + ott132p.find132pattern(new int[]{3,5,0,3,4}));
    }

    public void flattenNestedListIterator() {
        MyNestedInteger mn1 = new MyNestedInteger(List.of(new MyNestedInteger(1), new MyNestedInteger(1)));
        MyNestedInteger mn2 = new MyNestedInteger(2);
        MyNestedInteger mn3 = new MyNestedInteger(List.of(new MyNestedInteger(1), new MyNestedInteger(1)));
        FlattenNestedListIterator fnli = new FlattenNestedListIterator(List.of(mn1, mn2, mn3));
        System.out.println("[1,1,2,1,1] == " + List.of(fnli.next(), fnli.next(), fnli.next(), fnli.next(), fnli.next()));

        mn1 = new MyNestedInteger(6);
        mn2 = new MyNestedInteger(List.of(new MyNestedInteger(4), mn1));
        mn3 = new MyNestedInteger(List.of(new MyNestedInteger(1), mn2));
        fnli = new FlattenNestedListIterator(List.of(mn3, mn2, mn1));
        System.out.println("[1,4,6] == " + List.of(fnli.next(), fnli.next(), fnli.next()));
    }
}
