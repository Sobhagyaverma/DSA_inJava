import java.util.*;

/**
 * Problem 4: Product of Array Except Self
 * 
 * Input Format:
 * Number of elements n, then n integers.
 * 
 * Output Format:
 * Array where each element at i is product of all others except nums[i].
 * 
 * Approach: Prefix and Suffix Products (Optimal Space)
 * Time Complexity: O(n) - Two passes.
 * Space Complexity: O(1) - (Excluding output array) by using result array for
 * prefix then multiplying suffix.
 * Why Optimal: Solves the problem in linear time without division.
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int[] result = solve(nums);
        System.out.println("Result: " + Arrays.toString(result));
        sc.close();
    }

    public static int[] solve(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Prefix products
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Suffix products (running multiplication)
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}
