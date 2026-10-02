abstract class Assignment {
    String title;
    int maxMarks;

    Assignment(String title, int maxMarks) {
        this.title = title;
        this.maxMarks = maxMarks;
    }

    abstract double calculateMarks(double marks, int lateDays);
}

class CodingAssignment extends Assignment {

    CodingAssignment(String title, int maxMarks) {
        super(title, maxMarks);
    }

    double calculateMarks(double marks, int lateDays) {
        double penalty = lateDays * 0.10;
        return marks - (marks * penalty);
    }
}

class WrittenAssignment extends Assignment {

    WrittenAssignment(String title, int maxMarks) {
        super(title, maxMarks);
    }

    double calculateMarks(double marks, int lateDays) {
        double penalty = lateDays * 0.20;
        return marks - (marks * penalty);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    int lateDays;
    String status = "Submitted";

    Submission(Student student, Assignment assignment, int lateDays) {
        this.student = student;
        this.assignment = assignment;
        this.lateDays = lateDays;
    }

    void grade(double marks) {

        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: "
                    + assignment.title + " has already been graded.");
            return;
        }

        double finalMarks =
                assignment.calculateMarks(marks, lateDays);

        status = "Graded";

        System.out.println(student.name + " graded: "
                + finalMarks + "/" + assignment.maxMarks);
        System.out.println("Status: " + status);
    }
}

public class A2 {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding =
                new CodingAssignment("Linked List Lab", 50);

        Assignment written =
                new WrittenAssignment("Design Essay", 50);

        Submission s1 =
                new Submission(asha, coding, 0);

        Submission s2 =
                new Submission(ravi, written, 2);

        System.out.println("Asha submission received.");
        System.out.println("Ravi submission received.");

        s1.grade(45);
        s2.grade(40);

        s1.grade(40);
    }
}