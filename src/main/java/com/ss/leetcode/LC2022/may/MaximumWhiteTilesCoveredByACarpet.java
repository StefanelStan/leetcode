package com.ss.leetcode.LC2022.may;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumWhiteTilesCoveredByACarpet {
    // https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/
    /** Algorithm
        1. Use a flexible window - two pointers. Right will point to current tile and left will point to the first tile covered by the carpet
        2. For each tile segment, cover the current segment. Increase the number of covered tiles AND used carpet.
        3. If you've used too much carpet (used > carpetLen)
            - try to uncover as much carpet from the leftmost tile where the carpet starts.
            - if completely uncovering that segment does not give back enough carpet, then switch to next segment (left++)
            - when switching to next segment, you also gain back the carpet that covers the empty/blank space between segments
        4. Also, keep track of where your carpet starts within the left segment:
            EG: [1,10] but you might have to cover some tiles, thus your carpet can start from position 5.
        5. At each step, check the max tiles covered by the carpet.
     */
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        FlexibleCarpet flexibleCarpet = new FlexibleCarpet(tiles, carpetLen);
        int maxCoveredTiles = 0;
        for (int i = 0; i < tiles.length; i++) {
            flexibleCarpet.coverNextTile();
            maxCoveredTiles = Math.max(maxCoveredTiles, flexibleCarpet.getCoveredTiles());
        }
        return maxCoveredTiles;
    }

    private static class FlexibleCarpet {
        private final int[][] tiles;
        private final int maxCarpetLength;
        private int usedCarpet;
        private int excessCarpet;
        private int carpetStart, left, coveredTiles, right;

        public FlexibleCarpet(int[][] tiles, int maxCarpetLength) {
            this.tiles = tiles;
            this.maxCarpetLength = maxCarpetLength;
            carpetStart = tiles[0][0];
        }

        public void coverNextTile() {
            coveredTiles += tiles[right][1] + 1 - tiles[right][0];
            usedCarpet += ((tiles[right][1] + 1 - tiles[right][0])  +
                (right > 0 ? tiles[right][0] - tiles[right - 1][1] - 1 : 0));
            right++;
            adjustCarpet();
        }

        private void adjustCarpet() {
            while (usedCarpet > maxCarpetLength) {
                excessCarpet = usedCarpet - maxCarpetLength;
                if (excessCarpet >= tiles[left][1] + 1 - carpetStart) {
                    usedCarpet -= ((tiles[left][1] + 1 - carpetStart) + (tiles[left + 1][0] - tiles[left][1] - 1));
                    coveredTiles -= (tiles[left][1] + 1 - carpetStart);
                    left++;
                    carpetStart = tiles[left][0];

                } else {
                    carpetStart += excessCarpet;
                    usedCarpet -= excessCarpet;
                    coveredTiles -= excessCarpet;
                }
            }
        }

        public int getCoveredTiles() {
            return coveredTiles;
        }
    }


    // ALL WRONG
    public int maximumWhiteTiles2(int[][] tiles, int carpetLen) {
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
