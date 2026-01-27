package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 10: Check if Array Can Be Partitioned into Two Equal XOR Subsets
 * 
 * Input Format:
 * n, then n array elements.
 * 
 * Output Format:
 * Boolean (true/false).
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
