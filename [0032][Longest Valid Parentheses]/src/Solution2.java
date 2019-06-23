import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: 王俊超
 * Date: 2015-06-25
 * Time: 09:12
 * Declaration: All Rights Reserved !!!
 */
public class Solution2 {
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
        int result = 0;
        int start = 0;
        // 记录左括号的位置
        Deque<Integer> m = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            // 是左括号就记录位置
            if (s.charAt(i) == '(') {
                m.push(i);
            }
            // 是右括号
            else if (s.charAt(i) == ')') {
                // 之前的括号都已经配对，或者从没有括号配对
                if (m.isEmpty()) {
                    // 当前的位置已经是无效了，记录下一个位置是开始配对的位置
                    start = i + 1;
                } else {
                    // 出栈对应的左括号
                    m.pop();
                    // 如果栈为空，说明从start开始一直匹配，没出现多余的左括号：
                    // 结果就是：Math.max(result, i - start + 1)
                    // 如果栈非空，说明有多余的左括号，最后一个多余的左括号的位置就是m.peek()，
                    // 最大的匹配括号就是: Math.max(result, i - m.peek())
                    result = m.isEmpty() ? Math.max(result, i - start + 1) : Math.max(result, i - m.peek());
                }
            }
        }
        return result;
    }
}
