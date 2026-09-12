class AccessChecker {

    static String classifyAccess(String modifier, String context) {

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

            if (modifier.equals("public") ||
                modifier.equals("protected"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

            if (modifier.equals("public"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (modifier.equals("private")) {
            if (context.equals("SAME_CLASS"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (modifier.equals("default")) {
            if (context.equals("SAME_CLASS") ||
                context.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (modifier.equals("protected")) {
            if (context.equals("SAME_CLASS") ||
                context.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (modifier.equals("public"))
            return "ALLOWED";

        return "DENIED";
    }
}

public class Main2 {
    public static void main(String[] args) {

        System.out.println(
            AccessChecker.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        System.out.println(
            AccessChecker.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}