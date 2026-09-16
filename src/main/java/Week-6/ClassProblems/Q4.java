class LibraryMember {
    String memberId;
    int borrowLimit;
    int booksBorrowed;

    LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    void displayInfo() {
        System.out.print("General | Books: " + booksBorrowed);
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
        System.out.print("Student | Course: " + course
                + " | Books: " + booksBorrowed);
    }
}

public class Q4 {

    static String batchPrint(LibraryMember[] members) {

        StringBuilder result = new StringBuilder();

        for (LibraryMember member : members) {

            member.displayInfo();

            if (member instanceof StudentMember) {
                StudentMember s = (StudentMember) member;

                result.append("Student | Course: ")
                      .append(s.course)
                      .append(" | Books: ")
                      .append(s.booksBorrowed)
                      .append(" [Course via downcast: ")
                      .append(s.course)
                      .append("] | ");
            } else {
                result.append("General | Books: ")
                      .append(member.booksBorrowed)
                      .append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}