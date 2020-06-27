import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-08 18:59
 **/
public class Solution2 {
    /**
     * <pre>
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     *
     * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
     *
     * The order of output does not matter.
     *
     * Example 1:
     *
     * Input:
     * s: "cbaebabacd" p: "abc"
     *
     * Output:
     * [0, 6]
     *
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     *
     * Input:
     * s: "abab" p: "ab"
     *
     * Output:
     * [0, 1, 2]
     *
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     * </pre>
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();

        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> map1 = getMap(p);
        Map<Character, Integer> map2 = getMap(s.substring(0, p.length()));
        for (int i = 0; i <= s.length() - p.length(); i++) {

            char lastChar = s.charAt(i + p.length() - 1);
            char prevChar;
            if (i > 0 && (prevChar = s.charAt(i - 1)) != lastChar) {
                Integer val = map2.get(prevChar);
                if (val <= 1) {
                    map2.remove(prevChar);
                } else {
                    map2.put(prevChar, val - 1);
                }

                val = map2.get(lastChar);
                if (val == null) {
                    map2.put(lastChar, 1);
                } else {
                    map2.put(lastChar, val + 1);
                }
            }

            if (equals(map1, map2)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean equals(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() == map2.size()) {
            return contains(map1, map2) && contains(map2, map1);
        }
        return false;
    }

    /**
     * map1是否包含map2，即map2中的(k, v)都在map1中
     *
     * @param map1
     * @param map2
     * @return
     */
    private boolean contains(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> e : map2.entrySet()) {
            Integer v2 = map1.get(e.getKey());
            if (!map1.containsKey(e.getKey()) || !Objects.equals(e.getValue(), v2)) {
                return false;
            }
        }
        return true;
    }


    public Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        return map;
    }
}
