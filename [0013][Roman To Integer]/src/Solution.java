/**
 * Author: 王俊超
 * Date: 2015-03-01
 * Time: 16:09
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a roman numeral, convert it to an integer.
     * Input is guaranteed to be within the range from 1 to 3999.
     *
     * 题目大意
     * 给定一个罗马数字，将其转换成对应的整数。
     * 输入的数字在1-3999之间。
     *
     * 解题思路
     * 从前往后扫描，用一个临时变量记录分段数字。
     * 如果当前比前一个大，说明这一段的值应该是当前这个值减去上一个值。比如IV = 5 – 1；否
     * 则，将当前值加入到结果中，然后开始下一段记录。比如VI = 5 + 1, II=1+1
     * </pre>
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            // 当前的值比前一个值大，说明[i-1, i]组成一个值，并且值是s[i-1]-s[i]
            if (i > 0 && charToInt(s.charAt(i)) > charToInt(s.charAt(i - 1))) {
                // 要减去两倍之前前值才能回到真实值
                result += charToInt(s.charAt(i)) - 2 * charToInt(s.charAt(i - 1));
            } else {
                result += charToInt(s.charAt(i));
            }
        }

        return result;
    }

    private int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
