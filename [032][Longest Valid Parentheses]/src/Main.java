/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-25
 * Time: 09:22
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses(")()())()"));
        System.out.println(solution.longestValidParentheses(")()(()()))()()()"));
    }
}
