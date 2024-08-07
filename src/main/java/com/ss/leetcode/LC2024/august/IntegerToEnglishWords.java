package com.ss.leetcode.LC2024.august;

public class IntegerToEnglishWords {
    // https://leetcode.com/problems/integer-to-english-words
    private static final String[] units = {"Billion", "Million", "Thousand", ""};
    private static final int[][] unitIndices = {{-12,-10},{-9,-7},{-6,-4},{-3, -1}};
    private static final String[] toTen = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] toTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num < 10) {
            return toTen[num];
        }
        String numStr = String.valueOf(num);
        StringBuilder stb = new StringBuilder();
        String formatted;
        for (int i = 0; i < units.length; i++) {
            formatted = toWord(numStr, numStr.length() + unitIndices[i][0], numStr.length() + unitIndices[i][1], units[i]);
            if (!formatted.isEmpty()) {
                stb.append(formatted).append(' ');
            }
        }
        stb.setLength(stb.length() - 1);
        return stb.toString();
    }

    private String toWord(String num, int left, int right, String unit) {
        if (right < 0) {
            return "";
        }
        num = num.substring(Math.max(0,left), ++right);
        int value = Integer.parseInt(num);
        StringBuilder stb = new StringBuilder();
        // hundreds
        stb.append(processHundreds(value));
        String tenUnits = processTenUnits(value % 100);
        if (!stb.isEmpty() && !tenUnits.isEmpty()) {
            stb.append(' ');
        }
        stb.append(tenUnits);
        if (!stb.isEmpty() && !unit.isEmpty()) {
            stb.append(' ').append(unit);
        }
        return stb.toString();
    }

    private String processHundreds(int value) {
        int div = value / 100;
        StringBuilder stb = new StringBuilder();
        if (div > 0) {
            stb.append(toTen[div]).append(' ').append("Hundred");
        }
        return stb.toString();
    }

    private String processTenUnits(int value) {
        if (value == 0) {
            return "";
        }
        if (value < 10) {
            return toTen[value];
        } else if (value < 20) {
            return toTwenty[value - 10];
        }
        int dividedByTen = value / 10;
        int modTen = value % 10;
        StringBuilder stb = new StringBuilder();
        stb.append(tens[dividedByTen]);
        if (modTen > 0) {
            stb.append(' ').append(toTen[modTen]);
        }
        return stb.toString();
    }
}
