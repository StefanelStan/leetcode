package com.ss.leetcode.LC2023.october;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    // https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
    /** Algorithm
        1. Create a Map<String, List<String>> to map the access time of each employee
        2. Traverse keyName,keyTime and add each access log to the correct entry on the map
        3. Traverse the map and for each entry (keyName), IF the list of keyTimes contains illegal access, add it to answerList
        4. Determining the illegal access:
            - Sort the accessList
            - For each i (0, n-3). Check the time frame between accessList[i] & accessList[i+2] is <= 60.
            - If the user has 3 accesses in less than or equal to 60 minutes, return true and add it to answer list.
        5. Sort answerList and return it.
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> accessLog = getAccessLog(keyName, keyTime);
        List<String> answer = new ArrayList<>();
        accessLog.forEach((k, v) -> {
            if (hasMoreThanThreeAccesses(v)) {
                answer.add(k);
            }
        });
        Collections.sort(answer);
        return answer;
    }

    private Map<String, List<String>> getAccessLog(String[] keyName, String[] keyTime) {
        Map<String, List<String>> accessLog =  new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            accessLog.computeIfAbsent(keyName[i], v -> new ArrayList<>()).add(keyTime[i]);
        }
        return accessLog;
    }

    private boolean hasMoreThanThreeAccesses(List<String> accessLog) {
        Collections.sort(accessLog);
        for (int i = 0; i < accessLog.size() - 2; i++) {
            if (getTime(accessLog.get(i + 2)) - getTime(accessLog.get(i)) <= 60) {
                return true;
            }
        }
        return false;
    }

    private int getTime(String time) {
        return 60 * ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) +
            ((time.charAt(3) - 'a') * 10 + (time.charAt(4) - '0'));
    }
}
