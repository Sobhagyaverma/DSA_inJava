package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 22: Turn Off the Rightmost Set Bit
 * 
 * Problem Statement:
 * Given an integer n, turn off its rightmost set bit using a bit manipulation
 * trick.
 * 
 * Sample Input:
 * 10
 * Sample Output:
 * Result: 8 (1010 becomes 1000)
 * 
 * Sample Input:
 * 7
 * Sample Output:
 * Result: 6 (0111 becomes 0110)
 * 
 * Approach: Bit Trick
 * n & (n-1) turns off the rightmost set bit.
 * Time Complexity: O(1)
 */
public class TurnOffRightmostBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int result = n & (n - 1);
        System.out.println("Result: " + result);
        sc.close();
    }
}
