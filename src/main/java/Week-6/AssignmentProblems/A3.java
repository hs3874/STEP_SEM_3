import java.util.Arrays;

class GymMember {

    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

    protected void chargeLateFee(int amount) {

        if (feeCount < 10) {
            lateFeeHistory[feeCount] = amount;
            feeCount++;
        }
    }

    int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, feeCount);
    }

    int getTotalLateFees() {

        int total = 0;

        for (int i = 0; i < feeCount; i++) {
            total = total + lateFeeHistory[i];
        }

        return total;
    }
}

class PremiumMember extends GymMember {

    String trainerName;

    PremiumMember(String memberId, int monthlyFee,
                  String trainerName) {
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class A3 {

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember(
                    "MEM5", 2000, "Coach Riya");

        p.chargeLateFee(200);

        System.out.println(
            "Total Late Fee: "
            + p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(
            "Fee History: "
            + Arrays.toString(
                p.getLateFeeHistory()));
    }
}