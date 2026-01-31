package bit_manipulation;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 14: Count Pairs with Given XOR
 * 
 * Problem Statement:
 * Given an array nums and an integer k, count the number of pairs (i, j) such
 * that i < j and nums[i] ^ nums[j] = k.
 * 
 * Sample Input:
 * 4
 * 1 2 1 2
 * 0
 * Sample Output:
 * Pairs: 2 ([1,1] and [2,2])
 * 
 * Sample Input:
 * 4
 * 5 4 10 15
 * 1
 * Sample Output:
 * Pairs: 1 ([4,5])
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
