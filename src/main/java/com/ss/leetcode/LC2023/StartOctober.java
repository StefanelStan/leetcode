package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.october.AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

        start.alertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod();
    }

    public void alertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod() {
        AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod auskctomtiaohp = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod();

        System.out.println("[daniel] == " + auskctomtiaohp.alertNames(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"}, new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));
        System.out.println("[bob] == " + auskctomtiaohp.alertNames(new String[]{"alice","alice","alice","bob","bob","bob","bob"}, new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}));
    }
}
