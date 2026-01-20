package easy;

import java.util.Arrays;

// Объединение отсортированных массивов
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[] {4,5,6,0,0,0};
        int[] nums2 = new int[] {1,2,3};
        int m = 3;
        int n = 3;

        System.out.println(Arrays.toString(merge(nums1, m, nums2, n)));
    }
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0)
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];

        while (p2 >= 0)
            nums1[p--] = nums2[p2--];


        return nums1;
    }

}
