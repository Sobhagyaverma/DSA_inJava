package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 24: Find the Element That Appears Odd Number of Times
 * 
 * Input Format:
 * n, then n array elements.
 * 
 * Output Format:
 * The element that appears an odd number of times.
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
