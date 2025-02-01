package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.february.SpecialArrayI;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

        start.specialArrayI();
    }

    public void specialArrayI() {
        SpecialArrayI sai = new SpecialArrayI();

        System.out.println("true == " + sai.isArraySpecial(new int[]{1}));
        System.out.println("true == " + sai.isArraySpecial(new int[]{2,1,4}));
        System.out.println("false == " + sai.isArraySpecial(new int[]{4,3,1,6}));
    }
}
