package com.ss.leetcode.LC2023.september;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {
    // https://leetcode.com/problems/design-twitter
    /** Algorithm
        1. Use a global variable int timeStamp to leverage/increment the time of each insertion.
        2. Use a LinkedList to store the tweets of each user. EG: the tail will always have the most recent tweet, so insert at the tail
        3. The Node of each Element will be of type TweetNode(timeStamp, tweetId) and have a pointer to previous node
        4. Keep a List[501] with the tweets of each user[userId]
        5. Also, keep a Set[501] with the followees for each user
        6. When adding a new tweet, get the List[userId] and add a new tweetNode in the tail of the list, incrementing the timeStamp
        7. follow will add a new followeeId to the Set[followerId]
        8. getNewsFeed
            - will use a PriorityQueue (reverse order by timeStamp) to add only the latest nodes of user's tweets AND the
                tweets from Set[userId] of followees.
            - Poll the head from PQ, add it to list and add the previous element (head.previous) back to queue.
            - Do this 10 times or until PQ is empty.
            - Return the list.
     */
    private int timeStamp = 0;
    private final TweetList[] tweets;
    private final Set<Integer>[] followers;
    public DesignTwitter() {
        tweets = new TweetList[501];
        followers = new Set[501];
    }

    public void postTweet(int userId, int tweetId) {
        if (tweets[userId] == null) {
            tweets[userId] = new TweetList();
        }
        tweets[userId].addTweet(new TweetNode(tweetId, timeStamp));
        timeStamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetNode> recentNodes = getRecentNodes(userId);
        LinkedList<Integer> newsFeed = new LinkedList<>();
        while (!recentNodes.isEmpty() && newsFeed.size() < 10) {
            TweetNode feed = recentNodes.poll();
            newsFeed.addLast(feed.tweetId);
            if (feed.previous != null) {
                recentNodes.add(feed.previous);
            }
        }
        return newsFeed;
    }

    private PriorityQueue<TweetNode> getRecentNodes(int userId) {
        PriorityQueue<TweetNode> recentNodes = new PriorityQueue<>((a,b) -> Integer.compare(b.timeStamp, a.timeStamp));
        if (tweets[userId] != null) {
            recentNodes.add(tweets[userId].getLast());
        }
        if (followers[userId] != null) {
            for (int followeeId : followers[userId]) {
                if (tweets[followeeId] != null) {
                    recentNodes.add(tweets[followeeId].getLast());
                }
            }
        }
        return recentNodes;
    }

    public void follow(int followerId, int followeeId) {
        if(followers[followerId] == null) {
            followers[followerId] = new HashSet<>();
        }
        followers[followerId].add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers[followerId] != null) {
            if (followers[followerId].size() > 2) {
                followers[followerId].remove(followeeId);
            } else {
                followers[followerId] = null;
            }
        }
    }

    private static class TweetList {
        TweetNode tail;

        public void addTweet(TweetNode node) {
            if (tail != null) {
                node.previous = tail;
            }
            tail = node;
        }

        public TweetNode getLast() {
            return tail;
        }
    }

    private static class TweetNode {
        int tweetId;
        int timeStamp;
        TweetNode previous;

        public TweetNode(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
}
