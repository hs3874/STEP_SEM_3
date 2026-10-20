
public class P4 {
    public static void main(String[] args) {
        String[] names = {"Asha", "Ravi", "Neha"};

        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] subjectTotal = new int[3];
        int topper = 0;

        System.out.print("Totals ");

        for (int i = 0; i < marks.length; i++) {
            int total = 0;

            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
                subjectTotal[j] += marks[i][j];
            }

            System.out.print(names[i] + " " + total);

            if (i < marks.length - 1)
                System.out.print(", ");

            if (total > getTotal(marks, topper))
                topper = i;
        }

        System.out.println();

        System.out.printf("averages %.2f, %.2f, %.2f%n",
            subjectTotal[0] / 3.0,
            subjectTotal[1] / 3.0,
            subjectTotal[2] / 3.0);

        System.out.println("topper " + names[topper] +
            " (" + getTotal(marks, topper) + ")");
    }

    static int getTotal(int[][] marks, int i) {
        return marks[i][0] + marks[i][1] + marks[i][2];
    }
}
