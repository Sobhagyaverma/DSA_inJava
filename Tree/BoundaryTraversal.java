package tree;

import java.util.*;

public class BoundaryTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(int[] arr, int i) {
        if (i >= arr.length || arr[i] == -1)
            return null;

        Node root = new Node(arr[i]);
        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);
        return root;
    }

    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public static void leftBoundary(Node root) {
        if (root == null || isLeaf(root))
            return;

        System.out.print(root.data + " ");

        if (root.left != null)
            leftBoundary(root.left);
        else
            leftBoundary(root.right);
    }

    public static void rightBoundary(Node root) {
        if (root == null || isLeaf(root))
            return;

        if (root.right != null)
            rightBoundary(root.right);
        else
            rightBoundary(root.left);

        System.out.print(root.data + " ");
    }

    public static void printLeaves(Node root) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            System.out.print(root.data + " ");
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void rightBoundaryTopDown(Node root) {
        if (root == null || isLeaf(root))
            return;

        System.out.print(root.data + " ");

        if (root.right != null)
            rightBoundaryTopDown(root.right);
        else
            rightBoundaryTopDown(root.left);
    }

    public static void leftBoundaryBottomUp(Node root) {
        if (root == null || isLeaf(root))
            return;

        if (root.left != null)
            leftBoundaryBottomUp(root.left);
        else
            leftBoundaryBottomUp(root.right);

        System.out.print(root.data + " ");
    }

    public static void printLeavesRightToLeft(Node root) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            System.out.print(root.data + " ");
            return;
        }
        printLeavesRightToLeft(root.right);
        printLeavesRightToLeft(root.left);
    }

    public static void antiClockwise(Node root) {
        if (root == null)
            return;

        System.out.println("Anti-Clockwise Boundary Traversal:");
        System.out.print(root.data + " ");

        leftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        rightBoundary(root.right);

        System.out.println();
    }

    public static void clockwise(Node root) {
        if (root == null)
            return;

        System.out.println("Clockwise Boundary Traversal:");
        System.out.print(root.data + " ");

        rightBoundaryTopDown(root.right);
        printLeavesRightToLeft(root.right);
        printLeavesRightToLeft(root.left);
        leftBoundaryBottomUp(root.left);

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter node values in array form (-1 for null):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, 0);

        if (root != null) {
            antiClockwise(root);
            clockwise(root);
        }

        sc.close();
    }
}