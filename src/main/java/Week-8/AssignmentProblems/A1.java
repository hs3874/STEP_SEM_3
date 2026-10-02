interface WashType {
    int getDuration();
    double getCharge();
}

class QuickWash implements WashType {

    public int getDuration() {
        return 30;
    }

    public double getCharge() {
        return 20;
    }
}

class NormalWash implements WashType {

    public int getDuration() {
        return 45;
    }

    public double getCharge() {
        return 30;
    }
}

class HeavyWash implements WashType {

    public int getDuration() {
        return 60;
    }

    public double getCharge() {
        return 45;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class WashingMachine {
    String name;
    boolean free = true;

    WashingMachine(String name) {
        this.name = name;
    }

    void start() {
        free = false;
    }

    void complete() {
        free = true;
    }
}

class WashCycle {
    Student student;
    WashingMachine machine;
    WashType wash;

    WashCycle(Student student, WashingMachine machine, WashType wash) {
        this.student = student;
        this.machine = machine;
        this.wash = wash;
    }

    void startWash() {
        if (machine.free) {
            machine.start();

            System.out.println("Wash started on " + machine.name
                    + " for " + student.name);
            System.out.println("Duration: " + wash.getDuration() + " min");
            System.out.println("Charge: ₹" + wash.getCharge());
        } else {
            System.out.println(machine.name + " is currently busy.");
        }
    }

    void completeWash() {
        machine.complete();
        System.out.println(machine.name + " cycle completed.");
        System.out.println(machine.name + " is now free.");
    }
}

public class A1 {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        WashCycle w1 =
            new WashCycle(asha, m1, new QuickWash());
        w1.startWash();

        WashCycle w2 =
            new WashCycle(ravi, m1, new HeavyWash());
        w2.startWash();

        WashCycle w3 =
            new WashCycle(ravi, m2, new HeavyWash());
        w3.startWash();

        w1.completeWash();
    }
}