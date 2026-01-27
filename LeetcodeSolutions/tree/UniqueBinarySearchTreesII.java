package tree;

import java.util.*;

/**
 * Problem 19: Unique Binary Search Trees II (LeetCode 95)
 *
 * Input Format:
 * Integer n (number of nodes with values 1 to n).
 *
 * Output Format:
 * Count of structurally unique BSTs and prints one example.
 *
 * Approach: Recursive generation. For each value as root, recursively generate
 * all left and right subtrees and combine them.
 *
 * Time Complexity: Catalan number - exponential
 * Space Complexity: O(n) recursion depth + storage for all trees.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        List<TreeNode> trees = generateTrees(n);
        System.out.println("Number of unique BSTs: " + trees.size());

        if (!trees.isEmpty()) {
            System.out.println("Example tree (preorder):");
            printPreorder(trees.get(0));
            System.out.println();
        }

        sc.close();
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generate(1, n);
    }

    private static List<TreeNode> generate(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generate(start, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

    private static void printPreorder(TreeNode node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
