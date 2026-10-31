class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

public class Main {
    static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return null;

        DNode temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next.prev = null;
        temp.next = null;

        return head;
    }

    public static void main(String[] args) {
        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(3);
        head.next.next.prev = head.next;

        head = deleteLastNodeDoubly(head);

        DNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}