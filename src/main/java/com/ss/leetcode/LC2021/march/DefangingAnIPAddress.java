package com.ss.leetcode.LC2021.march;

public class DefangingAnIPAddress {
    private static final String CHUNK = "[.]";
    public String defangIPaddr(String address) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            stb.append(address.charAt(i) == '.' ? CHUNK : address.charAt(i));
        }
        return stb.toString();
    }
}
