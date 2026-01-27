package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 22: Turn Off the Rightmost Set Bit
 * 
 * Input Format:
 * An integer n.
 * 
 * Output Format:
 * The number after turning off the rightmost set bit.
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
