package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree {
    public static void main(String[] args) {
        runTests();
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<TreeNode> stack_p = new Stack<>();
        Stack<TreeNode> stack_q = new Stack<>();

        TreeNode current_p = p;
        TreeNode current_q = q;

        while( (current_q != null || !stack_q.empty()) || (current_p != null || !stack_p.empty()) ) {

            while(current_q != null) {
                stack_q.push(current_q);
                current_q = current_q.left;
            }

            while(current_p != null) {
                stack_p.push(current_p);
                current_p = current_p.left;
            }

            if( (stack_q.size() != stack_p.size()) || (stack_q.peek().val != stack_p.peek().val) )
                return false;

            current_q = stack_q.pop();
            current_p = stack_p.pop();

            current_q = current_q.right;
            current_p = current_p.right;
        }
       return true;
    }

    // Вспомогательный метод для создания дерева из массива
    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty() && index < values.length) {
            TreeNode node = queue.poll();

            if (values[index] != null) {
                node.left = new TreeNode(values[index]);
                queue.add(node.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                node.right = new TreeNode(values[index]);
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }

    // Тестовый метод
    public static void runTests() {
        System.out.println("=== Same Tree Tests ===\n");

        // Тест 1: Оба дерева идентичны [1,2,3]
        System.out.println("Test 1: Identical trees [1,2,3]");
        TreeNode p1 = buildTree(new Integer[]{1, 2, 3});
        TreeNode q1 = buildTree(new Integer[]{1, 2, 3});
        boolean result1 = isSameTree(p1, q1);
        System.out.println("Expected: true, Got: " + result1);
        System.out.println("Status: " + (result1 == true ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 2: Разная структура [1,2] vs [1,null,2]
        System.out.println("Test 2: Different structure [1,2] vs [1,null,2]");
        TreeNode p2 = buildTree(new Integer[]{1, 2});
        TreeNode q2 = buildTree(new Integer[]{1, null, 2});
        boolean result2 = isSameTree(p2, q2);
        System.out.println("Expected: false, Got: " + result2);
        System.out.println("Status: " + (result2 == false ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 3: Разные значения узлов [1,2,1] vs [1,1,2]
        System.out.println("Test 3: Different node values [1,2,1] vs [1,1,2]");
        TreeNode p3 = buildTree(new Integer[]{1, 2, 1});
        TreeNode q3 = buildTree(new Integer[]{1, 1, 2});
        boolean result3 = isSameTree(p3, q3);
        System.out.println("Expected: false, Got: " + result3);
        System.out.println("Status: " + (result3 == false ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 4: Оба дерева пусты
        System.out.println("Test 4: Both trees are empty");
        TreeNode p4 = buildTree(new Integer[]{});
        TreeNode q4 = buildTree(new Integer[]{});
        boolean result4 = isSameTree(p4, q4);
        System.out.println("Expected: true, Got: " + result4);
        System.out.println("Status: " + (result4 == true ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 5: Одно дерево пусто
        System.out.println("Test 5: One tree is empty");
        TreeNode p5 = buildTree(new Integer[]{1});
        TreeNode q5 = buildTree(new Integer[]{});
        boolean result5 = isSameTree(p5, q5);
        System.out.println("Expected: false, Got: " + result5);
        System.out.println("Status: " + (result5 == false ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 6: Одиночный узел с одинаковым значением
        System.out.println("Test 6: Single node with same value");
        TreeNode p6 = buildTree(new Integer[]{5});
        TreeNode q6 = buildTree(new Integer[]{5});
        boolean result6 = isSameTree(p6, q6);
        System.out.println("Expected: true, Got: " + result6);
        System.out.println("Status: " + (result6 == true ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 7: Одиночный узел с разными значениями
        System.out.println("Test 7: Single node with different values");
        TreeNode p7 = buildTree(new Integer[]{5});
        TreeNode q7 = buildTree(new Integer[]{3});
        boolean result7 = isSameTree(p7, q7);
        System.out.println("Expected: false, Got: " + result7);
        System.out.println("Status: " + (result7 == false ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 8: Более глубокое дерево [1,2,3,4,5,6,7]
        System.out.println("Test 8: Deeper identical trees [1,2,3,4,5,6,7]");
        TreeNode p8 = buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode q8 = buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        boolean result8 = isSameTree(p8, q8);
        System.out.println("Expected: true, Got: " + result8);
        System.out.println("Status: " + (result8 == true ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 9: Деревья отличаются только в одном узле
        System.out.println("Test 9: Trees differ in one node [1,2,3] vs [1,2,5]");
        TreeNode p9 = buildTree(new Integer[]{1, 2, 3});
        TreeNode q9 = buildTree(new Integer[]{1, 2, 5});
        boolean result9 = isSameTree(p9, q9);
        System.out.println("Expected: false, Got: " + result9);
        System.out.println("Status: " + (result9 == false ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 10: Асимметричные деревья [1,2,null,3] vs [1,null,2,3]
        System.out.println("Test 10: Asymmetric trees [1,2,null,3] vs [1,null,2,3]");
        TreeNode p10 = buildTree(new Integer[]{1, 2, null, 3});
        TreeNode q10 = buildTree(new Integer[]{1, null, 2, 3});
        boolean result10 = isSameTree(p10, q10);
        System.out.println("Expected: false, Got: " + result10);
        System.out.println("Status: " + (result10 == false ? "✓ PASS" : "✗ FAIL") + "\n");

        // Тест 11: Отрицательные числа [-1,-2,-3]
        System.out.println("Test 11: Negative values [-1,-2,-3]");
        TreeNode p11 = buildTree(new Integer[]{-1, -2, -3});
        TreeNode q11 = buildTree(new Integer[]{-1, -2, -3});
        boolean result11 = isSameTree(p11, q11);
        System.out.println("Expected: true, Got: " + result11);
        System.out.println("Status: " + (result11 == true ? "✓ PASS" : "✗ FAIL") + "\n");

        // Подсчет пройденных тестов
        int passCount = 0;
        if (result1 == true) passCount++;
        if (result2 == false) passCount++;
        if (result3 == false) passCount++;
        if (result4 == true) passCount++;
        if (result5 == false) passCount++;
        if (result6 == true) passCount++;
        if (result7 == false) passCount++;
        if (result8 == true) passCount++;
        if (result9 == false) passCount++;
        if (result10 == false) passCount++;
        if (result11 == true) passCount++;

        System.out.println("=== Test Summary ===");
        System.out.println("Total tests: 11");
        System.out.println("Passed: " + passCount);
        System.out.println("Failed: " + (11 - passCount));
    }
}
