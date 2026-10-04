public class A4 {
    public static void main(String[] args) {

        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};

        int k = 3;
        int threshold = 4;

        int sum = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + readings[i];
        }

        if (sum >= k * threshold)
            count++;

        for (int i = k; i < readings.length; i++) {

            sum = sum + readings[i];
            sum = sum - readings[i - k];

            if (sum >= k * threshold)
                count++;
        }

        System.out.println("Number of Alerts = " + count);
    }
}