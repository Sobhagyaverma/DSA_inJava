package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 8: Maximum XOR of Two Numbers in an Array
 * 
 * Input Format:
 * n, then n integers.
 * 
 * Output Format:
 * Maximum XOR value of any pair (nums[i], nums[j]).
 * 
 * Approach: Bitwise Trie
 * We insert each number into a Trie bit by bit (from MSB to LSB).
 * For each number, we try to traverse the Trie by picking the opposite bit to
 * maximize XOR.
 * Time Complexity: O(n * 32)
 * Space Complexity: O(n * 32)
 */
class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

public class MaximumXORPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        TrieNode root = new TrieNode();
        for (int num : nums)
            insert(root, num);

        int maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, getMaxXOR(root, num));
        }

        System.out.println("Maximum XOR: " + maxResult);
        sc.close();
    }

    private static void insert(TrieNode root, int num) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr.children[bit] = curr.children[bit];
            curr = curr.children[bit];
        }
    }

    private static int getMaxXOR(TrieNode root, int num) {
        TrieNode curr = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;
            if (curr.children[opposite] != null) {
                maxXor |= (1 << i);
                curr = curr.children[opposite];
            } else {
                curr = curr.children[bit];
            }
        }
        return maxXor;
    }
}
