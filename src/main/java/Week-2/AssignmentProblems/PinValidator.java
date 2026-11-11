public class PinValidator {
    public static void main(String[] args) {

        String pin = "4820";

        if (pin.length() == 4) {
            System.out.println("PIN length OK.");
        }
        else {
            System.out.println("Invalid PIN");
        }
    }
}