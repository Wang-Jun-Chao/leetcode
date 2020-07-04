import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-04 15:20
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findLHS() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{1, 3, 2, 2, 5, 2, 3, 7}, 5},
                {new int[]{-2, 0, 2, 2, 5, 5, 5, 5}, 0},
                {new int[]{1, 1, 1, 1}, 0},
        };

        for (Object[] d : data) {
            int result = s.findLHS((int[]) d[0]);
            Assert.assertEquals(d[1], result);
        }
    }
}