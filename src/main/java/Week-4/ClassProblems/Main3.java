class Account {
    String regNo;
    double totalFee;

    Account(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    final double calculateLateFee(int daysLate) {
        return daysLate * 2000;
    }

    final void printSummary(int daysLate) {
        double lateFee = calculateLateFee(daysLate);

        System.out.println(regNo + " | Total Fee: Rs "
                + totalFee + " | Late Fee: Rs " + lateFee);
    }
}

public class Main3 {
    public static void main(String[] args) {

        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {

            Account a = new Account(regNos[i], totalFees[i]);

            if (daysLate[i] > 0) {
                a.printSummary(daysLate[i]);
            } else {
                System.out.println(regNos[i] +
                        " - On time, no late fee");
            }
        }
    }
}