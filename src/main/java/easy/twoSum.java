package easy;

// Дан массив целых чисел nums и целое число target.
// Верните индексы двух чисел, сумма которых равна target.
// Можно предположить, что для каждого входных данных существует ровно одно решение,
// и нельзя использовать один и тот же элемент дважды.
// Можно возвращать ответ в любом порядке.
// Ограничения:
// 2 <= nums.length <= 10 4
// -10 9 <= nums[i] <= 10 9
// -10 9 <= target <= 10 9
// Существует только один верный ответ.

import java.util.*;

public class twoSum {
    private static final int MAX_LENGTH = 10_000;
    private static final long MAX_VALUE = 1_000_000_000L;

    public static void main(String[] args) {
        testCase(new int[]{2, 7, 11, 15}, 9);
        testCase(new int[]{3, 2, 4}, 6);
        testCase(new int[]{3, 3}, 6);
        testCase(new int[]{-3, 4, 3, 90}, 0);
        testCase(new int[]{}, 9);
    }

    private static void testCase(int[] nums, int target) {
        try {
            int[] result = twoSum(nums, target);
            System.out.println("Результат тестирования: " + Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("В результате тестирования выявлено исключение. " + e.getMessage());
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        CheckingForConditions(nums, target);
        // Способ 1
        HashMap<Integer, Integer> map = new HashMap<>();
        int complement = 0;
        for(int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] { map.get(complement), i };
            map.put(nums[i], i);
        }
        return new int[] {};

        // Способ 2
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int complement = 0;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i)
                return new int[] {i, map.get(complement)};
        }

        return new int[] {};*/
    }


    public static void CheckingForConditions(int[] nums, int target) {
        // Проверка длины массива
        if (nums.length < 2 || nums.length > MAX_LENGTH) {
            throw new IllegalArgumentException("Нарушено первое условие задачи: " +
                    "длина массива должна быть между 2 и 10.000.");
        }
        // Проверка диапазона элементов массива
        for (int element : nums) {
            if (element < -MAX_VALUE || element > MAX_VALUE) {
                throw new IllegalArgumentException("Нарушено второе условие задачи: " +
                        "элементы массива должны быть в диапазоне [-10^9, 10^9].");
            }
        }
        // Проверка диапазона target
        if (target < -MAX_VALUE || target > MAX_VALUE) {
            throw new IllegalArgumentException("Нарушено третье условие задачи: " +
                    "target должен быть в диапазоне [-10^9, 10^9].");
        }
    }

}
