package tree;

import java.util.Scanner;

/**
 * Problem 20: Recover Binary Search Tree (LeetCode 99)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null).
 * Note: Two nodes are swapped in the BST.
 *
 * Output Format:
 * Prints the corrected BST in inorder.
 *
 * Approach: Inorder traversal to find two swapped nodes, then swap them back.
 *
 * Time Complexity: O(n)
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

public class RecoverBinarySearchTree {
    private static TreeNode first = null;
    private static TreeNode second = null;
    private static TreeNode prev = null;

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

        System.out.print("Before recovery (inorder): ");
        printInorder(root);
        System.out.println();

        recoverTree(root);

        System.out.print("After recovery (inorder): ");
        printInorder(root);
        System.out.println();

        sc.close();
    }

    public static void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorder(root);

        // Swap the values
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private static void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);

        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;

        inorder(node.right);
    }

    private static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
