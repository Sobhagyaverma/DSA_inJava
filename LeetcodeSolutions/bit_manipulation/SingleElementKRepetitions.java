package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 16: Find Element Occurring Once When Others Appear K Times
 * 
 * Input Format:
 * n, array elements, then value k.
 * 
 * Output Format:
 * The single element appearing once.
 * 
 * Approach: Bit Counting
 * Count total set bits at each of the 32 positions.
 * At each position, sum % k will give the bit of the single element.
 * Time Complexity: O(32 * n)
 * Space Complexity: O(1)
 */
public class SingleElementKRepetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.print("Enter repetitions k: ");
        int k = sc.nextInt();

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) != 0)
                    count++;
            }
            if (count % k != 0) {
                result |= (1 << i);
            }
        }
        System.out.println("Single Element: " + result);
        sc.close();
    }
}
