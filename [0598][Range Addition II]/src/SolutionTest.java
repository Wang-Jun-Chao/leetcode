import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-04 16:04
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void maxCount() {
        Solution s = new Solution();
        Object[][] data = {
                {3, 3, new int[][]{{2, 2}, {3, 3}}, 4},
                {3, 3, new int[][]{{2, 3}, {3, 2}}, 4},
                {3, 3, new int[][]{}, 9},
        };

        for (Object[] d : data) {
            Object result = s.maxCount((int) d[0], (int)d[1], (int[][]) d[2]);
            Assert.assertEquals(d[3], result);
        }
    }
}