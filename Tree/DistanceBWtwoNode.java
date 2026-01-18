package tree;

import java.util.*;

public class DistanceBWtwoNode {
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

    public static Node lowestCA(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q)
            return root;

        Node left = lowestCA(root.left, p, q);
        Node right = lowestCA(root.right, p, q);

        if (left == null)
            return right;
        if (right == null)
            return left;

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist != -1) {
            return leftDist + 1;
        }
        if (rightDist != -1) {
            return rightDist + 1;
        }

        return -1;
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lowestCA(root, n1, n2);

        if (lca == null)
            return -1;

        int d1 = lcaDist(lca, n1);
        int d2 = lcaDist(lca, n2);

        return d1 + d2;
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

        System.out.println("\nEnter the value of p and q:");
        int p = sc.nextInt();
        int q = sc.nextInt();

        int distance = minDist(root, p, q);

        if (distance == -1) {
            System.out.println("One or both nodes not found in the tree.");
        } else {
            System.out.println("Minimum distance between " + p + " and " + q + " is: " + distance);
        }

        sc.close();
    }
}