package greedy_backtracking;

import java.util.Scanner;

/*
Problem Statement:
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, 
if you are at nums[i], you can jump to any nums[i + j] where:
0 <= j <= nums[i] and i + j < n.
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Input Format:
- An integer n (size of array)
- n space-separated integers (elements of nums)

Output Format:
- An integer representing the minimum jumps.

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
It is guaranteed that you can reach the last index.

Sample Input:
5
2 3 1 1 4
Sample Output:
2
*/

public class JumpGameII {
    /**
     * Greedy Choice:
     * At each step, we look at the farthest point we can reach from all reachable
     * nodes in the current jump range.
     * We update our jump range to the farthest point found. This ensures we cover
     * maximum distance with each jump.
     * 
     * Why Optimal:
     * By always jumping to the position that allows the farthest reach in the next
     * step,
     * we minimize the total number of jumps needed to reach the end.
     * 
     * Time Complexity: O(n) - Single pass through the array.
     * Space Complexity: O(1) - Using only a few variables for tracking points.
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0; // Edge case: already at the end

        int jumps = 0;
        int currentEnd = 0; // The end of the range reachable with current number of jumps
        int farthest = 0; // The farthest point reachable from current range

        for (int i = 0; i < n - 1; i++) {
            // Update farthest point reachable from the current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump's range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If current jump can already reach the end, we can break early
                if (currentEnd >= n - 1)
                    break;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Minimum jumps required: " + jump(nums));
        sc.close();
    }
}
