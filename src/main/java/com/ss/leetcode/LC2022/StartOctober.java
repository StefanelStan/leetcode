package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.october.TimeBasedKeyValueStore;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

        start.timeBasedKeyValueStore();
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
}
