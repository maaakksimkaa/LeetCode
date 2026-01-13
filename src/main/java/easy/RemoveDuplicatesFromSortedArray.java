package easy;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

    }

    // Удалите дубликаты из отсортированного массива
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int left = 1;
        for(int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right - 1]) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }
}
