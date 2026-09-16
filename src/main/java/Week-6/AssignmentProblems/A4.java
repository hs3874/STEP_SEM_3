class GymMember {

    String memberId;
    int monthlyFee;
    int sessionsAttended;

    GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    void displayInfo() {
        System.out.print(
            "Standard | Sessions: "
            + sessionsAttended);
    }
}

class PremiumMember extends GymMember {

    String trainerName;

    PremiumMember(String memberId, int monthlyFee,
                  String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    void displayInfo() {
        System.out.print(
            "Premium | Trainer: "
            + trainerName
            + " | Sessions: "
            + sessionsAttended);
    }
}

public class A4 {

    static String batchPrint(GymMember[] members) {

        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {

            member.displayInfo();

            if (member instanceof PremiumMember) {

                PremiumMember p =
                    (PremiumMember) member;

                result.append("Premium | Trainer: ")
                      .append(p.trainerName)
                      .append(" | Sessions: ")
                      .append(p.sessionsAttended)
                      .append(" [Trainer via downcast: ")
                      .append(p.trainerName)
                      .append("] | ");

            } else {

                result.append("Standard | Sessions: ")
                      .append(member.sessionsAttended)
                      .append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        GymMember[] members = {

            new GymMember("MEM6", 1000),

            new PremiumMember(
                "MEM7", 2000, "Coach Riya")
        };

        System.out.println(
            batchPrint(members));
    }
}