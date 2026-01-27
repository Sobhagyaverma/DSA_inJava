package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 19: Find XOR of Given Range [L, R]
 * 
 * Input Format:
 * Integers L and R.
 * 
 * Output Format:
 * L ^ (L+1) ^ ... ^ R.
 * 
 * Approach: Prefix XOR property
 * XOR(L, R) = XOR(1, R) ^ XOR(1, L-1).
 * Use O(1) XOR from 1 to N logic.
 * Time Complexity: O(1)
 */
public class XORRangeLR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter L and R: ");
        long L = sc.nextLong();
        long R = sc.nextLong();

        long result = computeXOR(R) ^ computeXOR(L - 1);
        System.out.println("XOR Sum from " + L + " to " + R + ": " + result);
        sc.close();
    }

    private static long computeXOR(long n) {
        if (n < 0)
            return 0;
        if (n % 4 == 0)
            return n;
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        return 0;
    }
}
