import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-08 18:59
 **/
public class Solution {
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

        int[] pArr = new int[26];
        int[] sArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (i > 0) {
                sArr[s.charAt(i - 1) - 'a']--;
                sArr[s.charAt(i + p.length() - 1) - 'a']++;
            }

            if (Arrays.equals(sArr, pArr)) {
                result.add(i);
            }
        }

        return result;
    }
}
