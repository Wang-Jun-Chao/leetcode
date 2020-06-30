import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-06-29 08:36
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void checkPerfectNumber() {
        Solution s = new Solution();
        Object[][] data = {
                {28, true},
                {-1, false},
                {0, false},
                {1, false},
                {6, true},
                {7, false},
                {8, false},
        };

        for (Object[] d: data) {
            Assert.assertEquals(s.checkPerfectNumber((Integer) d[0]), d[1]);
        }
    }
}