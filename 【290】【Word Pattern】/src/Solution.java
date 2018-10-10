import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 17:24
 **/
public class Solution {
    public boolean wordPattern(String pattern, String str) {

        if (pattern == null && str == null) {
            return true;
        } else if (pattern == null || str == null) {
            return false;
        }

        String[] parts = str.split("\\s+");

        if (pattern.length() != parts.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> rmap = new HashMap<>();

        Character c;
        for (int i = 0; i < pattern.length(); i++) {
            c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, parts[i]);
            } else {
                if (!parts[i].equals(map.get(c))) {
                    return false;
                }
            }
            // 双射，两边都要验证
            if (!rmap.containsKey(parts[i])) {
                rmap.put(parts[i], c);
            } else {
                if (!c.equals(rmap.get(parts[i]))) {
                    return false;
                }
            }
        }

        return true;
    }
}
