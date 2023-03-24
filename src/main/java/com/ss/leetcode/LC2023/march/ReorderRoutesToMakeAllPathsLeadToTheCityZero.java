package com.ss.leetcode.LC2023.march;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    // https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
    // NON OOP Version
    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List[] cities = buildConnections(connections);
        int[] minReorder = {0};
        traverseCities(cities, 0, visited, minReorder);
        return minReorder[0];
    }

    private List[] buildConnections(int[][] connections) {
        List[] cities = new List[connections.length + 1];
        for (int[] connection : connections) {
            if (cities[connection[0]] == null) {
                cities[connection[0]] = new ArrayList<>();
            }
            if (cities[connection[1]] == null) {
                cities[connection[1]] = new ArrayList<>();
            }
            cities[connection[0]].add(-connection[1]);
            cities[connection[1]].add(connection[0]);
        }
        return cities;
    }

    private void traverseCities(List[] cities, int index, boolean[] visited, int[] minReorder) {
        if (!visited[index]) {
            visited[index] = true;
            List<Integer> connections = cities[index];
            for (int connection : connections) {
                if (connection < 0 && !visited[-connection]) {
                    minReorder[0]++;
                }
                traverseCities(cities, Math.abs(connection), visited, minReorder);
            }
        }
    }

    // OOP Version
    public int minReorder2(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        City[] cities = buildCityConnections(connections);
        int[] minReorder = {0};
        traverseCities(cities[0], visited, minReorder);
        return minReorder[0];
    }

    private City[] buildCityConnections(int[][] connections) {
        City[] cities = new City[connections.length + 1];
        for (int[] connection : connections) {
            if (cities[connection[0]] == null) {
                cities[connection[0]] = new City(connection[0]);
            }
            if (cities[connection[1]] == null) {
                cities[connection[1]] = new City(connection[1]);
            }
            cities[connection[0]].addOutgoingConnection(cities[connection[1]]);
            cities[connection[1]].addIncomingConnection(cities[connection[0]]);
        }
        return cities;
    }

    private void traverseCities(City city, boolean[] visited, int[] minReorder) {
        if (!visited[city.id]) {
            visited[city.id] = true;
            for (City out : city.outgoing) {
                if(!visited[out.id]) {
                    minReorder[0]++;
                    traverseCities(out, visited, minReorder);
                }
            }
            for (City in : city.incoming) {
                traverseCities(in, visited, minReorder);
            }
        }
    }

    private static class City {
        List<City> outgoing;
        List<City> incoming;
        int id;

        public City(int id) {
            this.id = id;
            outgoing = new ArrayList<>();
            incoming = new ArrayList<>();
        }

        private void addOutgoingConnection(City city) {
            outgoing.add(city);
        }

        private void addIncomingConnection(City city) {
            incoming.add(city);
        }
    }
}
