import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-03 10:08
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void distributeCandies() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{1, 1, 2, 2, 3, 3}, 3},
                {new int[]{1, 1, 2, 3}, 2},
                {new int[]{1, 2, 3, 4}, 2},
        };

        for (Object[] d : data) {
            int result = s.distributeCandies((int[]) d[0]);
            Assert.assertEquals(d[1], result);
        }

    }
}