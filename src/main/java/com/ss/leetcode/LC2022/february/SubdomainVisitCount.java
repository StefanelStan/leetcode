package com.ss.leetcode.LC2022.february;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    // https://leetcode.com/problems/subdomain-visit-count/
    public List<String> subdomainVisits(String[] cpdomains) {
        final Map<String, Integer> domains = countSubdomains(cpdomains);
        final List<String> visits = new ArrayList<>(domains.size());
        domains.forEach((k,v) -> visits.add(v + " " + k));
        return visits;
    }

    private Map<String, Integer> countSubdomains(String[] cpdomains) {
        Map<String, Integer> domains = new HashMap<>();
        int count, i, dotCount;
        for (String cpdomain : cpdomains) {
            // get the count;
            count = 0;
            i = 0;
            dotCount = 0;
            while(cpdomain.charAt(i) != ' ') {
                count = count * 10 + (cpdomain.charAt(i++) - '0');
            }
            // get the subdomains
            domains.merge(cpdomain.substring(++i), count, Integer::sum);
            while(dotCount < 2 && i < cpdomain.length()) {
                if (cpdomain.charAt(i) == '.') {
                    dotCount++;
                    domains.merge(cpdomain.substring(i + 1), count, Integer::sum);
                }
                i++;
            }
        }
        return domains;
    }
}
