/**
 * Author: 王俊超
 * Time: 2020-06-30 12:50
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 2 || k < 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length) {
            swap(chars, index, Math.min(chars.length - 1, index + k - 1));
            index += 2 * k;
        }

        return new String(chars);
    }

    public void swap(char[] chars, int i, int j) {
        while (i < j) {
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
            i++;
            j--;
        }
    }
}
