package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.december.OddEvenLinkedList;
import com.ss.leetcode.LC2021.december.WateringPlants;
import com.ss.leetcode.shared.ListNode;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.wateringPlants();
        start.oddEvenLinkedList();
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
}
