import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 10:54
 **/
public class Solution {
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
            } else if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')){
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
