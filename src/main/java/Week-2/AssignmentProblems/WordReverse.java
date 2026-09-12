public class WordReverse {
    public static void main(String[] args) {

        String sentence = "hello club";

        String[] words = sentence.split(" ");

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            System.out.print(sb.reverse() + " ");
        }
    }
}