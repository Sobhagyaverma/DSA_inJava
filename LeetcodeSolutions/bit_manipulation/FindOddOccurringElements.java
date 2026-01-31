package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 24: Find the Element That Appears Odd Number of Times
 * 
 * Problem Statement:
 * Given an array of n elements, every element appears an even number of times
 * except for one element. Find that single odd-occurring element.
 * 
 * Sample Input:
 * 5
 * 1 2 3 2 1
 * Sample Output:
 * Odd Occurring: 3
 * 
 * Sample Input:
 * 3
 * 8 8 8
 * Sample Output:
 * Odd Occurring: 8
 * 
 * Approach: XOR
 * XOR of all elements is result.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FindOddOccurringElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int res = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            res ^= sc.nextInt();
        System.out.println("Odd occurring element: " + res);
        sc.close();
    }
}
