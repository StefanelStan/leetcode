package com.ss.leetcode;

import com.ss.leetcode.october.ReversePrefixOfWord;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start =  new StartOctober();

        start.reversePrefixOfWord();
    }

    public void reversePrefixOfWord() {
        ReversePrefixOfWord rpow = new ReversePrefixOfWord();

        System.out.println("dcbaefd == " + rpow.reversePrefix("abcdefd", 'd'));
        System.out.println("zxyxxe == " + rpow.reversePrefix("xyxzxe", 'z'));
        System.out.println("abcd == " + rpow.reversePrefix("abcd", 'z'));
    }
}
