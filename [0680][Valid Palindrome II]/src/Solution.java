/**
 * Author: 王俊超
 * Time: 2020-07-07 10:12
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            // 有一个不相等，可以抛弃start或者end字符，抛弃一个字符后，后面的都要是回文
            if (s.charAt(start) != s.charAt(end)) {
                return validPalindrome(s, start + 1, end) || validPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean validPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
