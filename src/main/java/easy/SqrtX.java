package easy;

// Поиск корня
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        int right = x;
        int left = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            long squared = (long) middle * middle;

            if (squared == x)
                return middle;
            else if (squared < x)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return right;
    }
}
