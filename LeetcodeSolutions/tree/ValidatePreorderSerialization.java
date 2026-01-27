package tree;

import java.util.Scanner;

/**
 * Problem 21: Validate Preorder Serialization of a Binary Tree (LeetCode 331)
 *
 * Input Format:
 * Preorder serialization string (comma-separated, # for null).
 *
 * Output Format:
 * true if valid serialization, false otherwise.
 *
 * Approach: Use a slot counter. Each node consumes 1 slot and creates 2 slots.
 * Null nodes consume 1 slot. Valid if we end with exactly 0 slots.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ValidatePreorderSerialization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter preorder serialization (comma-separated, # for null): ");
        String preorder = sc.nextLine();

        boolean isValid = isValidSerialization(preorder);
        System.out.println("Is valid serialization? " + isValid);

        sc.close();
    }

    public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1; // Start with one slot for root

        for (String node : nodes) {
            slots--; // Consume a slot

            if (slots < 0) {
                return false; // More nodes than available slots
            }

            if (!node.equals("#")) {
                slots += 2; // Non-null node creates two new slots
            }
        }

        return slots == 0;
    }
}
