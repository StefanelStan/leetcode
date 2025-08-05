package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.august.FruitsIntoBasketsII;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

        start.fruitsIntoBasketsII();
    }

    public void fruitsIntoBasketsII() {
        FruitsIntoBasketsII fibii = new FruitsIntoBasketsII();

        System.out.println("1 == " + fibii.numOfUnplacedFruits(new int[]{4,2,5}, new int[]{3,5,4}));
        System.out.println("0 == " + fibii.numOfUnplacedFruits(new int[]{3,6,1}, new int[]{6,4,7}));
        System.out.println("0 == " + fibii.numOfUnplacedFruits(new int[]{4,3,2}, new int[]{3,3,5}));
    }

}
