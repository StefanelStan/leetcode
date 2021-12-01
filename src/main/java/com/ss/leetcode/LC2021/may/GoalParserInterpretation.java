package com.ss.leetcode.LC2021.may;

public class GoalParserInterpretation {
    // https://leetcode.com/problems/goal-parser-interpretation/
    public String interpret(String command) {
        StringBuilder stb = new StringBuilder();
        int index = 0;
        while (index < command.length()) {
            if (command.charAt(index) == 'G') {
                stb.append('G');
                index++;
            } else if (command.charAt(index + 1) == 'a') {
                stb.append("al");
                index += 4;
            } else {
                stb.append("o");
                index += 2;
            }
        }

        return stb.toString();
    }
}
