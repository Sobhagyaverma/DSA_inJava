package greedy_backtracking;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Problem Statement:
There are n workers. You are given two integer arrays quality and wage where quality[i] 
is the quality of the ith worker and wage[i] is the minimum reasonable starting wage for the ith worker.
You want to hire exactly k workers to form a paid group. To hire a group of k workers, 
you must pay them according to the following rules:
1. Every worker in the paid group should be paid in the ratio of their quality compared 
   to other workers in the paid group.
2. Every worker in the paid group must be paid at least their minimum reasonable starting wage.
Return the least amount of money needed to form a paid group satisfying the above conditions.

Input Format:
- n (number of workers)
- n qualities (integers)
- n wages (integers)
- k (number of workers to hire)

Output Format:
- Minimum cost (double)

Constraints:
n == quality.length == wage.length
1 <= k <= n <= 10^4
1 <= quality[i], wage[i] <= 10^4

Sample Input:
3
10 20 5
70 50 30
2
Sample Output:
105.0
*/

public class MinCostHireKWorkers {
    /**
     * Greedy Choice:
     * For any hired worker i, their actual wage will be totalQuality * ratio_i,
     * where ratio_i = wage_i / quality_i.
     * To satisfy the k workers, we must pick at least one worker's ratio to be
     * the base ratio. All other workers will be paid based on this ratio.
     * To satisfy rule #2, the base ratio must be the MAXIMUM ratio among the k
     * selected workers.
     * 1. Sort workers by their ratio (wage/quality).
     * 2. Iterate through workers, maintaining a Max-Heap of the k lowest qualities.
     * 3. Total cost = current_ratio * sum_of_k_lowest_qualities.
     * 
     * Why Optimal:
     * Sorting by ratio ensures that for each worker i, we consider them as the
     * bottleneck ratio.
     * Using a max-heap of qualities allows us to always keep the k smallest
     * qualities,
     * which minimizes the total sum for any given ratio.
     * 
     * Time Complexity: O(n log n) - Sorting plus heap operations.
     * Space Complexity: O(n) - To store worker objects and heap.
     */
    static class Worker {
        int q, w;
        double ratio;

        Worker(int q, int w) {
            this.q = q;
            this.w = w;
            this.ratio = (double) w / q;
        }
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        // Sort by ratio ASC
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));

        // Max-heap to store qualities of hired workers
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int qualitySum = 0;
        double minCost = Double.MAX_VALUE;

        for (Worker worker : workers) {
            pq.offer(worker.q);
            qualitySum += worker.q;

            // If we have more than k workers, remove the one with highest quality
            if (pq.size() > k) {
                qualitySum -= pq.poll();
            }

            // If we have exactly k workers
            if (pq.size() == k) {
                // Since workers are sorted by ratio, current worker's ratio is the max
                minCost = Math.min(minCost, (double) qualitySum * worker.ratio);
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of workers:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] quality = new int[n];
        int[] wage = new int[n];

        System.out.println("Enter qualities:");
        for (int i = 0; i < n; i++)
            quality[i] = sc.nextInt();

        System.out.println("Enter wages:");
        for (int i = 0; i < n; i++)
            wage[i] = sc.nextInt();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        System.out.printf("Minimum cost to hire %d workers: %.5f\n", k, mincostToHireWorkers(quality, wage, k));
        sc.close();
    }
}
