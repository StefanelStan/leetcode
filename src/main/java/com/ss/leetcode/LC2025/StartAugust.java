package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.august.FruitsIntoBasketsII;
import com.ss.leetcode.LC2025.august.MaximumAreaOfLongestDiagonalRectangle;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.fruitsIntoBasketsII();
        start.maximumAreaOfLongestDiagonalRectangle();
    }

    public void fruitsIntoBasketsII() {
        FruitsIntoBasketsII fibii = new FruitsIntoBasketsII();

        System.out.println("1 == " + fibii.numOfUnplacedFruits(new int[]{4,2,5}, new int[]{3,5,4}));
        System.out.println("0 == " + fibii.numOfUnplacedFruits(new int[]{3,6,1}, new int[]{6,4,7}));
        System.out.println("0 == " + fibii.numOfUnplacedFruits(new int[]{4,3,2}, new int[]{3,3,5}));
    }

    public void maximumAreaOfLongestDiagonalRectangle() {
        MaximumAreaOfLongestDiagonalRectangle maoldr = new MaximumAreaOfLongestDiagonalRectangle();

        System.out.println("48 == " + maoldr.areaOfMaxDiagonal(new int[][]{{9,3},{8,6}}));
        System.out.println("12 == " + maoldr.areaOfMaxDiagonal(new int[][]{{4,3},{4,3}}));
        System.out.println("18 == " + maoldr.areaOfMaxDiagonal(new int[][]{{2,7},{4,2},{7,2},{5,5},{2,9},{3,3},{6,1},{3,3},{5,5},{2,6},{3,5},{5,1}}));
    }

}
