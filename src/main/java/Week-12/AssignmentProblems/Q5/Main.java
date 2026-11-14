
class Main {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node partition(Node head, int passMark) {
        Node lowHead = null, lowTail = null;
        Node highHead = null, highTail = null;

        Node p = head;

        while (p != null) {
            Node next = p.next;
            p.next = null;

            if (p.data < passMark) {
                if (lowHead == null) {
                    lowHead = lowTail = p;
                } else {
                    lowTail.next = p;
                    lowTail = p;
                }
            } else {
                if (highHead == null) {
                    highHead = highTail = p;
                } else {
                    highTail.next = p;
                    highTail = p;
                }
            }

            p = next;
        }

        if (lowHead == null)
            return highHead;

        lowTail.next = highHead;

        return lowHead;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(55);
        head.next = new Node(32);
        head.next.next = new Node(78);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(40);
        head.next.next.next.next.next = new Node(35);

        int passMark = 40;

        head = partition(head, passMark);

        display(head);
    }
}
