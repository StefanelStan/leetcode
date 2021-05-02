package com.ss.leetcode;

import com.ss.leetcode.may.HowManyNumbersAreSmaller;
import com.ss.leetcode.may.JewelsAndStones;
import com.ss.leetcode.may.ParkingSystem;
import com.ss.leetcode.may.PartitioningIntoMinimumNumber;

import java.util.Arrays;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();
//        start.partitionIntoMinNumber();
//        start.jewelsAndStones();
//        start.designParkingSystem();
        start.howManyNumbersAreSmaller();
    }

    public void partitionIntoMinNumber() {
        PartitioningIntoMinimumNumber pimnodbn = new PartitioningIntoMinimumNumber();

        System.out.println("3 == " + pimnodbn.minPartitions("32"));
        System.out.println("8 == " + pimnodbn.minPartitions("82734"));
        System.out.println("9 == " + pimnodbn.minPartitions("27346209830709182346"));
    }

    public void jewelsAndStones() {
        JewelsAndStones jas = new JewelsAndStones();

        System.out.println("3 == " + jas.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println("0 == " + jas.numJewelsInStones("z", "ZZ"));
    }

    public void designParkingSystem() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println("true == " + parkingSystem.addCar(1)); // return true becausebecause there is 1 available slot for a big car
        System.out.println("true == " + parkingSystem.addCar(2)); // return true because there is 1 available slot for a big car
        System.out.println("false == " + parkingSystem.addCar(3)); // return true because there is 1 available slot for a big car
        System.out.println("false == " + parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
    }

    public void howManyNumbersAreSmaller() {
        HowManyNumbersAreSmaller hmnas = new HowManyNumbersAreSmaller();
        int[] nums1 = {6,5,4,8};
        int[] nums2 = {7,7,7,7};

        System.out.println("[2,1,0,3] == " + Arrays.toString(hmnas.smallerNumbersThanCurrent(nums1)));
        System.out.println("[0,0,0,0] == " + Arrays.toString(hmnas.smallerNumbersThanCurrent(nums2)));
    }


}
