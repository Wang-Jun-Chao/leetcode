import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-27 19:58
 **/
public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        String t = "aeiouAEIOU";

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        while (left < right) {
            while (left < right && !set.contains(chars[left])) {
                left++;
            }
            while (left < right && !set.contains(chars[right])) {
                right--;
            }

            if (left < right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}
