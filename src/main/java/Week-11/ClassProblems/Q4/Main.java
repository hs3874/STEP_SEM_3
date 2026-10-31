class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {
    static Node deleteNthNode(Node head, int n) {
        if (n == 1)
            return head.next;

        Node temp = head;

        for (int i = 1; i < n - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head = deleteNthNode(head, 3);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}