public class StudentRecord {
    public static void main(String[] args) {

        String input = "Ananya Verma,RA2211003010123,CSE";

        String[] data = input.split(",");

        if (data.length != 3) {
            System.out.println("Invalid Record");
        }
        else {
            System.out.println("Name: " + data[0]);
            System.out.println("Roll No: " + data[1]);
            System.out.println("Dept: " + data[2]);
        }
    }
}