package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.november.LargestPositiveIntegerThatExistsWithItsNegative;
import com.ss.leetcode.LC2022.november.LongestPalindromeByConcatenatingTwoLetterWords;
import com.ss.leetcode.LC2022.november.MinimumGeneticMutation;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.largestPositiveIntegerThatExistsWithItsNegative();
//        start.minimumGeneticMutation();
        start.longestPalindromeByConcatenatingTwoLetterWords();
    }

    public void largestPositiveIntegerThatExistsWithItsNegative() {
        LargestPositiveIntegerThatExistsWithItsNegative lpitewin = new LargestPositiveIntegerThatExistsWithItsNegative();

        System.out.println("3 == " + lpitewin.findMaxK(new int[]{-1,2,-3,3}));
        System.out.println("7 == " + lpitewin.findMaxK(new int[]{-1,10,6,7,-7,1}));
        System.out.println("-1 == " + lpitewin.findMaxK(new int[]{-10,8,6,7,-2,-3}));
    }

    public void minimumGeneticMutation() {
        MinimumGeneticMutation mgm = new MinimumGeneticMutation();

        System.out.println("1 == " + mgm.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println("2 == " + mgm.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        System.out.println("3 == " + mgm.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
        System.out.println("-1 == " + mgm.minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"}));
        System.out.println("4 == " + mgm.minMutation("AAAACCCC", "CCCCCCCC", new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"}));
    }

    public void longestPalindromeByConcatenatingTwoLetterWords() {
        LongestPalindromeByConcatenatingTwoLetterWords lpbctlw = new LongestPalindromeByConcatenatingTwoLetterWords();

        System.out.println("6 == " + lpbctlw.longestPalindrome(new String[]{"lc","cl","gg"}));
        System.out.println("8 == " + lpbctlw.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
        System.out.println("2 == " + lpbctlw.longestPalindrome(new String[]{"cc","ll","xx"}));
        System.out.println("0 == " + lpbctlw.longestPalindrome(new String[]{"cu","lz","xa"}));
        System.out.println("22 == " + lpbctlw.longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"}));
    }
}
