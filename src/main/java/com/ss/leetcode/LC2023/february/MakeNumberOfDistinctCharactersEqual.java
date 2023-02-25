package com.ss.leetcode.LC2023.february;

public class MakeNumberOfDistinctCharactersEqual {
    // https://leetcode.com/problems/make-number-of-distinct-characters-equal/
    /** Algorithm
        1. Count and store each char of word1, word2 in an int[26] for letters a-z.
            This grouping will say how many distinc chars each string has.
            eg: "abcabc" -> [2,2,2,0,0......] => 3 distinct groups
            "defdg"  ->[0,0,0,2,1,1,1..] => 4 distinch groups
        2. If the diff between the groups is > 2, they cannot be made equal, so return false.
        3. The true difficulty comes when there is a difference of 0,1 and 2 between the two strings
        4. Use a holder class Uniqueness that will compare and store (as flags) seveal info about each string  -count of letters - int[26]
        5. Use two holder classes eg: Uniqueness u1, u2 for each string.
            EG: if one letter is present in one string but not the other, mark this as hasOneUnique flag for string 2.
            - if the same letter is present multiple times in s1 and not in s2, mark hasMoreUnique as true.
        6. These flags will be used to compare various edge cases and possibilities.
        7. Ex: if both strings have same number of unique chars we can make the swaps in next condition:(diff 0)
            - both strings have one common char (eg: "abc" "dbg" each string has 3 unique but one is shared so the shared can be swapped)
            - str1 has one unique char and str2 has one unique char which can be swapped.
            eg: [abc , def] -> any letter can be swapped
            - str2 has more unique chars and str1 has more unique chars.
        8. Apply combined logic for edge cases of diff 1 and diff2
             diff1 :EG: str1 has 3 distinct and str2 has 4. You need to eithert make str1 have 4 or make str2 to have 3
            diff2: str1 has 3 and str2 has 5. The only case is when you make str1 to have 4 and str2 to have 4.
     */
    public boolean isItPossible(String word1, String word2) {
        Uniqueness u1 = getUniqueness(word1);
        Uniqueness u2 = getUniqueness(word2);
        Uniqueness[] uniqueness = populateUniqueness(u1, u2);
        switch(uniqueness[1].size - uniqueness[0].size) {
            case 0 : return assertZeroDifference(uniqueness[0], uniqueness[1]);
            case 1: return assertOneDifference(uniqueness[0], uniqueness[1]);
            case 2: return assertTwoDifference(uniqueness[0], uniqueness[1]);
            default: return false;
        }
    }

    private Uniqueness getUniqueness(String word) {
        int[] count = new int[26];
        int size = 0;
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            count[ch - 'a']++;
            if (count[ch - 'a'] == 1) {
                size++;
            }
        }
        return new Uniqueness(count, size);
    }

    private Uniqueness[] populateUniqueness(Uniqueness u1, Uniqueness u2) {
        for (int i = 0; i < 26; i++) {
            if (u1.count[i] > 0 && u2.count[i] > 0) {
                u1.hasSharedCharacter = u2.hasSharedCharacter = true;
            }
            if (u1.count[i] == 1 && u2.count[i] == 0) {
                u1.hasOneUnique = true;
            }
            if (u1.count[i] > 1 && u2.count[i] == 0) {
                u1.hasMoreUniques = true;
            }
            if (u2.count[i] == 1 && u1.count[i] == 0) {
                u2.hasOneUnique = true;
            }
            if (u2.count[i] > 1 && u1.count[i] == 0) {
                u2.hasMoreUniques = true;
            }
            if (u1.count[i] > 1 && u2.count[i] > 0) {
                u1.hasMoreSharedCharacters = true;
            }
            if (u2.count[i] > 1 && u1.count[i] > 0) {
                u2.hasMoreSharedCharacters = true;
            }
            if (u1.count[i] == 1 && u2.count[i] > 0) {
                u1.hasOneSharedCharacter = true;
            }
            if (u2.count[i] == 1 && u1.count[i] > 0) {
                u2.hasOneSharedCharacter = true;
            }
        }
        return u1.size <= u2.size ? new Uniqueness[]{u1, u2} : new Uniqueness[]{u2, u1};
    }

    private boolean assertZeroDifference(Uniqueness u1, Uniqueness u2) {
        return u1.hasSharedCharacter || (u1.hasOneUnique && u2.hasOneUnique) || (u1.hasMoreUniques && u2.hasMoreUniques);
    }

    private boolean assertOneDifference(Uniqueness u1, Uniqueness u2) {
        return (u2.hasMoreUniques && u1.hasMoreSharedCharacters) || (u2.hasOneUnique && u1.hasMoreUniques) || (u2.hasOneUnique && u1.hasOneSharedCharacter)
            || (u2.hasOneSharedCharacter && u1.hasMoreSharedCharacters && isNotTheSame(u2, u1));
    }

    private boolean isNotTheSame(Uniqueness u2, Uniqueness u1) {
        int count = 0;
        int hasMoreToSwap = 0;
        for (int i = 0; i < 26; i++) {
            if (u2.count[i] == 1 && u1.count[i] > 1) {
                count++;
            }
            if(u1.count[i] >= 1 && u2.count[i] >= 1) {
                hasMoreToSwap++;
            }
        }
        return count > 1 || hasMoreToSwap > 1;
    }

    private boolean assertTwoDifference(Uniqueness u1, Uniqueness u2) {
        return u2.hasOneUnique && u1.hasMoreSharedCharacters;
    }

    private static class Uniqueness {
        int size;
        int[] count;
        // case 0
        boolean hasSharedCharacter;
        boolean hasOneUnique;
        boolean hasMoreUniques;
        // case 1
        boolean hasMoreSharedCharacters;
        boolean hasOneSharedCharacter;

        public Uniqueness(int[] count, int size) {
            this.count = count;
            this.size =  size;
        }
    }
}
