package com.ss.leetcode.march;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {
    // https://leetcode.com/problems/encode-and-decode-tinyurl/
    // Encodes a URL to a shortened URL.
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORTEN_URL_SIZE = 6;
    private static final Map<String, String> SHORTEN_URL_MAP = new HashMap<>();
    private static final Random rand = new Random();
    public String encode(String longUrl) {
        String shortenUrl = shortenUrl(longUrl);
        SHORTEN_URL_MAP.put(shortenUrl, longUrl);
        return "http://tinyurl.com/" + shortenUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return SHORTEN_URL_MAP.get(shortUrl.substring(shortUrl.lastIndexOf('/') + 1));
    }

    private String shortenUrl(String longUrl) {
        char[] shortenUrl = new char[SHORTEN_URL_SIZE];
        for (int i = 0; i < SHORTEN_URL_SIZE; i++) {
            shortenUrl[i] = ALPHABET.charAt(rand.nextInt(ALPHABET.length()));
        }
        return new String(shortenUrl);
    }
}
