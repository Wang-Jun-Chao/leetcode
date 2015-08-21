/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:47
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * The count-and-say sequence is the sequence of integers beginning as follows:
     * 1, 11, 21, 1211, 111221, ...
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth sequence.
     * Note: The sequence of integers will be represented as a string.
     *
     * 题目大意
     * n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，
     * 所以输出11；n=3时，由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，
     * 有1个2和1个1，所以输出1211。依次类推，写个countAndSay(n)函数返回字符串。
     *
     * 解题思路
     * 第一种情况：n<0时返回null。
     * 第二种情况：当n=1时，返回1
     * 第三种情况：当n>1时，假设n-1返回的字符串是s，对s的串进行处理理，对不同的数字
     * 进行分组比如112365477899，分成11，2，3，6，5，4，77，8，99。最有就2个1，
     * 1个2，1个3，1个6，1个5，一个4，2个7，1个8，2个9，就是211213161614271829，返回此结果。
     * </pre>
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {

        if (n < 1) {
            return null;
        }

        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = countAndSay(result);
        }

        return result;
    }

    public String countAndSay(String str) {
        StringBuilder builder = new StringBuilder(128);

        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                builder.append(count);
                builder.append(str.charAt(i - 1));
                count = 1;
            }
        }

        builder.append(count);
        builder.append(str.charAt(str.length() - 1));
        return builder.toString();
    }
}
