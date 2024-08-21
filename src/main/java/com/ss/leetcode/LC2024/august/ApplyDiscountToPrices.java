package com.ss.leetcode.LC2024.august;

public class ApplyDiscountToPrices {
    // https://leetcode.com/problems/apply-discount-to-prices
    /** Algorithm
        1. Split the sentence based on spaces into chunks[]
        2. Use a StringBuilder to append formatted chunks to it, separated by a space
        3. For each chunk, create a method that will return a String: if the chunk if a valid price,
            it will return the discounted price, else return the chunk
        4. Apply fail fast:
            - if chunk does not start with $, return/append the chunk
            - if it starts with $, loop from 1 to end and expect/assert digits, building the price.
            - if encoutering anything that a digit, return the chunk as it's not a correct price (EG: $a)
        5. Return the string value of string builder
     */
    public String discountPrices(String sentence, int discount) {
        StringBuilder stb = new StringBuilder();
        String[] chunks = sentence.split(" ");
        for(String chunk : chunks) {
            stb.append(applyDiscount(chunk, discount)).append(' ');
        }
        stb.setLength(stb.length() - 1);
        return stb.toString();
    }

    private String applyDiscount(String str, int discount) {
        if (str.charAt(0) != '$') {
            return str;
        }
        double price = 0;
        char ch;
        for (int i = 1; i < str.length(); i++) {
            ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                return str;
            } else {
                price = price * 10 + (ch - '0');
            }
        }
        return price > 0 ? String.format("$%.2f", (price * (100 - discount) / 100)) : str;
    }
}
