import java.util.*;

/**
 * Problem 1: Two Sum
 * 
 * Input Format:
 * Number of elements n, then n integers, then target k.
 * 
 * Output Format:
 * Indices of the two numbers that add up to target.
 * 
 * Approach: Hashing (HashMap)
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(n) - To store potential values in HashMap.
 * Why Optimal: Reduces the search for the complement to O(1) compared to O(n)
 * in nested loops.
 */
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] result = solve(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
        sc.close();
    }

    public static int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Value -> Index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
