public class Main {

    static int kthHighest(int[] marks, int k) {
        int target = marks.length - k;

        int low = 0;
        int high = marks.length - 1;

        while (low <= high) {
            int pivot = partition(marks, low, high);

            if (pivot == target)
                return marks[pivot];

            else if (pivot > target)
                high = pivot - 1;

            else
                low = pivot + 1;
        }

        return -1;
    }

    static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] marks = {72, 95, 60, 88, 79};

        int k = 2;

        System.out.println(k + "nd highest mark: " + kthHighest(marks, k));
    }
}