package easy;
// Напишите функцию для поиска самого длинного общего префикса в массиве строк.
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] test1 = {"flower", "flow", "flight"};
        String result1 = longestCommonPrefix(test1);
        System.out.println("Тест 1: " + result1); // fl

        String[] test2 = {"dog", "racecar", "car"};
        String result2 = longestCommonPrefix(test2);
        System.out.println("Тест 2: " + result2); // (пусто)

        String[] test3 = {"hello"};
        String result3 = longestCommonPrefix(test3);
        System.out.println("Тест 3: " + result3); // hello

        String[] test4 = {"aaa", "aaa", "aaa"};
        String result4 = longestCommonPrefix(test4);
        System.out.println("Тест 4: " + result4); // aaa

        String[] test5 = {"", "flower"};
        String result5 = longestCommonPrefix(test5);
        System.out.println("Тест 5: " + result5); // (пусто)

        String[] test6 = {"apple", "app", "apricot"};
        String result6 = longestCommonPrefix(test6);
        System.out.println("Тест 6: " + result6); // ap
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        for (int pos = 0; pos < minLength; pos++) { // ← ИСПРАВЛЕНО!
            char firstChar = strs[0].charAt(pos);

            for (int i = 1; i < strs.length; i++) {
                if (firstChar != strs[i].charAt(pos)) {
                    return strs[0].substring(0, pos);
                }
            }
        }
        return strs[0].substring(0, minLength);

    }
}
