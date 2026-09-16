class GymMember {

    static int count = 2000;

    final String membershipNumber;

    int monthlyFee;
    int feesPaid;

    GymMember(int monthlyFee) {

        count++;

        membershipNumber = "GYM-" + count;

        this.monthlyFee = monthlyFee;
    }

    void payFee(int amount) {
        feesPaid = feesPaid + amount;
    }

    void payFee(int amount, String mode) {

        System.out.println("Payment Mode: " + mode);

        payFee(amount);
    }

    int getFeesPaid() {
        return feesPaid;
    }

    static boolean isValidReferralCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    static int getMembersEnrolled() {
        return count - 2000;
    }
}

class GroupClassMember extends GymMember {

    String className;

    GroupClassMember(int monthlyFee, String className) {

        super(monthlyFee);

        this.className = className;
    }
}

public class A5 {

    static String processWeeklyCheckIn(
            GymMember[] members) {

        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {
                skipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + skipped + " null skipped | "
                + group + " group | "
                + individual
                + " individual";
    }

    public static void main(String[] args) {

        GymMember m1 =
                new GymMember(1000);

        System.out.println(
            m1.membershipNumber);

        System.out.println(
            GymMember.getMembersEnrolled());

        System.out.println(
            GymMember.isValidReferralCode("G45B"));

        System.out.println(
            GymMember.isValidReferralCode("G4B"));

        System.out.println(
            GymMember.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(
            "Fees Paid: "
            + m1.getFeesPaid());

        GymMember[] members = {

            new GroupClassMember(
                1500, "Zumba"),

            null,

            new GymMember(1000)
        };

        System.out.println(
            processWeeklyCheckIn(members));
    }
}