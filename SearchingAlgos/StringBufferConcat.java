public class StringBufferConcat {
    public static String concatStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"Hello", " ", "World", "!"};
        System.out.println(concatStrings(arr)); // Output: Hello World!
    }
}

