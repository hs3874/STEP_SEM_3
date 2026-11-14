
class Main {
    static class Participant {
        String name;
        int score;

        Participant(String n, int s) {
            name = n;
            score = s;
        }
    }

    public static void main(String[] args) {
        Participant[] p = {
            new Participant("Asha", 90),
            new Participant("Ravi", 85),
            new Participant("Neha", 90),
            new Participant("Kiran", 70)
        };

        int n = p.length;

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            Participant key = p[i];
            int j = i - 1;

            while (j >= 0 && p[j].score < key.score) {
                p[j + 1] = p[j];
                j--;
            }

            p[j + 1] = key;
        }

        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && p[i].score != p[i - 1].score) {
                rank = i + 1;
            }

            System.out.println(rank + " " +
                p[i].name + " " + p[i].score);
        }
    }
}
