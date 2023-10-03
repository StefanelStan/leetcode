package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.october.AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod;
import com.ss.leetcode.LC2023.october.CountCollisionsOnARoad;
import com.ss.leetcode.LC2023.october.CountGoodNumbers;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

//        start.alertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod();
//        start.countGoodNumbers();
        start.countCollisionsOnARoad();
    }

    public void alertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod() {
        AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod auskctomtiaohp = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod();

        System.out.println("[daniel] == " + auskctomtiaohp.alertNames(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"}, new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));
        System.out.println("[bob] == " + auskctomtiaohp.alertNames(new String[]{"alice","alice","alice","bob","bob","bob","bob"}, new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}));
    }

    public void countGoodNumbers() {
        CountGoodNumbers cgn = new CountGoodNumbers();

        System.out.println("5 == " + cgn.countGoodNumbers(1));
        System.out.println("400 == " + cgn.countGoodNumbers(4));
        System.out.println("8000 == " + cgn.countGoodNumbers(6));
        System.out.println("564908303 == " + cgn.countGoodNumbers(50));
    }

    public void countCollisionsOnARoad() {
        CountCollisionsOnARoad ccoar = new CountCollisionsOnARoad();

        System.out.println("5 == " + ccoar.countCollisions("RLRSLL"));
        System.out.println("0 == " + ccoar.countCollisions("LLRR"));
        System.out.println("63 == " + ccoar.countCollisions("RLRLRLLRRLLRRLLRLRLRLLLSLSLLRLRLRSSSLSLSLSLLRLRLRLSLSLSLRRRRRLRLLLRLRLRLRL"));
        System.out.println("12 == " + ccoar.countCollisions("RRRRRSLLLLLLL"));
        System.out.println("11 == " + ccoar.countCollisions("LLLLLLLLLLLRRRRRLLLLLLS"));
        System.out.println("26 == " + ccoar.countCollisions("SLLLLLLLLRRRRRRRLLLLLLLSSSSSSLLLL"));
        System.out.println("0 == " + ccoar.countCollisions("S"));
        System.out.println("0 == " + ccoar.countCollisions("R"));
        System.out.println("0 == " + ccoar.countCollisions("L"));
        System.out.println("0 == " + ccoar.countCollisions("LLLLSSSSS"));
    }
}
