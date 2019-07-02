/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 03:55
 **/
public class Solution {
    /**
     * <pre>
     * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
     *
     * Note:
     *
     * All letters in hexadecimal (a-f) must be in lowercase.
     * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
     * The given number is guaranteed to fit within the range of a 32-bit signed integer.
     * You must not use any method provided by the library which converts/formats the number to hex directly.
     * Example 1:
     *
     * Input:
     * 26
     *
     * Output:
     * "1a"
     * Example 2:
     *
     * Input:
     * -1
     *
     * Output:
     * "ffffffff"
     * </pre>
     *
     * @param num
     * @return
     */
    public String toHex(int num) {
        String result = "";
        String hex = "0123456789abcdef";
        int mask = 0b1111;

        int i;
        do {
            // 取低四位的值
            i = num & mask;
            // 转成16进制
            result = hex.charAt(i) + result;
            // 无符号右移四位，直到0
            num >>>= 4;
        } while (num > 0);

        return result;
    }
}
