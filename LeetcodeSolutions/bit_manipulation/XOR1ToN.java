package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 18: Find XOR from 1 to N
 * 
 * Problem Statement:
 * Given an integer n, calculate the XOR sum of all integers from 1 to n.
 * 
 * Sample Input:
 * 4
 * Sample Output:
 * XOR sum: 4 (1^2^3^4 = 4)
 * 
 * Sample Input:
 * 3
 * Sample Output:
 * XOR sum: 0 (1^2^3 = 0)
 * 
 * Approach: Pattern Observation
 * n % 4 == 0: Result = n
 * n % 4 == 1: Result = 1
 * n % 4 == 2: Result = n + 1
 * n % 4 == 3: Result = 0
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class XOR1ToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        long n = sc.nextLong();
        System.out.println("XOR sum from 1 to " + n + ": " + computeXOR(n));
        sc.close();
    }

    public static long computeXOR(long n) {
        if (n % 4 == 0)
            return n;
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        return 0;
    }
}
