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

    public int trap1(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                maxRight = Math.max(maxRight, height[j]);
            }

            // TODO 原理是什么？
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

        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
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
