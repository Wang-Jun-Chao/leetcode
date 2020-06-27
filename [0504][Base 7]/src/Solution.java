/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 19:59
 **/
public class Solution {
    /**
     * <pre>
     * Given an integer, return its base 7 string representation.
     *
     * Example 1:
     * Input: 100
     * Output: "202"
     * Example 2:
     * Input: -7
     * Output: "-10"
     * Note: The input will be in range of [-1e7, 1e7].
     * </pre>
     *
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        String result = "";
        boolean positive = num >= 0;
        num = Math.abs(num);

        do {
            result = (num % 7) + result;
            num /= 7;
        } while (num > 0);

        return positive ? result : "-" + result;
    }
}
