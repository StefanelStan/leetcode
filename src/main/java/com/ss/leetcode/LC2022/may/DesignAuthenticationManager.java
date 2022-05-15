package com.ss.leetcode.LC2022.may;

import java.util.HashMap;
import java.util.Map;

public class DesignAuthenticationManager {
    // https://leetcode.com/problems/design-authentication-manager/
    private final Map<String, Integer> tokens;
    private final int timeToLive;
    public DesignAuthenticationManager(int timeToLive) {
        this.tokens = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive -1);
    }

    public void renew(String tokenId, int currentTime) {
        Integer existingExpire = tokens.get(tokenId);
        if (existingExpire != null && existingExpire >= currentTime) {
            tokens.put(tokenId, currentTime + timeToLive -1);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int[] unexpired = {0};
        tokens.values().forEach(v -> {
            if (v >= currentTime) {
                unexpired[0]++;
            }
        });
        return unexpired[0];
    }
}
