package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 23: Count Total Set Bits from 1 to N
 * 
 * Problem Statement:
 * Given a positive integer n, count the total number of set bits in all
 * integers from 1 to n.
 * 
 * Sample Input:
 * 4
 * Sample Output:
 * Total Set Bits: 5 (1:1, 2:10, 3:11, 4:100. Total = 1+1+2+1=5)
 * 
 * Sample Input:
 * 17
 * Sample Output:
 * Total Set Bits: 35
 * 
 * Approach: Bitwise Position Observation
 * At bit position i (starting from 0), bits alternate between 0 and 1 every 2^i
 * positions.
 * Number of complete pairs of (0s, 1s) is (n + 1) / 2^(i + 1).
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class TotalSetBits1ToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Total Set Bits from 1 to " + n + ": " + countSetBits(n));
        sc.close();
    }

    public static int countSetBits(int n) {
        n++; // Adjust n to make range [0, n]
        int count = 0;
        int powerOf2 = 2; // Start with bit 0 (alternates every 1 position, so group size 2)

        for (int i = 0; i < 31; i++) {
            // Count full groups of (0s followed by 1s)
            int fullGroups = n / powerOf2;
            count += fullGroups * (powerOf2 / 2);

            // Count remaining 1s in the last partial group
            int remainder = n % powerOf2;
            if (remainder > powerOf2 / 2) {
                count += remainder - (powerOf2 / 2);
            }

            // Check overflow or break if powerOf2 > n
            if (powerOf2 > n)
                break;
            powerOf2 <<= 1;
        }
        return count;
    }
}
