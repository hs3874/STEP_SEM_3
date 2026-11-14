
import java.util.*;

class Main {
    static class Timetable {
        String name;
        ArrayList<String> periods;

        Timetable(String n, ArrayList<String> p) {
            name = n;
            periods = p;
        }

        Timetable copy(String newName) {
            return new Timetable(newName,
                new ArrayList<>(periods));
        }

        void setPeriod(int period, String subject) {
            periods.set(period - 1, subject);
        }

        void display() {
            System.out.println(name + ": " + periods);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> p = new ArrayList<>();

        p.add("Java");
        p.add("DSA");
        p.add("Maths");

        Timetable t1 = new Timetable("CSE-A", p);

        Timetable t2 = t1.copy("CSE-B");

        t2.setPeriod(2, "Physics");

        t1.display();
        t2.display();
    }
}
