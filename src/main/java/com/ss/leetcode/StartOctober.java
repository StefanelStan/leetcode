package com.ss.leetcode;

import com.ss.leetcode.october.AddDigits;
import com.ss.leetcode.october.Convert1DArrayInto2DArray;
import com.ss.leetcode.october.MaximumNumberOfWaysToPartitionAnArray;
import com.ss.leetcode.october.NumberOfPairsConcatenationTarget;
import com.ss.leetcode.october.ReversePrefixOfWord;

import java.util.Arrays;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start =  new StartOctober();

//        start.reversePrefixOfWord();
//        start.addDigits();
//        start.convert1DArrayInto2DArray();
//        start.numberOfPairsConcatenationTarget();
        start.maximumNumberOfWaysToPartitionAnArray();
    }

    public void reversePrefixOfWord() {
        ReversePrefixOfWord rpow = new ReversePrefixOfWord();

        System.out.println("dcbaefd == " + rpow.reversePrefix("abcdefd", 'd'));
        System.out.println("zxyxxe == " + rpow.reversePrefix("xyxzxe", 'z'));
        System.out.println("abcd == " + rpow.reversePrefix("abcd", 'z'));
    }

    public void addDigits() {
        AddDigits ad = new AddDigits();

        System.out.println("2 == " + ad.addDigits(38));
        System.out.println("0 == " + ad.addDigits(0));
        System.out.println("3 == " + ad.addDigits(453));
    }

    public void convert1DArrayInto2DArray() {
        Convert1DArrayInto2DArray c1dai2da = new Convert1DArrayInto2DArray();

        System.out.println("[[1,2],[3,4]] == " + Arrays.deepToString(c1dai2da.construct2DArray(new int[]{1,2,3,4}, 2,2)));
        System.out.println("[[1,2,3]] == " + Arrays.deepToString(c1dai2da.construct2DArray(new int[]{1,2,3}, 1,3)));
        System.out.println("[[]] == " + Arrays.deepToString(c1dai2da.construct2DArray(new int[]{1,2}, 1,1)));
    }

    public void numberOfPairsConcatenationTarget() {
        NumberOfPairsConcatenationTarget nopct = new NumberOfPairsConcatenationTarget();

        System.out.println("4 == " + nopct.numOfPairs(new String[]{"777","7","77","77"}, "7777"));
        System.out.println("2 == " + nopct.numOfPairs(new String[]{"123","4","12","34"}, "1234"));
        System.out.println("6 == " + nopct.numOfPairs(new String[]{"1","1","1"}, "11"));
    }

    public void maximumNumberOfWaysToPartitionAnArray() {
        MaximumNumberOfWaysToPartitionAnArray mnowtpaa = new MaximumNumberOfWaysToPartitionAnArray();

        System.out.println("1 == " + mnowtpaa.waysToPartition(new int[]{2,-1,2}, 3));
        System.out.println("2 == " + mnowtpaa.waysToPartition(new int[]{0,0,0}, 1));
        System.out.println("4 == " + mnowtpaa.waysToPartition(new int[]{22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14}, -33));
        System.out.println("4 == " + mnowtpaa.waysToPartition(new int[]{22,4,-33,-20,-15,15,-16,7,19,-10,0,-13,-14}, -33));
    }
    // 5873. Maximize the Confusion of an Exam

}
