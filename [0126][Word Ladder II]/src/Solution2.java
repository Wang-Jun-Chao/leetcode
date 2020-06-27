import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-20 08:42
 **/
public class Solution2 {
    /**
     * <pre>
     * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     *
     * Return an empty list if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output:
     * [
     *   ["hit","hot","dot","dog","cog"],
     *   ["hit","hot","lot","log","cog"]
     * ]
     * Example 2:
     *
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * Output: []
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     *
     * 使用了深度优化遍历方案，会超时
     * </pre>
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        List<List<String>> result = new LinkedList<>();
        Deque<String> current = new LinkedList<>();
        findLadders(beginWord, endWord, wordDict, current, result);
        for (List<String> r : result) {
            r.add(0, beginWord);
        }
        return result;
    }

    private void findLadders(String beginWord, String endWord, Set<String> wordDict, Deque<String> current, List<List<String>> result) {

        if (beginWord.equals(endWord)) {

            // 还没有结果，或者有的最优解，就添加结果
            if (result.isEmpty() || result.get(0).size() == current.size()) {
                result.add(new LinkedList<>(current));
            }
            // 当前解不是最优解，记录最优化解
            else if (result.get(0).size() > current.size()) {
                result.clear();
                result.add(new LinkedList<>(current));
            }

            return;
        }

        // 已经找到至少一个可能的最优解，当前还没有找到最优化解，但是转换次数已经等于目前找到的最优化解的次数，
        // 目前的方案一定不存在最优化解
        if (!result.isEmpty() && current.size() >= result.get(0).size()) {
            return;
        }

        char[] chars = beginWord.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char temp = chars[i];
                chars[i] = ch;
                String s = new String(chars);

                if (wordDict.contains(s)) {
                    wordDict.remove(s);
                    current.add(s);

                    findLadders(s, endWord, wordDict, current, result);
                    // 还原
                    wordDict.add(s);
                    current.remove(s);
                }

                // 还原
                chars[i] = temp;
            }
        }
    }
}
