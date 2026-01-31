package linked_list;

import java.util.Scanner;

/**
 * Problem 8: Intersection of Two Linked Lists (LeetCode 160)
 * 
 * Problem Statement:
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * 
 * Sample Input:
 * Intersect at 8 (Head A: 4-1-8-4-5, Head B: 5-6-1-8-4-5)
 * Sample Output:
 * Intersected at '8'
 * 
 * Sample Input:
 * No Intersection (Head A: 2-6-4, Head B: 1-5)
 * Sample Output:
 * No intersection
 * 
 * Approach: Two Pointers (Switching heads)
 * We use two pointers, pA and pB, starting at heads of A and B.
 * When a pointer reaches the end, it switches to the head of the other list.
 * They will meet at the intersection point after at most two passes.
 * 
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class IntersectionTwoLinkedLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of common nodes (intersecting part): ");
        int commonCount = sc.nextInt();
        ListNode[] commonNodes = new ListNode[commonCount];
        if (commonCount > 0)
            System.out.println("Enter common node values:");
        for (int i = 0; i < commonCount; i++) {
            commonNodes[i] = new ListNode(sc.nextInt());
        }
        for (int i = 0; i < commonCount - 1; i++) {
            commonNodes[i].next = commonNodes[i + 1];
        }

        System.out.print("Enter number of nodes in List A before intersection: ");
        int skipA = sc.nextInt();
        ListNode headA = buildListWithSuffix(sc, skipA, commonCount > 0 ? commonNodes[0] : null);

        System.out.print("Enter number of nodes in List B before intersection: ");
        int skipB = sc.nextInt();
        ListNode headB = buildListWithSuffix(sc, skipB, commonCount > 0 ? commonNodes[0] : null);

        ListNode result = getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }

        sc.close();
    }

    private static ListNode buildListWithSuffix(Scanner sc, int count, ListNode suffix) {
        if (count == 0)
            return suffix;
        System.out.println("Enter " + count + " node values:");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < count; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        curr.next = suffix;
        return dummy.next;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}
