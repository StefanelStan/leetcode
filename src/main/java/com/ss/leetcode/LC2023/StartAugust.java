package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.august.AllOOneDataStructure;
import com.ss.leetcode.LC2023.august.CheckIfThereIsAValidPartitionForTheArray;
import com.ss.leetcode.LC2023.august.CountBinarySubstrings;
import com.ss.leetcode.LC2023.august.FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree;
import com.ss.leetcode.LC2023.august.FindTheMaximumDivisibilityScore;
import com.ss.leetcode.LC2023.august.FrogJump;
import com.ss.leetcode.LC2023.august.HIndex;
import com.ss.leetcode.LC2023.august.InterleavingString;
import com.ss.leetcode.LC2023.august.MaximizeNumberOfSubsequencesInAString;
import com.ss.leetcode.LC2023.august.MaximumLengthOfPairChain;
import com.ss.leetcode.LC2023.august.MinimizeTheMaximumDifferenceOfPairs;
import com.ss.leetcode.LC2023.august.MinimumNumberOfTapsToOpenToWaterAGarden;
import com.ss.leetcode.LC2023.august.MinimumPenaltyForAShop;
import com.ss.leetcode.LC2023.august.MinimumReplacementsToSortTheArray;
import com.ss.leetcode.LC2023.august.PlatesBetweenCandles;
import com.ss.leetcode.LC2023.august.RepeatedDNASequences;
import com.ss.leetcode.LC2023.august.ShiftingLettersII;
import com.ss.leetcode.LC2023.august.TextJustification;
import com.ss.leetcode.LC2023.august.WalkingRobotSimulationII;
import com.ss.leetcode.LC2023.august.WordBreak;
import java.util.Arrays;
import java.util.List;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.repeatedDNASequences();
//        start.findTheMaximumDivisibilityScore();
//        start.wordBreak();
//        start.walkingRobotSimulationII();
//        start.minimizeTheMaximumDifferenceOfPairs();
//        start.checkIfThereIsAValidPartitionForTheArray();
//        start.platesBetweenCandles();
//        start.allOOneDataStructure();
//        start.findCriticalAndPseudoCriticalEdgesInMinimumSpanningTree();
//        start.countBinarySubstrings();
//        start.hIndex();
//        start.maximizeNumberOfSubsequencesInAString();
//        start.textJustification();
//        start.shiftingLettersII();
//        start.interleavingString();
//        start.maximumLengthOfPairChain();
//        start.frogJump();
//        start.minimumPenaltyForAShop();
//        start.minimumReplacementsToSortTheArray();
        start.minimumNumberOfTapsToOpenToWaterAGarden();
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

    public void walkingRobotSimulationII() {
        WalkingRobotSimulationII wrsii = new WalkingRobotSimulationII(6,3);
        wrsii.step(2);
        wrsii.step(2);
        System.out.println("[4,0] == " + Arrays.toString(wrsii.getPos()));
        System.out.println("East == " + wrsii.getDir());
        wrsii.step(1);
        wrsii.step(4);
        System.out.println("[1,2] == " + Arrays.toString(wrsii.getPos()));
        System.out.println("West == " + wrsii.getDir());

        wrsii = new WalkingRobotSimulationII(6,3);
        wrsii.step(14);
        System.out.println("South == " + wrsii.getDir());
        wrsii.step(5);
        System.out.println("East == " + wrsii.getDir());
        wrsii.step(1);
        System.out.println("North == " + wrsii.getDir());
        wrsii.step(15);
        System.out.println("North == " + wrsii.getDir());
        wrsii.step(33);
        System.out.println("West == " + wrsii.getDir());
        System.out.println("[0,2] == " + Arrays.toString(wrsii.getPos()));

        wrsii = new WalkingRobotSimulationII(2,2);
        wrsii.step(14);
        System.out.println("North == " + wrsii.getDir());
        wrsii.step(5);
        System.out.println("West == " + wrsii.getDir());
        wrsii.step(1);
        System.out.println("South == " + wrsii.getDir());
        wrsii.step(17);
        System.out.println("East == " + wrsii.getDir());
        wrsii.step(2);
        System.out.println("West == " + wrsii.getDir());
        wrsii.step(12);
        System.out.println("West == " + wrsii.getDir());
        System.out.println("[0,1] == " + Arrays.toString(wrsii.getPos()));

    }

    public void minimizeTheMaximumDifferenceOfPairs() {
        MinimizeTheMaximumDifferenceOfPairs mtmdop = new MinimizeTheMaximumDifferenceOfPairs();

        System.out.println("1 == " + mtmdop.minimizeMax(new int[]{10,1,2,7,1,3}, 2));
        System.out.println("0 == " + mtmdop.minimizeMax(new int[]{4,2,1,2}, 1));
    }

    public void checkIfThereIsAValidPartitionForTheArray() {
        CheckIfThereIsAValidPartitionForTheArray citiavpfta = new CheckIfThereIsAValidPartitionForTheArray();

        System.out.println("true == " + citiavpfta.validPartition(new int[]{4,4,4,5,6}));
        System.out.println("false == " + citiavpfta.validPartition(new int[]{1,1,1,2}));
    }

    public void platesBetweenCandles() {
        PlatesBetweenCandles pbc = new PlatesBetweenCandles();

        System.out.println("[2,3] == " + Arrays.toString(pbc.platesBetweenCandles("**|**|***|", new int[][]{{2,5},{5,9}})));
        System.out.println("9,0,0,0,0] == " + Arrays.toString(pbc.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}})));
    }

    public void allOOneDataStructure() {
        AllOOneDataStructure aoods = new AllOOneDataStructure();

        aoods.inc("hello");
        aoods.inc("hello");
        System.out.println("hello == " + aoods.getMaxKey());
        System.out.println("hello == " + aoods.getMinKey());
        aoods.inc("leet");
        System.out.println("hello == " + aoods.getMaxKey());
        System.out.println("leet == " + aoods.getMinKey());
    }

    public void findCriticalAndPseudoCriticalEdgesInMinimumSpanningTree() {
        FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree fcapceimst = new FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree();

        System.out.println("[[0,1],[2,3,4,5]] == " + fcapceimst.findCriticalAndPseudoCriticalEdges(5, new int[][]{{0,1,1},{1,2,1},{2,3,2},{0,3,2},
            {0,4,3},{3,4,3},{1,4,6}}));

        System.out.println("[[],[0,1,2,3]] == " + fcapceimst.findCriticalAndPseudoCriticalEdges(4, new int[][]{{0,1,1},{1,2,1},{2,3,1},{0,3,1}}));
    }

    public void countBinarySubstrings() {
        CountBinarySubstrings cbs = new CountBinarySubstrings();

        System.out.println("6 == " + cbs.countBinarySubstrings("00110011"));
        System.out.println("4 == " + cbs.countBinarySubstrings("10101"));
    }

    public void hIndex() {
        HIndex hi = new HIndex();

        System.out.println("3 == " + hi.hIndex(new int[]{3,0,6,1,5}));
        System.out.println("1 == " + hi.hIndex(new int[]{1,3,1}));
    }

    public void maximizeNumberOfSubsequencesInAString() {
        MaximizeNumberOfSubsequencesInAString mnosias = new MaximizeNumberOfSubsequencesInAString();

        System.out.println("4 == " + mnosias.maximumSubsequenceCount("abdcdbc", "ac"));
        System.out.println("6 == " + mnosias.maximumSubsequenceCount("aabb", "ab"));
        System.out.println("171 == " + mnosias.maximumSubsequenceCount("aaaaaaaaaaaaaaaaaa", "aa"));
        System.out.println("3 == " + mnosias.maximumSubsequenceCount("aa", "aa"));
    }

    public void textJustification() {
        TextJustification tj = new TextJustification();

        System.out.println("[This    is    an,example  of text,justification.  ] == " + tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println("[What   must   be,acknowledgment  ,shall be        ] == " + tj.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println("[Science  is  what we,understand      well,enough to explain to,a  computer.  Art is,everything  else  we,do                  ] == "
            + tj.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }

    public void shiftingLettersII() {
        ShiftingLettersII slii = new ShiftingLettersII();

        System.out.println("ace == " + slii.shiftingLetters("abc", new int[][]{{0,1,0},{1,2,1},{0,2,1}}));
        System.out.println("catz == " + slii.shiftingLetters("dztz", new int[][]{{0,0,0},{1,1,1}}));
    }

    public void interleavingString() {
        InterleavingString is = new InterleavingString();

        System.out.println("true == " + is.isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println("false == " + is.isInterleave("aabcc","dbbca","aadbbbaccc"));
        System.out.println("true == " + is.isInterleave("","",""));
        System.out.println("true == " + is.isInterleave("","b","b"));
        System.out.println("false == " + is.isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb",
            "babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
            "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"));
    }

    public void maximumLengthOfPairChain() {
        MaximumLengthOfPairChain mlopc = new MaximumLengthOfPairChain();

        System.out.println("2 == " + mlopc.findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println("3 == " + mlopc.findLongestChain(new int[][]{{1,2},{7,8},{4,5}}));
    }

    public void frogJump() {
        FrogJump fj = new FrogJump();

        System.out.println("true == " + fj.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println("false == " + fj.canCross(new int[]{0,1,2,3,4,8,9,11}));
        System.out.println("false == " + fj.canCross(new int[]{0,1,2,5,6,9,10,12,13,14,17,19,20,21,26,27,28,29,30}));
        System.out.println("true == " + fj.canCross(new int[]{0,1,2,3,4,5,6,7,8,9,12}));
        System.out.println("true == " + fj.canCross(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,514,515,516,517,518,519,520,521,522,523,524,525,526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,554,555,556,557,558,559,560,561,562,563,564,565,566,567,568,569,570,571,572,573,574,575,576,577,578,579,580,581,582,583,584,585,586,587,588,589,590,591,592,593,594,595,596,597,598,599,600,601,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,644,645,646,647,648,649,650,651,652,653,654,655,656,657,658,659,660,661,662,663,664,665,666,667,668,669,670,671,672,673,674,675,676,677,678,679,680,681,682,683,684,685,686,687,688,689,690,691,692,693,694,695,696,697,698,699,700,701,702,703,704,705,706,707,708,709,710,711,712,713,714,715,716,717,718,719,720,721,722,723,724,725,726,727,728,729,730,731,732,733,734,735,736,737,738,739,740,741,742,743,744,745,746,747,748,749,750,751,752,753,754,755,756,757,758,759,760,761,762,763,764,765,766,767,768,769,770,771,772,773,774,775,776,777,778,779,780,781,782,783,784,785,786,787,788,789,790,791,792,793,794,795,796,797,798,799,800,801,802,803,804,805,806,807,808,809,810,811,812,813,814,815,816,817,818,819,820,821,822,823,824,825,826,827,828,829,830,831,832,833,834,835,836,837,838,839,840,841,842,843,844,845,846,847,848,849,850,851,852,853,854,855,856,857,858,859,860,861,862,863,864,865,866,867,868,869,870,871,872,873,874,875,876,877,878,879,880,881,882,883,884,885,886,887,888,889,890,891,892,893,894,895,896,897,898,899,900,901,902,903,904,905,906,907,908,909,910,911,912,913,914,915,916,917,918,919,920,921,922,923,924,925,926,927,928,929,930,931,932,933,934,935,936,937,938,939,940,941,942,943,944,945,946,947,948,949,950,951,952,953,954,955,956,957,958,959,960,961,962,963,964,965,966,967,968,969,970,971,972,973,974,975,976,977,978,979,980,981,982,983,984,985,986,987,988,989,990,991,992,993,994,995,996,997,998,1035}));
    }

    public void minimumPenaltyForAShop() {
        MinimumPenaltyForAShop mpfas = new MinimumPenaltyForAShop();

        System.out.println("2 == " + mpfas.bestClosingTime("YYNY"));
        System.out.println("0 == " + mpfas.bestClosingTime("NNNNN"));
        System.out.println("4 == " + mpfas.bestClosingTime("YYYY"));
        System.out.println("0 == " + mpfas.bestClosingTime("NY"));
        System.out.println("12 == " + mpfas.bestClosingTime("YYNYNYYNYNYYNNYNYNYNNYNY"));
        System.out.println("5 == " + mpfas.bestClosingTime("YYYYYNN"));
        System.out.println("1 == " + mpfas.bestClosingTime("YN"));
    }

    public void minimumReplacementsToSortTheArray() {
        MinimumReplacementsToSortTheArray mrtsta = new MinimumReplacementsToSortTheArray();

        System.out.println("2 == " + mrtsta.minimumReplacement(new int[]{3,9,3}));
        System.out.println("0 == " + mrtsta.minimumReplacement(new int[]{1,2,3,4,5}));
    }

    public void minimumNumberOfTapsToOpenToWaterAGarden() {
        MinimumNumberOfTapsToOpenToWaterAGarden mnottotwag = new MinimumNumberOfTapsToOpenToWaterAGarden();

        System.out.println("1 == " + mnottotwag.minTaps(5, new int[]{3,4,1,1,0,0}));
        System.out.println("-1 == " + mnottotwag.minTaps(3, new int[]{0,0,0,0}));
        System.out.println("8 == " + mnottotwag.minTaps(28, new int[]{1,2,1,2,1,1,2,2,1,2,1,2,1,2,3,2,3,2,2,2,1,2,1,2,1,2,0,1,0}));
        System.out.println("1 == " + mnottotwag.minTaps(8, new int[]{4,0,0,0,4,0,0,0,4}));
    }
}
