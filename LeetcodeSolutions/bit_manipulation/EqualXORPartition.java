package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 10: Check if Array Can Be Partitioned into Two Equal XOR Subsets
 * 
 * Problem Statement:
 * Given an array of integers, check if it can be partitioned into two subsets
 * such that the XOR of elements in both subsets is equal.
 * 
 * Sample Input:
 * 4
 * 1 2 3 0
 * Sample Output:
 * Possible: true (Subsets {1,2,3} and {0} both have XOR 0)
 * 
 * Sample Input:
 * 3
 * 1 2 4
 * Sample Output:
 * Possible: false (Total XOR is 7)
 * 
 * Approach: XOR logic
 * If we partition into two subsets A and B, then XOR(A) = XOR(B).
 * Since XOR(A) ^ XOR(B) = TotalXOR, this means XOR(A) ^ XOR(A) = TotalXOR.
 * Thus, TotalXOR must be 0 for such a partition to be possible.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class EqualXORPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Possible: false");
            sc.close();
            return;
        }
        int totalXor = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            totalXor ^= sc.nextInt();
        }

        // If total XOR is 0, we can always find such a partition (except for empty edge
        // cases)
        System.out.println("Can be partitioned: " + (totalXor == 0));
        sc.close();
    }
}
