import java.util.*;

/**
 * Problem 13: Reverse Array In-Place
 * 
 * Input Format:
 * n, then n integers.
 * 
 * Output Format:
 * Reversed array.
 * 
 * Approach: Two Pointers (Start/End)
 * Time Complexity: O(n).
 * Space Complexity: O(1).
 * Why Optimal: In-place swapping until pointers meet at center.
 */
public class ReverseArrayInPlace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        reverse(nums);
        System.out.println("Reversed: " + Arrays.toString(nums));
        sc.close();
    }

    public static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
