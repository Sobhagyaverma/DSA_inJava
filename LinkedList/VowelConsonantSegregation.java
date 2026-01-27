package LinkedList;
import java.util.*;
public class VowelConsonantSegregation {
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node arrangeVowelsAndConsonants(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node vowelHead = new Node('0');
        Node vowelTail = vowelHead;
        
        Node consHead = new Node('0');
        Node consTail = consHead;

        Node curr = head;

        while (curr != null) {
            if (isVowel(curr.data)) {
                vowelTail.next = curr;
                vowelTail = vowelTail.next;
            } else {
                consTail.next = curr;
                consTail = consTail.next;
            }
            curr = curr.next;
        }

        vowelTail.next = consHead.next;
        consTail.next = null;

        if (vowelHead.next == null) {
            return consHead.next;
        }

        return vowelHead.next;
    }

    private boolean isVowel(char x) {
        x = Character.toLowerCase(x);
        return (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u');
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void insert(Node head, char data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        if (n > 0) {
            System.out.println("Enter the characters:");
            Node head = new Node(sc.next().charAt(0));
            
            for (int i = 1; i < n; i++) {
                insert(head, sc.next().charAt(0));
            }

            VowelConsonantSegregation solver = new VowelConsonantSegregation();
            head = solver.arrangeVowelsAndConsonants(head);

            System.out.println("Resulting List:");
            printList(head);
        }
        
        sc.close();
    }
}
