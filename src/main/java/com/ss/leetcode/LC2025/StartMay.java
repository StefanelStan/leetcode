package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.may.TotalCharactersInStringAfterTransformationsI;
import com.ss.leetcode.LC2025.may.TotalCharactersInStringAfterTransformationsII;
import java.util.List;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.totalCharactersInStringAfterTransformationsI();
        start.totalCharactersInStringAfterTransformationsII();
    }

    public void totalCharactersInStringAfterTransformationsI() {
        TotalCharactersInStringAfterTransformationsI tcisati = new TotalCharactersInStringAfterTransformationsI();

        System.out.println("7 == " + tcisati.lengthAfterTransformations("abcyy", 2));
        System.out.println("5 == " + tcisati.lengthAfterTransformations("azbk", 1));
        System.out.println("16 == " + tcisati.lengthAfterTransformations("z", 100));
        System.out.println("652815408 == " + tcisati.lengthAfterTransformations("hrzmawnweztcskakojfahyvnoctsctwsbagyqmmoheldlpzctduxmhfcwqcbvovoyswjtdzvsheoofocknqddfsjwxfuuhvznxry", 1000));
        System.out.println("79033769 == " + tcisati.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
    }

    public void totalCharactersInStringAfterTransformationsII() {
        TotalCharactersInStringAfterTransformationsII tcisatii = new TotalCharactersInStringAfterTransformationsII();

        System.out.println("7 == " + tcisatii.lengthAfterTransformations("abcyy", 2, List.of(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2)));
        System.out.println("8 == " + tcisatii.lengthAfterTransformations("azbk", 1, List.of(2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2)));
    }
}
