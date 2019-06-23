/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-23 15:09
 **/
public class Solution {
    /**
     * <pre>
     * Implement int sqrt(int x).
     *
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     *
     * Since the return type is an integer, the decimal digits are truncated and only the integer
     * part of the result is returned.
     *
     * Example 1:
     *
     * Input: 4
     * Output: 2
     * Example 2:
     *
     * Input: 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since
     *              the decimal part is truncated, 2 is returned.
     * </pre>
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        return mySqrt2(x);
    }

    /**
     * 使用二分法
     * <pre>
     * 思路：要实现一个sqrt函数，可以使用二分法，首先确定一个范围[begin, end]，这个范围的中间数mid，
     * 看mid的平方是否等于x，如果相等，则返回mid，如果不等则缩小[begin,end]的范围，为原来的一半。这
     * 里的初始范围可以是[1, x]，也可以是更精确一些的[1, (x/2) + 1]。（因 (x/2) + 1 的平方等于
     * x+1+(x^2/4)，它一定大于x，所以，x的平方根一定在[1, (x/2) + 1]范围内）
     *
     * </pre>
     *
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    /**
     * 使用牛顿法
     * <pre>
     * x^2 = a的解，也就是函数f(x) = x^2 – a与x轴的交点。可以在x轴上先任选一点x0，则点（x0, f(x0)）
     * 在f(x)上的切线，与x轴的交点为x1，它们满足切线的方程：f(x0)=(x0-x1)f’(x0)，可得x1更接近最终的
     * 结果，解方程得到：
     * 切线方程：y = 2x0(x - x0) + x0^2 - a，令y=0 -> x = (x0 + (a/x0))/2，即为x1的值
     *
     * x1 = (x0 + (a/x0))/2。以x1为新的x0，按照切线的方法依次迭代下去，最终求得符合精确度要求的结果值。
     * </pre>
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
