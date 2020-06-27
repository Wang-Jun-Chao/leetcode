import org.junit.Assert;
import org.junit.Test;

/**
 * Author: 王俊超
 * Time: 2020-06-26 16:55
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();
        Object[][] data = {
//                {new int[][]{{0, 0}, {1, 0}, {2, 0}}, 2},
//                {new int[][]{{1, 1}, {2, 2}, {3, 3}}, 2},
                {new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}}, 20}
        };

        for (Object[] d : data) {
            Assert.assertEquals(d[1], s.numberOfBoomerangs((int[][]) d[0]));
        }

    }
}
