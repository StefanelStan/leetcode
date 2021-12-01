package com.ss.leetcode.LC2021.july;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> topWords = new LinkedList<>();
        Map<String, Integer> freqWords = new HashMap<>();
        Arrays.stream(words).forEach(word -> freqWords.merge(word, 1, Integer::sum));
        TreeMap<Integer, List<String>> bucketMap = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<String, Integer> entry : freqWords.entrySet()) {
            List<String> bucketList = bucketMap.get(entry.getValue());
            if (bucketList == null) {
                bucketList = new LinkedList<>();
                bucketList.add(entry.getKey());
                bucketMap.put(entry.getValue(), bucketList);
            } else {
                bucketList.add(entry.getKey());
            }
        }

        int numberOfWords = 0;
        for(Map.Entry<Integer, List<String>> entry : bucketMap.entrySet()) {
            if (numberOfWords + entry.getValue().size() >= k) {
                Collections.sort(entry.getValue());
                topWords.addAll(entry.getValue().subList(0, k - numberOfWords));
                numberOfWords += (k - numberOfWords);
                break;
            } else {
                Collections.sort(entry.getValue());
                topWords.addAll(entry.getValue());
                numberOfWords += entry.getValue().size();
            }
        }
        return topWords;
    }
}
