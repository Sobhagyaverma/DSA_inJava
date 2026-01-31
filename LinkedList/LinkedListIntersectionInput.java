package LinkedList;
import java.util.*;

public class LinkedListIntersectionInput {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    public static ListNode createList(Scanner sc, int n) {
        if (n == 0) return null;
        ListNode head = new ListNode(sc.nextInt());
        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        return head;
    }

    public static void attachEnd(ListNode head, ListNode common) {
        if (head == null) return;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = common;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Create the Common/Intersection Part
        System.out.print("Enter number of common nodes (intersection part): ");
        int nCommon = sc.nextInt();
        ListNode commonHead = null;
        if (nCommon > 0) {
            System.out.println("Enter common node values:");
            commonHead = createList(sc, nCommon);
        }

        // 2. Create Unique Part of List A
        System.out.print("Enter number of unique nodes for List A: ");
        int nA = sc.nextInt();
        ListNode headA = null;
        if (nA > 0) {
            System.out.println("Enter List A unique values:");
            headA = createList(sc, nA);
            attachEnd(headA, commonHead);
        } else {
            headA = commonHead;
        }

        // 3. Create Unique Part of List B
        System.out.print("Enter number of unique nodes for List B: ");
        int nB = sc.nextInt();
        ListNode headB = null;
        if (nB > 0) {
            System.out.println("Enter List B unique values:");
            headB = createList(sc, nB);
            attachEnd(headB, commonHead);
        } else {
            headB = commonHead;
        }

        System.out.println("\nStructure Created:");
        System.out.print("List A: "); printList(headA);
        System.out.print("List B: "); printList(headB);

        // 4. Find Intersection
        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("\nIntersection Point Data: " + intersection.val);
        } else {
            System.out.println("\nNo Intersection.");
        }

        sc.close();
    }
}