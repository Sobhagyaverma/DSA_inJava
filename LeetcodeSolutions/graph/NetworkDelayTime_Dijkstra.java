package graph;

import java.util.*;

/*
Problem Statement:
You are given a network of n nodes, labeled from 1 to n. You are also given 
times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
where ui is the source node, vi is the target node, and wi is the time 
it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the minimum time it takes 
for all the n nodes to receive the signal. If it is impossible for all the n 
nodes to receive the signal, return -1.

Input Format:
- n nodes
- m edges, followed by (u, v, w).
- k (start node)

Output Format:
- Integer time.

Constraints:
- 1 <= n <= 100
- 1 <= times.length <= 6000
*/

public class NetworkDelayTime_Dijkstra {
    /**
     * Approach: Dijkstra's Algorithm (Shortest Path)
     * - Signal propagation time to each node is the shortest path from k to that
     * node.
     * - The time for all nodes to receive it is the maximum of all shortest path
     * distances.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(E log V)
     * - Space Complexity: O(V + E)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] t : times) {
            adj.get(t[0]).add(new int[] { t[1], t[2] });
        }

        // distances array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min-heap PriorityQueue: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, k });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if (d > dist[u])
                continue; // Already found a shorter path

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[] { dist[v], v });
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and number of edges m:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] times = new int[m][3];
        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < m; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
            times[i][2] = sc.nextInt();
        }
        System.out.println("Enter start node k:");
        int k = sc.nextInt();

        NetworkDelayTime_Dijkstra solver = new NetworkDelayTime_Dijkstra();
        System.out.println("Result: " + solver.networkDelayTime(times, n, k));
        sc.close();
    }
}
