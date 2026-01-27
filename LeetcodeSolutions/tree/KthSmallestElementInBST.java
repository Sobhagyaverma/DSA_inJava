package tree;

import java.util.Scanner;

/**
 * Problem 23: Kth Smallest Element in a BST (LeetCode 230)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null),
 * followed by k.
 *
 * Output Format:
 * The kth smallest element.
 *
 * Approach: Inorder traversal of BST gives sorted order. Return kth element.
 *
 * Time Complexity: O(n) worst case, O(k) average
 * Space Complexity: O(h) recursion stack.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class KthSmallestElementInBST {
    private static int count = 0;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes (level-order, -1 for null): ");
        int n = sc.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v != -1)
                nodes[i] = new TreeNode(v);
        }
        // Link children
        for (int i = 0; i < n; i++) {
            if (nodes[i] == null)
                continue;
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            if (leftIdx < n)
                nodes[i].left = nodes[leftIdx];
            if (rightIdx < n)
                nodes[i].right = nodes[rightIdx];
        }
        TreeNode root = n > 0 ? nodes[0] : null;

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int kthSmallest = kthSmallest(root, k);
        System.out.println("Kth smallest element: " + kthSmallest);

        sc.close();
    }

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode node, int k) {
        if (node == null)
            return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }
}
