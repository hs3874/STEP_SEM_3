abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }
}

class LeaveRequest {
    Employee employee;
    String dates;
    String status = "Pending";

    LeaveRequest(Employee employee, String dates) {
        this.employee = employee;
        this.dates = dates;
    }

    void submit() {
        System.out.println("Leave request submitted for " +
                employee.name + " (" + dates + ").");
        System.out.println("Status: " + status);
    }

    void approve() {
        if (status.equals("Pending")) {
            status = "Approved";
            System.out.println(employee.name + "'s leave request approved.");
            System.out.println("Status: " + status);
        }
    }

    void reject() {
        if (status.equals("Pending")) {
            status = "Rejected";
            System.out.println(employee.name + "'s leave request rejected.");
            System.out.println("Status: " + status);
        }
    }

    void changeStatus(String newStatus) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from "
                    + status + " to " + newStatus);
        }
    }
}

public class Q2 {
    public static void main(String[] args) {

        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        LeaveRequest r1 = new LeaveRequest(john, "Jan 1-5");
        r1.submit();
        r1.approve();

        LeaveRequest r2 = new LeaveRequest(jane, "Feb 10-11");
        r2.submit();
        r2.reject();

        r1.changeStatus("Pending");
    }
}