import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-07 10:07
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findLengthOfLCIS() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{1, 3, 5, 4, 7}, 3},
                {new int[]{2, 2, 2, 2, 2}, 1},
                {new int[]{1, 2, 3, 4, 5}, 5},
                {new int[]{2, 2, 3, 4, 5}, 4},
        };

        for (Object[] d : data) {
            int result = s.findLengthOfLCIS((int[]) d[0]);
            Assert.assertEquals(d[1], result);
        }
    }
}