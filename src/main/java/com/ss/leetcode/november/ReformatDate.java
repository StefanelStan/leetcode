package com.ss.leetcode.november;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {
    private Map<String, String> monthMap;
    public String reformatDate(String date) {
        setMap();
        String[] chunks = date.split(" ");
        StringBuilder stb = new StringBuilder();
        stb.append(chunks[2]);
        stb.append('-');
        stb.append(monthMap.get(chunks[1]));
        stb.append('-');
        if (chunks[0].length() <= 3){
            stb.append('0');
        }
        stb.append(chunks[0], 0, chunks[0].length() -2);
        return stb.toString();
    }

    private void setMap() {
        if (monthMap == null) {
            monthMap = new HashMap<>();
            monthMap.put("Jan", "01");
            monthMap.put("Feb", "02");
            monthMap.put("Mar", "03");
            monthMap.put("Apr", "04");
            monthMap.put("May", "05");
            monthMap.put("Jun", "06");
            monthMap.put("Jul", "07");
            monthMap.put("Aug", "08");
            monthMap.put("Sep", "09");
            monthMap.put("Oct", "10");
            monthMap.put("Nov", "11");
            monthMap.put("Dec", "12");
        }
    }
}
