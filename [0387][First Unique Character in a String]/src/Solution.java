import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-30 13:43
 **/
public class Solution {

    /**
     * <pre>
     * Given a string, find the first non-repeating character in it and return it's index.
     * If it doesn't exist, return -1.
     *
     * Examples:
     *
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     * </pre>
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }


        Map<Character, Integer> map = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            // 标记字符已经重复
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                // 记录位置
                map.put(s.charAt(i), i);
            }
        }

        Integer result = null;

        for (Integer n : map.values()) {
            if (n >= 0) {
                if (result == null) {
                    result = n;
                } else {
                    result = Math.min(n, result);
                }
            }
        }

        return result == null ? -1 : result;
    }
}
