import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        String text = "The mentor was great, the session was great and clear.";

        text = text.toLowerCase();
        text = text.replace(".", "");
        text = text.replace(",", "");

        String[] words = text.split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {

            if (word.equals("the") ||
                word.equals("was") ||
                word.equals("and") ||
                word.equals("a") ||
                word.equals("is") ||
                word.equals("of") ||
                word.equals("in")) {
                continue;
            }

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }

        for (String word : map.keySet()) {
            System.out.println(word + ": " + map.get(word));
        }
    }
}