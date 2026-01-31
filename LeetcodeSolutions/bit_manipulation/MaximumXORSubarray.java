package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 12: Maximum XOR Subarray
 * 
 * Problem Statement:
 * Given an array of integers, find the maximum XOR subarray value in the given
 * array.
 * 
 * Sample Input:
 * 4
 * 1 2 3 4
 * Sample Output:
 * Max XOR Subarray: 7 (3 ^ 4 = 7)
 * 
 * Sample Input:
 * 3
 * 8 1 2
 * Sample Output:
 * Max XOR Subarray: 11 (8 ^ 1 ^ 2 = 11)
 * 
 * Approach: Prefix XOR + Trie
 * XOR of subarray (i, j) is PrefixXOR[j] ^ PrefixXOR[i-1].
 * We use a Trie to find a prefix that maximizes XOR with current prefix.
 * Time Complexity: O(n * 32)
 * Space Complexity: O(n * 32)
 */
class TrieNode {
    TrieNode[] child = new TrieNode[2];
}

public class MaximumXORSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        TrieNode root = new TrieNode();
        insert(root, 0); // Base case for subarrays starting at index 0

        int preXor = 0;
        int maxResult = 0;
        for (int num : nums) {
            preXor ^= num;
            insert(root, preXor);
            maxResult = Math.max(maxResult, getMaxXor(root, preXor));
        }

        System.out.println("Maximum XOR Subarray: " + maxResult);
        sc.close();
    }

    private static void insert(TrieNode root, int val) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (val >> i) & 1;
            if (curr.child[bit] == null)
                curr.child[bit] = new TrieNode();
            curr = curr.child[bit];
        }
    }

    private static int getMaxXor(TrieNode root, int val) {
        TrieNode curr = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (val >> i) & 1;
            if (curr.child[1 - bit] != null) {
                res |= (1 << i);
                curr = curr.child[1 - bit];
            } else {
                curr = curr.child[bit];
            }
        }
        return res;
    }
}
