package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class sortAternatingNode {

    public static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void PrintList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node sort(Node head) {
        Node[] list = splitList(head);
        Node asc = list[0];
        Node dec = list[1];
        dec = reverse(dec);
        return merge(asc, dec);
    }

    static Node[] splitList(Node head) {
        Node a = null, b = null;
        Node atail = null, btail = null;
        boolean flag = true;
        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (flag) {
                if (a == null) {
                    a = atail = head;
                } else {
                    atail.next = head;
                    atail = head;
                }
            } else {
                if (b == null)
                    b = btail = head;
                else {
                    btail.next = head;
                    btail = head;
                }

            }
            flag = !flag;
            head = next;
        }
        return new Node[] { a, b };
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node Head = null;

        Head = insert(Head, 13);
        Head = insert(Head, 99);
        Head = insert(Head, 20);
        Head = insert(Head, 80);
        Head = insert(Head, 50);

        System.out.print("unsorted list ");
        PrintList(Head);
        Head = sort(Head);

        System.out.println("Sorted List:");
        PrintList(Head);
    }

}
