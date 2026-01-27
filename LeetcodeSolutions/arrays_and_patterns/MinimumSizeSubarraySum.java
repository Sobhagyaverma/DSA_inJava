import java.util.*;

/**
 * Problem 15: Minimum Size Subarray Sum
 * 
 * Input Format:
 * n, then n positive integers, then target k.
 * 
 * Output Format:
 * Minimum length of a contiguous subarray of which the sum >= target.
 * 
 * Approach: Sliding Window (Two Pointers)
 * Time Complexity: O(n) - Each pointer moves at most n times.
 * Space Complexity: O(1).
 * Why Optimal: Efficiently expands and shrinks window to find the smallest
 * range meeting the condition.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter positive integers:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Minimum length: " + minSubArrayLen(target, nums));
        sc.close();
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int left = 0, sum = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
