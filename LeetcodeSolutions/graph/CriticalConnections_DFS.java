package graph;

import java.util.*;

/*
Problem Statement:
There are n servers numbered from 0 to n - 1 connected by undirected 
server-to-server connections forming a network where 
connections[i] = [ai, bi] represents a connection between servers ai and bi.
Any server can reach other servers directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers 
unable to reach some other server. 
Return all critical connections in the network in any order.

Input Format:
- n
- m connections

Output Format:
- List of critical edges [u, v].

Constraints:
- 2 <= n <= 10^5
- n - 1 <= connections.length <= 10^5
*/

public class CriticalConnections_DFS {
    /**
     * Approach: Tarjan's Bridge-Finding Algorithm (DFS)
     * - We use two arrays: discoveryTime and lowLinkValue.
     * - discoveryTime[u] is the time at which node u was visited during DFS.
     * - lowLinkValue[u] is the minimum discovery time reachable from u
     * (including itself and back-edges).
     * - An edge (u, v) is a bridge if discoveryTime[u] < lowLinkValue[v].
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V + E)
     * - Space Complexity: O(V + E) for adjacency list and arrays.
     */
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (List<Integer> c : connections) {
            adj.get(c.get(0)).add(c.get(1));
            adj.get(c.get(1)).add(c.get(0));
        }

        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, -1, adj, disc, low, result);
            }
        }
        return result;
    }

    private void dfs(int u, int p, List<List<Integer>> adj, int[] disc, int[] low, List<List<Integer>> res) {
        disc[u] = low[u] = ++time;
        for (int v : adj.get(u)) {
            if (v == p)
                continue; // Skip parent edge
            if (disc[v] == -1) {
                // Not visited
                dfs(v, u, adj, disc, low, res);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and number of connections m:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> connections = new ArrayList<>();
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < m; i++) {
            connections.add(Arrays.asList(sc.nextInt(), sc.nextInt()));
        }

        CriticalConnections_DFS solver = new CriticalConnections_DFS();
        System.out.println("Critical connections: " + solver.criticalConnections(n, connections));
        sc.close();
    }
}
