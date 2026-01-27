package tree;

import java.util.Scanner;

/**
 * Problem 14: Lowest Common Ancestor of a BST (LeetCode 235)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null),
 * followed by two node values p and q.
 *
 * Output Format:
 * Value of the lowest common ancestor.
 *
 * Approach: Use BST property - if both p and q are less than root, go left;
 * if both are greater, go right; otherwise root is LCA.
 *
 * Time Complexity: O(h) where h is height.
 * Space Complexity: O(1) iterative or O(h) recursive.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestorBST {
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

        System.out.print("Enter values of p and q: ");
        int pVal = sc.nextInt();
        int qVal = sc.nextInt();

        TreeNode lca = lowestCommonAncestor(root, pVal, qVal);
        System.out.println("LCA: " + (lca != null ? lca.val : "null"));
        sc.close();
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        while (root != null) {
            if (p < root.val && q < root.val) {
                root = root.left;
            } else if (p > root.val && q > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
