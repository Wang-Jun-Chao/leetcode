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

    int trap3(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> st = new LinkedList<>();
        while (current < height.length) {
            while (!st.isEmpty() && height[current] > height[st.getFirst()]) {
                int top = st.peek();
                st.pop();
                if (st.isEmpty()) {
                    break;
                }
                int distance = current - st.peek() - 1;
                int boundedHeight = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            st.push(current++);
        }
        return ans;
    }

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
