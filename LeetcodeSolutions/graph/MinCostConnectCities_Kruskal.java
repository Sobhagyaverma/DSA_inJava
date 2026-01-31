package graph;

import java.util.*;

/*
Problem Statement:
There are n cities labeled from 1 to n. You are given connections where 
connections[i] = [city1i, city2i, costi] indicates that the cost of connecting 
city1i and city2i is costi. Return the minimum cost to connect all cities such 
that there is at least one path between each pair of cities. 
If it is impossible to connect all n cities, return -1.

Input Format:
- n cities
- m connections, followed by triplets [u, v, cost].

Output Format:
- Minimum cost or -1.

Constraints:
- 1 <= n <= 10^4
- 1 <= connections.length <= 10^4
*/

public class MinCostConnectCities_Kruskal {
    /**
     * Approach: Kruskal's Algorithm (Minimum Spanning Tree)
     * - Sort all connections (edges) by cost.
     * - Use Union-Find to pick the smallest edges that don't form a cycle.
     * - A tree with n nodes must have exactly n-1 edges.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(E log E) - sorting edges.
     * - Space Complexity: O(V) for Union-Find.
     */
    static class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n + 1];
            count = n;
            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }

        int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count--;
                return true;
            }
            return false;
        }
    }

    public int minimumCost(int n, int[][] connections) {
        // Sort by cost ASC
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int edgesUsed = 0;

        for (int[] c : connections) {
            if (uf.union(c[0], c[1])) {
                totalCost += c[2];
                edgesUsed++;
            }
        }

        return (edgesUsed == n - 1) ? totalCost : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of cities n:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        System.out.println("Enter number of connections m:");
        int m = sc.nextInt();
        int[][] connections = new int[m][3];
        System.out.println("Enter connections (u v cost):");
        for (int i = 0; i < m; i++) {
            connections[i][0] = sc.nextInt();
            connections[i][1] = sc.nextInt();
            connections[i][2] = sc.nextInt();
        }

        MinCostConnectCities_Kruskal solver = new MinCostConnectCities_Kruskal();
        System.out.println("Result: " + solver.minimumCost(n, connections));
        sc.close();
    }
}
