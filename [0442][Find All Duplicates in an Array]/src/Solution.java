import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 13:49
 **/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                result.add(i);
            } else {
                set.add(i);
            }
        }

        Collections.sort(result);
        return result;
    }
}
