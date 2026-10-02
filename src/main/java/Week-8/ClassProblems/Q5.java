interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        System.out.println("Credit Card payment processed.");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        System.out.println("PayPal payment failed.");
        return false;
    }
}

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotal() {
        return price * quantity;
    }
}

class Order {
    String customer;
    double total = 0;
    String status = "Pending";

    Order(String customer) {
        this.customer = customer;
    }

    void addProduct(Product p) {
        total += p.getTotal();
    }

    void pay(PaymentMethod method) {

        if (total == 0) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        boolean result = method.processPayment(total);

        if (result) {
            status = "Paid";
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class Q5 {
    public static void main(String[] args) {

        Order o1 = new Order("Customer X");

        o1.addProduct(new Product("Product A", 100, 2));
        o1.addProduct(new Product("Product B", 50, 1));

        System.out.println("Order created for Customer X.");
        o1.pay(new CreditCardPayment());

        Order o2 = new Order("Customer Y");
        o2.pay(new CreditCardPayment());

        Order o3 = new Order("Customer Z");
        o3.addProduct(new Product("Product C", 200, 1));
        o3.pay(new PayPalPayment());
    }
}