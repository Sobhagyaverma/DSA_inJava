package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 4: Find the Missing Number (LeetCode 268)
 * 
 * Problem Statement:
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 * 
 * Sample Input:
 * 3
 * 3 0 1
 * Sample Output:
 * missing number: 2
 * 
 * Sample Input:
 * 2
 * 0 1
 * Sample Output:
 * missing number: 2
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
