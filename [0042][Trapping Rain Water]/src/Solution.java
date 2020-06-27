import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:20
 **/
class Solution {

    public int trap(int[] height) {
        return trap4(height);
    }

    /**
     * <pre>
     * 对于每个柱子，找到其左右两边最高的柱子，该柱子能容纳的面积就是min(max_left,max_right) - height。所以，
     * 1. 从左往右扫描一遍，对于每个柱子，求取左边最大值；
     * 2. 从右往左扫描一遍，对于每个柱子，求最大右值；
     * 3. 再扫描一遍，把每个柱子的面积并累加。
     * </pre>
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            // 找此柱左边最高的柱子
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 找此柱子右边最高的柱子
            for (int j = i + 2; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            // Math.min(maxLeft, maxRight) - height[i] 此柱子可以容纳的水
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];


        // 对于每个柱子求左右最大值，并保存起来
        for (int i = 1; i < size - 1; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[size - i - 1] = Math.max(height[size - i], rightMax[size - i]);
        }


        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * <pre>
     * 用一个栈辅助，小于栈顶的元素压入，大于等于栈顶就把栈里所有小于或
     * 等于当前值的元素全部出栈处理掉，计算面积，最后把当前元素入栈
     *
     *
     *
     *         =
     *    =   === =
     *  = == =======
     * =============
     * 0123456789012
     * </pre>
     *
     * @param height
     * @return
     */
    int trap3(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> st = new LinkedList<>();
        while (current < height.length) {
            // 当前元素比栈顶元素大
            while (!st.isEmpty() && height[current] > height[st.getFirst()]) {
                int top = st.pop();
                if (st.isEmpty()) {
                    break;
                }

                // 求距离，如上图，比如current=7，此时top=4，top到current距离：current-top-1
                int distance = current - st.peek() - 1;
                // top以下的水位已经计算过了，top以上的水位就
                // height[current] - height[top], height[st.peek()] - height[top]
                // 较小的值，简化为以下面的表达式
                int boundedHeight = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * boundedHeight;
            }

            // 当前元素不大于栈顶元素
            st.push(current++);
        }
        return ans;
    }

    /**
     * <pre>
     * 1. 扫描一遍，找到最高的柱子，这个柱子将数组分为两半；
     * 2. 处理左边一半；
     * 3. 处理右边一半。
     * </pre>
     *
     * @param height
     * @return
     */
    int trap4(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }

                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }

                --right;
            }
        }
        return ans;
    }
}
