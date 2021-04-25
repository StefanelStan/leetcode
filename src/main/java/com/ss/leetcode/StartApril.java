package com.ss.leetcode;

import com.ss.leetcode.april.BattleshipsInABoard;
import com.ss.leetcode.april.BulbSwitcherIV;
import com.ss.leetcode.april.DisplayTableOfFoodOrdersInARestaurant;
import com.ss.leetcode.april.LuckyNumbersInAMatrix;
import com.ss.leetcode.april.MaximumIceCreamBars;
import com.ss.leetcode.april.NumberOfGoodPairs;
import com.ss.leetcode.april.QueensThatCanAttackTheKing;
import com.ss.leetcode.april.QueriesPointsInsideCircle;
import com.ss.leetcode.april.RemoveAllAdjacentDuplicatesInString;
import com.ss.leetcode.april.ReverseString;
import com.ss.leetcode.april.ShuffleTheArray;
import com.ss.leetcode.april.SortArrayByParityII;
import com.ss.leetcode.april.SortIntegersByThePowerValue;

import java.util.Arrays;
import java.util.List;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();
//        start.bulbSwitcherIV();
//        start.sortArrayByParityII();
//        start.reverseString();
//        start.battleshipsInABoard();
//        start.removeAllAdjacentDuplicatesInString();
//        start.luckyNumbersInAMatrix();
//        start.queensThatCanAttackTheKing();
//        start.sortIntegersByThePowerValue();
//        start.displayTableOfFoodOrdersInARestaurant();
//        start.maximumIceCreamBars();
//        start.shuffleTheArray();
//        start.numberOfGoodPairs();
        start.queriesOnNumberOfPointsInsideACircle();
    }

    private void bulbSwitcherIV() {
        BulbSwitcherIV bsiv = new BulbSwitcherIV();
        String target1 = "10111";
        String target2 = "101";
        String target3 = "00000";
        String target4 = "001011101";

        System.out.println("3 == " + bsiv.minFlips(target1));
        System.out.println("3 == " + bsiv.minFlips(target2));
        System.out.println("0 == " + bsiv.minFlips(target3));
        System.out.println("5 == " + bsiv.minFlips(target4));
    }

    private void sortArrayByParityII() {
        SortArrayByParityII sabp2 = new SortArrayByParityII();
        int[] nums1 = {4,2,5,7};
        int[] nums2 = {2,3};

        System.out.println("[4,5,2,7] == " + Arrays.toString(sabp2.sortArrayByParityII(nums1)));
        System.out.println("[2, 3] == " + Arrays.toString(sabp2.sortArrayByParityII(nums2)));
    }

    private void reverseString() {
        ReverseString rs = new ReverseString();
        char[] input1 = {'h','e','l','l','o'};
        char[] input2 = {'H','a','n','n','a','h'};

        rs.reverseString(input1);
        rs.reverseString(input2);
        System.out.println("[o l l e h] == " + Arrays.toString(input1));
        System.out.println("[h a n n a H] == " + Arrays.toString(input2));
    }

    private void battleshipsInABoard() {
        BattleshipsInABoard biab = new BattleshipsInABoard();
        char[][] board1 = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        char[][] board2 = {{'X', '.', '.', 'X'}, {'.', 'X', '.', 'X'}, {'.', 'X', '.', 'X'}};

        System.out.println("2 == " + biab.countBattleships(board1));
        System.out.println("3 == " + biab.countBattleships(board2));
    }

    private void removeAllAdjacentDuplicatesInString() {
        RemoveAllAdjacentDuplicatesInString raadis = new RemoveAllAdjacentDuplicatesInString();
//        System.out.println("ca == " + raadis.removeDuplicates("abbaca"));
//        System.out.println(" == " + raadis.removeDuplicates("aaaaaaaa"));
        System.out.println("a == " + raadis.removeDuplicates("aaaaaaaaa"));
    }

    public void luckyNumbersInAMatrix() {
        LuckyNumbersInAMatrix lniam = new LuckyNumbersInAMatrix();
        int[][] matrix1 = {{3,7,8}, {9,11,13}, {15,16,17}};
        int[][] matrix2 = {{1,10,4,2}, {9,3,8,7}, {15,16,17,12}};
        int[][] matrix3 = {{7,8}, {1,2}};

        System.out.println("[15] == " + lniam.luckyNumbers(matrix1));
        System.out.println("[12] == " + lniam.luckyNumbers(matrix2));
        System.out.println("[7] == " + lniam.luckyNumbers(matrix3));
    }

    public void queensThatCanAttackTheKing() {
        QueensThatCanAttackTheKing qtcatk = new QueensThatCanAttackTheKing();
        int[][] queens1 = {{0,1}, {1,0}, {4,0}, {0,4}, {3,3}, {2,4}};
        int[][] queens2 = {{0,0}, {1,1}, {2,2}, {3,4}, {3,5}, {4,4}, {4,5}};
        int[] king1 = {0,0};
        int[] king2 = {3,3};

        System.out.println("[[0,1],[1,0],[3,3]] == " + qtcatk.queensAttacktheKing(queens1, king1));
        System.out.println("[[2,2],[3,4],[4,4]] == " + qtcatk.queensAttacktheKing(queens2, king2));
    }

    public void sortIntegersByThePowerValue() {
        SortIntegersByThePowerValue sibtpv = new SortIntegersByThePowerValue();

        System.out.println("13 == " + sibtpv.getKth(12, 15, 2));
        System.out.println("1 == " + sibtpv.getKth(1, 1, 1));
        System.out.println("7 == " + sibtpv.getKth(7, 11, 4));
        System.out.println("18 == " + sibtpv.getKth(2, 61, 41));
    }

    public void displayTableOfFoodOrdersInARestaurant() {
        DisplayTableOfFoodOrdersInARestaurant dtofoiar = new DisplayTableOfFoodOrdersInARestaurant();
        var orders1 = List.of (List.of("David","3","Ceviche"),
                List.of("Corina","10","Beef Burrito"),
                List.of("David","3","Fried Chicken"),
                List.of("Carla","5","Water"),
                List.of("Carla","5","Ceviche"),
                List.of("Rous","3","Ceviche")
        );
        var orders2 = List.of (List.of("James","12","Fried Chicken"),
                List.of("Ratesh","12","Fried Chicken"),
                List.of("Amadeus","12","Fried Chicken"),
                List.of("Adam","1","Canadian Waffles"),
                List.of("Brianna","1","Canadian Waffles")
        );
        var orders3 = List.of (List.of("Laura","2","Bean Burrito"),
                List.of("Jhon","2","Beef Burrito"),
                List.of("Melissa","2","Soda")
        );

        var output1 = List.of( List.of("Table","Beef Burrito","Ceviche","Fried Chicken","Water"),
                List.of("3","0","2","1","0"),
                List.of("5","0","1","0","1"),
                List.of("10","1","0","0","0")
        );
        var output2 = List.of(List.of("Table","Canadian Waffles","Fried Chicken"),
                List.of("1","2","0"),
                List.of("12","0","3")
        );
        var output3 = List.of(List.of("Table","Bean Burrito","Beef Burrito","Soda"),
                List.of("2","1","1","1")
        );

        System.out.println(output1 + " == " + dtofoiar.displayTable(orders1));
        System.out.println(output2 + " == " + dtofoiar.displayTable(orders2));
        System.out.println(output3 + " == " + dtofoiar.displayTable(orders3));
    }

    public void maximumIceCreamBars() {
        MaximumIceCreamBars micb = new MaximumIceCreamBars();
        int[] costs1 = {1,3,2,4,1};
        int[] costs2 = {10,6,8,7,7,8};
        int[] costs3 = {1,6,3,1,2,5};

        System.out.println("4 == " + micb.maxIceCream(costs1, 7));
        System.out.println("0 == " + micb.maxIceCream(costs2, 5));
        System.out.println("6 == " + micb.maxIceCream(costs3, 20));

    }

    public void shuffleTheArray() {
        ShuffleTheArray sta = new ShuffleTheArray();
        int[] nums1 = {2,5,1,3,4,7};
        int[] nums2 = {1,2,3,4,4,3,2,1};
        int[] nums3 = {1,1,2,2};

        System.out.println("[2,3,5,4,1,7] == " + Arrays.toString(sta.shuffle(nums1, 3)));
        System.out.println("[1,4,2,3,3,2,4,1] == " + Arrays.toString(sta.shuffle(nums2, 4)));
        System.out.println("[1,2,1,2] == " + Arrays.toString(sta.shuffle(nums3, 2)));
    }

    public void numberOfGoodPairs() {
        NumberOfGoodPairs nogp = new NumberOfGoodPairs();
        int[] nums1 = {1,2,3,1,1,3};
        int[] nums2 = {1,1,1,1};
        int[] nums3 = {1,2,3};
        int[] nums4 = {2,2,1,5,1,5,5,2,3,1,1,5,3,2,3,3,3,1,3,3,4,3,1,3,1,4,5,5,2,2,1,3,5,2,2,4,3,2,5,3,1,1,3,3,2,5,2,
                1,2,4,3,4,4,3,2,4,4,1,3,3,3,5,5,5,4,1,1,2,3,3,2,5,3,4,5,3,1,2,5,4,5,2,3,3,1,5,2,4,2,4,4,3,1,3};

        System.out.println("4 == " + nogp.numIdenticalPairs(nums1));
        System.out.println("6 == " + nogp.numIdenticalPairs(nums2));
        System.out.println("0 == " + nogp.numIdenticalPairs(nums3));
        System.out.println("885 == " + nogp.numIdenticalPairs(nums4));

    }

    public void queriesOnNumberOfPointsInsideACircle() {
        QueriesPointsInsideCircle qpic = new QueriesPointsInsideCircle();
        int[][] points1 =  {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries1 =  {{2,3,1},{4,3,1},{1,1,2}};
        int[][] points2 =  {{1,1},{2,2},{3,3},{4,4},{5,5}};
        int[][] queries2 =  {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};

        System.out.println("[3,2,2] == " + Arrays.toString(qpic.countPoints(points1, queries1)));
        System.out.println("[2,3,2,4] == " + Arrays.toString(qpic.countPoints(points2, queries2)));
    }
}
