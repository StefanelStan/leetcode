package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.january.FindTheTownJudge;
import com.ss.leetcode.LC2022.january.LongPressedName;
import com.ss.leetcode.LC2022.january.RemoveOneElementArrayStrictlyIncreasing;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

//        start.longPressedName();
        start.findTheTownJudge();
//        start.removeOneElementArrayStrictlyIncreasing();
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

    public void findTheTownJudge() {
        FindTheTownJudge ftj = new FindTheTownJudge();

        System.out.println("2 == " + ftj.findJudge(2, new int[][]{{1,2}}));
        System.out.println("3 == " + ftj.findJudge(3, new int[][]{{1,3},{2,3}}));
        System.out.println("-1 == " + ftj.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
    }

    public void removeOneElementArrayStrictlyIncreasing() {
        RemoveOneElementArrayStrictlyIncreasing roeasi = new RemoveOneElementArrayStrictlyIncreasing();

        System.out.println("true == " + roeasi.canBeIncreasing(new int[]{1,2,10,5,7}));
        System.out.println("false == " + roeasi.canBeIncreasing(new int[]{2,3,1,2}));
        System.out.println("false == " + roeasi.canBeIncreasing(new int[]{1,1,1}));
        System.out.println("true == " + roeasi.canBeIncreasing(new int[]{1,1}));
        System.out.println("false == " + roeasi.canBeIncreasing(new int[]{1,2,2,1}));
        System.out.println("true == " + roeasi.canBeIncreasing(new int[]{2,4,9,10,12,15,16,17,20,22,24,28,30,32,34,36,37,39,41,42,44,45,47,49,50,51,56,57,59,60,61,62,64,65,68,70,76,77,84,86,87,89,90,92,96,101,102,105,108,111,114,115,118,119,123,126,130,132,133,134,137,149,150,152,154,156,165,167,168,169,170,175,178,181,186,188,189,190,193,200,202,203,204,205,206,208,209,214,215,216,217,220,224,226,230,231,234,236,237,238,239,240,241,245,247,249,250,253,258,260,262,266,267,270,272,273,274,275,283,284,290,291,294,296,300,301,302,303,304,305,307,309,310,312,314,315,317,318,319,322,324,325,326,333,335,337,340,341,343,344,347,348,349,350,351,352,353,364,365,369,370,373,375,378,380,381,382,388,389,394,401,402,405,406,407,414,417,418,420,424,428,431,434,435,437,440,443,448,453,454,455,457,461,464,468,469,470,473,481,483,486,488,490,492,497,500,501,502,503,504,507,510,513,514,517,518,519,521,524,525,526,527,528,529,535,537,538,539,540,541,551,553,555,557,558,562,564,565,566,568,569,571,573,577,578,588,590,592,595,596,597,598,601,602,603,604,605,608,609,612,615,619,620,621,622,623,624,627,629,630,633,634,635,637,638,639,641,645,646,650,651,655,656,657,658,659,660,661,662,663,670,674,675,677,680,681,684,687,688,692,697,701,702,707,708,713,717,718,719,721,723,724,725,726,728,729,733,734,736,739,740,741,744,747,749,756,757,766,768,769,771,773,774,776,781,784,786,787,788,792,793,796,797,800,801,802,805,807,808,810,815,816,819,826,830,831,833,834,837,840,842,843,844,845,847,849,854,862,864,868,871,873,875,878,881,882,883,888,890,895,896,901,902,903,904,906,909,911,912,913,918,920,921,923,927,929,932,941,942,943,944,945,832,946,947,949,952,958,960,966,967,968,969,970,974,978,980,981,982,985,990,992,994,996,998,999,1000}));
    }
}
