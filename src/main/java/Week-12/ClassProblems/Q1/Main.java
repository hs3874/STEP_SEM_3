
 class Main {
    static char[] stack = new char[100];
    static int top = -1;

    static void push(char c) {
        stack[++top] = c;
    }

    static char pop() {
        return stack[top--];
    }

    static int priority(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    static String toPostfix(String s) {
        String post = "";
        top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                post += c;
            }
            else if (c == '(') {
                push(c);
            }
            else if (c == ')') {
                while (top != -1 && stack[top] != '(')
                    post += pop();
                pop();
            }
            else {
                while (top != -1 && stack[top] != '(' &&
                       priority(stack[top]) >= priority(c)) {
                    post += pop();
                }
                push(c);
            }
        }

        while (top != -1)
            post += pop();

        return post;
    }

    static int evaluate(String s) {
        int[] st = new int[100];
        int t = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                st[++t] = c - '0';
            } else {
                int b = st[t--];
                int a = st[t--];

                switch (c) {
                    case '+': st[++t] = a + b; break;
                    case '-': st[++t] = a - b; break;
                    case '*': st[++t] = a * b; break;
                    case '/':
                        if (b == 0) return -1;
                        st[++t] = a / b;
                        break;
                }
            }
        }

        return st[t];
    }

    public static void main(String[] args) {
        String[] exp = {"2+3*4", "(2+3)*4", "8/2-3"};

        for (String s : exp) {
            String p = toPostfix(s);
            System.out.println(p + " = " + evaluate(p));
        }
    }
}
