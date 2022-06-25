package com.ss.leetcode.LC2022.june;

public class MaximumXORAfterOperations {
    /** Algorithm/Theory:
     1. XOR returns T/1 only if the two operands are distinct: 1 X 0 is 1 but 1X1 / 0X0 = 0.
     2. Imagine a table of bit representations of the given numbers:
     EG: [3,2,4,6]
     3 = 0 1 1
     2 = 0 1 0
     4 = 1 0 0
     6 = 1 1 0
     As we see, each column has both 1s and 0s, thus meaning that XOR will be 1 on each column-> 1 1 1 (7)
     EG [1,2,3,9,2]
     1 = 0 0 0 1
     2 = 0 0 1 0
     3 = 0 0 1 1
     9 = 1 0 0 1
     2 = 0 0 1 0
     As we see, columns [0,2,3] have a both 0 and 1, thus XOR on these columns will return 1,
     but column 1 has all 0s, thus XOR on this column will return 0.
     The answer will by 1 0 1 1 => 11.
     3. Create an int[32] to count how many 1s are on each bit position for each number
     4. Iterate over each given num and mark/count its number of 1s on their respective positions
     [3,2,4,6]
     before [0,0,...0,0,0]
     after 3: [0,0,...0,1,1]
     after 2: [0,0,...0,2,1]
     after 4: [0,0,...1,2,1]
     after 6: [0,0,...2,3,1]
     5. Use a stringbuffer to bitwise recreate the result number:
     If a column has 0 1s OR n 1s (all 0s or all 1s) then that column will produce 0, else will produce 1.
     6. Reproduce each bit of each column and return the in representation of that number.
     */
    public int maximumXOR(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] oneCounts = new int[32];
        for (int num : nums) {
            addToCount(num, oneCounts);
        }
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (oneCounts[i] == 0 || oneCounts[i] == nums.length) {
                stb.append('0');
            } else {
                stb.append('1');
            }
        }
        return Integer.parseInt(stb.toString(), 2);
    }

    private void addToCount(int num, int[] oneCounts) {
        int pos = 31;
        while (num != 0) {
            if ((num & 1) == 1) {
                oneCounts[pos]++;
            }
            num = num >> 1;
            pos--;
        }
    }
}
