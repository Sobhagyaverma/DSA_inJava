package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 20: Count Number of Bits to Flip to Convert A to B (LeetCode 461)
 * 
 * Problem Statement:
 * Given two integers A and B, return the number of bits you would need to flip
 * to convert A to B.
 * 
 * Sample Input:
 * 10 20
 * Sample Output:
 * Flipped Bits: 4
 * 
 * Sample Input:
 * 7 10
 * Sample Output:
 * Flipped Bits: 3
 * 
 * Approach: Hamming Distance
 * XOR A and B to get set bits where they differ, then count set bits.
 * Time Complexity: O(log N) or O(set bits)
 * Space Complexity: O(1)
 */
public class BitsToFlipAB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A and B: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int diff = a ^ b;
        int count = 0;
        // Count set bits in diff
        while (diff != 0) {
            diff &= (diff - 1); // Turn off rightmost set bit
            count++;
        }
        System.out.println("Bits to flip: " + count);
        sc.close();
    }
}
