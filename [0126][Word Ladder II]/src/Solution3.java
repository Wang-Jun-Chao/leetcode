import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-20 08:42
 **/
public class Solution3 {
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
     * 使用了广度优化遍历方案，会超时
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
        // 用于保存所有中间结果
        Deque<Deque<String>> paths = new LinkedList<>();


        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);
        paths.addLast(deque);

        boolean find = false;

        while (!paths.isEmpty() && !find) {
            // 先遍历看是否找到结果，如果找到了，一定是最优化解
            for (Deque<String> path : paths) {
                if (path.getLast().equals(endWord)) {
                    result.add(new LinkedList<>(path));
                    find = true;
                }
            }

            // find表示已经找到了
            // paths.getFirst().size() >=beginWord.length()说明不可能找到结果，path最
            System.out.println(paths.getFirst().size());
            if (find || paths.getFirst().size() >= wordDict.size()) {
                break;
            }

            // TODO 什么时候判断找不到，path中可能形成环


            // 没有找到最优化解，构建下一层
            for (int k = paths.size(); k > 0; k--) {

                // 取路径的最后一个元素
                Deque<String> path = paths.removeFirst();
                String s = path.getLast();

                // 当前路径下，还可以使用的字词
                Set<String> set = new HashSet<>(wordDict);
                set.removeAll(path);

                System.out.println(set);

                // 找出当前层的每个元素经过一次变化后，是否在剩余的wordDict中找到，
                // 如果找到就放到下一层的处理中
                char[] chars = s.toCharArray();
                for (int i = 0; i < beginWord.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char temp = chars[i];
                        chars[i] = j;
                        String t = new String(chars);

                        // 一次变换后可以找到单词，放到下一层处理中
                        if (set.contains(t) && !t.equals(s)) {
                            path.addLast(t);
                            paths.addLast(new LinkedList<>(path));
                            path.removeLast();
                        }
                        // 还原
                        chars[i] = temp;
                    }
                }

            }
        }

        return result;
    }
}
