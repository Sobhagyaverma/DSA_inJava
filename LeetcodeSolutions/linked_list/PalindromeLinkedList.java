package linked_list;

import java.util.Scanner;

/**
 * Problem 7: Palindrome Linked List (LeetCode 234)
 * 
 * Input Format:
 * Number of nodes n, followed by n values.
 * 
 * Output Format:
 * Boolean indicating if the list is a palindrome.
 * 
 * Approach: Reverse Second Half
 * 1. Use slow/fast pointers to find the middle.
 * 2. Reverse the second half of the list.
 * 3. Compare the first half and the reversed second half.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Why Optimal:
 * It checks the palindrome property in linear time using constant extra space.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        System.out.println("Is Palindrome: " + isPalindrome(dummy.next));

        sc.close();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalfHead = reverse(slow.next);

        // 3. Compare
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean result = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional: restore list would be here
        return result;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
