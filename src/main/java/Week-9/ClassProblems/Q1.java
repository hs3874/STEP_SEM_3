public class Q1 {
    public static void main(String[] args) {

        String[] isbn = {
            "0001112223",
            "0002223334",
            "0003334445",
            "0004445556",
            "0005556667"
        };

        String[] title = {
            "Introduction to Algebra",
            "Beginning Python",
            "Classic Mythology",
            "Data and Society",
            "European History"
        };

        String target = "0003334445";

        int low = 0;
        int high = isbn.length - 1;
        String result = "Not Found";

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isbn[mid].equals(target)) {
                result = title[mid];
                break;
            } else if (isbn[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}