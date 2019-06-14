import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: 王俊超
 * Date: 2015-06-17
 * Time: 20:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a string, find the length of the longest substring without repeating characters.
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
     * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     *
     * 题目大意：
     * 给定一个字符串，找字符中的最大非重复子串
     *
     * 解题思路：
     * 用start记录当当处理的开始位置
     * 历遍字符串，当当前字符从开始位置start开始已经出现过的时候，子串开始位置+1，否则更新map中的hash值为当前位置。
     * </pre>
     *
     * @param s
     * @return
     */
    // 可以处理所有的UTF-8字符
    public int lengthOfLongestSubstring(String s) {
        // 字符串输入不合法
        if (s == null) {
            return 0;
        }

        // 当前处理的开始位置
        int start = 0;
        // 保存结果
        int result = 0;
        // 访问标记，记录最新一次访问的字符和位置
        Map<Character, Integer> map = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果字符已经出现过(在标记开位置算起)，就重新标记start
            if (map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            }
            // 如果没有出现过就求最大的非重复子串的长度
            else {
                result = Math.max(result, i - start + 1);
            }

            // 更新访问记录
            map.put(ch, i);
        }
        return result;
    }

    // 只考虑ASCII字符
    public int lengthOfLongestSubstring2(String s) {
        // 字符串输入不合法
        if (s == null) {
            return 0;
        }

        // 标记字符是否出现过，并且记录是的最新一次访问的元素的位置
        int[] appear = new int[256];
        // 初始化为-1
        Arrays.fill(appear, -1);
        // 当前处理的开始位置
        int start = 0;
        // 保存结果
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            // 如果字符已经出现过(在标记开位置)，就重新标记start
            if (appear[s.charAt(i)] >= start) {
                start = i + 1;
            }
            // 如果没有出现过就求最大的非重复子串的长度
            else {
                result = Math.max(result, i - start + 1);
            }
            // 标记第i个字符已经被访问过（最新是第i个位置）
            appear[s.charAt(i)] = i;
        }

        return result;
    }
}
