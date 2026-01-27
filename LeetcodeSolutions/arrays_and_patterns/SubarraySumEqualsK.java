import java.util.*;

/**
 * Problem 14: Subarray Sum Equals K
 * 
 * Input Format:
 * n, then n integers, then target k.
 * 
 * Output Format:
 * Count of subarrays that sum to k.
 * 
 * Approach: Prefix Sum + Hashing
 * Time Complexity: O(n).
 * Space Complexity: O(n).
 * Why Optimal: Allows checking if prefixSum - k exists in O(1) time.
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Number of subarrays: " + subarraySum(nums, k));
        sc.close();
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: prefix sum of 0 appears once

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
