package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.april.MaximumValueOfAnOrderedTripletI;
import com.ss.leetcode.LC2025.april.MaximumValueOfAnOrderedTripletII;
import com.ss.leetcode.LC2025.april.MinimumNumberOfOperationsToMakeElementsInArrayDistinct;
import com.ss.leetcode.LC2025.april.PartitionEqualSubsetSum;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.maximumValueOfAnOrderedTripletI();
//        start.maximumValueOfAnOrderedTripletII();
//        start.partitionEqualSubsetSum();
        start.minimumNumberOfOperationsToMakeElementsInArrayDistinct();
    }

    public void maximumValueOfAnOrderedTripletI() {
        MaximumValueOfAnOrderedTripletI mvoaoti = new MaximumValueOfAnOrderedTripletI();

        System.out.println("77 == " + mvoaoti.maximumTripletValue(new int[]{12,6,1,2,7}));
        System.out.println("133 == " + mvoaoti.maximumTripletValue(new int[]{1,10,3,4,19}));
        System.out.println("0 == " + mvoaoti.maximumTripletValue(new int[]{1,2,3}));
        System.out.println("2345076549 == " + mvoaoti.maximumTripletValue(new int[]{23452, 1,2, 32256, 91345, 99999, 1, 10000}));
    }

    public void maximumValueOfAnOrderedTripletII() {
        MaximumValueOfAnOrderedTripletII mvoaotii = new MaximumValueOfAnOrderedTripletII();

        System.out.println("77 == " + mvoaotii.maximumTripletValue(new int[]{12,6,1,2,7}));
        System.out.println("133 == " + mvoaotii.maximumTripletValue(new int[]{1,10,3,4,19}));
        System.out.println("0 == " + mvoaotii.maximumTripletValue(new int[]{1,2,3}));
        System.out.println("2345076549 == " + mvoaotii.maximumTripletValue(new int[]{23452, 1,2, 32256, 91345, 99999, 1, 10000}));
    }

    public void partitionEqualSubsetSum() {
        PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();

        System.out.println("true == " + pess.canPartition(new int[]{1,5,11,5}));
        System.out.println("false == " + pess.canPartition(new int[]{1,2,3,5}));
        System.out.println("false == " + pess.canPartition(new int[]{4}));
        System.out.println("true == " + pess.canPartition(new int[]{1,2,3,4,5,15}));
        System.out.println("true == " + pess.canPartition(new int[]{1,2,3,6}));
        System.out.println("false == " + pess.canPartition(new int[]{1,1,1}));
        System.out.println("true == " + pess.canPartition(new int[]{1,1,1,1}));
        System.out.println("false == " + pess.canPartition(new int[]{8,1,2,6,2,2}));
    }

    public void minimumNumberOfOperationsToMakeElementsInArrayDistinct() {
        MinimumNumberOfOperationsToMakeElementsInArrayDistinct mnootmeiad = new MinimumNumberOfOperationsToMakeElementsInArrayDistinct();

        System.out.println("2 == " + mnootmeiad.minimumOperations(new int[]{1,2,3,4,2,3,3,5,7}));
        System.out.println("2 == " + mnootmeiad.minimumOperations(new int[]{4,5,6,4,4}));
        System.out.println("0 == " + mnootmeiad.minimumOperations(new int[]{6,7,8,9}));
        System.out.println("1 == " + mnootmeiad.minimumOperations(new int[]{1,2,3,1,2,3,4}));
        System.out.println("5 == " + mnootmeiad.minimumOperations(new int[]{5,6,76,56,34,32,43,64,46,4,23,43,45,6,12,23,24,6,4,3}));
        System.out.println("0 == " + mnootmeiad.minimumOperations(new int[]{5}));
    }
}
