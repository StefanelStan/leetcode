package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.april.AccountBalanceAfterRoundedPurchase;
import com.ss.leetcode.LC2024.april.GroupsOfStrings;
import com.ss.leetcode.LC2024.april.MaximalRectangle;
import com.ss.leetcode.LC2024.april.MaximumMatchingOfPlayersWithTrainers;
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
        start.maximalRectangle();
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
}
