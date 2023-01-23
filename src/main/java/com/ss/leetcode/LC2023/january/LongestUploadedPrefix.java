package com.ss.leetcode.LC2023.january;

public class LongestUploadedPrefix {
    // https://leetcode.com/problems/longest-uploaded-prefix
    /** Algorithm
        1. Use a boolean[n+1] to mark present videos
        2. Keep track of endOfPrefix to return it each time
        3. With each upload, mark boolean[i] = true.
        - If video == 1, you can build a prefix from 1 to k. Keep track of endOfPrefix
        - If video == endOfPrefix + 1, you might have another segment on the right that was just completed.
          Recalculate the endOfPrefix, but this time starting from the last know endOfPrefix.
     */
    private final boolean[] uploads;
    private int endOfPrefix = 0;
    public LongestUploadedPrefix(int n) {
        uploads = new boolean[n + 1];
    }

    public void upload(int video) {
        uploads[video] = true;
        // end of prefix is 0 so 0 + 1 = 1 -> it will start building a chain if video is 1
        if (video == endOfPrefix + 1) {
            calculateEndOfPrefix(video);
        }
    }

    private void calculateEndOfPrefix(int from) {
        while(from < uploads.length && uploads[from]) {
            endOfPrefix = from++;
        }
    }

    public int longest() {
        return endOfPrefix;
    }
}
