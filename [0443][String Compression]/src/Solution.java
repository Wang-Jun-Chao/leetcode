/**
 * Author: 王俊超
 * Time: 2020-06-26 07:29
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 从向前处理
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int end;
        int start = 0;
        int length = 0;
        while (start < chars.length) {
            end = start + 1;
            while (end < chars.length && chars[start] == chars[end]) {
                end++;
            }

            String num = "" + (end - start);

            length += 1;
            if (end - start > 1) { // 有重复的字符
                length += num.length(); // 重复字符的个数
                int tmp = start + 1;
                for (int i = 0; i < num.length(); i++) {
                    chars[tmp] = num.charAt(i);
                    tmp++;
                }

                while (tmp < end) { // 不需要的字符清零
                    chars[tmp] = 0;
                    tmp++;
                }
            }

            start = end; // 开始处理下一个字符

        }


        // 找第一个0值的字符位置
        start = 0;
        while (start < chars.length && chars[start] != 0) {
            start++;
        }

        end = start;
        while (end < chars.length) {
            // 找start位置之后第一个值不为0的位置
            while (end < chars.length && chars[end] == 0) {
                end++;
            }

            // 将end及之后不为0的值向前移动
            while (end < chars.length && chars[end] != 0) {
                chars[start] = chars[end];
                start++;
                end++;
            }

        }


        return length;
    }
}
