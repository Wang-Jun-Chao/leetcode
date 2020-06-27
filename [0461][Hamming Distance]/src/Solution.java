/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 09:25
 **/
public class Solution {
    /**
     * <pre>
     * The Hamming distance between two integers is the number of positions at which
     * the corresponding bits are different.
     *
     * Given two integers x and y, calculate the Hamming distance.
     *
     * Note:
     * 0 ≤ x, y < 231.
     *
     * Example:
     *
     * Input: x = 1, y = 4
     *
     * Output: 2
     *
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * The above arrows point to positions where the corresponding bits are different.
     * </pre>
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int result = 0;
        while (x > 0 && y > 0) {
            int xLeft = x % 2;
            int yLeft = y % 2;
            x /= 2;
            y /= 2;

            result += xLeft ^ yLeft;
        }

        if (y > 0) {
            x = y;
        }

        while (x > 0) {
            result += x % 2;
            x /= 2;
        }

        return result;
    }
}
