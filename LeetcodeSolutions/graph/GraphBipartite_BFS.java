package graph;

import java.util.*;

/*
Problem Statement:
There is an undirected graph with n nodes, where each node is numbered from 0 to n - 1. 
You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B 
such that every edge in the graph connects a node in set A and a node in set B.
Return true if and only if it is bipartite.

Input Format:
- n (nodes)
- n lines describing adjacents for each node.

Output Format:
- Boolean.

Constraints:
- 1 <= n <= 100
- graph[u] does not contain u.
- All edges are undirected.
*/

public class GraphBipartite_BFS {
    /**
     * Approach: Graph Coloring (BFS)
     * - A graph is bipartite if we can color it using 2 colors such that no two
     * adjacent nodes have the same color.
     * - Use an integer array 'colors' where 0=uncolored, 1=Red, -1=Blue.
     * - For each uncolored node, start a BFS and color it's neighbors with
     * the opposite color. If we find an adjacent node with the SAME color,
     * the graph is not bipartite.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V + E)
     * - Space Complexity: O(V)
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: uncolored, 1: red, -1: blue

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0)
                continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : graph[curr]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[curr];
                        queue.offer(next);
                    } else if (colors[next] == colors[curr]) {
                        return false; // Conflict found
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        int[][] graph = new int[n][];
        System.out.println("For each node, enter its neighbors separated by space (one line per node):");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                graph[i] = new int[0];
            } else {
                String[] parts = line.split("\\s+");
                graph[i] = new int[parts.length];
                for (int j = 0; j < parts.length; j++) {
                    graph[i][j] = Integer.parseInt(parts[j]);
                }
            }
        }

        GraphBipartite_BFS solver = new GraphBipartite_BFS();
        System.out.println("Is Bipartite: " + solver.isBipartite(graph));
        sc.close();
    }
}
