import java.util.*;

/**
 * Problem 12: Move Zeroes
 * 
 * Input Format:
 * n, then n integers.
 * 
 * Output Format:
 * Modified array with zeroes moved to the end.
 * 
 * Approach: Two Pointers (Slow/Fast)
 * Time Complexity: O(n).
 * Space Complexity: O(1).
 * Why Optimal: Moves non-zero elements forward in a single pass without extra
 * array.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        move(nums);
        System.out.println("Result: " + Arrays.toString(nums));
        sc.close();
    }

    public static void move(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0)
                nums[insertPos++] = num;
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
