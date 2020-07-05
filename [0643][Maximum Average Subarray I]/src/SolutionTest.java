import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-05 16:29
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findMaxAverage() {
        Solution s = new Solution();
        Object[][] data = {
//                {new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75},
                {new int[]{7, 4, 5, 8, 8, 3, 9, 8, 7, 6}, 7, 7.0},
        };

        for (Object[] d : data) {
            Object result = s.findMaxAverage((int[]) d[0], (Integer) d[1]);
            Assert.assertEquals(d[2], result);
        }
    }
}