import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 14:49
 **/
public class Solution {
    /**
     * <pre>
     * Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Note:
     *
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     * Follow up:
     *
     * What if the given array is already sorted? How would you optimize your algorithm?
     * What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * What if elements of nums2 are stored on disk, and the memory is limited such that
     * you cannot load all elements into the memory at once?
     * </pre>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();

        for (int i : nums1) {
            map.merge(i, 1, Integer::sum);
        }

        for (int i : nums2) {
            Integer v = map.get(i);
            if (v != null && v > 0) {
                result.add(i);
                map.put(i, v - 1);
            }
        }

        int[] r = new int[result.size()];
        int i = 0;
        for (int n : result) {
            r[i++] = n;
        }

        return r;
    }
}
