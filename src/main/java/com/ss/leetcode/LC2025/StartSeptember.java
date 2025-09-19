package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.september.DesignSpreadsheet;
import com.ss.leetcode.LC2025.september.DesignTaskManager;
import com.ss.leetcode.LC2025.september.FindClosestPerson;
import com.ss.leetcode.LC2025.september.FindMostFrequentVowelAndConsonant;
import java.util.List;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.findClosestPerson();
//        start.findMostFrequentVowelAndConsonant();
//        start.designTaskManager();
        start.designSpreadsheet();
    }

    public void findClosestPerson() {
        FindClosestPerson fcp = new FindClosestPerson();

        System.out.println("1 == " + fcp.findClosest(2,7,4));
        System.out.println("2 == " + fcp.findClosest(2,5,6));
        System.out.println("0 == " + fcp.findClosest(1,5,3));
    }

    public void findMostFrequentVowelAndConsonant() {
        FindMostFrequentVowelAndConsonant fmfvac = new FindMostFrequentVowelAndConsonant();

        System.out.println("6 == " + fmfvac.maxFreqSum("successes"));
        System.out.println("3 == " + fmfvac.maxFreqSum("aeiaeia"));
        System.out.println("4 == " + fmfvac.maxFreqSum("aaaa"));
        System.out.println("4 == " + fmfvac.maxFreqSum("aaaai"));
        System.out.println("12 == " + fmfvac.maxFreqSum("asdadaoidsjdasdjwsoicfnsdlcvsadkc"));
        System.out.println("7 == " + fmfvac.maxFreqSum("aeioubbbffffpppppvvvvvv"));
    }

    public void designTaskManager() {
        DesignTaskManager dtm = new DesignTaskManager(List.of(List.of(1, 101, 10), List.of(2, 102, 20), List.of(3, 103, 15)));

        dtm.add(4, 104, 5);
        dtm.edit(102, 8);
        System.out.println("3 == " + dtm.execTop());
        dtm.rmv(101);
        dtm.add(5, 105, 15);
        System.out.println("5 == " + dtm.execTop());
    }

    public void designSpreadsheet() {
        DesignSpreadsheet ds = new DesignSpreadsheet(3);

        System.out.println("12 == " + ds.getValue("=5+7"));
        ds.setCell("A1", 10);
        System.out.println("16 == " + ds.getValue("=A1+6"));
        ds.setCell("B2", 15);
        System.out.println("25 == " + ds.getValue("=A1+B2"));
        ds.resetCell("A1");
        System.out.println("15 == " + ds.getValue("=A1+B2"));
    }
}
