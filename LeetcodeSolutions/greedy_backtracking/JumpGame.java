package greedy_backtracking;

import java.util.Scanner;

/*
Problem Statement:
You are given an integer array nums. You are initially positioned at the array's first index, 
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Input Format:
- n (size of array)
- n integers

Output Format:
- Boolean (true/false)

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5

Sample Input:
5
2 3 1 1 4
Sample Output:
true
*/

public class JumpGame {
    /**
     * Greedy Choice:
     * At each step, keep track of the maximum index reachable so far.
     * If at any point the current index is greater than the maximum reachable
     * index,
     * it means we have reached a dead end.
     * 
     * Why Optimal:
     * We only care about the farthest we can reach. If we can reach index 'i',
     * we can reach any index '< i'. So tracking the global max reach is sufficient.
     * 
     * Time Complexity: O(n) - Single pass.
     * Space Complexity: O(1) - One variable.
     */
    public static boolean canJump(int[] nums) {
        int maxReachable = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If current index is not reachable, return false
            if (i > maxReachable)
                return false;

            // Update the global maximum reachable index
            maxReachable = Math.max(maxReachable, i + nums[i]);

            // If we can already reach the end, success!
            if (maxReachable >= n - 1)
                return true;
        }

        return maxReachable >= n - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter jump lengths:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Can reach the end: " + canJump(nums));
        sc.close();
    }
}
