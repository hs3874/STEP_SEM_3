public class A3 {
    public static void main(String[] args) {

        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        String[] items = new String[orders.length];
        int[] count = new int[orders.length];

        int size = 0;

        for (String order : orders) {

            int found = -1;

            for (int j = 0; j < size; j++) {
                if (items[j].equals(order)) {
                    found = j;
                    break;
                }
            }

            if (found == -1) {
                items[size] = order;
                count[size] = 1;
                size++;
            } else {
                count[found]++;
            }
        }

        int max = 0;
        int position = 0;

        for (int i = 0; i < size; i++) {
            if (count[i] > max) {
                max = count[i];
                position = i;
            }
        }

        System.out.println("Item = " + items[position]);
        System.out.println("Count = " + max);
    }
}