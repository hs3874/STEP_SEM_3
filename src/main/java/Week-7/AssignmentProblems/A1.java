interface Ringable {
    String ring();
}

class AlarmClock implements Ringable {
    String time;

    AlarmClock(String time) {
        this.time = time;
    }

    public String ring() {
        return "Alarm ringing for " + time;
    }
}

class Doorbell implements Ringable {
    String location;

    Doorbell(String location) {
        this.location = location;
    }

    public String ring() {
        return "Doorbell ringing at " + location;
    }
}

public class A1 {
    static void ringAll(Ringable[] devices) {
        for (int i = 0; i < devices.length; i++) {
            System.out.println(devices[i].ring());
        }
    }

    public static void main(String[] args) {
        AlarmClock a = new AlarmClock("7:00 AM");
        Doorbell d = new Doorbell("Front Door");

        ringAll(new Ringable[]{a, d});
    }
}