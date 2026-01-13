package easy;

// Позиция вставки при поиске за O(log n)
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // Обычные случаи
        test(arr, 7, 3);
        test(arr, 1, 0);
        test(arr, 19, 9);

        // Специальные случаи
        test(new int[]{5}, 5, 0);
        test(new int[]{3, 7}, 3, 0);
        test(new int[]{3, 7}, 7, 1);
    }

    public static void test(int[] arr, int target, int expected) {
        int result = searchInsert(arr, target);
        String status = result == expected ? "✅" : "❌";
        System.out.printf("%s target:%d expected:%d got:%d%n",
                status, target, expected, result);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
