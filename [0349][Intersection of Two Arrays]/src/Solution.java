import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 14:42
 **/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
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
