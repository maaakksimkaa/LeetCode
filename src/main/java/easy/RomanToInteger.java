package easy;

import java.util.HashMap;
import java.util.Map;

// Римские цифры представлены семью различными символами: I, V, X, L, C, D и M.
// Преобразуйте римскую цифру в целое число.
public class RomanToInteger {

    public static void main(String[] args) {
        String[] tests = { "III", "IV", "IX", "LVIII", "MCMXCIV" };

        for (String s : tests) {
            int value = romanToInt(s);
            System.out.println(s + " -> " + value);
        }
    }
    // Способ 1
    /*private static final Map<Character, Integer> ROMAN = new HashMap<>();
    static {
        ROMAN.put('I', 1);
        ROMAN.put('V', 5);
        ROMAN.put('X', 10);
        ROMAN.put('L', 50);
        ROMAN.put('C', 100);
        ROMAN.put('D', 500);
        ROMAN.put('M', 1000);
    }

    public static int romanToInt(String s) {
        int result = 0;
        int curr;
        int next;
        for (int i = 0; i < s.length() - 1; i++) {
            curr = ROMAN.get(s.charAt(i));
            next = ROMAN.get(s.charAt(i + 1));
            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        result += ROMAN.get(s.charAt(s.length() - 1));
        return result;
    }*/

    // Способ 2
    public static int romanToInt(String s) {
        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int curr = switch (ch) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };

            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }

            prev = curr;
        }

        return result;
    }

}
