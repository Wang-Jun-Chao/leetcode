import java.util.HashSet;
import java.util.Set;

/**
 * Author: 王俊超
 * Time: 2020-07-05 17:13
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 通过求和找丢失的数
     * m + x + y = total
     * m + x + x = sum
     * y - x = total -sum
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }

        Set<Integer> map = new HashSet<>();
        int num = 1;
        int sum = 0;

        for (int n : nums) {
            if (map.contains(n)) {
                num = n;
            } else {
                map.add(n);
            }
            sum += n;
        }

        return new int[]{num, (1 + nums.length) * nums.length / 2 - sum + num};

    }

}
