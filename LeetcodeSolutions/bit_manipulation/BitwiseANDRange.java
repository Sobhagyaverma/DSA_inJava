package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 9: Bitwise AND of Numbers Range
 * 
 * Input Format:
 * Left and Right (integers).
 * 
 * Output Format:
 * Bitwise AND of all numbers in the range [left, right].
 * 
 * Approach: Common Prefix
 * For a range of numbers, the bits to the right of the first differing bit
 * between left and right will eventually flip.
 * We shift both numbers right until they meet (common prefix), then shift back.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class BitwiseANDRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter left and right: ");
        int left = sc.nextInt();
        int right = sc.nextInt();

        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        System.out.println("Result: " + (left << shift));
        sc.close();
    }
}
