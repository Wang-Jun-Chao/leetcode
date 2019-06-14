import java.util.Queue;
import java.util.Stack;

/**
 * Author: 王俊超
 * Date: 2015-06-20
 * Time: 06:58
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     *
     * Some examples:
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     *
     * 题目大意：
     * 计算逆波半表达式的值，有效的运算符是：+、-、*、/，每个操作数要么是一个整数要么是另一个表达式
     *
     * 解题思路：
     * 使用栈进行操作
     * </pre>
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        // 参数校验
        if (tokens == null || tokens.length < 1) {
            throw new IllegalArgumentException();
        }

        int op1;
        int op2;
        // 操作数栈
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // 说明是运算符，要取栈顶两个元素进行运算
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                // 取栈顶元素
                op2 = stack.pop();
                op1 = stack.pop();

                // 进行运算
                switch (token.charAt(0)) {
                    case '+':
                        op1 += op2;
                        break;
                    case '-':
                        op1 -= op2;
                        break;
                    case '*':
                        op1 *= op2;
                        break;
                    case '/':
                        op1 /= op2;
                        break;
                }
                // 结果入栈
                stack.push(op1);
            }
            // 说明是操作数，入栈
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        // 栈中最后只会剩下一个元素，那就是最后计算的结果
        return stack.pop();
    }
}
