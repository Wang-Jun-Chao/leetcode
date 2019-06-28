import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:32
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a string containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[’ and ‘]’,
     * determine if the input string is valid.
     * The brackets must close in the correct order, “()” and “()[]{}” are all valid
     * but “(]” and “([)]” are not.
     *
     * 题目大意
     * 给定一个只包含(‘, ‘)’, ‘{‘, ‘}’, ‘[’ 和‘]’的字符串，验证它是否是有效的。
     * 括号必须配对，并且要以正确的顺序。
     *
     * 解题思路
     * 用一个栈来对输入的括号串进行处理，如果是左括号就入栈，如果是右括号就与栈顶元素看是否组成一对括号，
     * 组成就弹出，并且处理下一个输入的括号，如果不匹配就直接返回结果。
     * </pre>
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        final String left = "([{";
        final String right = ")]}";

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);

            // 如果是左括号就入栈
            if (left.indexOf(c) > -1) {
                stack.push(c);
            } else {
                // 如果是右括号就看栈顶元素
                // 如果栈为空或者栈顶元素不匹配就返回false
                if (stack.isEmpty() || right.indexOf(c) != left.indexOf(stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
