public class ISBNValidator {
    public static void main(String[] args) {

        String code = " pen2026004251 ";

        code = code.trim();

        String publisher = code.substring(0, 3).toUpperCase();
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        System.out.println("[" + publisher + "] YEAR: "
                + year + " | CATALOG: " + catalog);
    }
}