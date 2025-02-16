package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.february.EncryptAndDecryptStrings;
import com.ss.leetcode.LC2025.february.MinimumOperationsToExceedThresholdValueII;
import com.ss.leetcode.LC2025.february.SpecialArrayI;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.specialArrayI();
//        start.encryptAndDecryptStrings();
        start.minimumOperationsToExceedThresholdValueII();
    }

    public void specialArrayI() {
        SpecialArrayI sai = new SpecialArrayI();

        System.out.println("true == " + sai.isArraySpecial(new int[]{1}));
        System.out.println("true == " + sai.isArraySpecial(new int[]{2,1,4}));
        System.out.println("false == " + sai.isArraySpecial(new int[]{4,3,1,6}));
    }

    public void encryptAndDecryptStrings() {
        EncryptAndDecryptStrings eads = new EncryptAndDecryptStrings(new char[]{'a', 'b', 'c', 'd'},
            new String[]{"ei", "zf", "ei", "am"}, new String[]{"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"});

        System.out.println("eizfeiam == " + eads.encrypt("abcd"));
        System.out.println("2 == " + eads.decrypt("eizfeiam"));
    }

    public void minimumOperationsToExceedThresholdValueII() {
        MinimumOperationsToExceedThresholdValueII motetvii = new MinimumOperationsToExceedThresholdValueII();

        System.out.println("2 == " + motetvii.minOperations(new int[]{2,11,10,1,3}, 10));
        System.out.println("4 == " + motetvii.minOperations(new int[]{1,1,2,4,9}, 20));
    }
}
