
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class M2 {
    static Node removeAll(Node head, int code) {
        while (head != null && head.data == code)
            head = head.next;

        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.data == code)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }

        return head;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(5);

        head = removeAll(head, 5);
        display(head);
    }
}
