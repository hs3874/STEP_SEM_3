public class InventoryRecord {
    public static void main(String[] args) {

        String input = "Wireless Mouse,WM-2201,150";

        String[] data = input.split(",");

        if (data.length != 3) {
            System.out.println("Invalid Record");
        }
        else {
            System.out.println("Product: " + data[0]);
            System.out.println("SKU: " + data[1]);
            System.out.println("Qty: " + data[2]);
        }
    }
}