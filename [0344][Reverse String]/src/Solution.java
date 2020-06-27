/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-16 16:04
 **/
public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }

        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
