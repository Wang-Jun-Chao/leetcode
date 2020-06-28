import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Target;

/**
 * Author: 王俊超
 * Time: 2020-06-28 22:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{1, 2, 3}, 3},
                {new int[]{1, 1, 1}, 0},
                {new int[]{1, 1, 2}, 1},
        };

        for (Object[] d : data) {
            Assert.assertEquals(s.minMoves((int[]) d[0]), d[1]);
        }
    }
}
