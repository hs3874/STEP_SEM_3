
class Main {
    static class Editor {
        String[] stack;
        int top = -1;

        Editor(int n) {
            stack = new String[n];
        }

        void type(String word) {
            if (top == stack.length - 1) {
                System.out.println("rejected: history full");
                return;
            }

            stack[++top] = word;
            display();
        }

        void undo() {
            if (top == -1) {
                System.out.println("rejected: nothing to undo");
                return;
            }

            top--;
            display();
        }

        void display() {
            if (top == -1) {
                System.out.println("(empty)");
                return;
            }

            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Editor e = new Editor(3);

        e.type("Hi");
        e.type("there");
        e.type("all");
        e.type("now");

        e.undo();
        e.undo();
        e.undo();
        e.undo();
    }
}
