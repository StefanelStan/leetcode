package com.ss.leetcode.november;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountsMerge {
    // https://leetcode.com/problems/accounts-merge/
    // not yet finished
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> merges = new ArrayList<>();
        Map<String, List<EmailList>> emails = mapAccounts(accounts);
        emails.forEach((k,v) -> {
            v.forEach(setOfEmails -> {
                List<String> account = new ArrayList<>();
                account.add(k);
                account.addAll(setOfEmails.emailBucket.stream().sorted().collect(Collectors.toList()));
                merges.add(account);
            });
        });
        return merges;
    }

    private Map<String, List<EmailList>> mapAccounts(List<List<String>> accounts) {
        Map<String, List<EmailList>> emails = new HashMap<>();
        List<Integer>[] connections = new List[accounts.size()];

        for (int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            List<EmailList> accountsForName = emails.computeIfAbsent(account.get(0), k -> new ArrayList<>());
            Set<String> currAccountSet = new HashSet<>(account.subList(1, account.size()));
            for (EmailList emailList : accountsForName) {
                if (existsAlready(emailList, currAccountSet)) {
                    List<Integer> conns = connections[emailList.order];
                    if (conns == null) {
                        conns = new ArrayList<>();
                        connections[emailList.order] = conns;
                    }
                    conns.add(i);
                }
            }
        }
        return emails;
    }

    private boolean existsAlready(EmailList emailList, Set<String> currAccountSet) {
        return false;
    }

    private class EmailList {
        int order;
        Set<String> emailBucket = new HashSet<>();

        public EmailList(int order) {
            this.order = order;
        }
    }
}
