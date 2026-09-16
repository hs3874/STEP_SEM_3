class LibraryMember {

    static int count = 100;

    final String memberNumber;

    int borrowLimit;
    int booksBorrowed;

    LibraryMember(int borrowLimit) {
        count++;

        memberNumber = "LIB-" + count;

        this.borrowLimit = borrowLimit;
    }

    void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    void borrowBook(String genre) {
        System.out.println("Genre: " + genre);
        borrowBook();
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    static boolean isValidRenewalCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    static int getMembersEnrolled() {
        return count - 100;
    }
}

class FacultyMember extends LibraryMember {

    String department;

    FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }
}

public class Q5 {

    static String processNightlyAudit(LibraryMember[] members) {

        int processed = 0;
        int skipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMember member : members) {

            if (member == null) {
                skipped++;
                continue;
            }

            processed++;

            if (member instanceof FacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + skipped + " null skipped | "
                + faculty + " faculty | "
                + regular + " regular";
    }

    public static void main(String[] args) {

        LibraryMember m1 = new LibraryMember(3);

        System.out.println(m1.memberNumber);
        System.out.println(LibraryMember.getMembersEnrolled());

        System.out.println(
                LibraryMember.isValidRenewalCode("R12A"));

        System.out.println(
                LibraryMember.isValidRenewalCode("R1A"));

        System.out.println(
                LibraryMember.isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println("Books Borrowed: "
                + m1.getBooksBorrowed());

        LibraryMember[] members = {
            new FacultyMember(5, "Physics"),
            null,
            new LibraryMember(3)
        };

        System.out.println(
                processNightlyAudit(members));
    }
}