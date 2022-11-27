package com.ss.leetcode.LC2022.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankTeamsByVotes {
    // https://leetcode.com/problems/rank-teams-by-votes/
    // Not explained right on LC
    public String rankTeams(String[] votes) {
        Vote[][] votingBoard = getSortedVotingBoard(votes);
        StringBuilder stb = new StringBuilder();
        boolean[] hasBeenAdded = new boolean[26];
        for (int i = 0; i < votes[0].length() && stb.length() < votes[0].length(); i++) {
            List<Character> rankedTeams = getRankedTeams(votingBoard, i, hasBeenAdded);
            System.out.println(rankedTeams);
            for (char ch : rankedTeams) {
                hasBeenAdded[ch - 'A'] = true;
                stb.append(ch);
            }
        }
        return stb.toString();
    }

    private List<Character> getRankedTeams(Vote[][] votingBoard, int rank, boolean[] hasBeenAdded) {
        int max = votingBoard[rank][0].votes;
        List<Character> topRanked = new ArrayList<>();
        for (int j = 0; j < votingBoard[rank].length && votingBoard[rank][j].votes == max; j++) {
            if (!hasBeenAdded[votingBoard[rank][j].team - 'A']) {
                topRanked.add(votingBoard[rank][j].team);
            }
        }
        return topRanked.size() == 1 ? topRanked : getNextRankedTeams(votingBoard, rank + 1, topRanked, hasBeenAdded);
    }

    private List<Character> getNextRankedTeams(Vote[][] votingBoard, int rank, List<Character> topRanked, boolean[] hasBeenAdded) {
        if (rank >= votingBoard.length || votingBoard[rank][0].votes == 0) {
            return topRanked;
        }
        int stoppingRank = -1;
        List<Character> nextBestRanked = new ArrayList<>();
        for (int j = 0; j < votingBoard[rank].length; j++) {
            if (!hasBeenAdded[votingBoard[rank][j].team - 'A']) {
                if (topRanked.contains(votingBoard[rank][j].team)) {
                    if (stoppingRank == -1) {
                        stoppingRank = votingBoard[rank][j].votes;
                    } else if (stoppingRank != votingBoard[rank][j].votes) {
                        break;
                    }
                    nextBestRanked.add(votingBoard[rank][j].team);
                }
            }
        }
        return nextBestRanked.size() == 1 ? nextBestRanked : getNextRankedTeams(votingBoard, rank + 1, nextBestRanked, hasBeenAdded);
    }

    private Vote[][] getSortedVotingBoard(String[] votes) {
        Vote[][] votingBoard = new Vote[votes[0].length()][26];
        for (int i = 0; i < votingBoard.length; i++) {
            for (int j = 0; j < 26; j++) {
                votingBoard[i][j] = new Vote((char)('A' + j));
            }
        }
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                votingBoard[i][vote.charAt(i) - 'A'].votes++;
            }
        }
        for (Vote[] value : votingBoard) {
            Arrays.sort(value, (a, b) -> a.votes == b.votes ? a.team - b.team : b.votes - a.votes);
        }
        return votingBoard;
    }

    private static class Vote {
        private char team;
        private int votes;

        public Vote(char team) {
            this.team = team;
        }
    }
}
