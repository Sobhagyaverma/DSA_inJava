package linked_list;

import java.util.Scanner;

/**
 * Problem 19: Add Two Numbers (LeetCode 2)
 * 
 * Problem Statement:
 * You are given two non-empty linked lists representing two non-negative
 * integers.
 * The digits are stored in reverse order, and each of their nodes contains a
 * single digit.
 * Add the two numbers and return the sum as a linked list.
 * 
 * Sample Input:
 * L1: 2 -> 4 -> 3
 * L2: 5 -> 6 -> 4
 * Sample Output:
 * Sum: 7 -> 0 -> 8 (342 + 465 = 807)
 * 
 * Sample Input:
 * L1: 0
 * L2: 0
 * Sample Output:
 * Sum: 0
 * 
 * Approach: Elementary Addition with Carry
 * We traverse both lists simultaneously, adding corresponding digits plus
 * carry.
 * Create new nodes for the result.
 * 
 * Time Complexity: O(max(m, n))
 * Space Complexity: O(max(m, n)) for the result list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of List 1: ");
        int n1 = sc.nextInt();
        ListNode l1 = buildList(sc, n1);

        System.out.print("Enter size of List 2: ");
        int n2 = sc.nextInt();
        ListNode l2 = buildList(sc, n2);

        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);

        ListNode sum = addTwoNumbers(l1, l2);

        System.out.print("Sum: ");
        printList(sum);

        sc.close();
    }

    private static ListNode buildList(Scanner sc, int n) {
        if (n <= 0)
            return null;
        System.out.println("Enter node values:");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
