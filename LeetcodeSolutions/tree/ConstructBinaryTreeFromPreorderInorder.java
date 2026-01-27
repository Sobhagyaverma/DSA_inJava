package tree;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 9: Construct Binary Tree from Preorder and Inorder Traversal
 * (LeetCode 105)
 *
 * Input Format:
 * n (number of nodes), then n preorder values, then n inorder values.
 *
 * Output Format:
 * Prints level-order traversal of the constructed tree.
 *
 * Approach: Recursive construction using hashmap for inorder indices.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for hashmap and recursion stack.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ConstructBinaryTreeFromPreorderInorder {
    private static int preIndex = 0;
    private static Map<Integer, Integer> inorderMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        System.out.println("Enter preorder values:");
        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();
        System.out.println("Enter inorder values:");
        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();

        inorderMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            inorderMap.put(inorder[i], i);

        TreeNode root = buildTree(preorder, 0, n - 1);
        System.out.println("Constructed tree level-order:");
        printLevelOrder(root);
        sc.close();
    }

    private static TreeNode buildTree(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderMap.get(rootVal);
        root.left = buildTree(preorder, inStart, inIndex - 1);
        root.right = buildTree(preorder, inIndex + 1, inEnd);
        return root;
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                System.out.print("null ");
                continue;
            }
            System.out.print(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        System.out.println();
    }
}
