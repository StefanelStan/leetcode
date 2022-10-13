package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.october.IncreasingTripletSubsequence;
import com.ss.leetcode.LC2022.october.NumberOfCommonFactors;
import com.ss.leetcode.LC2022.october.TimeBasedKeyValueStore;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

//        start.timeBasedKeyValueStore();
//        start.increasingTripletSubsequence();
        start.numberOfCommonFactors();
    }

    public void timeBasedKeyValueStore() {
        TimeBasedKeyValueStore tbkvs = new TimeBasedKeyValueStore();
//
//        tbkvs.set("foo", "bar", 1);
//        System.out.println("bar == " + tbkvs.get("foo", 1));
//        System.out.println("bar == " + tbkvs.get("foo", 3));
//        System.out.println("bar == " + tbkvs.get("foo", 0));
//        tbkvs.set("foo", "bar2", 4);
//        tbkvs.set("foo", "bar3", 8);
//        System.out.println("bar2 == " + tbkvs.get("foo", 4));
//        System.out.println("bar2 == " + tbkvs.get("foo", 5));
//        System.out.println("bar3 == " + tbkvs.get("foo", 10));
//        System.out.println("bar == " + tbkvs.get("foo", 0));

        tbkvs.set("love", "high", 10);
        tbkvs.set("love", "low", 20);
        System.out.println(" == " + tbkvs.get("love", 5));
        System.out.println("high == " + tbkvs.get("love", 10));
        System.out.println("high == " + tbkvs.get("love", 15));
        System.out.println("low == " + tbkvs.get("love", 20));
        System.out.println("low == " + tbkvs.get("love", 25));
    }

    public void increasingTripletSubsequence() {
        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();

        System.out.println("true == " + its.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println("false == " + its.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println("true == " + its.increasingTriplet(new int[]{2,1,5,0,4,6}));
        System.out.println("true == " + its.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println("false == " + its.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println("true == " + its.increasingTriplet(new int[]{5,4,3,2,1,3,4}));
        System.out.println("false == " + its.increasingTriplet(new int[]{1,2}));
        System.out.println("false == " + its.increasingTriplet(new int[]{3,2,1}));
        System.out.println("false == " + its.increasingTriplet(new int[]{3,2}));
        System.out.println("true == " + its.increasingTriplet(new int[]{1,2,3}));
        System.out.println("true == " + its.increasingTriplet(new int[]{0,100,10,12,5,13}));
        System.out.println("false == " + its.increasingTriplet(new int[]{6,7,1,2}));
        System.out.println("true == " + its.increasingTriplet(new int[]{100,3,101,2,102,1}));
    }

    public void numberOfCommonFactors() {
        NumberOfCommonFactors nocf = new NumberOfCommonFactors();

        System.out.println("4 == " + nocf.commonFactors(12, 6));
        System.out.println("2 == " + nocf.commonFactors(25, 30));
        System.out.println("1 == " + nocf.commonFactors(12, 1));
    }
}
