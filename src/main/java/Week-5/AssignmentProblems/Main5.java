final class LoanReceipt {
    String bookId;

    LoanReceipt(String bookId) {
        this.bookId = bookId;
    }
}

class ReferenceOnlyLoanReceipt {
    String bookId;

    ReferenceOnlyLoanReceipt(String bookId) {
        this.bookId = bookId;
    }
}

public class Main5 {
    public static void main(String[] args) {

        LoanReceipt r1 = new LoanReceipt("B101");

        ReferenceOnlyLoanReceipt r2 =
                new ReferenceOnlyLoanReceipt("B102");

        if (r2 instanceof ReferenceOnlyLoanReceipt) {
            System.out.println("Reference-only receipt");
        }
    }
}