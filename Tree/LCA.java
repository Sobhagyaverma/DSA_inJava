package tree;

import java.util.*;

public class LCA {

    static class Node {
        int data;
        Node right;
        Node left;

        Node(int var1) {
            this.data = var1;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(int arr[], int i) {
        if (i >= arr.length || arr[i] == -1)
            return null;

        Node root = new Node(arr[i]);
        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);
        return root;
    }

    public static void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the tree: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements (use -1 for null/empty nodes):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, 0);

        System.out.print("\nLevelOrder Traversal of your tree: ");
        levelOrder(root);
        System.out.println();

        sc.close();
    }
}