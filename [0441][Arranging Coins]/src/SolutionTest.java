import org.junit.Assert;
import org.junit.Test;

/**
 * Author: 王俊超
 * Time: 2020-06-25 14:32
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();

        int[][] data = {
                {-1, 0},
                {0, 0},
                {1, 1},
                {2, 1},
                {5, 2},
                {8, 3},
                {10, 4},
                {11, 4},
                {12, 4},
                {13, 4},
                {14, 4},
                {15, 5},
        };

        for (int[] d : data) {
            Assert.assertEquals(s.arrangeCoins(d[0]), d[1]);
        }
    }
}
