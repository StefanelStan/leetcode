package com.ss.leetcode.LC2022.november;

public class ConvertTheTemperature {
    // https://leetcode.com/problems/convert-the-temperature/
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32};
    }
}
