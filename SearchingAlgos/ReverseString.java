import java.util.*;
public class ReverseString {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println(reverse(input));
    }
}
