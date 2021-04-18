package com.ss.leetcode;

import com.ss.leetcode.april.BattleshipsInABoard;
import com.ss.leetcode.april.BulbSwitcherIV;
import com.ss.leetcode.april.DisplayTableOfFoodOrdersInARestaurant;
import com.ss.leetcode.april.LuckyNumbersInAMatrix;
import com.ss.leetcode.april.QueensThatCanAttackTheKing;
import com.ss.leetcode.april.RemoveAllAdjacentDuplicatesInString;
import com.ss.leetcode.april.ReverseString;
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
        start.displayTableOfFoodOrdersInARestaurant();
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
}
