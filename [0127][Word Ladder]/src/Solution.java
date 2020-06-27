import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-06-20
 * Time: 08:11
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given two words (beginWord and endWord), and a dictionary, find the length
     * of shortest transformation sequence from beginWord to endWord, such that:
     *
     *   - Only one letter can be changed at a time
     *   - Each intermediate word must exist in the dictionary
     *
     * For example,
     *
     * Given:
     * start = "hit"
     * end = "cog"
     * dict = ["hot","dot","dog","lot","log"]
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     *
     * Note:
     *   - Return 0 if there is no such transformation sequence.
     *   - All words have the same length.
     *   - All words contain only lowercase alphabetic characters.
     *
     * 题目大意：
     * 给定两个词（beginWord和endWord），和一个字典，查找从beginWord转型到endWord的最短长度：
     *   - 一次只有一个字母可以被改变
     *   - 每个中间字必须存在于词典中
     *
     * 注意：
     *   - 如果不存在这样的变换序列，返回0。
     *   - 所有单词具有相同的长度。
     *   - 所有单词只包含小写字母字符。
     *
     * 解题思路：
     * 广度优化遍历
     * </pre>
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordDict = new HashSet<>(wordList);

        char[] chars;
        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);
        int result = 0;
        String s;
        String t;
        while (!deque.isEmpty()) {

            // 处理当前层
            for (int k = deque.size(); k > 0; k--) {
                s = deque.removeFirst();

                if (s.equalsIgnoreCase(endWord)) {
                    return result + 1;
                }

                // 找出当前层的每个元素经过一次变化后，是否在剩余的wordDict中找到，
                // 如果找到就放到下一层的处理中
                chars = s.toCharArray();
                for (int i = 0; i < beginWord.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char temp = chars[i];
                        chars[i] = j;
                        t = new String(chars);
                        // 一次变换后可以找到单词，放到下一层处理中，并且在wordDict中删除记录
                        if (wordDict.contains(t) && !t.equals(s)) {
                            deque.addLast(t);
                            wordDict.remove(t);
                        }
                        // 还原
                        chars[i] = temp;
                    }
                }
            }


            result++;
        }

        return 0;
    }
}
