abstract class DeliveryNote {
    abstract String confirmDelivery();

    String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}

class ParcelNote extends DeliveryNote {
    String trackingId;

    ParcelNote(String trackingId) {
        this.trackingId = trackingId;
    }

    String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}

class LetterNote extends DeliveryNote {
    String trackingId;

    LetterNote(String trackingId) {
        this.trackingId = trackingId;
    }

    String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}

public class Q5 {
    static void logAll(DeliveryNote[] notes) {
        for (int i = 0; i < notes.length; i++) {
            System.out.println(notes[i].confirmDelivery());
        }
    }

    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");

        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));

        DeliveryNote ref = p;

        logAll(new DeliveryNote[]{
            ref,
            new LetterNote("TRK-2")
        });
    }
}