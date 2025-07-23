public class SearchWordInSentences {
    public static String search(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"This is a test.","We are learning Java.","Searching for a word."};
        System.out.println(search(sentences, "Java"));
    }
}

