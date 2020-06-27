import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/keyboard-row/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 10:25
 **/
public class Solution {


    public String[] findWords(String[] words) {
        String[] lines = {
                "`1234567890-=~!@#$%^&*()_+",
                "qwertyuiop[]\\QWERTYUIOP{}|",
                "asdfghjkl;'ASDFGHJKL:\"",
                "zxcvbnm,./ZXCVBNM<>?"};

        if (words == null || words.length < 1) {
            return words;
        }

        List<String> result = new LinkedList<>();
        for (String s : words) {
            for (String l : lines) {
                if (contains(l, s)) {
                    result.add(s);
                    break;
                }
            }
        }

        return result.toArray(new String[0]);
    }

    private boolean contains(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (s.indexOf(t.charAt(i)) < 0) {
                return false;
            }

        }
        return true;
    }
}
