import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-20 08:42
 **/
public class Solution {
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
     * 使用了图的遍历
     * https://www.cnblogs.com/splash/p/4102786.html
     * </pre>
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    HashMap<String, ArrayList<String>> nodeSet = new HashMap<>();

    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);

        List<List<String>> result = new ArrayList<List<String>>();

        if (!wordDict.contains(end)) {
            return result;
        }

        Queue<String> q = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>();
        HashMap<String, Integer> dist = new HashMap<String, Integer>();
        q.add(start);
        nodeSet.put(start, new ArrayList<String>());
        nodeSet.put(end, new ArrayList<String>());
        dist.put(start, 1);

        while (!q.isEmpty()) {
            String temp = q.poll();
            int l = dist.get(temp);
            hs.add(temp);
            for (int i = 0; i < temp.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (temp.charAt(i) == c) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(temp);
                    sb.setCharAt(i, c);
                    String next = sb.toString();
                    if (next.equals(end)) {
                        if (!dist.containsKey(end)) {
                            dist.put(end, l + 1);
                            nodeSet.get(end).add(temp);
                        } else if (dist.get(end) == l + 1) {
                            nodeSet.get(end).add(temp);
                        }
                    } else if (wordDict.contains(next) && !hs.contains(next)) {
                        if (!dist.containsKey(next)) {
                            q.add(next);
                            dist.put(next, l + 1);
                            ArrayList<String> arr = new ArrayList<String>();
                            arr.add(temp);
                            nodeSet.put(next, arr);
                        } else if (dist.get(next) == l + 1) {
                            nodeSet.get(next).add(temp);
                        }
                    }
                }
            }
        }
        List<String> path = new ArrayList<String>();
        path.add(end);

        collect(start, result, path, nodeSet.get(end));
        return result;
    }

    public void collect(String start, List<List<String>> re, List<String> path, ArrayList<String> prevNodes) {
        for (int i = 0; i < prevNodes.size(); i++) {
            path.add(0, prevNodes.get(i));
            if (prevNodes.get(i).equals(start)) {
                List<String> pathCopy = new ArrayList<String>(path);
                re.add(pathCopy);
            } else {
                collect(start, re, path, nodeSet.get(prevNodes.get(i)));
            }
            path.remove(0);
        }
    }
}
