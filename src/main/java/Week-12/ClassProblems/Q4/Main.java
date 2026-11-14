
class Main {
    static int lowerBound(int[] a, int x) {
        int low = 0;
        int high = a.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (a[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] a = {40, 55, 70, 70, 70, 85, 90};
        int[] q = {70, 60, 95};

        for (int x : q) {
            int below = lowerBound(a, x);
            int exactly = lowerBound(a, x + 1) - below;

            System.out.println(x + ": exactly " +
                exactly + ", below " + below);
        }
    }
}
