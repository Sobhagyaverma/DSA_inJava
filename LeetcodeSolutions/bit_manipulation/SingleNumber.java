package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 1: Single Number
 * 
 * Input Format:
 * Number of elements n, then n integers where every element appears twice
 * except for one.
 * 
 * Output Format:
 * The single number that appears only once.
 * 
 * Approach: XOR Bitwise Operation
 * Property: a ^ a = 0 and a ^ 0 = a.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SingleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int res = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            res ^= sc.nextInt();
        }
        System.out.println("Single Number: " + res);
        sc.close();
    }
}
