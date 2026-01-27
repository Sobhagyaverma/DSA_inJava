package linked_list;

import java.util.Scanner;

/**
 * Problem 19: Add Two Numbers (LeetCode 2)
 * 
 * Input Format:
 * List 1 size and values (digits in reverse order).
 * List 2 size and values (digits in reverse order).
 * 
 * Output Format:
 * Sum as a linked list (digits in reverse order).
 * 
 * Approach: Elementary Addition with Carry
 * We traverse both lists simultaneously, adding corresponding digits plus
 * carry.
 * Create new nodes for the result.
 * 
 * Time Complexity: O(max(m, n))
 * Space Complexity: O(max(m, n)) for the result list.
 * 
 * Why Optimal:
 * It performs addition in a single pass, handling different lengths and carry
 * correctly.
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
