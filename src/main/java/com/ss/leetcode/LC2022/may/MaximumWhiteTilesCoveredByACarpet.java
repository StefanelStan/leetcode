package com.ss.leetcode.LC2022.may;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumWhiteTilesCoveredByACarpet {
    // https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        if (carpetLen == 1) {
            return carpetLen;
        } else {
            return getMaxWhileTiles(tiles, carpetLen);
        }
    }

    private int getMaxWhileTiles(int[][] tiles, int carpetLen) {
        int maxWhileTiles = 0;
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int start = 0;
        int coveredTiles = 0, remainingCarpet = carpetLen;
        int tileLength;
        for (int i = 0; i < tiles.length; i++) {
            tileLength = tiles[i][1] + 1 - tiles[i][0];
            remainingCarpet = (i == 0 || start == i) ? carpetLen : remainingCarpet - (tiles[i][0] - 1 - tiles[i - 1][1]);
            // what if this is negative?
            if (remainingCarpet <= 0) {
                maxWhileTiles = Math.max(maxWhileTiles, coveredTiles);
            }
            if (remainingCarpet < tileLength) {
                // carpet won't suffice to cover this while tile. Let's see how many tiles covers from this tile
                if (remainingCarpet >= 0) {
                    maxWhileTiles = Math.max(maxWhileTiles, coveredTiles + remainingCarpet);
                }
                // now move start to left to determine tiles;
                if (start == i) {
                    // no point in searching because you're already on current tile;
                    start++;
                    maxWhileTiles = Math.max(maxWhileTiles, carpetLen);
                    remainingCarpet = carpetLen;
                    coveredTiles = 0;
                } else {
                    if (tileLength >= carpetLen) {
                        // no points searching. Just set this one.
                        maxWhileTiles = Math.max(maxWhileTiles, carpetLen);
                        coveredTiles = 0;
                        start++;
                    } else {
                        while (remainingCarpet <= tileLength && start < i) {
                            start++;
                            remainingCarpet += (tiles[start][0] - tiles[start-1][0]);
                            coveredTiles -= tiles[start-1][1] + 1 - tiles[start-1][0];
                        }
                        remainingCarpet -= tileLength;
                        coveredTiles += tileLength;
                        maxWhileTiles = Math.max(maxWhileTiles, coveredTiles);
                    }
                }
            } else {
                // add this tile and sum it up
                coveredTiles += tileLength;
                remainingCarpet -= tileLength;
                maxWhileTiles = Math.max(maxWhileTiles, coveredTiles);
            }
        }
        return maxWhileTiles;
    }

    /**
     public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
     if (carpetLen == 1) {
     return carpetLen;
     }
     Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
     LinkedList<int[]> coveredTiles = new LinkedList<>();
     int maxCoveredTiles = -1;
     int listCoveredTiles = 0;
     int remainingCarpet = carpetLen;
     int tileLength;
     for(int[] tile : tiles) {
     tileLength = (tile[1] - tile[0]) + 1;
     if (coveredTiles.isEmpty()) {
     if (tileLength <= remainingCarpet) {
     listCoveredTiles += tileLength;
     remainingCarpet -= tileLength;
     coveredTiles.addLast(tile);
     } else { // no need to add it as it won't stretch long enough
     listCoveredTiles += remainingCarpet;
     remainingCarpet = 0;
     }
     maxCoveredTiles = Math.max(maxCoveredTiles, listCoveredTiles);
     } else {
     remainingCarpet -= ((tile[0] - coveredTiles.getLast()[1]) -1);
     if (remainingCarpet < tileLength) {
     // evacuate until you make ti stretch all over this one too!
     if (remainingCarpet > 0) {
     maxCoveredTiles = Math.max(maxCoveredTiles, (listCoveredTiles + remainingCarpet));
     }
     while(remainingCarpet < tileLength && !coveredTiles.isEmpty()) {
     int[] firstTile = coveredTiles.removeFirst();
     listCoveredTiles -= ((firstTile[1] - firstTile[0]) + 1);
     remainingCarpet = (coveredTiles.isEmpty() ? carpetLen : remainingCarpet + coveredTiles.peekFirst()[0] - firstTile[1] + 1);
     }
     if (coveredTiles.isEmpty()) {
     // you removed them all and it still does not cover because the current tile distance is bigger
     remainingCarpet = carpetLen;
     if (tileLength <= remainingCarpet) {
     listCoveredTiles += tileLength;
     remainingCarpet -= tileLength;
     coveredTiles.addLast(tile);
     } else { // no need to add it as it won't stretch long enough
     listCoveredTiles += remainingCarpet;
     remainingCarpet = 0;
     }
     maxCoveredTiles = Math.max(maxCoveredTiles, listCoveredTiles);
     continue;
     }
     coveredTiles.addLast(tile);
     listCoveredTiles += tileLength;
     maxCoveredTiles = Math.max(maxCoveredTiles, listCoveredTiles);
     remainingCarpet -= tileLength;
     } else {
     // add this tile and get min/max
     coveredTiles.addLast(tile);
     listCoveredTiles += tileLength;
     maxCoveredTiles = Math.max(maxCoveredTiles, listCoveredTiles);
     remainingCarpet -= tileLength;
     }
     }
     }
     return maxCoveredTiles;
     }
     */
}
