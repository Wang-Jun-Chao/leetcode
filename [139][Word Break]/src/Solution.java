import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: 王俊超
 * Date: 2015-06-21
 * Time: 08:13
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     *
     * Given a string s and a dictionary of words dict, determine if s can
     * be segmented into a space-separated sequence of one or more dictionary words.
     *
     * For example, given
     * s = "leetcode",
     * dict = ["leet", "code"].
     * Return true because "leetcode" can be segmented as "leet code".
     *
     * 题目大意：
     * 给定一个字符串s和单词字典dict，确定s是否可以分割成一个或多个单词空格分隔的序列。
     *
     * 解题思路：
     * 一个字符串S，它的长度为N，如果S能够被“字典集合”（dict）中的单词拼接而成，那么所要满足的条件为：
     * F(0, N) = F(0, i) && F(i, j) && F(j, N);
     * 这样子，如果我们想知道某个子串是否可由Dict中的几个单词拼接而成就可以用这样的方式得到结果
     * （满足条件为True, 不满足条件为False）存入到一个boolean数组的对应位置上，这样子，最后boolean
     * 数组的最后一位就是F(0, N)的值，为True表示这个字符串S可由Dict中的单词拼接，否则不行！
     * </pre>
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        // 参数校验
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        // 标记是否匹配，match[i]表表[0, i-1]都匹配
        int length = s.length();
        boolean[] match = new boolean[length + 1];
        match[0] = true;

        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    // f(0,n) = f(0,i) + f(i,j) + f(j,n)
                    match[i] = true;
                    break;
                }
            }
        }


        return match[length];
    }


    // 下面是另一种解法，但是会超时
    public boolean wordBreak2(String s, Set<String> wordDict) {

        // 参数校验
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        Map<Character, Set<String>> wordMap = new HashMap<>(wordDict.size());
        // 将所有开始字符相同的单词放入一个Set中
        for (String word : wordDict) {
            Set<String> set = wordMap.get(word.charAt(0));
            if (set == null) {
                // 新创建一个set放入Map中
                set = new HashSet<>();
                wordMap.put(word.charAt(0), set);
            }
            // 单词存入set中
            set.add(word);
        }

        return wordBreak(s, 0, wordMap);
    }

    /**
     * 搜索字符串是否可以被分割成单词串
     *
     * @param s       字符串
     * @param idx     处理的开始位置
     * @param wordMap 单词字典，开始字符相同的在同一个set集合中
     * @return 搜索结果
     */
    public boolean wordBreak(String s, int idx, Map<Character, Set<String>> wordMap) {

        if (idx >= s.length()) {
            return true;
        }

        Set<String> words = wordMap.get(s.charAt(idx));

        if (words != null) {
            for (String word : words) {
                // idx之前的字符已经匹配，如果从ide之后起匹配word单词
                if (s.startsWith(word, idx)) {
                    // 递归处理
                    boolean result = wordBreak(s, idx + word.length(), wordMap);
                    // 如果满足条件，返回true
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
