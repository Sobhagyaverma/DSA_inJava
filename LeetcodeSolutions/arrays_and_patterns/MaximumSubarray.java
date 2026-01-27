import java.util.*;

/**
 * Problem 5: Maximum Subarray
 * 
 * Input Format:
 * Number of elements n, then n integers.
 * 
 * Output Format:
 * Sum of the maximum subarray.
 * 
 * Approach: Kadane's Algorithm
 * Time Complexity: O(n) - Single pass.
 * Space Complexity: O(1) - Constant space.
 * Why Optimal: It solves the problem by deciding at each index whether to
 * extend the previous subarray or start fresh.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println("Max Subarray Sum: " + maxSubArray(nums));
        sc.close();
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
}
