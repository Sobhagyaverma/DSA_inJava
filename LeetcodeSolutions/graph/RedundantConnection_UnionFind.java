package graph;

import java.util.*;

/*
Problem Statement:
In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n, 
with one additional edge added. The added edge connects two different vertices 
and was not an edge that already existed. The resulting graph is given as a 
2D array of edges.
Return an edge that can be removed so that the resulting graph is a tree 
of n nodes. If there are multiple answers, return the answer that occurs 
last in the input.

Input Format:
- n edges (pairs of nodes)

Output Format:
- The redundant edge [u, v].

Constraints:
- 3 <= n <= 1000
*/

public class RedundantConnection_UnionFind {
    /**
     * Approach: Union-Find
     * - We process edges one by one and keep merging the components.
     * - If we encounter an edge [u, v] where u and v are already in the same
     * component (find(u) == find(v)), then this edge is redundant.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(N * α(N))
     * - Space Complexity: O(N)
     */
    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++)
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
                return true;
            }
            return false;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) {
                return e; // Redundant edge found
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of edges (n):");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int[][] edges = new int[n][2];
        System.out.println("Enter edges:");
        for (int i = 0; i < n; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        RedundantConnection_UnionFind solver = new RedundantConnection_UnionFind();
        int[] res = solver.findRedundantConnection(edges);
        System.out.println("Redundant edge: [" + res[0] + ", " + res[1] + "]");
        sc.close();
    }
}
