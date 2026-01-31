package greedy_backtracking;

import java.util.Scanner;

/*
Problem Statement:
Alice has n balloons arranged on a rope. You are given a 0-indexed string colors 
where colors[i] is the color of the ith balloon.
Alice wants the rope to be colorful. She does not want any two consecutive balloons 
to have the same color, so she asks Bob to remove some balloons from the rope 
until it is colorful. Bob can remove any balloon from the rope with a cost of 
neededTime[i].
Return the minimum cost Bob has to pay to make the rope colorful.

Input Format:
- n (number of balloons)
- s (string representing colors)
- n integers (neededTime array)

Output Format:
- Minimum total cost (integer)

Constraints:
n == colors.length == neededTime.length
1 <= n <= 10^5
1 <= neededTime[i] <= 10^4
colors contains only lowercase English letters.

Sample Input:
7
abaacdb
1 2 3 4 5 6 7
Sample Output:
4 (Removing one 'a' from 'aa', Bob picks the one with min cost, which is 4 or 5? Wait, for 'aa' at indices 2 and 3, costs are 3 and 4. Min is 3. Result: 3)
Wait, sample calculation: 
abaacdb
1 2 3 4 5 6 7
'a' at index 2 and 3 are same. Bob removes one.
Cost(index 2) = 3, Cost(index 3) = 4. 
Bob removes index 2, min cost = 3. 
*/

public class MinTimeRopeColorful {
    /**
     * Greedy Choice:
     * When there is a sequence of consecutive balloons of the same color,
     * we must remove all of them except ONE. To minimize the cost, we should
     * keep the one with the MAXIMUM removal time and remove all others.
     * 
     * Why Optimal:
     * For any cluster of identical consecutive colors, the number of balloons to
     * remove is fixed (cluster_size - 1). The only way to minimize the removal cost
     * is to avoid removing the most expensive balloon in that cluster.
     * 
     * Time Complexity: O(n) - Single pass.
     * Space Complexity: O(1) - Constant auxiliary space.
     */
    public static int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int n = colors.length();

        for (int i = 1; i < n; i++) {
            // Check for consecutive identical colors
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Greedy: remove the cheaper one
                totalCost += Math.min(neededTime[i], neededTime[i - 1]);

                // Update the 'current' balloon in the sequence to be the more expensive one
                // for comparison with the next balloon
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of balloons:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        System.out.println("Enter colors string:");
        String colors = sc.next();

        int[] neededTime = new int[n];
        System.out.println("Enter removal times:");
        for (int i = 0; i < n; i++) {
            neededTime[i] = sc.nextInt();
        }

        System.out.println("Minimum time required: " + minCost(colors, neededTime));
        sc.close();
    }
}
