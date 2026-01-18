package tree;

import java.util.*;

public class bstInput {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static Node BST(int arr[]) {
        Node root = null;
        for (int val : arr) {
            root = insert(root, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key > root.data) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }

    }

    public static Node getIS(Node root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node deleteNode(Node root, int val) {
        if (root == null)
            return null;
        if (val < root.data) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.data) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node iS = getIS(root.right);
                root.data = iS.data;
                root.right = deleteNode(root.right, iS.data);

            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of node ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = BST(arr);
        System.out.println("INORDER IS ");

        inorder(root);
        System.out.println();

        System.out.println("Enter key");

        int key = sc.nextInt();

        boolean ans = search(root, key);
        System.out.println(ans);

        System.out.println("Enter Node to be delete ");
        int val = sc.nextInt();

        Node delete = deleteNode(root, val);
        inorder(delete);
        sc.close();
    }
}
