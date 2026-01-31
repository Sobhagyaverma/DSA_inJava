package graph;

import java.util.*;

/*
Problem Statement:
There are n cities connected by some number of flights. You are given an array 
flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight 
from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price 
from src to dst with at most k stops. If there is no such route, return -1.

Input Format:
- n cities
- number of flights f, and f triplets [from, to, price]
- src, dst, k

Output Format:
- Minimum cost.

Constraints:
- 1 <= n <= 100
- 0 <= flights.length <= (n * (n - 1) / 2)
- 0 <= k <= n - 1
*/

public class CheapestFlights_Dijkstra {
    /**
     * Approach: Modified Dijkstra / BFS
     * - We use a PriorityQueue to store [cost, city, stops].
     * BUT standard Dijkstra might fail if a cheaper path has more stops.
     * - A better way here is to use a simple BFS where we keep track of
     * min distance to each node at a specific stop count.
     * - Alternatively, Dijkstra can work if we track the number of stops
     * and only prune if we find a path with both better cost AND fewer stops.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(E * K)
     * - Space Complexity: O(V + E)
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] { f[1], f[2] });
        }

        // minPrice[i] will store the minimum cost to reach city i
        int[] minPrice = new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        minPrice[src] = 0;

        // Queue: {city, currentCost}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { src, 0 });
        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int u = curr[0];
                int currentCost = curr[1];

                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int price = neighbor[1];
                    if (currentCost + price < minPrice[v]) {
                        minPrice[v] = currentCost + price;
                        queue.offer(new int[] { v, minPrice[v] });
                    }
                }
            }
            stops++;
        }

        return (minPrice[dst] == Integer.MAX_VALUE) ? -1 : minPrice[dst];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and number of flights f:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int fCount = sc.nextInt();
        int[][] flights = new int[fCount][3];
        System.out.println("Enter flights (from to price):");
        for (int i = 0; i < fCount; i++) {
            flights[i][0] = sc.nextInt();
            flights[i][1] = sc.nextInt();
            flights[i][2] = sc.nextInt();
        }
        System.out.println("Enter src, dst, and max stops k:");
        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();

        CheapestFlights_Dijkstra solver = new CheapestFlights_Dijkstra();
        System.out.println("Cheapest Price: " + solver.findCheapestPrice(n, flights, src, dst, k));
        sc.close();
    }
}
