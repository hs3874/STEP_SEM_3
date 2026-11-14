
class Main {
    static class Node {
        String name;
        Node prev, next;

        Node(String n) {
            name = n;
        }
    }

    static Node head = null;
    static Node cur = null;

    static void open(String name) {
        Node n = new Node(name);

        if (head == null) {
            head = cur = n;
        } else {
            n.prev = cur;
            n.next = cur.next;

            if (cur.next != null)
                cur.next.prev = n;

            cur.next = n;
            cur = n;
        }
    }

    static void close() {
        if (cur == null)
            return;

        Node old = cur;

        if (old.prev != null)
            old.prev.next = old.next;
        else
            head = old.next;

        if (old.next != null) {
            old.next.prev = old.prev;
            cur = old.next;
        } else {
            cur = old.prev;
        }
    }

    static void back() {
        if (cur != null && cur.prev != null)
            cur = cur.prev;
    }

    static void forward() {
        if (cur != null && cur.next != null)
            cur = cur.next;
    }

    static void display() {
        Node p = head;

        while (p != null) {
            if (p == cur)
                System.out.print("[" + p.name + "]");
            else
                System.out.print(p.name);

            if (p.next != null)
                System.out.print(" <-> ");

            p = p.next;
        }

        System.out.println();
    }

    static void printBackward() {
        Node p = head;

        if (p == null) {
            System.out.println("Backward: (empty)");
            return;
        }

        while (p.next != null)
            p = p.next;

        System.out.print("Backward: ");

        while (p != null) {
            System.out.print(p.name);

            if (p.prev != null)
                System.out.print(" <-> ");

            p = p.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        open("Mail");
        System.out.print("OPEN Mail: ");
        display();

        open("Docs");
        System.out.print("OPEN Docs: ");
        display();

        open("Maps");
        System.out.print("OPEN Maps: ");
        display();

        back();
        System.out.print("BACK: ");
        display();

        back();
        System.out.print("BACK: ");
        display();

        back();
        System.out.println("BACK: already at first tab");

        open("Drive");
        System.out.print("OPEN Drive: ");
        display();

        close();
        System.out.print("CLOSE Drive: ");
        display();

        forward();
        System.out.print("FORWARD: ");
        display();

        close();
        System.out.print("CLOSE Maps: ");
        display();

        printBackward();
    }
}
