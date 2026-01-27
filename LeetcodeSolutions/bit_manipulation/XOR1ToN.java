package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 18: Find XOR from 1 to N
 * 
 * Input Format:
 * Integer n.
 * 
 * Output Format:
 * 1 ^ 2 ^ 3 ^ ... ^ n.
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
