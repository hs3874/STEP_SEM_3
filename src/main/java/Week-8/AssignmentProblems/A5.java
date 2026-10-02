interface NotificationChannel {
    void send(String student, String notice);
}

class EmailChannel implements NotificationChannel {

    public void send(String student, String notice) {
        System.out.println("[Email -> " + student + "] " + notice);
    }
}

class SmsChannel implements NotificationChannel {

    public void send(String student, String notice) {
        System.out.println("[SMS -> " + student + "] " + notice);
    }
}

class AppChannel implements NotificationChannel {

    public void send(String student, String notice) {
        System.out.println("[App -> " + student + "] " + notice);
    }
}

class Student {
    String name;
    String department;

    NotificationChannel[] channels;
    int count = 0;

    Student(String name, String department) {
        this.name = name;
        this.department = department;
        channels = new NotificationChannel[5];
    }

    void addChannel(NotificationChannel channel) {
        channels[count] = channel;
        count++;
    }

    void receive(String notice) {
        for (int i = 0; i < count; i++) {
            channels[i].send(name, notice);
        }
    }
}

class Notice {
    String title;
    String[] departments;

    Notice(String title, String[] departments) {
        this.title = title;
        this.departments = departments;
    }

    boolean valid() {
        return title != null && title.length() > 0
                && departments.length > 0;
    }
}

class NoticeBoard {

    Student[] students;
    int count = 0;

    NoticeBoard() {
        students = new Student[10];
    }

    void addStudent(Student student) {
        students[count] = student;
        count++;
    }

    void postNotice(Notice notice) {

        if (!notice.valid()) {
            System.out.println(
                "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.title
                + "' posted.");

        for (int i = 0; i < count; i++) {

            for (int j = 0; j < notice.departments.length; j++) {

                if (students[i].department.equals(
                        notice.departments[j])) {

                    students[i].receive(notice.title);
                    break;
                }
            }
        }
    }
}

public class A5 {
    public static void main(String[] args) {

        Student asha = new Student("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student ravi = new Student("Ravi", "ECE");
        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();

        board.addStudent(asha);
        board.addStudent(ravi);

        String[] cse = {"CSE"};

        Notice n1 =
                new Notice("Lab Closed Tomorrow", cse);

        board.postNotice(n1);

        String[] all = {"CSE", "ECE"};

        Notice n2 =
                new Notice("Fee Deadline Extended", all);

        board.postNotice(n2);

        String[] none = {};

        Notice n3 =
                new Notice("Sports Day", none);

        board.postNotice(n3);
    }
}