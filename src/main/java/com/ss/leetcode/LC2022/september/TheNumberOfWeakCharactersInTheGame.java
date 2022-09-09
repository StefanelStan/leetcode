package com.ss.leetcode.LC2022.september;

public class TheNumberOfWeakCharactersInTheGame {
    /** Algorithm
         1. Use an array of size [100_003] to store the max defense of each category/group of attack.
            maxProperties[4] will contain the max defense of an  attack of value = 4;
         2. Traverse properties and set this array.
         3. Looking at this in a backward manner, we observe that from a point i, i+1 will contain only the
             attacks that have a value greater than i.
             If we were to know the max element on this left side, we can quickly determine if there
             is a pair with a greater attack and defense.
         4. So traverse this backwards with an index i and set i+1 to be the max between i+1 and i+2.
             Basically calculate a rolling max from end to beginning.
             eg: [7,9,2,8,1,0,0]
             rolling this we obtain 9,9,8,8,1,0,0.
         5. So, if we were to send a property [1,4] we can quickly look at the index 2: 2 has a max of 8,
             so there is an element at the left of [1] which has a greater value than 4.
             So [1,4] is a weak character.
     */
    public int numberOfWeakCharacters(int[][] properties) {
        int weakCharacters = 0, max = 0;
        int[] maxProperties = getMaxProperties(properties);
        for (int[] property : properties) {
            if (property[1] < maxProperties[property[0] + 1]) {
                weakCharacters++;
            }
        }
        return weakCharacters;
    }

    private int[] getMaxProperties(int[][] properties) {
        int[] maxProperty = new int[100_003];
        int maxAttack = 0, minAttack = 100_001;
        for (int[] property : properties) {
            maxProperty[property[0]] = Math.max(property[1], maxProperty[property[0]]);
            maxAttack = Math.max(maxAttack, property[0]);
            minAttack = Math.min(minAttack, property[0]);

        }
        for (int j = maxAttack; j >= minAttack; j--) {
            maxProperty[j + 1] = Math.max(maxProperty[j + 1], maxProperty[j + 2]);
        }
        return maxProperty;
    }
}
