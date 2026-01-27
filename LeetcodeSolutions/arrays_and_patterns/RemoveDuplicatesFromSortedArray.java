import java.util.*;

/**
 * Problem 11: Remove Duplicates from Sorted Array
 * 
 * Input Format:
 * n, then n sorted integers.
 * 
 * Output Format:
 * k (unique elements) and the modified array leading elements.
 * 
 * Approach: Two Pointers (In-place)
 * Time Complexity: O(n).
 * Space Complexity: O(1).
 * Why Optimal: Modifies the array without extra space while iterating once.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int k = removeDuplicates(nums);
        System.out.println("Unique count: " + k);
        System.out.print("Modified array: [");
        for (int i = 0; i < k; i++)
            System.out.print(nums[i] + (i < k - 1 ? ", " : ""));
        System.out.println("]");
        sc.close();
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex++] = nums[i];
            }
        }
        return insertIndex;
    }
}
