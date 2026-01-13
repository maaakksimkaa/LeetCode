package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Дана строка s, содержащая только символы '(', ')', '{', '}', '[' и ']'.
// Определите, является ли входная строка корректной.
public class ValidParentheses {
    private static final Map<Character, Character> PAIRS = new HashMap<>();
    static {
        PAIRS.put(')', '(');
        PAIRS.put('}', '{');
        PAIRS.put(']', '[');
    }
    public static void main(String[] args) {
        // Пример 1: Корректная последовательность
        String test1 = "()";
        boolean result1 = isValid(test1);
        System.out.println("Тест 1: \"" + test1 + "\" -> " + result1); // true

        // Пример 2: Вложенные скобки
        String test2 = "()[]{}";
        boolean result2 = isValid(test2);
        System.out.println("Тест 2: \"" + test2 + "\" -> " + result2); // true

        // Пример 3: Неправильный порядок закрытия
        String test3 = "([)]";
        boolean result3 = isValid(test3);
        System.out.println("Тест 3: \"" + test3 + "\" -> " + result3); // false

        // Пример 4: Только закрывающие скобки
        String test4 = "]";
        boolean result4 = isValid(test4);
        System.out.println("Тест 4: \"" + test4 + "\" -> " + result4); // false

        // Пример 5: Только открывающие скобки
        String test5 = "{[";
        boolean result5 = isValid(test5);
        System.out.println("Тест 5: \"" + test5 + "\" -> " + result5); // false

        // Пример 6: Пустая строка
        String test6 = "";
        boolean result6 = isValid(test6);
        System.out.println("Тест 6: \"" + test6 + "\" -> " + result6); // true

        // Пример 7: Сложная вложенность
        String test7 = "{[()]}";
        boolean result7 = isValid(test7);
        System.out.println("Тест 7: \"" + test7 + "\" -> " + result7); // true

        // Пример 8: Неверная вложенность
        String test8 = "([{}])";
        boolean result8 = isValid(test8);
        System.out.println("Тест 8: \"" + test8 + "\" -> " + result8); // true

        // Пример 9: Нечётное количество скобок
        String test9 = "({[";
        boolean result9 = isValid(test9);
        System.out.println("Тест 9: \"" + test9 + "\" -> " + result9); // false

        // Пример 10: Скобки в правильном порядке, но разные типы внутри
        String test10 = "[({})]";
        boolean result10 = isValid(test10);
        System.out.println("Тест 10: \"" + test10 + "\" -> " + result10); // true
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(PAIRS.containsKey(c)) {
                if(stack.isEmpty() || stack.pop() != PAIRS.get(c))
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
