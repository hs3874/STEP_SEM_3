final class BookingReceipt {
    String bookingId;

    BookingReceipt(String bookingId) {
        this.bookingId = bookingId;
    }

    void print() {
        System.out.println("Booking ID: " + bookingId);
    }
}

class GroupBookingReceipt {
    String bookingId;
    int groupSize;

    GroupBookingReceipt(String bookingId, int groupSize) {
        this.bookingId = bookingId;
        this.groupSize = groupSize;
    }

    void print() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Group Size: " + groupSize);
    }
}

public class Main5 {
    public static void main(String[] args) {

        BookingReceipt b = new BookingReceipt("B101");
        b.print();

        GroupBookingReceipt g = new GroupBookingReceipt("B102", 5);
        g.print();
    }
}