class AccessChecker {

    static String classifyAccess(String modifier, String context) {

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

            if (modifier.equals("public") ||
                modifier.equals("protected"))
                return "ALLOWED";

            return "DENIED";
        }

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

            if (modifier.equals("public"))
                return "ALLOWED";

            return "DENIED";
        }

        if (modifier.equals("private")) {
            return context.equals("SAME_CLASS")
                ? "ALLOWED" : "DENIED";
        }

        if (modifier.equals("default")) {
            return (context.equals("SAME_CLASS") ||
                    context.equals("SAME_PACKAGE"))
                ? "ALLOWED" : "DENIED";
        }

        if (modifier.equals("protected")) {
            return (context.equals("SAME_CLASS") ||
                    context.equals("SAME_PACKAGE"))
                ? "ALLOWED" : "DENIED";
        }

        return "ALLOWED";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String result =
                classifyAccess(attempts[i][0], attempts[i][1]);

            if (result.equals("DENIED")) {

                return attempts[i][0]
                    + " via " + attempts[i][1]
                    + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }
}

public class Main2 {
    public static void main(String[] args) {

        String[][] attempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            AccessChecker.firstDeniedAttempt(attempts));
    }
}