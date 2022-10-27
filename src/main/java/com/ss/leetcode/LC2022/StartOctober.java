package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.october.CountNumberOfDistinctIntegersAfterReverseOperations;
import com.ss.leetcode.LC2022.october.DeleteTheMiddleNodeOfALinkedList;
import com.ss.leetcode.LC2022.october.DetermineIfTwoEventsHaveConflict;
import com.ss.leetcode.LC2022.october.FindResultantArrayAfterRemovingAnagrams;
import com.ss.leetcode.LC2022.october.IncreasingTripletSubsequence;
import com.ss.leetcode.LC2022.october.MaximumRepeatingSubstring;
import com.ss.leetcode.LC2022.october.NumberOfCommonFactors;
import com.ss.leetcode.LC2022.october.TimeBasedKeyValueStore;
import com.ss.leetcode.shared.ListNode;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

//        start.timeBasedKeyValueStore();
//        start.increasingTripletSubsequence();
//        start.numberOfCommonFactors();
//        start.deleteTheMiddleNodeOfALinkedList();
//        start.maximumRepeatingSubstring();
//        start.findResultantArrayAfterRemovingAnagrams();
//        start.countNumberOfDistinctIntegersAfterReverseOperations();
        start.determineIfTwoEventsHaveConflict();
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

    public void deleteTheMiddleNodeOfALinkedList() {
        DeleteTheMiddleNodeOfALinkedList dtmoall = new DeleteTheMiddleNodeOfALinkedList();

        System.out.println("[1,3,4,1,2,6] == " + dtmoall.deleteMiddle(ListNode.makeChain(new int[]{1,3,4,7,1,2,6})).getAsList());
        System.out.println("[1,2,4] == " + dtmoall.deleteMiddle(ListNode.makeChain(new int[]{1,2,3,4})).getAsList());
        System.out.println("[2] == " + dtmoall.deleteMiddle(ListNode.makeChain(new int[]{2,1})).getAsList());
        System.out.println("null == " + dtmoall.deleteMiddle(ListNode.makeChain(new int[]{1})));
    }

    public void maximumRepeatingSubstring() {
        MaximumRepeatingSubstring mrs = new MaximumRepeatingSubstring();

        System.out.println("2 == " + mrs.maxRepeating("ababc","ab"));
        System.out.println("1 == " + mrs.maxRepeating("ababc","ba"));
        System.out.println("0 == " + mrs.maxRepeating("ababc","ac"));
        System.out.println("1 == " + mrs.maxRepeating("aaabc","abc"));
        System.out.println("10 == " + mrs.maxRepeating("abababaaaacdababababababababababacab","ab"));
        System.out.println("6 == " + mrs.maxRepeating("aaaaaa","a"));
        System.out.println("0 == " + mrs.maxRepeating("aa","aaa"));
        System.out.println("1 == " + mrs.maxRepeating("aaabaaaacaaaaa","aaa"));
        System.out.println("5 == " + mrs.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
    }

    public void findResultantArrayAfterRemovingAnagrams() {
        FindResultantArrayAfterRemovingAnagrams fraara = new FindResultantArrayAfterRemovingAnagrams();

        System.out.println("[abba, cd] == " + fraara.removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
        System.out.println("[a,b,c,d,e] == " + fraara.removeAnagrams(new String[]{"a","b","c","d","e"}));
        System.out.println("[abba,aaa,aa,aaa] == " + fraara.removeAnagrams(new String[]{"abba","aabb","aaa","aaa","aa","aaa"}));
    }

    public void countNumberOfDistinctIntegersAfterReverseOperations() {
        CountNumberOfDistinctIntegersAfterReverseOperations cnodiaro = new CountNumberOfDistinctIntegersAfterReverseOperations();

        System.out.println("6 == " + cnodiaro.countDistinctIntegers(new int[]{1,13,10,12,31}));
        System.out.println("1 == " + cnodiaro.countDistinctIntegers(new int[]{2,2,2}));
        System.out.println("35 == " + cnodiaro.countDistinctIntegers(new int[]{32,1212,232,3232,1212,7676,543,2323,1212,4545,232,2323,121,343,553,333,444,555,1,1,11,11,111,111,1,7,3,2,7,6,6,5,4,656,343,434,322,223,112,211}));
        System.out.println("1 == " + cnodiaro.countDistinctIntegers(new int[]{7}));
        System.out.println("2 == " + cnodiaro.countDistinctIntegers(new int[]{23,32}));
    }

    public void determineIfTwoEventsHaveConflict() {
        DetermineIfTwoEventsHaveConflict ditehc = new DetermineIfTwoEventsHaveConflict();

        System.out.println("true == " + ditehc.haveConflict(new String[]{"01:15","02:00"}, new String[]{"02:00","03:00"}));
        System.out.println("true == " + ditehc.haveConflict(new String[]{"01:00","02:00"}, new String[]{"01:20","03:00"}));
        System.out.println("false == " + ditehc.haveConflict(new String[]{"10:00","11:00"}, new String[]{"14:00","15:00"}));
    }
}
