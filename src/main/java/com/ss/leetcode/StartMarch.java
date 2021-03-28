package com.ss.leetcode;

import com.ss.leetcode.march.CellsWithOddValuesInAMatrix;
import com.ss.leetcode.march.ConsecutiveNumbersSum;
import com.ss.leetcode.march.CountNumberOfTeams;
import com.ss.leetcode.march.DefangingAnIPAddress;
import com.ss.leetcode.march.DesignBrowserHistory;
import com.ss.leetcode.march.DesignHashSet;
import com.ss.leetcode.march.DesignUndergroundSystem;
import com.ss.leetcode.march.DestinationCity;
import com.ss.leetcode.march.DiagonalTraverseII;
import com.ss.leetcode.march.EncodeAndDecodeTinyURL;
import com.ss.leetcode.march.EvaluateTheBracketPairsOfAString;
import com.ss.leetcode.march.FindAndReplacePattern;
import com.ss.leetcode.march.FlippingAnImage;
import com.ss.leetcode.march.KidsWithTheGreatestNumberOfCandies;
import com.ss.leetcode.march.MatrixDiagonalSum;
import com.ss.leetcode.march.MaxIncreaseToKeepCitySkyline;
import com.ss.leetcode.march.Maximum69Number;
import com.ss.leetcode.march.MaximumNumberOfCoinsYouCanGet;
import com.ss.leetcode.march.MinimumAddToMakeParenthesesValid;
import com.ss.leetcode.march.MinimumNumberOfStepsAnagram;
import com.ss.leetcode.march.MinimumSubsequenceInNonIncreasingOrder;
import com.ss.leetcode.march.QueriesOnAPermutationWithKey;
import com.ss.leetcode.march.RevealCardsInIncreasingOrder;
import com.ss.leetcode.march.ReversePairs;
import com.ss.leetcode.march.RichestCustomerWealth;
import com.ss.leetcode.march.RunningSumOf1dArray;
import com.ss.leetcode.march.ScoreAfterFlippingMatrix;
import com.ss.leetcode.march.SortArrayByIncreasingFrequency;
import com.ss.leetcode.march.SortTheMatrixDiagonally;
import com.ss.leetcode.march.SplitAStringInBalancedStrings;
import com.ss.leetcode.march.UniqueMorseCodeWords;
import com.ss.leetcode.march.WidestVerticalAreaBetweenTwoPoints;

import java.util.Arrays;
import java.util.List;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();
//        start.defangingAnIPAddress();
//        start.kidsWithTheGreatestNumberOfCandies();
//        start.diagonalTraverseII();
//        start.widestVerticalAreaBetweenTwoPointsContainingNoPoints();
//        start.sortTheMatrixDiagonally();
//        start.splitAStringInBalancedStrings();
//        start.maxIncreaseToKeepCitySkyline();
//        start.uniqueMorseCodeWords();
//        start.queriesOnAPermutationWithKey();
//        start.cellsWithOddValuesInAMatrix();
//        start.encodeAndDecodeTinyURL();
//        start.consecutiveNumbersSum();
//        start.maximumNumberOfCoinsYouCanGet();
//        start.reversePairs();
//        start.countNumberOfTeams();
//        start.designBrowserHistory();
//        start.revealCardsInIncreasingOrder();
//        start.designHashSet();
//        start.flippingAnImage();
//        start.maximum69Number();
//        start.matrixDiagonalSum();
//        start.destinationCity();
//        start.runningSumOf1dArray();
//        start.richestCustomerWealth();
//        start.minimumNumberOfStepsToMakeTwoStringsAnagram();
//        start.minimumAddToMakeParenthesesValid();
//        start.findAndReplacePattern();
//        start.scoreAfterFlippingMatrix();
//        start.designUndergroundSystem();
//        start.minimumSubsequenceInNonIncreasingOrder();
//        start.evaluateTheBracketPairsOfAString();
        start.sortArrayByIncreasingFrequency();
    }

    private void defangingAnIPAddress() {
        DefangingAnIPAddress daip = new DefangingAnIPAddress();
        System.out.println("1[.]1[.]1[.]1 == " + daip.defangIPaddr("1.1.1.1"));
        System.out.println("255[.]100[.]50[.]0 == " + daip.defangIPaddr("255.100.50.0"));
    }

    private void kidsWithTheGreatestNumberOfCandies() {
        KidsWithTheGreatestNumberOfCandies kwtgnoc = new KidsWithTheGreatestNumberOfCandies();
        System.out.println("[true,true,true,false,true] == " + kwtgnoc.kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
        System.out.println("[true,false,false,false,false] == " + kwtgnoc.kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1));
        System.out.println("[true,false,true] == " + kwtgnoc.kidsWithCandies(new int[] { 12, 1, 12 }, 10));

    }

    private void diagonalTraverseII() {
        DiagonalTraverseII dt2 = new DiagonalTraverseII();
        List<List<Integer>> nums1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        List<List<Integer>> nums2 = List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7), List.of(8), List.of(9, 10, 11), List.of(12, 13, 14, 15, 16));
        List<List<Integer>> nums3 = List.of(List.of(1, 2, 3), List.of(4), List.of(5, 6, 7), List.of(8), List.of(9, 10, 11));
        List<List<Integer>> nums4 = List.of(List.of(1, 2, 3, 4, 5, 6));

        System.out.println("[1,4,2,7,5,3,8,6,9] == " + Arrays.toString(dt2.findDiagonalOrder(nums1)));
        System.out.println("[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16] == " + Arrays.toString(dt2.findDiagonalOrder(nums2)));
        System.out.println("[1,4,2,5,3,8,6,9,7,10,11] == " + Arrays.toString(dt2.findDiagonalOrder(nums3)));
        System.out.println("[1,2,3,4,5,6] == " + Arrays.toString(dt2.findDiagonalOrder(nums4)));
    }

    private void widestVerticalAreaBetweenTwoPointsContainingNoPoints() {
        WidestVerticalAreaBetweenTwoPoints wvabtp = new WidestVerticalAreaBetweenTwoPoints();
        int[][] points1 = { { 8, 7 }, { 9, 9 }, { 7, 4 }, { 9, 7 } };
        int[][] points2 = { { 3, 1 }, { 9, 0 }, { 1, 0 }, { 1, 4 }, { 5, 3 }, { 8, 8 } };

        System.out.println("1 == " + wvabtp.maxWidthOfVerticalArea(points1));
        System.out.println("3 == " + wvabtp.maxWidthOfVerticalArea(points2));

    }

    private void sortTheMatrixDiagonally() {
        SortTheMatrixDiagonally stmd = new SortTheMatrixDiagonally();
        int[][] matrix1 = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
        int[][] matrix2 = { { 11, 25, 66, 1, 69, 7 }, { 23, 55, 17, 45, 15, 52 }, { 75, 31, 36, 44, 58, 8 }, { 22, 27, 33, 25, 68, 4 }, { 84, 28, 14, 11, 5, 50 } };

        System.out.println("[[1,1,1,1],[1,2,2,2],[1,2,3,3]] == " + Arrays.deepToString(stmd.diagonalSort(matrix1)));
        System.out.println("[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]] == "
                + Arrays.deepToString(stmd.diagonalSort(matrix2)));
    }

    private void splitAStringInBalancedStrings() {
        SplitAStringInBalancedStrings sasibs = new SplitAStringInBalancedStrings();
        System.out.println("4 == " + sasibs.balancedStringSplit("RLRRLLRLRL"));
        System.out.println("3 == " + sasibs.balancedStringSplit("RLLLLRRRLR"));
        System.out.println("1 == " + sasibs.balancedStringSplit("LLLLRRRR"));
        System.out.println("2 == " + sasibs.balancedStringSplit("RLRRRLLRLL"));
    }

    private void maxIncreaseToKeepCitySkyline() {
        MaxIncreaseToKeepCitySkyline mitkcs = new MaxIncreaseToKeepCitySkyline();
        int[][] grid = { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };
        System.out.println("35 == " + mitkcs.maxIncreaseKeepingSkyline(grid));
    }

    private void uniqueMorseCodeWords() {
        UniqueMorseCodeWords umcw = new UniqueMorseCodeWords();
        String[] words = { "gin", "zen", "gig", "msg" };
        System.out.println("2 == " + umcw.uniqueMorseRepresentations(words));
    }

    private void queriesOnAPermutationWithKey() {
        QueriesOnAPermutationWithKey qoapwk = new QueriesOnAPermutationWithKey();
        int[] query1 = { 3, 1, 2, 1 };
        int[] query2 = { 4, 1, 2, 2 };
        int[] query3 = { 7, 5, 5, 8, 3 };

//        System.out.println("[2,1,2,1] == " + Arrays.toString(qoapwk.processQueries(query1, 5)));
        System.out.println("[3,1,2,0] == " + Arrays.toString(qoapwk.processQueries(query2, 4)));
        System.out.println("[6,5,0,7,5] == " + Arrays.toString(qoapwk.processQueries(query3, 8)));

    }

    private void cellsWithOddValuesInAMatrix() {
        CellsWithOddValuesInAMatrix cwoviam = new CellsWithOddValuesInAMatrix();
        int[][] indices = { { 0, 1 }, { 1, 1 } };
        int[][] indices2 = { { 1, 1 }, { 0, 0 } };

        System.out.println("6 == " + cwoviam.oddCells(2, 3, indices));
        System.out.println("0 == " + cwoviam.oddCells(2, 2, indices2));

    }

    private void encodeAndDecodeTinyURL() {
        EncodeAndDecodeTinyURL eadtu = new EncodeAndDecodeTinyURL();
        String longUrl1 = "https://leetcode.com/problems/design-tinyurl";
        String longUrl2 = "https://leetcode.com/problems/design-tinyurl2";
        String encoded1 = eadtu.encode(longUrl1);
        String encoded2 = eadtu.encode(longUrl2);

        System.out.println("LongUrl1 enc-dec matches == " + longUrl1.equals(eadtu.decode(encoded1)));
        System.out.println("LongUrl2 enc-dec matches == " + longUrl2.equals(eadtu.decode(encoded2)));
    }

    private void consecutiveNumbersSum() {
        // Time Limit Exceeded
        ConsecutiveNumbersSum cns = new ConsecutiveNumbersSum();
        System.out.println("2 == " + cns.consecutiveNumbersSum(5));
        System.out.println("3 == " + cns.consecutiveNumbersSum(9));
        System.out.println("4 == " + cns.consecutiveNumbersSum(15));
        System.out.println("4 == " + cns.consecutiveNumbersSum(77601076));
        System.out.println("6 == " + cns.consecutiveNumbersSum(776021076));
    }

    private void maximumNumberOfCoinsYouCanGet() {
        MaximumNumberOfCoinsYouCanGet mnocycg = new MaximumNumberOfCoinsYouCanGet();
        int[] piles1 = { 2, 4, 1, 2, 7, 8 };
        int[] piles2 = { 2, 4, 5 };
        int[] piles3 = { 9, 8, 7, 6, 5, 1, 2, 3, 4 };

        System.out.println("9 == " + mnocycg.maxCoins(piles1));
        System.out.println("4 == " + mnocycg.maxCoins(piles2));
        System.out.println("18 == " + mnocycg.maxCoins(piles3));

    }

    private void reversePairs() {
        // TLE - Time Limit Exceeded
        ReversePairs rp = new ReversePairs();
        int[] input1 = { 1, 3, 2, 3, 1 };
        int[] input2 = { 2, 4, 3, 5, 1 };
        int[] input3 = { -5, -5 };

        System.out.println("2 == " + rp.reversePairs(input1));
        System.out.println("3 == " + rp.reversePairs(input2));
        System.out.println("1 == " + rp.reversePairs(input3));

    }

    private void countNumberOfTeams() {
        CountNumberOfTeams cnot = new CountNumberOfTeams();
        int[] rating1 = { 2, 5, 3, 4, 1 };
        int[] rating2 = { 2, 1, 3 };
        int[] rating3 = { 1, 2, 3, 4 };

        System.out.println("3 == " + cnot.numTeams(rating1));
        System.out.println("0 == " + cnot.numTeams(rating2));
        System.out.println("4 == " + cnot.numTeams(rating3));
    }

    private void designBrowserHistory() {
        DesignBrowserHistory browserHistory = new DesignBrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println("facebook.com == " + browserHistory.back(1));
        System.out.println("google.com == " + browserHistory.back(1));
        System.out.println("facebook.com == " + browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println("linkedin.com == " + browserHistory.forward(2));
        System.out.println("google.com == " + browserHistory.back(2));
        System.out.println("leetcode.com == " + browserHistory.back(7));
    }

    private void revealCardsInIncreasingOrder() {
        RevealCardsInIncreasingOrder rciio = new RevealCardsInIncreasingOrder();
        int[] input1 = { 17, 13, 11, 2, 3, 5, 7 };
        int[] input2 = { 17, 13, 11, 2, 3, 5, 7, 8 };
        int[] input3 = { 8, 2, 4, 7, 5 };
        int[] input4 = { 2, 3, 7, 5, 4, 6 };
        int[] input5 = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        int[] input6 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

//        System.out.println("[2,13,3,11,5,17,7] == " + Arrays.toString(rciio.deckRevealedIncreasing(input1)));
//        System.out.println("[2,8,3,13,5,11,7,17] == " + Arrays.toString(rciio.deckRevealedIncreasing(input2)));
//        System.out.println("[2,8,4,7,5] == " + Arrays.toString(rciio.deckRevealedIncreasing(input3)));
//        System.out.println("[2,5,3,7,4,6] == " + Arrays.toString(rciio.deckRevealedIncreasing(input4)));
//        System.out.println("[2,13,3,10,4,15,5,11,6,14,7,12,8,16,9] == " + Arrays.toString(rciio.deckRevealedIncreasing(input5)));
        System.out.println("[1,12,2,8,3,11,4,9,5,13,6,10,7] == " + Arrays.toString(rciio.deckRevealedIncreasing(input6)));
    }

    private void designHashSet() {
        DesignHashSet dhs = new DesignHashSet();
        dhs.add(1);      // set = [1]
        dhs.add(2);      // set = [1, 2]
        System.out.println("true == " + dhs.contains(1)); // return True
        System.out.println("false == " + dhs.contains(3)); // return False, (not found)
        dhs.add(2);      // set = [1, 2]
        System.out.println("true == " + dhs.contains(2)); // return True
        dhs.remove(2);   // set = [1]
        System.out.println("false == " + dhs.contains(2)); // return False, (already removed)
    }

    private void flippingAnImage() {
        FlippingAnImage fai = new FlippingAnImage();
        int[][] image1 = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        int[][] image2 = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };

//        System.out.println("[[1,0,0],[0,1,0],[1,1,1]] == " + Arrays.deepToString(fai.flipAndInvertImage(image1)));
        System.out.println("[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] == " + Arrays.deepToString(fai.flipAndInvertImage(image2)));
    }

    private void maximum69Number() {
        Maximum69Number msnn = new Maximum69Number();
        System.out.println("9969 == " + msnn.maximum69Number(9669));
        System.out.println("9999 == " + msnn.maximum69Number(9996));
        System.out.println("9999 == " + msnn.maximum69Number(9999));
    }

    private void matrixDiagonalSum() {
        MatrixDiagonalSum mds = new MatrixDiagonalSum();
        int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix2 = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
        int[][] matrix3 = { { 5 } };

        System.out.println("25 == " + mds.diagonalSum(matrix1));
        System.out.println("8 == " + mds.diagonalSum(matrix2));
        System.out.println("5 == " + mds.diagonalSum(matrix3));
    }

    private void destinationCity() {
        DestinationCity dc = new DestinationCity();
        var paths1 = List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"));
        var paths2 = List.of(List.of("B", "C"), List.of("D", "B"), List.of("C", "A"));
        var paths3 = List.of(List.of("A", "Z"));

        System.out.println("Sao Paulo == " + dc.destCity(paths1));
        System.out.println("A == " + dc.destCity(paths2));
        System.out.println("Z == " + dc.destCity(paths3));
    }

    private void runningSumOf1dArray() {
        RunningSumOf1dArray rsooda = new RunningSumOf1dArray();
        int[] array1 = { 1, 2, 3, 4 };
        int[] array2 = { 1, 1, 1, 1, 1 };
        int[] array3 = { 3, 1, 2, 10, 1 };

        System.out.println("[1,3,6,10] == " + Arrays.toString(rsooda.runningSum(array1)));
        System.out.println("[1,2,3,4,5] == " + Arrays.toString(rsooda.runningSum(array2)));
        System.out.println("[3,4,6,16,17] == " + Arrays.toString(rsooda.runningSum(array3)));
    }

    private void richestCustomerWealth() {
        RichestCustomerWealth rcw = new RichestCustomerWealth();
        int[][] accounts1 = { { 1, 2, 3 }, { 3, 2, 1 } };
        int[][] accounts2 = { { 1, 5 }, { 7, 3 }, { 3, 5 } };
        int[][] accounts3 = { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } };

        System.out.println("6 == " + rcw.maximumWealth(accounts1));
        System.out.println("10 == " + rcw.maximumWealth(accounts2));
        System.out.println("17 == " + rcw.maximumWealth(accounts3));

    }

    private void minimumNumberOfStepsToMakeTwoStringsAnagram() {
        MinimumNumberOfStepsAnagram mnofa = new MinimumNumberOfStepsAnagram();
        System.out.println("1 == " + mnofa.minSteps("bab", "aba"));
        System.out.println("5 == " + mnofa.minSteps("leetcode", "practice"));
        System.out.println("0 == " + mnofa.minSteps("anagram", "mangaar"));
        System.out.println("0 == " + mnofa.minSteps("xxyyzz", "xxyyzz"));
        System.out.println("4 == " + mnofa.minSteps("friend", "family"));
    }

    private void minimumAddToMakeParenthesesValid() {
        MinimumAddToMakeParenthesesValid matmpv = new MinimumAddToMakeParenthesesValid();
        System.out.println("1 == " + matmpv.minAddToMakeValid("())"));
        System.out.println("3 == " + matmpv.minAddToMakeValid("((("));
        System.out.println("0 == " + matmpv.minAddToMakeValid("()"));
        System.out.println("4 == " + matmpv.minAddToMakeValid("()))(("));

    }

    private void findAndReplacePattern() {
        FindAndReplacePattern farp = new FindAndReplacePattern();
        String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };

        System.out.println("[\"mee\", \"aqq\"] == " + farp.findAndReplacePattern(words, "abb"));
    }

    private void scoreAfterFlippingMatrix() {
        ScoreAfterFlippingMatrix scfm = new ScoreAfterFlippingMatrix();
        int[][] matrix1 = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };

        System.out.println("39 == " + scfm.matrixScore(matrix1));
    }

    private void designUndergroundSystem() {
        DesignUndergroundSystem undergroundSystem = new DesignUndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println("14.0 == " + undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println("11.0 == " + undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println("11.0 == " + undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println("12.0 == " + undergroundSystem.getAverageTime("Leyton", "Waterloo"));
    }

    private void minimumSubsequenceInNonIncreasingOrder() {
        MinimumSubsequenceInNonIncreasingOrder msinio = new MinimumSubsequenceInNonIncreasingOrder();
        int[] nums1 = { 4, 3, 10, 9, 8 };
        int[] nums2 = { 4, 4, 7, 6, 7 };
        int[] nums3 = { 6 };

        System.out.println("[10,9] == " + msinio.minSubsequence(nums1));
        System.out.println("[7,7,6] == " + msinio.minSubsequence(nums2));
        System.out.println("[6] == " + msinio.minSubsequence(nums3));
    }

    private void evaluateTheBracketPairsOfAString() {
        EvaluateTheBracketPairsOfAString etbpoas = new EvaluateTheBracketPairsOfAString();
        String s1 = "(name)is(age)yearsold";
        String s2 = "hi(name)";
        String s3 = "(a)(a)(a)aaa";
        var knowledge1 = List.of(List.of("name", "bob"), List.of("age", "two"));
        var knowledge2 = List.of(List.of("a", "b"));
        var knowledge3 = List.of(List.of("a", "yes"));

        System.out.println("bobistwoyearsold == " + etbpoas.evaluate(s1, knowledge1));
        System.out.println("hi? == " + etbpoas.evaluate(s2, knowledge2));
        System.out.println("yesyesyesaaa == " + etbpoas.evaluate(s3, knowledge3));

    }

    private void sortArrayByIncreasingFrequency() {
        SortArrayByIncreasingFrequency sabif = new SortArrayByIncreasingFrequency();
        int[] nums1 = {1,1,2,2,2,3};
        int[] nums2 = {2,3,1,3,2};
        int[] nums3 = {-1,1,-6,4,5,-6,1,4,1};

        System.out.println("[3,1,1,2,2,2] == " + Arrays.toString(sabif.frequencySort(nums1)));
        System.out.println("[1,3,3,2,2] == " + Arrays.toString(sabif.frequencySort(nums2)));
        System.out.println("[5,-1,4,4,-6,-6,1,1,1] == " + Arrays.toString(sabif.frequencySort(nums3)));
    }
}
