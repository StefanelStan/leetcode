package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.november.CountAlternatingSubarrays;
import com.ss.leetcode.LC2024.november.KthLargestPerfectSubtreeSizeInBinaryTree;
import com.ss.leetcode.LC2024.november.MinimizeMalwareSpreadII;
import com.ss.leetcode.LC2024.november.PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList;
import com.ss.leetcode.LC2024.november.StringCompressionIII;
import com.ss.leetcode.shared.TreeNode;
import java.util.List;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.countAlternatingSubarrays();
//        start.minimizeMalwareSpreadII();
//        start.kthLargestPerfectSubtreeSizeInBinaryTree();
//        start.stringCompressionIII();
        start.peopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList();
    }

    public void countAlternatingSubarrays() {
        CountAlternatingSubarrays cas = new CountAlternatingSubarrays();

        System.out.println("5 == " + cas.countAlternatingSubarrays(new int[]{0,1,1,1}));
        System.out.println("10 == " + cas.countAlternatingSubarrays(new int[]{1,0,1,0}));
        System.out.println("1 == " + cas.countAlternatingSubarrays(new int[]{1}));
        System.out.println("3 == " + cas.countAlternatingSubarrays(new int[]{0,1}));
        System.out.println("2 == " + cas.countAlternatingSubarrays(new int[]{1,1}));
        System.out.println("5 == " + cas.countAlternatingSubarrays(new int[]{0,0,1,1}));
        System.out.println("129 == " + cas.countAlternatingSubarrays(new int[]{0,1,1,1,1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}));
        System.out.println("71 == " + cas.countAlternatingSubarrays(new int[]{0,0,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,0,1,0,1}));
    }

    public void minimizeMalwareSpreadII() {
        MinimizeMalwareSpreadII mmsii = new MinimizeMalwareSpreadII();

        System.out.println("0 == " + mmsii.minMalwareSpread(new int[][]{{1,1,0}, {1,1,0},{0,0,1}}, new int[]{0,1}));
        System.out.println("1 == " + mmsii.minMalwareSpread(new int[][]{{1,1,0}, {1,1,1},{0,1,1}}, new int[]{0,1}));
        System.out.println("1 == " + mmsii.minMalwareSpread(new int[][]{{1,1,0,0}, {1,1,1,0},{0,1,1,1},{0,0,1,1}}, new int[]{0,1}));
    }

    public void kthLargestPerfectSubtreeSizeInBinaryTree() {
        KthLargestPerfectSubtreeSizeInBinaryTree klpssibt = new KthLargestPerfectSubtreeSizeInBinaryTree();

        TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(5, new TreeNode(1), new TreeNode(8)), new TreeNode(2)),
            new TreeNode(6, new TreeNode(5, new TreeNode(6), new TreeNode(8)), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        TreeNode root3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));

        System.out.println("3 == " + klpssibt.kthLargestPerfectSubtree(root1, 2));
        System.out.println("7 == " + klpssibt.kthLargestPerfectSubtree(root2, 1));
        System.out.println("-1 == " + klpssibt.kthLargestPerfectSubtree(root3, 3));
    }

    public void stringCompressionIII() {
        StringCompressionIII sciii = new StringCompressionIII();

        System.out.println("1a1b1c1d1e == " + sciii.compressedString("abcde"));
        System.out.println("9a5a2b == " + sciii.compressedString("aaaaaaaaaaaaaabb"));
        System.out.println("1a == " + sciii.compressedString("a"));
        System.out.println("9a4a9b6b6a8b == " + sciii.compressedString("aaaaaaaaaaaaabbbbbbbbbbbbbbbaaaaaabbbbbbbb"));
        System.out.println("7b5a1b7a7b9a7a2b5a1b == " + sciii.compressedString("bbbbbbbaaaaabaaaaaaabbbbbbbaaaaaaaaaaaaaaaabbaaaaab"));
        System.out.println("1a1b1c1d1e1f == " + sciii.compressedString("abcdef"));
    }

    public void peopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList() {
        PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList pwlofcinasoal = new PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList();

        System.out.println("[0,1,4] == " + pwlofcinasoal.peopleIndexes(List.of(List.of("leetcode","google","facebook"), List.of("google","microsoft"), List.of("google","facebook"), List.of("google"), List.of("amazon"))));
        System.out.println("[0,1] == " + pwlofcinasoal.peopleIndexes(List.of(List.of("leetcode","google","facebook"), List.of("leetcode","amazon"), List.of("facebook","google"))));
        System.out.println("[0,1,2,3] == " + pwlofcinasoal.peopleIndexes(List.of(List.of("leetcode"), List.of("google"), List.of("facebook"), List.of("amazon"))));
    }
}
