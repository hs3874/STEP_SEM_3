
import java.util.HashSet;

class Student {
    String roll, name;

    Student(String roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return roll.equals(s.roll);
    }

    public int hashCode() {
        return roll.hashCode();
    }
}

public class P3 {
    public static void main(String[] args) {
        HashSet<Student> members = new HashSet<>();

        Student[] students = {
            new Student("21CS01", "Asha"),
            new Student("21CS01", "Asha"),
            new Student("21CS02", "Ravi")
        };

        for (Student s : students) {
            if (members.add(s))
                System.out.println("Added");
            else
                System.out.println("duplicate rejected");
        }

        System.out.println("member count " + members.size());

        Student s1 = new Student("21CS02", "Ravi");
        Student s2 = new Student("21CS03", "Priya");

        System.out.println("contains: " + members.contains(s1));
        System.out.println("contains: " + members.contains(s2));
    }
}
