package com.ss.leetcode.LC2022.october;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MostPopularVideoCreator {
    // https://leetcode.com/problems/most-popular-video-creator/
    /** Algorithm
         1. Create a class CreatorPopularity that will retain totalViews, highestVideoViews and
            smallest lexicographically video with the highest video count for that particular user
         2. This object will hold a method add video that will increment total views
            and set/select the highest video with the lowest lexic. value
         3. Use a map <String, CreatorPopularity> that will map each creator to its popularity.
         4. Loop over the input arrays and for each creator/video/id retain the highest/max global popularity ever encounter across all creators
         5. Loop over the map and if the value (creatorPopularity) has the totalViews == max, add the creator and title to the answer
         6. Return the answer.
     */
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, CreatorPopularity> biggestVideos = new HashMap<>();
        int maxPopularity = -1;
        for (int i = 0; i < creators.length; i++) {
            int popularity = biggestVideos.computeIfAbsent(creators[i], k -> new CreatorPopularity()).addVideo(ids[i], views[i]);
            maxPopularity = Math.max(maxPopularity, popularity);
        }
        List<List<String>> mostPopular = new LinkedList<>();
        for(Map.Entry<String, CreatorPopularity> entry : biggestVideos.entrySet()) {
            if(entry.getValue().totalViews == maxPopularity) {
                mostPopular.add(List.of(entry.getKey(), entry.getValue().highestVideoId));
            }
        }
        return mostPopular;
    }

    private static class CreatorPopularity {
        int totalViews = 0;
        int highestVideoViews = 0;
        // if video view is 0, a null string will throw NPE. Thus, we need a heavy string
        String highestVideoId = String.valueOf((char)('z' + 1));


        public int addVideo(String id, int views) {
            totalViews += views;
            if (views > highestVideoViews) {
                highestVideoViews = views;
                highestVideoId = id;
            } else if (views == highestVideoViews && id.compareTo(highestVideoId) < 0) {
                highestVideoId = id;
            }
            return totalViews;
        }
    }
}
