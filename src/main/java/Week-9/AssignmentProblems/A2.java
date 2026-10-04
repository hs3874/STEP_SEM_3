public class A2 {
    public static void main(String[] args) {

        int[] a = {3, 8, 15, 20};
        int[] b = {5, 8, 12};

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }

            k++;
        }

        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }

        for (i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}