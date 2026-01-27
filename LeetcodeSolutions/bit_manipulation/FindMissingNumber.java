package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 4: Find the Missing Number
 * 
 * Input Format:
 * n, then n integers from 0 to n with one missing.
 * 
 * Output Format:
 * The missing number.
 * 
 * Approach: XOR
 * XOR of all elements in array ^ XOR of all numbers from 0 to n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FindMissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (max value): ");
        int n = sc.nextInt();
        int xorTotal = 0;
        // XOR numbers from 0 to n
        for (int i = 0; i <= n; i++)
            xorTotal ^= i;

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            xorTotal ^= sc.nextInt();
        }
        System.out.println("Missing Number: " + xorTotal);
        sc.close();
    }
}
