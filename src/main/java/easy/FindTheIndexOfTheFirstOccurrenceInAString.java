package easy;

// Найдите индекс первого вхождения в строку
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        // Тестовые случаи
        testCase("sadbutsad", "sad", 0);
        testCase("leetcode", "leeto", -1);
        testCase("a", "a", 0);
        testCase("ab", "b", 1);
        testCase("aab", "aab", 0);
        testCase("aaaa", "aa", 0);
        testCase("aaab", "aab", 1);
        testCase("mississippi", "issip", 4);
        testCase( "hello", "ll", 2);
        testCase("abc", "xyz", -1);
    }

    private static void testCase( String haystack, String needle, int expected) {
        int result = strStr(haystack, needle);
        String status = result == expected ? "✅ PASS" : "❌ FAIL";
        System.out.println(String.format("%s | haystack: \"%s\", needle: \"%s\" | Expected: %d, Got: %d",
                status, haystack, needle, expected, result));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean match = true;
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if(match) return i;
        }

        return -1;
    }
}
