
interface Chargeable {
    void charge();
}

class Vehicle {
    String type, pass, owner;
    int fee;

    Vehicle(String type, String pass, String owner) {
        this.type = type;
        this.pass = pass;
        this.owner = owner;

        if (type.equals("Bike") || type.equals("EBike"))
            fee = 300;
        else
            fee = 1000;
    }

    void display() {
        System.out.println(pass + " (" + type + ") pass fee " + fee);
    }
}

class ElectricVehicle extends Vehicle implements Chargeable {
    ElectricVehicle(String type, String pass, String owner) {
        super(type, pass, owner);
    }

    public void charge() {
        System.out.println(pass + " charging bay allotted");
    }
}

public class P2 {
    public static void main(String[] args) {
        Vehicle[] v = {
            new Vehicle("Bike", "KA01", "Asha"),
            new ElectricVehicle("ECar", "KA02", "Ravi")
        };

        for (Vehicle x : v)
            x.display();

        String[] requests = {"KA02", "KA01"};

        for (String id : requests) {
            boolean found = false;

            for (Vehicle x : v) {
                if (x.pass.equals(id)) {
                    found = true;

                    if (x instanceof Chargeable)
                        ((Chargeable) x).charge();
                    else
                        System.out.println(id +
                            " rejected: charging unsupported");

                    break;
                }
            }

            if (!found)
                System.out.println("Vehicle not found");
        }
    }
}
