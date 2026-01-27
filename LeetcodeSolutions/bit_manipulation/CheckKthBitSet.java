package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 21: Check if Kth Bit Is Set
 * 
 * Input Format:
 * Number num and bit position k (0-indexed).
 * 
 * Output Format:
 * Boolean (true/false).
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
