package greedy_backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
A company is planning to interview 2n people. Given the array costs where 
costs[i] = [aCosti, bCosti], the cost of flying the ith person to city A is aCosti, 
and the cost of flying the ith person to city B is bCosti.
Return the minimum cost to fly every person to a city such that exactly n people 
arrive in each city.

Input Format:
- 2n (total number of people, must be even)
- 2n pairs of integers (costA, costB)

Output Format:
- Minimum total cost

Constraints:
2 * n == costs.length
2 <= costs.length <= 100
costs.length is even.
1 <= aCosti, bCosti <= 1000

Sample Input:
4
10 20
30 200
400 50
30 20
Sample Output:
110 (10 + 30 + 50 + 20 = 110)
*/

public class TwoCityScheduling {
    /**
     * Greedy Choice:
     * 1. Assume everyone goes to City A first. Initial cost = sum(costA[i]).
     * 2. Now we MUST send 'n' people to City B instead.
     * 3. The relative cost change when switching person 'i' from A to B is
     * (costB[i] - costA[i]).
     * 4. To minimize the final cost, we greedily pick the 'n' switches with the
     * smallest
     * (most negative) relative cost change.
     * 
     * Why Optimal:
     * The logic covers all possible outcomes because every person MUST go to
     * exactly one city.
     * By calculating the 'penalty' or 'saving' for each person if sent to B instead
     * of A,
     * and sorting these differences, we find the globally optimal split.
     * 
     * Time Complexity: O(n log n) - Sorting.
     * Space Complexity: O(1) or O(log n).
     */
    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int totalCost = 0;

        // Send everyone to city A initially
        for (int[] cost : costs) {
            totalCost += cost[0];
        }

        // Calculate saving/cost if we switch to city B
        int[] diff = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            diff[i] = costs[i][1] - costs[i][0];
        }

        // Sort differences ascending
        Arrays.sort(diff);

        // Pick the n best switches to City B
        for (int i = 0; i < n; i++) {
            totalCost += diff[i];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total number of people (even):");
        if (!sc.hasNextInt())
            return;
        int total = sc.nextInt();

        int[][] costs = new int[total][2];
        System.out.println("Enter cost to City A and cost to City B for each person:");
        for (int i = 0; i < total; i++) {
            costs[i][0] = sc.nextInt();
            costs[i][1] = sc.nextInt();
        }

        System.out.println("Minimum scheduling cost: " + twoCitySchedCost(costs));
        sc.close();
    }
}
