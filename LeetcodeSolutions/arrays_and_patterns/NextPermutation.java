import java.util.*;

/**
 * Problem 19: Next Permutation
 * 
 * Input Format:
 * n, then n integers representing a permutation.
 * 
 * Output Format:
 * The lexicographically next greater permutation.
 * 
 * Approach: Pattern Recognition (Find dip, swap, reverse)
 * Time Complexity: O(n).
 * Space Complexity: O(1).
 * Why Optimal: Finds the next permutation in linear time with minimal swaps.
 */
public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter current permutation:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        nextPermutation(nums);
        System.out.println("Next Permutation: " + Arrays.toString(nums));
        sc.close();
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 1. Find the first dip from right
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0) {
            // 2. Find element just larger than nums[i]
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        // 3. Reverse everything after i to get the smallest possible sequence
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
