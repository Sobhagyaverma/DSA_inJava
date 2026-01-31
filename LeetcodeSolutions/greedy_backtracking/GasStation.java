package greedy_backtracking;

import java.util.Scanner;

/*
Problem Statement:
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station 
to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel 
around the circuit once in the clockwise direction, otherwise return -1. 
If there exists a solution, it is guaranteed to be unique.

Input Format:
- An integer n (number of stations)
- n integers for gas array
- n integers for cost array

Output Format:
- Starting index (0-indexed) or -1

Constraints:
n == gas.length == cost.length
1 <= n <= 10^5
0 <= gas[i], cost[i] <= 10^4

Sample Input:
5
1 2 3 4 5
3 4 5 1 2
Sample Output:
3
*/

public class GasStation {
    /**
     * Greedy Choice:
     * We track the total gas and total cost. If total gas is less than total cost,
     * a complete circuit is impossible (return -1).
     * If total tank is sufficient, we pick a starting point. While traversing,
     * if the current tank becomes negative, the stations before and including
     * the current station cannot be the starting point. We pick the next station
     * as the new potential start.
     * 
     * Why Optimal:
     * 1. If sum(gas) >= sum(cost), a solution must exist.
     * 2. If we start at A and fail at B, no station between A and B can be the
     * start
     * because A reached those stations with some gas left (or zero), so starting
     * there would definitely fail before or at B.
     * 
     * Time Complexity: O(n) - Single pass.
     * Space Complexity: O(1) - constant extra space.
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];

            // If we can't reaches the next station
            if (currentTank < 0) {
                // Greedy move: change start to the next station
                startIndex = i + 1;
                // Reset tank for the new candidate start
                currentTank = 0;
            }
        }

        // Global check: if total gas doesn't cover total cost, no start point works
        return (totalGas < totalCost) ? -1 : startIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of gas stations:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] gas = new int[n];
        int[] cost = new int[n];

        System.out.println("Enter gas values:");
        for (int i = 0; i < n; i++)
            gas[i] = sc.nextInt();

        System.out.println("Enter cost values:");
        for (int i = 0; i < n; i++)
            cost[i] = sc.nextInt();

        int result = canCompleteCircuit(gas, cost);
        if (result == -1) {
            System.out.println("Impossible to complete the circuit.");
        } else {
            System.out.println("Start at station index: " + result);
        }

        sc.close();
    }
}
