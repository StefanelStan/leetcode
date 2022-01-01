package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.january.LongPressedName;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

        start.longPressedName();
    }

    public void longPressedName() {
        LongPressedName lpn = new LongPressedName();

        System.out.println("true == " + lpn.isLongPressedName("alex", "aaleex"));
        System.out.println("false == " + lpn.isLongPressedName("alex", "talex"));
        System.out.println("false == " + lpn.isLongPressedName("alex", "aalxee"));
        System.out.println("false == " + lpn.isLongPressedName("alex", "aaleexe"));
        System.out.println("false == " + lpn.isLongPressedName("alex", "aalaeexe"));
        System.out.println("true == " + lpn.isLongPressedName("alex", "aalleexxxxxx"));
        System.out.println("true == " + lpn.isLongPressedName("a", "aa"));
        System.out.println("true == " + lpn.isLongPressedName("ab", "abb"));
        System.out.println("true == " + lpn.isLongPressedName("abc", "aabbcc"));
        System.out.println("false == " + lpn.isLongPressedName("ab", "aa"));
    }
}
