class AccessChecker {

    static String classifyAccess(String modifier, String context) {

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

        if (modifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {

        int privateA = 0, privateD = 0;
        int defaultA = 0, defaultD = 0;
        int protectedA = 0, protectedD = 0;
        int publicA = 0, publicD = 0;

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            String result =
                classifyAccess(modifier, context);

            if (modifier.equals("private")) {
                if (result.equals("ALLOWED")) privateA++;
                else privateD++;
            }
            else if (modifier.equals("default")) {
                if (result.equals("ALLOWED")) defaultA++;
                else defaultD++;
            }
            else if (modifier.equals("protected")) {
                if (result.equals("ALLOWED")) protectedA++;
                else protectedD++;
            }
            else {
                if (result.equals("ALLOWED")) publicA++;
                else publicD++;
            }
        }

        return "private: " + privateA + " allowed / " + privateD
            + " denied | default: " + defaultA + " allowed / "
            + defaultD + " denied | protected: " + protectedA
            + " allowed / " + protectedD + " denied | public: "
            + publicA + " allowed / " + publicD + " denied";
    }
}

class LibraryMember {

    private String membershipPin;
    int branchCode;
    protected double finesOwed;
    public String displayName;
}

public class Main1 {
    public static void main(String[] args) {

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            AccessChecker.summarizeByModifier(attempts));
    }
}