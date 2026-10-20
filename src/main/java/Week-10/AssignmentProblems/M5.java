
class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
    }
}

public class M5 {
    Node tail;

    void addLast(String name) {
        Node n = new Node(name);

        if (tail == null) {
            tail = n;
            n.next = n;
        } else {
            n.next = tail.next;
            tail.next = n;
            tail = n;
        }
    }

    void printTurns(int turns) {
        if (tail == null)
            return;

        Node temp = tail.next;

        for (int i = 0; i < turns; i++) {
            System.out.print(temp.name);

            if (i < turns - 1)
                System.out.print(" ");

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        M5 game = new M5();

        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");

        game.printTurns(7);
    }
}
