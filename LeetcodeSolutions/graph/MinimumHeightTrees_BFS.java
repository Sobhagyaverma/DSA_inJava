package graph;

import java.util.*;

/*
Problem Statement:
A tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.
Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
Return a list of all MHTs' root labels.

Input Format:
- n (nodes), and n-1 edges.

Output Format:
- List of root labels.

Constraints:
- 1 <= n <= 2 * 10^4
*/

public class MinimumHeightTrees_BFS {
    /**
     * Approach: Topological Sort (Iterative Removal of Leaves)
     * - The roots of MHTs will be the central nodes of the tree.
     * - We iteratively remove leaves (nodes with degree 1) until 1 or 2 nodes
     * remain.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V) - Each node/edge removed once.
     * - Space Complexity: O(V) - Adjacency list and degree array.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1)
                leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);
                if (adj.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }

        return leaves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int[][] edges = new int[n - 1][2];
        System.out.println("Enter n-1 edges:");
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        MinimumHeightTrees_BFS solver = new MinimumHeightTrees_BFS();
        System.out.println("MHT roots: " + solver.findMinHeightTrees(n, edges));
        sc.close();
    }
}
