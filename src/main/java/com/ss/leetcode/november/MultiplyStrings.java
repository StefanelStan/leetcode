package com.ss.leetcode.november;

public class MultiplyStrings {
    // https://leetcode.com/problems/multiply-strings/
    public String multiply(String num1, String num2) {
        String first = num1.length() < num2.length() ? num1 : num2;
        String second = first == num1 ? num2 : num1;
        int[][] mulMat = new int[second.length()][first.length() + second.length()];
        parseAndAdd(first, second, mulMat);
        return getResult(mulMat);
    }

    private void parseAndAdd(String first, String second, int[][] mulMat) {
        int carryOver, tmp;
        for (int f = first.length() -1, index = 0; f >= 0; f--, index++) {
            int matStartPos = mulMat[0].length -1 - (first.length() -1 - f);
            carryOver = 0;
            for (int s = second.length() -1; s >= 0; s--) {
                tmp = Character.getNumericValue(first.charAt(f)) * Character.getNumericValue(second.charAt(s));
                tmp += carryOver;
                mulMat[first.length() -1 - f][matStartPos] = tmp % 10;
                carryOver = tmp / 10;
                matStartPos--;
            }
            if (carryOver > 0) {
                mulMat[first.length() -1 - f][matStartPos] = carryOver;
            }
        }
    }

    private String getResult(int[][] mulMat) {
        StringBuilder stb = new StringBuilder();
        int carryOver = 0, colSum;
        for (int j = mulMat[0].length -1; j >= 0; j--) {
            colSum = 0;
            for (int i = 0; i < mulMat.length; i++) {
                colSum += mulMat[i][j];
            }
            colSum += carryOver;
            stb.append(colSum % 10);
            carryOver = colSum / 10;
        }

        if (carryOver > 0) {
            stb.append(carryOver);
        }
        int firstZero = 0;
        for (int i = stb.length() -1; i >= 0; i--) {
            if (stb.charAt(i) != '0') {
                firstZero = i;
                break;
            }
        }
        stb.delete(firstZero +1, stb.length());
        return stb.reverse().toString();
    }
}
