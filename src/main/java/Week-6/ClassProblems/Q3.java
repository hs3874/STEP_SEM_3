import java.util.Arrays;

class LibraryMember {
    String memberId;
    int borrowLimit;

    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    protected void chargeFine(int amount) {
        if (fineCount < 10) {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }

    int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    int getTotalFine() {
        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total = total + fineHistory[i];
        }

        return total;
    }
}

class StudentMember extends LibraryMember {
    String course;

    StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class Q3 {
    public static void main(String[] args) {

        StudentMember s =
                new StudentMember("STU5", 3, "CSE");

        s.chargeFine(100);

        System.out.println("Total Fine: "
                + s.getTotalFine());

        int[] history = s.getFineHistory();

        history[0] = 999;

        System.out.println("Fine History: "
                + Arrays.toString(s.getFineHistory()));
    }
}