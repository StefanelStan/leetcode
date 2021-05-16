package com.ss.leetcode;

import com.ss.leetcode.may.CheckIfTheSentenceIsPangram;
import com.ss.leetcode.may.CountItemsMatchingARule;
import com.ss.leetcode.may.CreateTargetArrayInTheGivenOrder;
import com.ss.leetcode.may.DecompressRunLengthEncodedList;
import com.ss.leetcode.may.GoalParserInterpretation;
import com.ss.leetcode.may.HowManyNumbersAreSmaller;
import com.ss.leetcode.may.JewelsAndStones;
import com.ss.leetcode.may.NumberOfStepsToReduceANumberToZero;
import com.ss.leetcode.may.ParkingSystem;
import com.ss.leetcode.may.PartitioningIntoMinimumNumber;
import com.ss.leetcode.may.ShuffleString;
import com.ss.leetcode.may.SubtractProductAndSumDigits;

import java.util.Arrays;
import java.util.List;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();
//        start.partitionIntoMinNumber();
//        start.jewelsAndStones();
//        start.designParkingSystem();
//        start.howManyNumbersAreSmaller();
//        start.subtractProductAndSumDigits();
//        start.numberOfStepsToReduceANumberToZero();
//        start.shuffleString();
//        start.decompressRunLengthEncodedList();
//        start.createTargetArrayInTheGivenOrder();
//        start.goalParserInterpretation();
//        start.countItemsMatchingARule();
        start.checkIfTheSentenceIsPangram();
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

    public void subtractProductAndSumDigits() {
        SubtractProductAndSumDigits spasd = new SubtractProductAndSumDigits();

        System.out.println("15 == " + spasd.subtractProductAndSum(234));
        System.out.println("21 == " + spasd.subtractProductAndSum(4421));
    }

    public void numberOfStepsToReduceANumberToZero() {
        NumberOfStepsToReduceANumberToZero nostrantz =  new NumberOfStepsToReduceANumberToZero();

        System.out.println("6 == " + nostrantz.numberOfSteps(14));
        System.out.println("4 == " + nostrantz.numberOfSteps(8));
        System.out.println("12 == " + nostrantz.numberOfSteps(123));
    }

    public void shuffleString() {
        ShuffleString ss = new ShuffleString();

        System.out.println("leetcode == "+ ss.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
        System.out.println("abc == "+ ss.restoreString("abc", new int[]{0,1,2}));
    }

    public void decompressRunLengthEncodedList() {
        DecompressRunLengthEncodedList drlel = new DecompressRunLengthEncodedList();

        System.out.println("[2,4,4,4] == " + Arrays.toString(drlel.decompressRLElist(new int[]{1,2,3,4})));
        System.out.println("[1,3,4] == " + Arrays.toString(drlel.decompressRLElist(new int[]{1,1,2,3})));
    }

    public void createTargetArrayInTheGivenOrder() {
        CreateTargetArrayInTheGivenOrder ctaitgo = new CreateTargetArrayInTheGivenOrder();
        int[] nums1 = { 0,1,2,3,4};
        int[] index1 ={0,1,2,2,1};
        int[] nums2 = {1,2,3,4,0};
        int[] index2 = {0,1,2,3,0};
        int[] nums3 = {1};
        int[] index3 = {0};

        System.out.println("[0,4,1,3,2] == " + Arrays.toString(ctaitgo.createTargetArray(nums1, index1)));
        System.out.println("[0,1,2,3,4] == " + Arrays.toString(ctaitgo.createTargetArray(nums2, index2)));
        System.out.println("[1] == " + Arrays.toString(ctaitgo.createTargetArray(nums3, index3)));
    }

    public void goalParserInterpretation() {
        GoalParserInterpretation gpi = new GoalParserInterpretation();
        System.out.println("Goal == " + gpi.interpret("G()(al)"));
        System.out.println("Gooooal == " + gpi.interpret("G()()()()(al)"));
        System.out.println("alGalooG == " + gpi.interpret("(al)G(al)()()G"));
    }

    public void countItemsMatchingARule() {
        CountItemsMatchingARule cimar = new CountItemsMatchingARule();
        var items1 = List.of(List.of("phone","blue","pixel"), List.of("computer","silver","lenovo"), List.of("phone","gold","iphone"));
        var items2 = List.of(List.of("phone","blue","pixel"), List.of("computer","silver","phone"), List.of("phone","gold","iphone"));

        System.out.println("1 == " + cimar.countMatches(items1, "color", "silver"));
        System.out.println("2 == " + cimar.countMatches(items1, "type", "phone"));
    }

    public void checkIfTheSentenceIsPangram() {
        CheckIfTheSentenceIsPangram cisip = new CheckIfTheSentenceIsPangram();
        System.out.println("true == " + cisip.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println("false == " + cisip.checkIfPangram("leetcode"));

        System.out.println("true == " + cisip.checkIfPangram2("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println("false == " + cisip.checkIfPangram2("leetcode"));
    }
}
