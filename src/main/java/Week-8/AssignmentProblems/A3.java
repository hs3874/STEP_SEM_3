interface Seat {
    double getPrice();
    String getName();
}

class RegularSeat implements Seat {

    String name;

    RegularSeat(String name) {
        this.name = name;
    }

    public double getPrice() {
        return 150;
    }

    public String getName() {
        return name;
    }
}

class PremiumSeat implements Seat {

    String name;

    PremiumSeat(String name) {
        this.name = name;
    }

    public double getPrice() {
        return 250;
    }

    public String getName() {
        return name;
    }
}

class ReclinerSeat implements Seat {

    String name;

    ReclinerSeat(String name) {
        this.name = name;
    }

    public double getPrice() {
        return 400;
    }

    public String getName() {
        return name;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Show {
    String time;

    Show(String time) {
        this.time = time;
    }
}

class Booking {
    Customer customer;
    Show show;
    Seat[] seats;
    int count = 0;

    Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
        seats = new Seat[6];
    }

    void addSeat(Seat seat) {
        if (count < 6) {
            seats[count] = seat;
            count++;
        } else {
            System.out.println("Maximum 6 seats allowed.");
        }
    }

    void confirm() {

        double total = 0;

        System.out.println("Booking confirmed for "
                + customer.name);

        for (int i = 0; i < count; i++) {
            System.out.println(seats[i].getName());
            total += seats[i].getPrice();
        }

        System.out.println("Total: ₹" + total);
    }

    void cancel() {
        System.out.println("Booking cancelled.");
    }
}

public class A3 {
    public static void main(String[] args) {

        Customer asha = new Customer("Asha");
        Show show = new Show("7 PM");

        Booking b = new Booking(asha, show);

        b.addSeat(new RegularSeat("A1"));
        b.addSeat(new RegularSeat("A2"));
        b.addSeat(new PremiumSeat("F5"));

        b.confirm();

        b.cancel();
    }
}