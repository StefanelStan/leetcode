package com.ss.leetcode.LC2021.august;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    // https://leetcode.com/problems/unique-email-addresses/submissions/
    public int numUniqueEmails(String[] emails) {
        Set<String> mailsToSend = new HashSet<>();
        for (String email : emails) {
            parseEmail(email, mailsToSend);
        }

        return mailsToSend.size();
    }

    private void parseEmail(String email, Set<String> mailsToSend) {
        StringBuilder stb = new StringBuilder();
        boolean buildingLocalname = true;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                stb.append(email.substring(i));
                break;
            }
            if (email.charAt(i) == '+') {
                buildingLocalname = false;
            } else if (email.charAt(i) != '.' && buildingLocalname) {
                stb.append(email.charAt(i));
            }
        }

        mailsToSend.add(stb.toString());
    }
}
