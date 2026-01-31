package graph;

import java.util.*;

/*
Problem Statement:
Given n nodes in an undirected graph and an array of edges, return the total 
number of connected components.

Input Format:
- n, followed by number of edges e, and e pairs.

Output Format:
- Integer component count.

Constraints:
- 1 <= n <= 2000
*/

public class ConnectedComponents_DFS {
    /**
     * Approach: DFS
     * - We traverse the graph node by node. If a node hasn't been visited,
     * it's part of a new component.
     * - Use DFS to visit all nodes in that component.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V + E)
     * - Space Complexity: O(V + E)
     */
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }

    private void dfs(int curr, List<List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and edge count:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int e = sc.nextInt();

        int[][] edges = new int[e][2];
        System.out.println("Enter edges:");
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        ConnectedComponents_DFS solver = new ConnectedComponents_DFS();
        System.out.println("Count: " + solver.countComponents(n, edges));
        sc.close();
    }
}
