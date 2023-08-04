package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.august.FindTheMaximumDivisibilityScore;
import com.ss.leetcode.LC2023.august.RepeatedDNASequences;
import com.ss.leetcode.LC2023.august.WordBreak;
import java.util.List;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.repeatedDNASequences();
//        start.findTheMaximumDivisibilityScore();
        start.wordBreak();
    }

    public void repeatedDNASequences() {
        RepeatedDNASequences rdnas = new RepeatedDNASequences();

        System.out.println("[AAAAACCCCC,CCCCCAAAAA] == " + rdnas.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println("[AAAAAAAAAA] == " + rdnas.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    public void findTheMaximumDivisibilityScore() {
        FindTheMaximumDivisibilityScore ftmds = new FindTheMaximumDivisibilityScore();

        System.out.println("3 == " + ftmds.maxDivScore(new int[]{4,7,9,3,9}, new int[]{5,2,3}));
        System.out.println("5 == " + ftmds.maxDivScore(new int[]{20,14,21,10}, new int[]{5,7,5}));
        System.out.println("10 == " + ftmds.maxDivScore(new int[]{12}, new int[]{10,16}));
        System.out.println("9 == " + ftmds.maxDivScore(new int[]{69,3,92,14,67,90,31,40,54,63,99,88,28,100,5,72,89,60,90,71}, new int[]{97,16,7,60,6,57,73,84,17,8,77,60,7,74,74,24,52,43,94,48,9,99}));
    }

    public void wordBreak() {
        WordBreak wb = new WordBreak();

        System.out.println("true == " + wb.wordBreak("leetcode", List.of("leet","code")));
        System.out.println("true == " + wb.wordBreak("applepenapple", List.of("apple","pen")));
        System.out.println("false == " + wb.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }
}
