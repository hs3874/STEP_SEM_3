class LibraryMember {
    String memberId;
    int borrowLimit;
    int booksBorrowed;

    LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        booksBorrowed = 0;
    }

    void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    void displayInfo() {
        System.out.println("General Member | Books Borrowed: " + booksBorrowed);
    }
}

class StudentMember extends LibraryMember {
    String course;

    StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    void displayInfo() {
        System.out.println("Student Member | Course: " + course
                + " | Books Borrowed: " + booksBorrowed);
    }
}

class HonorsStudentMember extends StudentMember {
    int bonusLimit;

    HonorsStudentMember(String memberId, int borrowLimit,
                        String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    void displayInfo() {
        System.out.println("Honors Student Member | Course: " + course
                + " | Bonus Limit: " + bonusLimit
                + " | Books Borrowed: " + booksBorrowed);
    }
}

class FacultyMember extends LibraryMember {
    String department;

    FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    void displayInfo() {
        System.out.println("Faculty Member | Department: " + department
                + " | Books Borrowed: " + booksBorrowed);
    }
}

public class Q2 {

    static String classifyGeneration(LibraryMember member) {

        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof StudentMember) {
            return "Student branch";
        }

        return "General Member";
    }

    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;

        for (LibraryMember member : members) {
            total = total + member.getBooksBorrowed();
        }

        return total;
    }

    public static void main(String[] args) {

        LibraryMember general =
                new LibraryMember("STU1", 3);

        StudentMember student =
                new StudentMember("STU2", 3, "CSE");

        HonorsStudentMember honors =
                new HonorsStudentMember("STU3", 3, "ECE", 2);

        FacultyMember faculty =
                new FacultyMember("STU4", 5, "Physics");

        general.displayInfo();
        student.displayInfo();
        honors.displayInfo();
        faculty.displayInfo();

        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        LibraryMember[] members = {
            student, honors, faculty
        };

        System.out.println("Total Books Borrowed: "
                + getTotalBooksBorrowed(members));
    }
}