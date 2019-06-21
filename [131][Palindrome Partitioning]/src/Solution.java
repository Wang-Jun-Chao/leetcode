import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-21 18:29
 **/
public class Solution {
    /**
     * <pre>
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return all possible palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     *
     * 解决方案：可以使用回溯法
     * TODO : 可以构建一个回文表，再进行判定
     * </pre>
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        Deque<String> current = new LinkedList<>();

        partition(s, 0, current, result);

        return result;
    }

    private void partition(String s, int index, Deque<String> current, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new LinkedList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String t = s.substring(index, i + 1);
            if (isPalindrome(s, index, i)) {
                current.addLast(t);
                partition(s, i + 1, current, result);
                // 还原
                current.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
