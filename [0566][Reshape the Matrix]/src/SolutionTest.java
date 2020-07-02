import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Author: 王俊超
 * Time: 2020-07-02 08:46
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void matrixReshape() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[][]{{1, 2}, {3, 4}}, 1, 4, new int[][]{{1, 2, 3, 4}}},
                {new int[][]{{1, 2}, {3, 4}}, 2, 4, new int[][]{{1, 2}, {3, 4}}},
        };

        for (Object[] d : data) {
            int[][] result =  s.matrixReshape((int[][]) d[0], (Integer) d[1], (Integer) d[2]);
            int[][] actual = (int[][]) d[3];
            Assert.assertEquals(result.length, actual.length);

            for (int i = 0; i < result.length; i++) {
                Assert.assertArrayEquals(actual[i], result[i]);
            }
        }
    }
}