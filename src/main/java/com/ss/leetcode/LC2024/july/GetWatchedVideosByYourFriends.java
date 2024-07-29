package com.ss.leetcode.LC2024.july;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GetWatchedVideosByYourFriends {
    // https://leetcode.com/problems/get-watched-videos-by-your-friends
    /** Algorithm
        1. Apply BFS to get the queue of friends at level level
        2. For each friend from queue, get the list of videos and count it into amap
        3. Sort the keyset based on values (frequency) and name of movie.
        4. Return the list
     */
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> levelFriends = getLevelFriends(id, friends, level);
        if (levelFriends.isEmpty()) {
            return Collections.emptyList();
        }
        Map<String, Integer> videos = getWatchedVideos(levelFriends, watchedVideos);
        return videos.keySet().stream().sorted((a,b) -> videos.get(a).equals(videos.get(b)) ? a.compareTo(b) : Integer.compare(videos.get(a), videos.get(b))).toList();
    }

    private Map<String, Integer> getWatchedVideos(Queue<Integer> friends, List<List<String>> watchedVideos) {
        Map<String, Integer> videos = new HashMap<>();
        for (int friend : friends) {
            for (String video : watchedVideos.get(friend)) {
                videos.merge(video, 1, Integer::sum);
            }
        }
        return videos;
    }

    private Queue<Integer> getLevelFriends(int id, int[][] friends, int level) {
        if (friends[id].length == 0) {
            return new LinkedList<>();
        }
        int currentLevel = 0, size, currentFriend;
        boolean[] visited = new boolean[friends.length];
        Queue<Integer> nextOnes = new LinkedList<>();
        nextOnes.add(id);
        visited[id] = true;
        while (!nextOnes.isEmpty() && currentLevel < level) {
            size = nextOnes.size();
            while (size > 0) {
                currentFriend = nextOnes.poll();
                for (int next : friends[currentFriend]) {
                    if (!visited[next]) {
                        nextOnes.add(next);
                        visited[next] = true;
                    }
                }
                size--;
            }
            currentLevel++;
        }
        return nextOnes;
    }
}
