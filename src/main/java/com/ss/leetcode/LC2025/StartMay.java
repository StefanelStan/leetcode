package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.may.TotalCharactersInStringAfterTransformationsI;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

        start.totalCharactersInStringAfterTransformationsI();
    }

    public void totalCharactersInStringAfterTransformationsI() {
        TotalCharactersInStringAfterTransformationsI tcisati = new TotalCharactersInStringAfterTransformationsI();

        System.out.println("7 == " + tcisati.lengthAfterTransformations("abcyy", 2));
        System.out.println("5 == " + tcisati.lengthAfterTransformations("azbk", 1));
        System.out.println("16 == " + tcisati.lengthAfterTransformations("z", 100));
        System.out.println("652815408 == " + tcisati.lengthAfterTransformations("hrzmawnweztcskakojfahyvnoctsctwsbagyqmmoheldlpzctduxmhfcwqcbvovoyswjtdzvsheoofocknqddfsjwxfuuhvznxry", 1000));
        System.out.println("79033769 == " + tcisati.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
    }
}
