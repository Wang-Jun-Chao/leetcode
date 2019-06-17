import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-17 15:29
 **/
public class Solution {
    /**
     * <pre>
     * Given n non-negative integers representing the histogram's bar height where the width
     * of each bar is 1, find the area of largest rectangle in the histogram.
     *
     *
     *    -
     *   --
     *   --
     *   -- -
     * - ----
     * ------
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     *    -
     *   ==
     *   ==
     *   == -
     * - ==--
     * --==--
     * Example:
     * Input: [2,1,5,6,2,3]
     * Output: 10
     *
     * https://leetcode.com/problems/largest-rectangle-in-histogram/
     * </pre>
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        // 记录位置
        Deque<Integer> stack = new LinkedList<>();

        int i = 0;
        int result = 0;

        // 复制数组，最后位置补0，方便计算
        int[] h = Arrays.copyOf(heights, heights.length + 1);

        while (i < h.length) {
            // 之前的元素小于等于当前元素
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                // 当前元素入栈
                stack.push(i);
                i++;
            } else {
                // 栈顶元素位置出栈
                int t = stack.pop();
                // 高度是height[t]
                // stack.isEmpty(): 说明栈里的所有元素都比height[i]大，i位置之前有i个元素，序列就是[0 ,1, ..., i-1]
                // 所求的长度就是i
                // stack不为空，说明计算的位置是[stack.peek(), ..., i-1] 长度
                result = Math.max(result, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }


        return result;

    }
}
