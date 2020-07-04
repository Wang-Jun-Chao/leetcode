import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Author: 王俊超
 * Time: 2020-07-04 15:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {

    /**
     * 求每个元素的个数，再找相邻元素之和最大的
     * 相邻指元素之差为1
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = 0;
        Arrays.sort(nums);

        int prevNum = Integer.MIN_VALUE;
        int prevCnt = 0;
        for (int i = 0; i < nums.length; ) {
            int next = i + 1;
            while (next < nums.length && nums[next] == nums[i]) {
                next++;
            }
            if (prevNum + 1 == nums[i]) {
                max = Math.max(max, prevCnt + next - i);
            }

            prevNum = nums[i];
            prevCnt = next - i;
            i = next;

        }

        return max;
    }

    /**
     * 求每个元素的个数，再找相邻元素之和最大的
     * 相邻指元素之差为1
     *
     * @param nums
     * @return
     */
    public int findLHS2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        Map.Entry<Integer, Integer> prev = null; // 前一个遍历的元素
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (prev != null && prev.getKey() + 1 == entry.getKey()) { // 相邻元素
                max = Math.max(max, prev.getValue() + entry.getValue()); // 取较大的
            }
            prev = entry;
        }

        return max;
    }
}
