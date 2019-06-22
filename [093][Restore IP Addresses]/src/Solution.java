import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-23 06:48
 **/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        doRestore(result, "", s, 0);
        return result;
    }

    private void doRestore(List<String> result, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4) {
                result.add(path.substring(1));
            }
            return;
        }

        int length = (s.charAt(0) == '0' ? 1 : 3); // 避免前导0
        length = length < s.length() ? length : s.length();
        for (int i = 1; i <= length; i++) {
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255) {
                doRestore(result, path + "." + part, s.substring(i), k + 1);
            }
        }
    }
}
