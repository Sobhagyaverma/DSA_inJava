package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 21: Check if Kth Bit Is Set
 * 
 * Problem Statement:
 * Given a number num and a bit position k (0-indexed), check if the k-th bit of
 * the number is set (1) or not (0).
 * 
 * Sample Input:
 * 5 2
 * Sample Output:
 * true (5 in binary is 101, 2nd bit is set)
 * 
 * Sample Input:
 * 5 1
 * Sample Output:
 * false (5 in binary is 101, 1st bit is not set)
 * 
 * Approach: Bit Shifting
 * (num >> k) & 1 results in 1 if bit is set.
 * Time Complexity: O(1)
 */
public class CheckKthBitSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number and k: ");
        int num = sc.nextInt();
        int k = sc.nextInt();

        boolean isSet = ((num >> k) & 1) == 1;
        System.out.println("Is " + k + "-th bit set? " + isSet);
        sc.close();
    }
}
