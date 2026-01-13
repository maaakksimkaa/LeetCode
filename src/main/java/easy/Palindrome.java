package easy;

import java.util.Arrays;

// Для заданного целого числа x верните true, если x является палиндромом, и false в противном случае.
public class Palindrome {
    public static void main(String[] args) {
        testCase(121);
        testCase(-121);
        testCase(10);
        testCase(0);
        testCase(1);
        testCase(1001);
        testCase(12321);
        testCase(12345);
    }
    private static void testCase(int num) {
        System.out.println("Результат для числа " + num + " равен: " + isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x % 10 == 0 && x != 0) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return x == reversed || x == reversed / 10;
    }
}
