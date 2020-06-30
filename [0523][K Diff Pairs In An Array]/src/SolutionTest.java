import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-06-30 08:56
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findPairs() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{3, 1, 4, 1, 5}, 2, 2},
                {new int[]{1, 2, 3, 4, 5}, 1, 4},
                {new int[]{1, 3, 1, 5, 4}, 0, 1},
                {new int[]{1, 1, 1, 1, 1}, 0, 1},
                {new int[]{1, 1, 2, 2, 1}, 0, 2},
        };

        for (Object[] d: data) {
            Assert.assertEquals(d[2], s.findPairs((int[]) d[0], (Integer) d[1]));
        }
    }
}