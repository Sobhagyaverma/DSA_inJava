package graph;

import java.util.Scanner;

/*
Problem Statement:
Given n nodes and undirected edges, check if it forms a valid tree.

Input Format:
- n, number of edges, followed by edges.

Output Format:
- Boolean.

Constraints:
- Requirements: 1 connected component and no cycles.
*/

public class GraphValidTree_UnionFind {
    /**
     * Approach: Union-Find with Path Compression & Union by Rank
     * - A valid tree must have n-1 edges.
     * - Each edge added must connect two previously disconnected components.
     * If find(p) == find(q), the edge forms a cycle.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(E * α(V)), where α is the inverse Ackermann function.
     * - Space Complexity: O(V) for the parent and rank arrays.
     */
    static class UnionFind {
        int[] parent;
        int[] rank;
        int components;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]); // Path compression
        }

        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                // Union by rank
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootI] = rootJ;
                    rank[rootJ]++;
                }
                components--;
                return true;
            }
            return false; // Cycle detected
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1]))
                return false; // Cycle
        }
        return uf.components == 1; // Connected
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and edge count:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int e = sc.nextInt();

        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        GraphValidTree_UnionFind solver = new GraphValidTree_UnionFind();
        System.out.println("Result: " + solver.validTree(n, edges));
        sc.close();
    }
}
