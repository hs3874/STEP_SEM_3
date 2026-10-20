
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class M1 {
    Node head;

    void addFirst(int token) {
        Node n = new Node(token);
        n.next = head;
        head = n;
    }

    void addLast(int token) {
        Node n = new Node(token);

        if (head == null) {
            head = n;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = n;
    }

    void insertAt(int index, int token) {
        if (index == 0) {
            addFirst(token);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        Node n = new Node(token);
        n.next = temp.next;
        temp.next = n;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        M1 list = new M1();

        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);

        list.display();
    }
}
