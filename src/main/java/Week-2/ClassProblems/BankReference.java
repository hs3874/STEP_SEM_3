public class BankReference {
    public static void main(String[] args) {

        String raw = " hdf03022600042 ";

        raw = raw.trim();

        String bank = raw.substring(0, 3).toUpperCase();
        String date = raw.substring(3, 9);
        String seq = raw.substring(9);

        String result = "[" + bank + "] DATE: "
                      + date.substring(0, 2) + "/"
                      + date.substring(2, 4) + "/"
                      + date.substring(4, 6)
                      + " | SEQ: " + seq;

        System.out.println(result);
    }
}