public class Main {

    static long countInversions(int[] roll) {
        int[] temp = new int[roll.length];

        return mergeSort(roll, temp, 0, roll.length - 1);
    }

    static long mergeSort(int[] a, int[] temp, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            count += mergeSort(a, temp, left, mid);
            count += mergeSort(a, temp, mid + 1, right);

            count += merge(a, temp, left, mid, right);
        }

        return count;
    }

    static long merge(int[] a, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        long count = 0;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid)
            temp[k++] = a[i++];

        while (j <= right)
            temp[k++] = a[j++];

        for (i = left; i <= right; i++)
            a[i] = temp[i];

        return count;
    }

    public static void main(String[] args) {
        int[] roll = {2, 4, 1, 3, 5};

        System.out.println("Inversions: " + countInversions(roll));
    }
}