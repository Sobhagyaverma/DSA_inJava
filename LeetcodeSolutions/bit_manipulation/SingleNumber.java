package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 1: Single Number (LeetCode 136)
 * 
 * Problem Statement:
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * Sample Input:
 * 3
 * 2 2 1
 * Sample Output:
 * 1
 * 
 * Sample Input:
 * 5
 * 4 1 2 1 2
 * Sample Output:
 * 4
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
