import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 10:28
 **/
public class Solution {
    public boolean isAnagram(String s, String t) {

        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            Integer count = map.get(c);
            // t有s中不包含的字符串
            if (count == null) {
                return false;
            } else {
                map.put(c, count - 1);
            }
        }

        // map中的值有非0的说明不合法
        for (Integer i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
