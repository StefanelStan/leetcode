package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.april.AccountBalanceAfterRoundedPurchase;
import com.ss.leetcode.LC2024.april.CountFertilePyramidsInALand;
import com.ss.leetcode.LC2024.april.FindTheValueOfThePartition;
import com.ss.leetcode.LC2024.april.GroupsOfStrings;
import com.ss.leetcode.LC2024.april.Largest1BorderedSquare;
import com.ss.leetcode.LC2024.april.MaximalRectangle;
import com.ss.leetcode.LC2024.april.MaximumMatchingOfPlayersWithTrainers;
import com.ss.leetcode.LC2024.april.MinimumFallingPathSumII;
import com.ss.leetcode.LC2024.april.MinimumNumberOfOperationsToMakeArrayXOREqualToK;
import com.ss.leetcode.LC2024.april.NthTribonacciNumber;
import com.ss.leetcode.LC2024.april.OpenTheLock;
import com.ss.leetcode.LC2024.april.RemoveKDigits;
import com.ss.leetcode.LC2024.april.ValidParenthesisString;
import java.util.Arrays;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.maximumMatchingOfPlayersWithTrainers();
//        start.groupsOfStrings();
//        start.validParenthesisString();
//        start.accountBalanceAfterRoundedPurchase();
//        start.removeKDigits();
//        start.maximalRectangle();
//        start.findTheValueOfThePartition();
//        start.openTheLock();
//        start.nthTribonacciNumber();
//        start.countFertilePyramidsInALand();
//        start.minimumFallingPathSumII();
//        start.largest1BorderedSquare();
        start.minimumNumberOfOperationsToMakeArrayXOREqualToK();
    }

    public void maximumMatchingOfPlayersWithTrainers() {
        MaximumMatchingOfPlayersWithTrainers mmopwt = new MaximumMatchingOfPlayersWithTrainers();

        System.out.println("2 == " +  mmopwt.matchPlayersAndTrainers(new int[]{4,7,9}, new int[]{8,2,5,8}));
        System.out.println("1 == " +  mmopwt.matchPlayersAndTrainers(new int[]{1,1,1}, new int[]{10}));
        System.out.println("12 == " +  mmopwt.matchPlayersAndTrainers(new int[]{4,3,2,3,4,5,6,7,6,5,4,54,6,76}, new int[]{2,3,4,5,6,5,45,3,4,4,5,6,7,8,9}));
        System.out.println("0 == " +  mmopwt.matchPlayersAndTrainers(new int[]{7}, new int[]{5}));
        System.out.println("16 == " +  mmopwt.matchPlayersAndTrainers(new int[]{6,7,8,7,6,5,6,7,8,9,8,8,76,6,5,4}, new int[]{5,4,5,6,7,6,5,4,1,3,32,2,1,2,3,4,5,65,6,76,8,9,9,8,7,5,5,34}));
    }

    public void groupsOfStrings() {
        GroupsOfStrings gos = new GroupsOfStrings();

        System.out.println("[2,3] == " + Arrays.toString(gos.groupStrings(new String[]{"a","b","ab","cde"})));
        System.out.println("[1,3] == " + Arrays.toString(gos.groupStrings(new String[]{"a","ab","abc"})));
    }

    public void validParenthesisString() {
        ValidParenthesisString vps = new ValidParenthesisString();

        System.out.println("true == " + vps.checkValidString("()"));
        System.out.println("true == " + vps.checkValidString("(*)"));
        System.out.println("true == " + vps.checkValidString("(*))"));
        System.out.println("false == " + vps.checkValidString("((((((()((((((*)*()*(*)(**)(*)((((()())()()()(((()())))))))))(())(()))())((()()((((()(())(()**)()()"));
        System.out.println("true == " + vps.checkValidString("(((((())()))())())((*(*)*(*)*()*((*(*()()(**)(*(*))))))())())))(()))))(()())()"));
        System.out.println("false == " + vps.checkValidString("((((()((*())*)(*)**()))()()()((((()()*((())))))(())()())(((())())())))))))(((((()))))(((()()))(*)()"));
        System.out.println("false == " + vps.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        System.out.println("false == " + vps.checkValidString("((((((()(((((((((()())()()()(((()())))))))))(())(()))())((()()(((()((()(())*(()**)()(())"));
        System.out.println("false == " + vps.checkValidString("((*()(*)())(*()*()*())((((()(((((((((()())()()()(((()))))))))))(()))())((()()(((()((()(())*(()**)())"));
        System.out.println("false == " + vps.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }

    public void accountBalanceAfterRoundedPurchase() {
        AccountBalanceAfterRoundedPurchase abarp = new AccountBalanceAfterRoundedPurchase();

        System.out.println("90 == " + abarp.accountBalanceAfterPurchase(9));
        System.out.println("80 == " + abarp.accountBalanceAfterPurchase(15));
        System.out.println("100 == " + abarp.accountBalanceAfterPurchase(4));
    }

    public void removeKDigits() {
        RemoveKDigits rkd = new RemoveKDigits();

        System.out.println("1219 == " + rkd.removeKdigits("1432219", 3));
        System.out.println("200 == " + rkd.removeKdigits("10200", 1));
        System.out.println("0 == " + rkd.removeKdigits("10", 2));
    }

    public void maximalRectangle() {
        MaximalRectangle mr = new MaximalRectangle();

        System.out.println("6 == " + mr.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println("0 == " + mr.maximalRectangle(new char[][]{{'0'}}));
        System.out.println("1 == " + mr.maximalRectangle(new char[][]{{'1'}}));
    }

    public void findTheValueOfThePartition() {
        FindTheValueOfThePartition ftvotp = new FindTheValueOfThePartition();

        System.out.println("1 == " + ftvotp.findValueOfPartition(new int[]{1,3,2,4}));
        System.out.println("9 == " + ftvotp.findValueOfPartition(new int[]{100,1,10}));
        System.out.println("9 == " + ftvotp.findValueOfPartition(new int[]{100,1,10}));
        System.out.println("5 == " + ftvotp.findValueOfPartition(new int[]{1,6}));
        System.out.println("0 == " + ftvotp.findValueOfPartition(new int[]{1,1}));
        System.out.println("0 == " + ftvotp.findValueOfPartition(new int[]{145,3123,12154,63421,76743,52312,332323,51123,73568,35626,5563234,12445254,124324,5464,324243,565655,23235,12135,4234356,121245,342134,2324,53434,56564,676656,787845,298983,334324,334362,5634343,45324,543,645,6426534,54321,543,642,534,543434,343435,12126,21334,5313432,31315,4131336,5313147}));
    }

    public void openTheLock() {
        OpenTheLock otl = new OpenTheLock();

        System.out.println("6 == " + otl.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println("1 == " + otl.openLock(new String[]{"8888"}, "0009"));
        System.out.println("-1 == " + otl.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        System.out.println("1 == " + otl.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0001"));
    }

    public void nthTribonacciNumber() {
        NthTribonacciNumber ntn = new NthTribonacciNumber();

        System.out.println("4 == " + ntn.tribonacci(4));
        System.out.println("1389537 == " + ntn.tribonacci(25));
        System.out.println("2082876103 == " + ntn.tribonacci(37));
        System.out.println("0 == " + ntn.tribonacci(0));
        System.out.println("1 == " + ntn.tribonacci(1));
        System.out.println("1 == " + ntn.tribonacci(2));
        System.out.println("35890 == " + ntn.tribonacci(19));
    }

    public void countFertilePyramidsInALand() {
        CountFertilePyramidsInALand cfpial = new CountFertilePyramidsInALand();

        System.out.println("2 == " + cfpial.countPyramids(new int[][]{{0,1,1,0}, {1,1,1,1}}));
        System.out.println("2 == " + cfpial.countPyramids(new int[][]{{1,1,1}, {1,1,1}}));
        System.out.println("13 == " + cfpial.countPyramids(new int[][]{{1,1,1,1,0}, {1,1,1,1,1},{1,1,1,1,1},{0,1,0,0,1}}));
        System.out.println("6 == " + cfpial.countPyramids(new int[][]{{0,0,1,0,0}, {0,1,1,1,0},{1,1,1,1,1}}));
        System.out.println("12 == " + cfpial.countPyramids(new int[][]{{0,0,0,1,0,0,0}, {0,0,1,1,1,0,0},{0,1,1,1,1,0,0},{1,1,1,1,1,1,1}}));
    }

    public void minimumFallingPathSumII() {
        MinimumFallingPathSumII mfpsii = new MinimumFallingPathSumII();

        System.out.println("13 == " + mfpsii.minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println("7 == " + mfpsii.minFallingPathSum(new int[][]{{7}}));
    }

    public void largest1BorderedSquare() {
        Largest1BorderedSquare l1bs = new Largest1BorderedSquare();

        System.out.println("1 == " + l1bs.largest1BorderedSquare(new int[][]{{1,1,0,0}}));
        System.out.println("9 == " + l1bs.largest1BorderedSquare(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
        System.out.println("4 == " + l1bs.largest1BorderedSquare(new int[][]{{1,0,0,1,1,1},{1,1,0,0,1,1},{1,1,0,0,1,1},{1,1,1,1,1,0},{1,1,1,1,1,0}}));
        System.out.println("1 == " + l1bs.largest1BorderedSquare(new int[][]{{1}}));
        System.out.println("0 == " + l1bs.largest1BorderedSquare(new int[][]{{0}}));
        System.out.println("1 == " + l1bs.largest1BorderedSquare(new int[][]{{0},{1},{1}}));
    }

    public void minimumNumberOfOperationsToMakeArrayXOREqualToK() {
        MinimumNumberOfOperationsToMakeArrayXOREqualToK mnootmaxetk = new MinimumNumberOfOperationsToMakeArrayXOREqualToK();

        System.out.println("2 == " + mnootmaxetk.minOperations(new int[]{2,1,3,4}, 1));
        System.out.println("0 == " + mnootmaxetk.minOperations(new int[]{2,0,2,0}, 0));
    }
}
