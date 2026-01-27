package bit_manipulation;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 14: Count Pairs with Given XOR
 * 
 * Input Format:
 * n, array elements, then target XOR value k.
 * 
 * Output Format:
 * Number of pairs (i, j) such that nums[i] ^ nums[j] = k.
 * 
 * Approach: Hashing
 * a ^ b = k => b = a ^ k.
 * We store counts of elements encountered so far.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class CountPairsWithXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.print("Enter target XOR: ");
        int k = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int complement = num ^ k;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println("Total Pairs: " + count);
        sc.close();
    }
}
