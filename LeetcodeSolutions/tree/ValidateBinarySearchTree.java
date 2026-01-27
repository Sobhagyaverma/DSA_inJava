package tree;

import java.util.Scanner;

/**
 * Problem 5: Validate Binary Search Tree (LeetCode 98)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null).
 *
 * Output Format:
 * true if the tree satisfies BST properties, false otherwise.
 *
 * Approach: In‑order traversal – the values must be strictly increasing.
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

public class ValidateBinarySearchTree {
    private static Integer prev = null;

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
        // link children
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
        System.out.println("Is valid BST? " + isValidBST(root));
        sc.close();
    }

    public static boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private static boolean inorder(TreeNode node) {
        if (node == null)
            return true;
        if (!inorder(node.left))
            return false;
        if (prev != null && node.val <= prev)
            return false;
        prev = node.val;
        return inorder(node.right);
    }
}
