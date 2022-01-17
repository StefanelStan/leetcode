package com.ss.leetcode.LC2022.january;

public class DivideAStringIntoGroupsOfSizeK {
    // https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
    public String[] divideString(String s, int k, char fill) {
        int nrOfGroups = (s.length() / k) + (s.length() % k == 0 ? 0 : 1);
        String[] groups = new String[nrOfGroups];
        int index = 0;
        int groupIndex = 0;
        while (index + k <= s.length()) {
            groups[groupIndex] = s.substring(index, index + k);
            index += k;
            groupIndex++;
        }

        if (index < s.length()) {
            StringBuilder stb = new StringBuilder();
            for(int i = index; i < s.length(); i++) {
                stb.append(s.charAt(i));
            }
            for (int i = s.length() % k; i < k; i++) {
                stb.append(fill);
            }
            groups[groupIndex] = stb.toString();
        }
        return groups;
    }
}
