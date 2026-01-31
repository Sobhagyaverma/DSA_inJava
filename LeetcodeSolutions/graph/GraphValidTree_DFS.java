package graph;

import java.util.*;

/*
Problem Statement:
Given n nodes labeled from 0 to n - 1 and a list of undirected edges, 
write a function to check whether these edges make up a valid tree.

A valid tree must:
1. Be connected.
2. Have no cycles.
3. Have exactly n - 1 edges for n nodes.

Input Format:
- n (number of nodes)
- e (number of edges)
- e pairs representing edges

Output Format:
- Boolean (true/false)

Constraints:
- 1 <= n <= 2000
*/

public class GraphValidTree_DFS {
    /**
     * Logic:
     * - A tree with n nodes must have exactly n-1 edges. If not, return false.
     * - Check if all nodes are connected using DFS starting from 0.
     * - If nodes visited == n, it's connected and (as edges = n-1) contains no
     * cycles.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V + E)
     * - Space Complexity: O(V + E)
     */
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();
        dfs(0, adj, visited);

        return visited.size() == n;
    }

    private void dfs(int curr, List<List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(curr))
            return;
        visited.add(curr);
        for (int neighbor : adj.get(curr)) {
            dfs(neighbor, adj, visited);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and number of edges:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int eCount = sc.nextInt();

        int[][] edges = new int[eCount][2];
        System.out.println("Enter edges:");
        for (int i = 0; i < eCount; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        GraphValidTree_DFS solver = new GraphValidTree_DFS();
        System.out.println("Is valid tree: " + solver.validTree(n, edges));
        sc.close();
    }
}
