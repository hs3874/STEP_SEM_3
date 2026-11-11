public class PhoneMask {
    public static void main(String[] args) {

        String phone = "9876543210";

        if (phone.length() != 10) {
            System.out.println("Invalid phone number");
        }
        else {
            StringBuilder result = new StringBuilder("XXXXXX-");
            result.append(phone.substring(6));

            System.out.println(result);
        }
    }
}