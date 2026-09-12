class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String name, String company, double packageLpa) {
        studentName = name;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class Placement {
    public static void main(String[] args) {

        PlacementRecord[] students = new PlacementRecord[3];

        students[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        students[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        students[2] = new PlacementRecord("Karthik", "Infosys", 4.0);

        for (PlacementRecord s : students) {
            s.printRecord();
        }
    }
}