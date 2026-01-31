package greedy_backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Input Format:
- n (number of children)
- n ratings (integers)

Output Format:
- Minimum total candies

Constraints:
n == ratings.length
1 <= n <= 2 * 10^4
0 <= ratings[i] <= 2 * 10^4

Sample Input:
3
1 0 2
Sample Output:
5 (Candies: [2, 1, 2])
*/

public class CandyDistribution {
    /**
     * Greedy Choice:
     * We fulfill the 'higher rating than neighbors' condition in two passes:
     * 1. Left to Right: Ensure a child gets more than the left neighbor if their
     * rating is higher.
     * 2. Right to Left: Ensure a child gets more than the right neighbor if their
     * rating is higher.
     * At each step, we make the minimal decision (candies[i] = candies[neighbor] +
     * 1) to satisfy the constraint.
     * 
     * Why Optimal:
     * The two-pass strategy ensures that for every child, the local constraints
     * relative
     * to both neighbors are satisfied with the minimum possible total count.
     * 
     * Time Complexity: O(n) - Two linear passes.
     * Space Complexity: O(n) - To store candy counts for each child.
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;

        int[] candies = new int[n];
        Arrays.fill(candies, 1); // Each child must have at least one

        // Left to Right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Ensure it's more than the right neighbor BUT keeps the L->R constraint
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int c : candies) {
            totalCandies += c;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of children:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] ratings = new int[n];
        System.out.println("Enter ratings:");
        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }

        System.out.println("Minimum candies required: " + candy(ratings));
        sc.close();
    }
}
