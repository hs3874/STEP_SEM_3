
class Account {
    String id;
    int balance;

    Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    void withdraw(int amount) {
        System.out.println("Account not found");
    }
}

class Savings extends Account {
    Savings(String id, int balance) {
        super(id, balance);
    }

    void withdraw(int amount) {
        if (balance - amount < 1000) {
            System.out.println(id + " rejected: minimum balance 1000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + balance);
        }
    }
}

class Current extends Account {
    Current(String id, int balance) {
        super(id, balance);
    }

    void withdraw(int amount) {
        if (balance - amount < -5000) {
            System.out.println(id + " rejected: overdraft limit 5000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + balance);
        }
    }
}

public class P1 {
    public static void main(String[] args) {
        Account[] accounts = {
            new Savings("S1", 5000),
            new Current("C1", 2000)
        };

        String[] ids = {"S1", "C1", "S1", "C1"};
        int[] amounts = {4500, 6000, 3000, 2000};

        for (int i = 0; i < ids.length; i++) {
            boolean found = false;

            for (Account a : accounts) {
                if (a.id.equals(ids[i])) {
                    a.withdraw(amounts[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Account not found");
            }
        }
    }
}
