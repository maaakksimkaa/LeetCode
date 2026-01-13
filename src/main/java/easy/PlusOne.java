package easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        test(new int[]{1, 2, 3}, new int[]{1, 2, 4});
        test(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2});
        test(new int[]{9}, new int[]{1, 0});
        test(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0});
        test(new int[]{1, 2, 9}, new int[]{1, 3, 0});
        test(new int[]{0}, new int[]{1});
        test(new int[]{8, 9, 9}, new int[]{9, 0, 0});
        test(new int[]{1}, new int[]{2});
    }

    static void test(int[] input, int[] expected) {
        int[] result = plusOne(input);
        boolean passed = arraysEqual(result, expected);
        String status = passed ? "✅ PASS" : "❌ FAIL";
        System.out.printf("%s | Input: %s | Expected: %s | Got: %s%n",
                status,
                Arrays.toString(input),
                Arrays.toString(expected),
                Arrays.toString(result));
    }

    static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
