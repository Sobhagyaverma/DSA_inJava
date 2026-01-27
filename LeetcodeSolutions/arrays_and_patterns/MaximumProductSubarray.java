import java.util.*;

/**
 * Problem 6: Maximum Product Subarray
 * 
 * Input Format:
 * Number of elements n, then n integers.
 * 
 * Output Format:
 * Maximum product of a subarray.
 * 
 * Approach: Kadane's Variation (Tracking Min and Max)
 * Time Complexity: O(n) - Single pass.
 * Space Complexity: O(1) - Constant space.
 * Why Optimal: Since products can flip sign (neg * neg = pos), we track both
 * min and max products at each step.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println("Max Product: " + maxProduct(nums));
        sc.close();
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            maxSoFar = tempMax;
            result = Math.max(result, maxSoFar);
        }
        return result;
    }
}
