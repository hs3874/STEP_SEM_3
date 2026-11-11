public class FileValidator {
    public static void main(String[] args) {

        String filename = "Assignment1.PDF";

        int dot = filename.lastIndexOf('.');
        String extension = filename.substring(dot + 1);

        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {

            System.out.println("Accepted");
        }
        else {
            System.out.println("Rejected - invalid file type");
        }
    }
}