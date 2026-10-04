public class A1 {
    public static void main(String[] args) {

        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int bestStudent = 0;
        int bestTotal = 0;

        for (int i = 0; i < marks.length; i++) {

            int total = 0;

            for (int j = 0; j < marks[i].length; j++) {
                total = total + marks[i][j];
            }

            if (total > bestTotal) {
                bestTotal = total;
                bestStudent = i;
            }
        }

        System.out.println("Student Index = " + bestStudent);
        System.out.println("Total Marks = " + bestTotal);
    }
}