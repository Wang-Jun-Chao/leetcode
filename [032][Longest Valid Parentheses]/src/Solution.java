import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: 王俊超
 * Date: 2015-06-25
 * Time: 09:12
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     *
     * For "(()", the longest valid parentheses substring is "()", which has length = 2.
     * Another example is ")()())", where the longest valid parentheses substring is "()()",
     * which has length = 4.
     *
     * 题目大意：
     * 给定一个字符串，只包含小括号号，求最长的合法的小括号的数目
     *
     * 解题思路：
     * 使用栈来实现
     * </pre>
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        // 用于记录待匹配的左括号和右括号的位置
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            // 如是当前字符是右括号，并且记录栈非空，并且前一个字符是左括号
            if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(') {
                // 左括号出栈
                st.pop();
                // 求最大值
                // 此时与(匹配的)已经出栈，所以栈要么为空，要么是与当前)最近的)
                // 要么是与当前)第二近的(
                max = Math.max(max, i - ((st.isEmpty()) ? -1 : st.peek()));
            }
            // 其它情况就将字符入栈
            else {
                st.push(i);
            }
        }

        return max;
    }
}
