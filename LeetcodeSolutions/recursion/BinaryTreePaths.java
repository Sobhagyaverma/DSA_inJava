import java.util.*;

/**
 * Problem 21: Binary Tree Paths
 * 
 * Input Format:
 * Level-order traversal of binary tree (use null for empty nodes).
 * Example: 1 2 3 null 5
 * 
 * Output Format:
 * All root-to-leaf paths.
 * 
 * Approach:
 * DFS recursion to traverse all paths from root to leaves.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter level-order traversal (space separated, null for empty):");
        String line = sc.nextLine();
        String[] nodes = line.split("\s+");

        TreeNode root = buildTree(nodes);

        List<String> paths = new ArrayList<>();
        if (root != null)
            findPaths(root, "", paths);

        System.out.println("Tree Paths: " + paths);
        sc.close();
    }

    private static void findPaths(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
            return;
        }

        if (node.left != null)
            findPaths(node.left, path + node.val + "->", paths);
        if (node.right != null)
            findPaths(node.right, path + node.val + "->", paths);
    }

    private static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();

            if (!nodes[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
