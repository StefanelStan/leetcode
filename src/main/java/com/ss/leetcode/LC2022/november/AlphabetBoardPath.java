package com.ss.leetcode.LC2022.november;

public class AlphabetBoardPath {
    // https://leetcode.com/problems/alphabet-board-path/
    private int[][] letterCoords;
    public String alphabetBoardPath(String target) {
        setLetterCoords();
        StringBuilder stb = new StringBuilder();
        char currentChar = 'a';
        for (int i = 0; i < target.length(); i++) {
            appendPathToLetter(currentChar, target.charAt(i), stb);
            currentChar = target.charAt(i);
        }
        return stb.toString();
    }

    private void appendPathToLetter(char currentChar, char targetChar, StringBuilder stb) {
        if (currentChar == targetChar) {
            appendChar(stb, '!', 1);
        } else if (targetChar == 'z') {
            if (currentChar != 'u') {
                appendPathToLetter(currentChar, 'u', stb);
                stb.setLength(stb.length() - 1);
            }
            appendChar(stb, 'D', 1);
            appendChar(stb, '!', 1);
        } else {
            appendVerticalDirection(currentChar, targetChar, stb);
            appendHorizontalDirection(currentChar, targetChar, stb);
            appendChar(stb, '!', 1);
        }
    }

    private void appendChar(StringBuilder stb, char c, int times) {
        while(times-- > 0) {
            stb.append(c);
        }
    }

    private void appendVerticalDirection(char currentChar, char targetChar, StringBuilder stb) {
        appendChar(stb, currentChar < targetChar ? 'D' : 'U',
            Math.abs(letterCoords[0][currentChar - 'a'] - letterCoords[0][targetChar - 'a']));
    }

    private void appendHorizontalDirection(char currentChar, char targetChar, StringBuilder stb) {
        appendChar(stb, letterCoords[1][currentChar - 'a'] < letterCoords[1][targetChar - 'a'] ? 'R' : 'L',
            Math.abs(letterCoords[1][currentChar - 'a'] - letterCoords[1][targetChar - 'a']));
    }

    private void setLetterCoords() {
        if (letterCoords == null) {
            letterCoords = new int[2][26];
            int i, j;
            for (int charIndex = 0; charIndex < 26; charIndex++) {
                i = charIndex / 5;
                j = charIndex % 5;
                letterCoords[0][charIndex] = i;
                letterCoords[1][charIndex] = j;
            }
        }
    }
}
