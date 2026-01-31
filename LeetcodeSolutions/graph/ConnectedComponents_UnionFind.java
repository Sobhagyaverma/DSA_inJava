package graph;

import java.util.Scanner;

/*
Problem Statement:
Given n nodes and undirected edges, find the number of connected components.

Input Format:
- n, edge count, followed by edges.

Output Format:
- Integer answer.
*/

public class ConnectedComponents_UnionFind {
    /**
     * Approach: Union-Find
     * - Initialize 'count' of components to n.
     * - For each edge, if it connects two different components, decrement 'count'.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(E * α(V))
     * - Space Complexity: O(V)
     */
    static class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count--;
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        return uf.count;
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
        ConnectedComponents_UnionFind solver = new ConnectedComponents_UnionFind();
        System.out.println("Result: " + solver.countComponents(n, edges));
        sc.close();
    }
}
