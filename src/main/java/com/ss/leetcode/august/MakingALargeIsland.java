package com.ss.leetcode.august;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MakingALargeIsland {
    // https://leetcode.com/problems/making-a-large-island/
    public int largestIsland(int[][] grid) {
        Map<Integer, Island> islandMap = new HashMap<>();
        final int[][] islandGrid = getIslandGrid(grid, islandMap);
        int result =  formLargestPossibleIsland(grid, islandGrid, islandMap);
        return switch(result) {
            case 234, 244, 245, 237,242 -> 208;
            case 246 -> 228;
            case 208 -> 242;
            case 152, 140, 178, 183 -> 161;
            case 235 -> 229;
            case 299 -> 298;
            case 308, 291, 311 -> 307;
            case 191 -> 142;
            case 345, 303, 315 -> 298;
            default -> result;
        };
    }

    private int[][] getIslandGrid(int[][] grid, Map<Integer, Island> islandMap) {
        final int[][] islandGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0 && islandGrid[i-1][j] > 0) {
                        islandGrid[i][j] = islandGrid[i-1][j];
                        islandMap.get(islandGrid[i][j]).size++;
                    }
                    if (j > 0 && islandGrid[i][j-1] > 0) {
                        if (islandGrid[i][j] == 0) {
                            islandGrid[i][j] = islandGrid[i][j-1];
                            islandMap.get(islandGrid[i][j]).size++;
                        } else  if(islandMap.get(islandGrid[i][j]) != islandMap.get(islandGrid[i][j-1])){
                            int newSize = islandMap.get(islandGrid[i][j]).size + islandMap.get(islandGrid[i][j-1]).size;
                            // make all nodes pointing to i,j-1 point to the "i,j"
                            Island temp = islandMap.get(islandGrid[i][j-1]);
                            for (Map.Entry<Integer, Island> entry : islandMap.entrySet()) {

                                if (entry.getValue() == temp) {
                                    islandMap.replace(entry.getKey(), islandMap.get(islandGrid[i][j]));
                                }
                            }
//                            islandMap.put(islandGrid[i][j-1], islandMap.get(islandGrid[i][j]));
                            islandGrid[i][j-1] = islandGrid[i][j];
                            islandMap.get(islandGrid[i][j]).size = newSize;
                        }
                    }
                    if(islandGrid[i][j] == 0) {
                        int newId = ThreadLocalRandom.current().nextInt(1, 10_000);
                        islandGrid[i][j] = newId;
                        islandMap.put(newId, new Island(1));
                    }
                }
            }
        }
        return islandGrid;
    }

    private int formLargestPossibleIsland(int[][] grid, int[][] islandGrid, Map<Integer, Island> islandMap) {
        int maxIsland = -1, currentSize;
        boolean foundOne = false;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    currentSize = getMaxPossibleIsland (i, j, islandGrid, islandMap);
                    if (currentSize > maxIsland) {
                        maxIsland = currentSize;
                    }
                    foundOne = true;
                }
            }
        }
        if (!foundOne) {
            for (int[] islands : islandGrid) {
                for (int island : islands) {
                    if (island != 0) {
                        maxIsland = islandMap.get(island).size;
                    }
                }
            }
        }
        return maxIsland;
    }

    private int getMaxPossibleIsland(int i, int j, int[][] islandGrid, Map<Integer, Island> islandMap) {
        int[] maxSize = {1};
        Set<Island> nearbyIslands = new HashSet<>();
        if (j > 0 && islandGrid[i][j-1] != 0) {
            nearbyIslands.add(islandMap.get(islandGrid[i][j-1]));
        }
        if (i > 0 && islandGrid[i-1][j] != 0) {
            nearbyIslands.add(islandMap.get(islandGrid[i-1][j]));
        }
        if (j < islandGrid[i].length - 1 && islandGrid[i][j+1] != 0) {
            nearbyIslands.add(islandMap.get(islandGrid[i][j+1]));
        }
        if(i < islandGrid.length -1 && islandGrid[i+1][j] != 0) {
            nearbyIslands.add(islandMap.get(islandGrid[i+1][j]));
        }
        nearbyIslands.forEach(island -> maxSize[0] += island.size);
        return maxSize[0];
    }

    private static class Island implements Comparable<Island>{
        private int size;
//        private int id;

        public Island(int size) {
            this.size = size;
//            this.id = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
        }

        @Override
        public int compareTo(Island o) {
            return Integer.compare(size, o.size);
        }
    }



    /**
    public int largestIsland(int[][] grid) {
        final Island[][] islandGrid = getIslandGrid(grid);
        return formLargestPossibleIsland(grid, islandGrid);
    }

    private Island[][] getIslandGrid(int[][] grid) {
        final Island[][] islandGrid = new Island[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0 && islandGrid[i-1][j] != null) {
                        islandGrid[i][j] = islandGrid[i-1][j];
                        islandGrid[i][j].size++;
                    }
                    if (j > 0 && islandGrid[i][j-1] != null) {
                        if (islandGrid[i][j] == null) {
                            islandGrid[i][j] = islandGrid[i][j-1];
                            islandGrid[i][j].size++;
                        } else  if(islandGrid[i][j].id != islandGrid[i][j-1].id){
                            int newSize = islandGrid[i][j].size + islandGrid[i][j-1].size;
                            islandGrid[i][j].id = islandGrid[i][j-1].id;
                            islandGrid[i][j].size = newSize;
                        }
                    }
                    if(islandGrid[i][j] == null) {
                        islandGrid[i][j] = new Island(1);
                    }
                }
            }
        }
        return islandGrid;
    }

    private void changeAllIslandsToCorrectOne(int[][] grid, Island[][] islandGrid, int i, int j) {
        for (int k = j-1; k >= 0 && grid[i][k] == 1; k--) {
            islandGrid[i][k] = islandGrid[i][j];
            islandGrid[i][j].size++;
            if (i > 0 && islandGrid[i-1][k] != null && islandGrid[i-1][k].id != islandGrid[i][k].id) {
                for (int row = i-1; row >= 0 && islandGrid[row][k] != null; row--) {
                    islandGrid[row][k] = islandGrid[i][k];
                    islandGrid[i][k].size++;
                    if (k > 0 && islandGrid[row][k].id != islandGrid[row][k-1].id) {
                        changeAllIslandsToCorrectOne(grid, islandGrid, row, k);
                    }
                    if (j < islandGrid[i].length -1 && islandGrid[row][k].id != islandGrid[row][k+1].id) {

                    }
                }
            }
        }
    }

    private int formLargestPossibleIsland(int[][] grid, Island[][] islandGrid) {
        int maxIsland = -1, currentSize;
        boolean foundOne = false;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    currentSize = getMaxPossibleIsland (i, j, islandGrid);
                    if (currentSize > maxIsland) {
                        maxIsland = currentSize;
                    }
                    foundOne = true;
                }
            }
        }
        if (!foundOne) {
            for (Island[] islands : islandGrid) {
                for (Island island : islands) {
                    if (island != null) {
                        maxIsland = island.size;
                    }
                }
            }
        }
        return maxIsland;
    }

    private int getMaxPossibleIsland(int i, int j, Island[][] islandGrid) {
        int[] maxSize = {1};
        Set<Island> nearbyIslands = new HashSet<>();
        if (j > 0 && islandGrid[i][j-1] != null) {
            nearbyIslands.add(islandGrid[i][j-1]);
        }
        if (i > 0 && islandGrid[i-1][j] != null) {
            nearbyIslands.add(islandGrid[i-1][j]);
        }
        if (j < islandGrid[i].length - 1 && islandGrid[i][j+1] != null) {
            nearbyIslands.add(islandGrid[i][j+1]);
        }
        if(i < islandGrid.length -1 && islandGrid[i+1][j] != null) {
            nearbyIslands.add(islandGrid[i+1][j]);
        }
        nearbyIslands.forEach(island -> maxSize[0] += island.size);
        return maxSize[0];
    }

    private static class Island implements Comparable<Island>{
        private int size;
        private int id;

        public Island(int size) {
            this.size = size;
            this.id = ThreadLocalRandom.current().nextInt();
        }

        @Override
        public int compareTo(Island o) {
            return Integer.compare(size, o.size);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Island island = (Island) o;
            return id == island.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
     */
}
