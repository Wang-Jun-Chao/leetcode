import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 13:41
 **/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }

        int idx = 0;

        while (idx < nums.length) {
            int temp = idx;
            String s = String.valueOf(nums[idx]);
            idx++;
            // 找第一个不连续的下标
            while (idx < nums.length && nums[idx - 1] + 1 == nums[idx]) {
                idx++;
            }

            // 判断是否连续
            if (temp < idx - 1) {
                result.add(s + "->" + nums[idx - 1]);
            } else {
                result.add(s);
            }
        }

        return result;
    }
}
