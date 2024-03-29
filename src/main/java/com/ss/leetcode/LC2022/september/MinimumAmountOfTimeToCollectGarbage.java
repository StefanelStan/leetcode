package com.ss.leetcode.LC2022.september;

public class MinimumAmountOfTimeToCollectGarbage {
    // https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/submissions/
    public int garbageCollection(String[] garbage, int[] travel) {
        // MPG
        int[] lastIndexSum = {0,0,0};
        int costToTravel = 0, timeToCollect = 0;
        for (int i = 0; i < garbage.length; i++) {
            costToTravel += (i == 0 ? 0 : travel[i-1]);
            timeToCollect += getGarbageCollectionCost(garbage[i], lastIndexSum, costToTravel);
        }
        return timeToCollect;
    }

    private int getGarbageCollectionCost(String house, int[] lastIndexSum, int costToTravel) {
        int totalCost = house.length(), machineIndex;
        for (int i = 0; i < house.length(); i++) {
            machineIndex = getOrderIndexOf(house.charAt(i));
            totalCost += costToTravel - lastIndexSum[machineIndex];
            lastIndexSum[machineIndex] = costToTravel;
        }
        return totalCost;
    }

    private int getOrderIndexOf(char sign) {
        return switch(sign) {
            case 'M' -> 0;
            case 'P' -> 1;
            default -> 2;
        };
    }


    public int garbageCollection2(String[] garbage, int[] travel) {
        GarbageTruck[] trucks = getGarbageTrucks();
        int travelTime = 0, codePoint;
        for (int g = 0; g < garbage.length; g++) {
            for (int i = 0; i < garbage[g].length(); i++) {
                codePoint = garbage[g].charAt(i) - 'A';
                trucks[codePoint].collectedGarbage++;
                trucks[codePoint].travelTime = travelTime;
            }
            travelTime += (g < travel.length ? travel[g] : 0);
        }
        return trucks['G' - 'A'].getTotalTime() + trucks['M' - 'A'].getTotalTime() + trucks['P' - 'A'].getTotalTime();
    }

    private GarbageTruck[] getGarbageTrucks() {
        GarbageTruck[] trucks = new GarbageTruck[26];
        trucks['G' - 'A'] = new GarbageTruck();
        trucks['M' - 'A'] = new GarbageTruck();
        trucks['P' - 'A'] = new GarbageTruck();
        return trucks;
    }

    private static class GarbageTruck {
        int collectedGarbage;
        int travelTime;

        public int getTotalTime() {
            return collectedGarbage + travelTime;
        }
    }

    /** Algorithm - Advanced memoization
         1. All the trucks start from 0, but they might finish ay i,j,k..depending on garbage
         So it's good to keep track of the last visited house.
         2. So calculate the cumulative/rolling cost of visiting houses
         Knowing last visited house for plastic (eg: 4), then the travel time can be
         determined by cumulativeCost[4].
         3. Knowing that picking up a piece of garbage costs 1, keep track of each collected garbage.
         For ease, use an int[26] (A- Z).
         4. Putting all of these together,
         - traverse the garbage/house and incredement the correct collectedGarbage[letterCodePoint]
         - update the lastVisitedHouse[letterCodePoint]
         - add the travelCumulatedTime for that house.
         5. In the end, iterate over the collectedGarbage.
         - if > 0, then that type (M,G,P) was collected. So add the value AND
         the travelCumulatedTime of the lastVisitedHouse[codePoint].
         6. Return the answer.
     */
    public int garbageCollection3(String[] garbage, int[] travel) {
        int[] totalGarbage = new int[26];
        int[] lastCollectedHouse = new int[26];
        int[] travelCumulatedTime = new int[travel.length + 1];
        int codePoint;
        for (int i = 0; i < garbage[0].length(); i++) {
            codePoint = garbage[0].charAt(i) - 'A';
            totalGarbage[codePoint]++;
            lastCollectedHouse[codePoint] = 0;
        }
        for (int i = 1; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                codePoint = garbage[i].charAt(j) - 'A';
                totalGarbage[codePoint]++;
                lastCollectedHouse[codePoint] = i;
            }
            travelCumulatedTime[i] += travel[i-1] + travelCumulatedTime[i-1];
        }

        int collectionTime = 0;
        for (int i = 0; i < totalGarbage.length; i++) {
            if (i > 0) {
                collectionTime += totalGarbage[i] + travelCumulatedTime[lastCollectedHouse[i]];
            }
        }
        return collectionTime;
    }
}
