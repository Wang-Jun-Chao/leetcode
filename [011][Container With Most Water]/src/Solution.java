/**
 * Author: 王俊超
 * Date: 2015-06-30
 * Time: 07:25
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given n non-negative integers a1, a2, ..., an, where each represents
     * a point at coordinate (i, ai). n vertical lines are drawn such that
     * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
     * which together with x-axis forms a container, such that the container
     * contains the most water.
     *
     * Note: You may not slant the container.
     *
     * 题目大意：
     * 找两条竖线然后这两条线以及X轴构成的容器能容纳最多的水。
     *
     * 解题思路：
     * 使用贪心算法，
     *      1.首先假设我们找到能取最大容积的纵线为 i, j (假定i<j)，
     *      那么得到的最大容积 C = min( ai , aj ) * ( j- i) ；
     *
     *      2.下面我们看这么一条性质：
     *          ①: 在 j 的右端没有一条线会比它高！假设存在 k |( j<k && ak > aj) ，
     *          那么  由 ak > aj，所以 min(ai, aj, ak) =min(ai, aj) ，
     *          所以由i, k构成的容器的容积C' = min(ai, aj) * (k - i) > C，
     *          与C是最值矛盾，所以得证j的后边不会有比它还高的线；
     *
     *          ②:同理，在i的左边也不会有比它高的线；这说明什么呢？
     *          如果我们目前得到的候选： 设为 x, y两条线（x< y)，那么能够得到比
     *          它更大容积的新的两条边必然在[x, y]区间内并且 ax' >= ax , ay' >= ay;
     *
     *      3.所以我们从两头向中间靠拢，同时更新候选值；在收缩区间的时候优先从
     *      x, y中较小的边开始收缩；
     * </pre>
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        // 参数校验
        if (height == null || height.length < 2) {
            return 0;
        }


        // 记录最大的结果
        int result = 0;

        // 左边的竖线
        int left = 0;
        // 右边的竖线
        int right = height.length - 1;

        while (left < right) {
            // 设算当前的最大值
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            // 如果右边线高
            if (height[left] < height[right]) {
                int k = left;
                // 从[left, right - 1]中，从左向右找，找第一个高度比height[left]高的位置
                while (k < right && height[k] <= height[left]) {
                    k++;
                }

                // 从[left, right - 1]中，记录第一个比原来height[left]高的位置
                left = k;
            }
            // 左边的线高
            else {
                int k = right;
                // 从[left + 1, right]中，从右向左找，找第一个高度比height[right]高的位置
                while (k > left && height[k] <= height[right]) {
                    k--;
                }

                // 从[left, right - 1]中，记录第一个比原来height[right]高的位置
                right = k;
            }
        }

        return result;
    }
}
