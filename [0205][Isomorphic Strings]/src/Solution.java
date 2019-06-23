import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 11:57
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character while
     * preserving the order of characters. No two characters may map to the same character
     * but a character may map to itself.
     * <p>
     * For example,
     * Given "egg", "add", return true.
     * Given "foo", "bar", return false.
     * Given "paper", "title", return true.
     * <p>
     * Note:
     * You may assume both s and t have the same length.
     * <p>
     * 题目大意：
     * 给定两个字符串s和t，判断它们是否是同构的。
     * <p>
     * 如果字符串s可以通过字符替换的方式得到字符串t，则称s和t是同构的。
     * <p>
     * 字符的每一次出现都必须被其对应字符所替换，同时还需要保证原始顺序不发生改变。
     * 两个字符不能映射到同一个字符，但是字符可以映射到其本身。
     * <p>
     * 测试样例如题目描述。
     * 可以假设s和t等长。
     * <p>
     * 解题思路：
     * 【只要s和t满足一一映射就可以了】
     * 使用一个哈希表map维护两个字符串中字符的映射关系，同时用一个set保存映射的值。
     * (s[i], t[i])，如是s[i]键没有在map中出现过并且t[i]没有在set中出现过，就加入到映射关系中，
     * t[i]值已经出现过，说明是多对一映射，不符合返回false。s[i]键如果已经出现过，
     * 设为s[k]，对应的映射值为t[k]),即s[i]==s[k],则找出s[k]的对对应值t[k]，
     * 如果t[i]!=t[k],说明一个同一个字符存在两个不同的映射，两个字符串不是同构的，返回false，
     * 继续处理下一个字符，直到结束
     * <p>
     * 当出现映射不一致的情形时，返回False，否则返回True
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {

        // 两个字符串都为空
        if (s == null && t == null) {
            return true;
        }
        // 只有一个为空
        else if (s == null || t == null) {
            return false;
        }
        // 两个字符串的长度都为0
        else if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        // 两个字符串的长度不相等
        else if (s.length() != t.length()) {
            return false;
        }

        // 保存映射关系
        Map<Character, Character> map = new HashMap<>(s.length());
        Set<Character> set = new HashSet<>(t.length());
        char sChar;
        char tChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);

            // 键未出现过，就俺在映射关系
            if (!map.containsKey(sChar)) {
                if (set.contains(tChar)) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                    set.add(tChar);
                }
            }
            // 如是键已经出现过
            else {

                // 原先的键映射的值是map.get(sChar)，现在要映射的值是tChar
                // 如果两个值不相等，说明已经映射了两次，不符合，返回false
                if (map.get(sChar) != tChar) {
                    return false;
                }
            }


        }


        return true;
    }
}
