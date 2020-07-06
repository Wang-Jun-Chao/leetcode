import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-06 08:17
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void imageSmoother() {
        Solution s = new Solution();
        Object[][] data = {
                {
                        new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
                        new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                },
        };

        for (Object[] d : data) {
            int[][] result = s.imageSmoother((int[][]) d[0]);
            for (int i = 0; i < result.length; i++) {
                Assert.assertArrayEquals(((int[][]) d[1])[i], result[i]);
            }
        }
    }
}