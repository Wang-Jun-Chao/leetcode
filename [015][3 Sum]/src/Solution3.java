import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-20
 * Time: 21:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution3 {
    /**
     * <pre>
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * The solution set must not contain duplicate triplets.
     *
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     *
     * 题目大意：
     *
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int target = 0;
        for (int a = 0; a < nums.length - 2; ++a) {

            int b = a + 1;
            int c = nums.length - 1;
            while (b < c) {
                if (nums[a] + nums[b] + nums[c] < target) {
                    ++b;
                } else if (nums[a] + nums[b] + nums[c] > target) {
                    --c;
                } else {
                    List<Integer> idxs = new ArrayList<>();
                    idxs.add(nums[a]);
                    idxs.add(nums[b]);
                    idxs.add(nums[c]);
                    if (!result.contains(idxs)) {
                        result.add(idxs);
                    }
                    ++b;
                    --c;
                }
            }
        }
        return result;
    }

}