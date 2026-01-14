package easy;

import java.util.ArrayList;

// Подъём по лестнице
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("Результат: " + climbStairs(44));
    }

    public static int climbStairs(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(1, 1);

        for(int i = 2; i <= n; i++) {
            int element = list.get(i - 1) + list.get(i - 2);
            list.add(i, element);
        }

        return list.get(n);
    }

}
