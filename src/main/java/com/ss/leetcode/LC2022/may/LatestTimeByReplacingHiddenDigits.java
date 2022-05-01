package com.ss.leetcode.LC2022.may;

public class LatestTimeByReplacingHiddenDigits {
    // https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
    public String maximumTime(String time) {
        String[] chunks = time.split(":");
        StringBuilder stb = new StringBuilder();
        stb.append(formatHour(chunks[0].toCharArray()));
        stb.append(':');
        stb.append(formatMinute(chunks[1].toCharArray()));
        return stb.toString();
    }

    private String formatHour(char[] hour) {
        if (hour[0] != '?' && hour[1] != '?') {
            return new String(hour);
        }
        StringBuilder stb = new StringBuilder();
        if (hour[0] == '?') {
            if (hour[1] == '?') {
                stb.append("23");
            } else if (hour[1] > '3') {
                stb.append("1").append(hour[1]);
            } else {
                stb.append('2').append(hour[1]);
            }
        } else {
            stb.append(hour[0]);
            stb.append(hour[0] > '1' ? '3' : '9');
        }
        return stb.toString();
    }

    private String formatMinute(char[] minute) {
        if (minute[0] != '?' && minute[1] != '?') {
            return new String(minute);
        }
        StringBuilder stb = new StringBuilder();
        if (minute[0] == '?') {
            if (minute[1] == '?') {
                stb.append("59");
            } else {
                stb.append('5').append(minute[1]);
            }
        } else {
            stb.append(minute[0]);
            stb.append('9');
        }
        return stb.toString();
    }
}
