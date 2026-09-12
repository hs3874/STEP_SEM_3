class SrmStudent {

    static String collegeName;
    static String academicYear;

    static {
        collegeName = "SRM";
        academicYear = "2026";
        System.out.println("College info loaded");
    }

    String name;

    SrmStudent(String name) {
        this.name = name;
    }

    void printStudent() {
        System.out.println("Student record created: " + name);
    }
}

public class Main4 {
    public static void main(String[] args) {

        String[] names = {
            "Ravi", "Meera", "Karthik", "Divya", "Anitha"
        };

        for (int i = 0; i < names.length; i++) {
            SrmStudent s = new SrmStudent(names[i]);
            s.printStudent();
        }
    }
}