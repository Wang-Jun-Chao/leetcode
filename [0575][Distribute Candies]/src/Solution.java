import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: 王俊超
 * Time: 2020-07-03 10:03
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 找出共有多少种糖果，如果种类大于糖果数目的一半就取糖果数目的一半，否则就取糖果的种类数
     *
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        if (candies == null || candies.length % 2 != 0) {
            throw new IllegalArgumentException("illegal candies: " + Arrays.toString(candies));
        }

        Set<Integer> set = new HashSet<>(candies.length);
        for (int c : candies) {
            set.add(c);
        }

        return Math.min(set.size(), candies.length / 2);
    }

}
