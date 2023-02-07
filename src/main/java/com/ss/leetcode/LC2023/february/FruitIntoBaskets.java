package com.ss.leetcode.LC2023.february;

import java.util.Arrays;

public class FruitIntoBaskets {
    // https://leetcode.com/problems/fruit-into-baskets
    /** Algorithm
         1. Use an int[2][3] to store two baskets: type - quantity - lastStack.
         2. Last Stack represents how many CONTINUOUS fruits of type type have been picked up
            picking another type of fruit will reset this counter for type
            EG: 1 1 1 2 2 2 1 1
             i = 0-2: type1 stack will be 3
             i = 3-5 type2 stack will be 3
             i = 6: at this point, the stack of type[1] will reset to 1
             i = 7: type[1] stack will be 2.
             3. Use a linkedList (I used a simple 2 rows matrix) to add fruits in your basket.
             Always insert via the tail side.
         4. If the current type matches the tail basket, insert in basket and increment lastStack
         5. If the current type does not match the tail but matches the head,
            you MUST swap the head and tail. However, as it's a different type of fruit than the tail, remember to reset the lastStack
            of the fruit type. This will become relevant on step 6
         6. If the fruit type is different from the head/tail, you MUST drop/empty the head basket, put the fruits from tail basket to head basket and add this NEW type of fruit in the tail basket.
            ! However, when you move the fruits from tail to head basket, you cannot move ALL of them, as they might have been put in
            alternative sequences: 1 1 2 2 1 3. That's why you can only preserve the lastStack of fruits from the tail.
            EG: 1 1 2 2 1 3.
                for index i = 5, your head basket will have type2 with 2 fruits, lastStack 2
                your tail basket will have type1, 3 fruits but 1 stack.
                when emptying head basket and putting tail basket content in head basket, you can only put/preserve lastStack of type1 fruits: 1.
                because if you drop type2 fruits, you must also drop ALL the fruits gathered before type2.
                lastStack will hint you how many fruits you gathered AFTER type2 / swap.
     */
    public int totalFruit(int[] fruits) {
        int total = 0;
        int[][] baskets = new int[2][3];
        baskets[0][0] = -1;
        baskets[1][0] = -1;
        for (int type : fruits) {
            if (type == baskets[0][0]) {
                baskets[0][1]++;
                baskets[0][2]++;
            } else if (type == baskets[1][0]) {
                // swap the hands AND reset basket pile
                swapBaskets(baskets);
                baskets[0][1]++;
                baskets[0][2]++;
            } else {
                // evict first basket AND add this in new basket
                emptyBasket(baskets);
                baskets[0][0] = type;
                baskets[0][1] = 1;
                baskets[0][2] = 1;
            }
            total = Math.max(total, baskets[0][1] + baskets[1][1]);
        }
        return total;
    }

    private void swapBaskets(int[][] baskets) {
        int[] temp = Arrays.copyOf(baskets[1], baskets[1].length);
        baskets[1][0] = baskets[0][0];
        baskets[1][1] = baskets[0][1];
        baskets[0][0] = temp[0];
        baskets[0][1] = temp[1];
        baskets[0][2] = 0;
    }

    private void emptyBasket(int[][] baskets) {
        baskets[1][0] = baskets[0][0];
        baskets[1][1] = baskets[0][2];
        baskets[1][2] = 0;
    }
}
