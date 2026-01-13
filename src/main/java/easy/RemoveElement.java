package easy;

import java.util.Arrays;

// Удалите все вхождения val в nums на месте.
public class RemoveElement {
    public static void main(String[] args) {
        // Тест 1: Базовый случай
        test(new int[]{3, 2, 2, 3}, 3, 2, "Базовый случай");
        // Тест 2: Все элементы равны val
        test(new int[]{1, 1, 1, 1}, 1, 0, "Все элементы равны val");
        // Тест 3: val отсутствует в массиве
        test(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 5, 8, "val отсутствует");
        // Тест 4: val в начале и конце
        test(new int[]{2, 1, 3, 4, 2}, 2, 3, "val в начале и конце");
        // Тест 5: Один элемент
        test(new int[]{1}, 1, 0, "Один элемент");
    }

    private static void test(int[] nums, int val, int expectedK, String description) {

        int[] originalNums = nums.clone(); // Сохраняем оригинальный массив
        int k = removeElement(nums, val);

        System.out.println("  Исходный массив: " + Arrays.toString(originalNums));
        System.out.println("  val = " + val);
        System.out.println("  Ожидается k = " + expectedK);
        System.out.println("  Получилось k = " + k);
        System.out.println();

    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if(nums[left] == val) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                right--;
            } else
                left++;
        }
        return left;

    }

}
