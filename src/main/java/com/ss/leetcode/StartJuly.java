package com.ss.leetcode;

import com.ss.leetcode.july.BuildArrayFromPermutation;
import com.ss.leetcode.july.IncreasingDecreasingString;
import com.ss.leetcode.july.MinimumOperationsArrayIncreasing;
import com.ss.leetcode.july.MinimumTimeVisitingAllPoints;

import java.util.Arrays;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.buildArrayFromPermutation();
//        start.minimumTimeVisitingAllPoints();
//        start.minimumOperationsToMakeTheArrayIncreasing();
        start.increasingDecreasingString();
    }

    public void buildArrayFromPermutation() {
        BuildArrayFromPermutation bafp = new BuildArrayFromPermutation();

        System.out.println("[0,1,2,4,5,3] == " + Arrays.toString(bafp.buildArray(new int[]{0,2,1,5,3,4})));
        System.out.println("[4,5,0,1,2,3] == " + Arrays.toString(bafp.buildArray(new int[]{5,0,1,2,3,4})));

    }

    public void minimumTimeVisitingAllPoints() {
        MinimumTimeVisitingAllPoints mtval = new MinimumTimeVisitingAllPoints();
        int[][] input1 = {{220,-503},{525,533},{-121,-746},{809,529},{594,629},{249,199},{20,55},{-997,-877},{-465,-357},
                {445,-151},{814,719},{-349,-277},{844,-598},{-262,-539},{-721,-596},{-883,310},{-13,113},{-869,-829},
                {817,766},{-234,794},{-438,-398},{831,626},{0,-142},{314,65},{161,213},{-65,-325},{-336,-351},{-624,370},
                {-591,-23},{-886,729},{879,336},{743,-682},{285,38},{460,959},{-575,-613},{-795,-106},{-198,-696},{206,317},
                {-785,-316},{638,593},{-439,413},{150,-633},{752,170},{988,713},{-554,832},{915,-453},{794,-276},{633,75},
                {815,-992},{290,-787},{514,708},{-571,-232},{304,-821},{850,-970},{-521,984},{479,-121},{-272,135},{-480,192},
                {126,-696},{975,444},{-385,-162},{-990,480},{279,-84},{118,122},{-981,265},{-465,350},{517,495},{-523,-944},
                {-372,-557},{103,-531},{145,383},{-98,-403},{265,-958},{-515,-737},{-431,-904},{-457,610},{-488,495},{757,-48},{-811,-632}};

        System.out.println("68796 == " + mtval.minTimeToVisitAllPoints(input1));
        System.out.println("7 == " + mtval.minTimeToVisitAllPoints(new int[][]{{1,1}, {3,4}, {-1,0}}));
        System.out.println("5 == " + mtval.minTimeToVisitAllPoints(new int[][]{{3,2}, {-2, 2}}));
    }

    public void minimumOperationsToMakeTheArrayIncreasing() {
        MinimumOperationsArrayIncreasing motmtai = new MinimumOperationsArrayIncreasing();

        System.out.println("3 == " + motmtai.minOperations(new int[]{1,1,1}));
        System.out.println("14 == " + motmtai.minOperations(new int[]{1,5,2,4,1}));
        System.out.println("0 == " + motmtai.minOperations(new int[]{8}));
    }

    public void increasingDecreasingString() {
        IncreasingDecreasingString ids = new IncreasingDecreasingString();

        System.out.println("abccbaabccba == " + ids.sortString("aaaabbbbcccc"));
        System.out.println("art == " + ids.sortString("rat"));
        System.out.println("cdelotee == " + ids.sortString("leetcode"));
        System.out.println("ggggggg == " + ids.sortString("ggggggg"));
        System.out.println("ops == " + ids.sortString("spo"));
    }
}
