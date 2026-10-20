
class Staff {
    String name, type;
    int pay;

    Staff(String name, String type, int pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    void display() {
        System.out.println("Payslip[name=" + name +
            ", type=" + type + ", pay=" + pay + "]");
    }
}

public class P5 {
    public static void main(String[] args) {
        Staff[] staff = {
            new Staff("Asha", "FullTime", 50000),
            new Staff("Ravi", "PartTime", 80 * 300),
            new Staff("Neha", "Intern", 15000)
        };

        int total = 0;
        int topper = 0;

        for (int i = 0; i < staff.length; i++) {
            staff[i].display();
            total += staff[i].pay;

            if (staff[i].pay > staff[topper].pay)
                topper = i;
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + staff[topper].name);
    }
}
