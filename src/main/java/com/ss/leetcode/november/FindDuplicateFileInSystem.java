package com.ss.leetcode.november;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    // https://leetcode.com/problems/find-duplicate-file-in-system/
    public List<List<String>> findDuplicate(String[] paths) {
        final List<List<String>> duplicates = new ArrayList<>();
        Map<String, List<String>> contentFileMap = new HashMap<>();
        addFilesToMap(paths, contentFileMap);
        contentFileMap.forEach((k, v) -> {
            if (v.size() > 1) {
                duplicates.add(v);
            }
        });
        return duplicates;
    }

    private void addFilesToMap(String[] paths, Map<String, List<String>> contentFileMap) {
        for (String path : paths) {
            String[] chunks = path.split(" ");
            for (int i = 1; i < chunks.length; i++) {
                int firstPosition = chunks[i].indexOf('(');
                String fullPath = chunks[0] + '/' + chunks[i].substring(0, firstPosition);
                String content = chunks[i].substring(firstPosition+1, chunks[i].length() -1);
                List<String> listOfPaths = contentFileMap.computeIfAbsent(content, k -> new ArrayList<>());
                listOfPaths.add(fullPath);
            }
        }
    }
}
