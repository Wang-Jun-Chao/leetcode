import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 10:54
 **/
public class Solution {
    /**
     * <pre>
     * Implement a basic calculator to evaluate a simple expression string.
     *
     * The expression string contains only non-negative integers, +, -, *, / operators
     * and empty spaces . The integer division should truncate toward zero.
     *
     * Example 1:
     *
     * Input: "3+2*2"
     * Output: 7
     * Example 2:
     *
     * Input: " 3/2 "
     * Output: 1
     * Example 3:
     *
     * Input: " 3+5 / 2 "
     * Output: 5
     * Note:
     *
     * You may assume that the given expression is always valid.
     * Do not use the eval built-in library function.
     * 思路：
     * 遇到加减就入操作数栈和操作符栈，遇到乘除就计算，将计算结果作为新的字符串的第一个值，后面是处理的字符串
     * 最后处理所有剩下的加减操作
     * 如 1+2+3*4+5+6
     * 处理完第一个*号后
     * operator: +, +
     * operand: 1, 2
     * s: 12+5+6
     * 整个字符串处理完后
     * operator: +, +, +, +
     * operand: 1, 2, 12, 5, 6
     * 再进行计算
     * </pre>
     *
     * @param s
     * @return
     */
    public int calculate(String s) {

        if (s == null || s.length() < 1) {
            throw new IllegalArgumentException("s: " + s);
        }

        Deque<Integer> operands = new LinkedList<>();
        Deque<Character> operators = new LinkedList<>();

        int idx = 0;
        while (idx < s.length()) {
            while (idx < s.length() && s.charAt(idx) == ' ') {
                idx++;
            }

            // 找操作数
            int start = idx;
            idx++;
            while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                idx++;
            }
            // 操作数入栈
            operands.addLast(Integer.parseInt(s.substring(start, idx)));

            // 找idx后的第一个非空白字符
            while (idx < s.length() && s.charAt(idx) == ' ') {
                idx++;
            }

            // 如果是乘法或者除法，就进行一次计算
            if (idx < s.length() && (s.charAt(idx) == '*' || s.charAt(idx) == '/')) {
                char op = s.charAt(idx);
                // 下一个数字的第一个位置
                while (idx < s.length() && !Character.isDigit(s.charAt(idx))) {
                    idx++;
                }

                start = idx;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    idx++;
                }

                int operand = Integer.parseInt(s.substring(start, idx));
                int prev = operands.removeLast();
                int result = calculate(prev, operand, op);
                // 计算结果放在新的字符串首位，idx变成第一位
                // 比如 1*2+3 => 2+3
                s = result + s.substring(idx);
                idx = 0;
            } else if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
                // 如果是加减
                operators.addLast(s.charAt(idx));
                idx++;
            } else {
                idx++;
            }
        }

        while (!operators.isEmpty()) {
            int a = operands.removeFirst();
            int b = operands.removeFirst();
            int r = calculate(a, b, operators.removeFirst());
            operands.addFirst(r);
        }

        return operands.getLast();
    }

    private int calculate(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }
}
