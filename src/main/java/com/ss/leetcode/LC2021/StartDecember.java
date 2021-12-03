package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.december.ConstructTheRectangle;
import com.ss.leetcode.LC2021.december.MaximumProductSubarray;
import com.ss.leetcode.LC2021.december.OddEvenLinkedList;
import com.ss.leetcode.LC2021.december.TeemoAttacking;
import com.ss.leetcode.LC2021.december.WateringPlants;
import com.ss.leetcode.shared.ListNode;

import java.util.Arrays;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.wateringPlants();
//        start.oddEvenLinkedList();
//        start.constructTheRectangle();
//        start.teemoAttacking();
        start.maximumProductSubarray();
    }

    public void wateringPlants() {
        WateringPlants wp = new WateringPlants();

        System.out.println("14 == " + wp.wateringPlants(new int[]{2,2,3,3}, 5));
        System.out.println("30 == " + wp.wateringPlants(new int[]{1,1,1,4,2,3}, 4));
        System.out.println("49 == " + wp.wateringPlants(new int[]{7,7,7,7,7,7,7}, 8));
    }

    public void oddEvenLinkedList() {
        OddEvenLinkedList oell = new OddEvenLinkedList();

        System.out.println("[1,3,5,2,4] == " + oell.oddEvenList(ListNode.makeChain(new int[]{1,2,3,4,5})).getAsList());
        System.out.println("[2,3,6,7,1,5,4] == " + oell.oddEvenList(ListNode.makeChain(new int[]{2,1,3,5,6,4,7})).getAsList());
    }

    public void constructTheRectangle() {
        ConstructTheRectangle ctr = new ConstructTheRectangle();

        System.out.println("[2,2] == " + Arrays.toString(ctr.constructRectangle(4)));
        System.out.println("[37,1] == " + Arrays.toString(ctr.constructRectangle(37)));
        System.out.println("[427,286] == " + Arrays.toString(ctr.constructRectangle(122122)));
    }

    public void teemoAttacking() {
        TeemoAttacking ta = new TeemoAttacking();

        System.out.println("4 == " + ta.findPoisonedDuration(new int[]{1,4}, 2));
        System.out.println("3 == " + ta.findPoisonedDuration(new int[]{1,2}, 2));
    }

    public void maximumProductSubarray() {
        MaximumProductSubarray mps = new MaximumProductSubarray();

//        System.out.println("6 == " + mps.maxProduct(new int[]{2,3,-2,4}));
//        System.out.println("0 == " + mps.maxProduct(new int[]{-2,0,-1}));
        System.out.println("0 == " + mps.maxProduct(new int[]{-2,0}));
    }
}
