import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-06-29 08:48
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void fib() {
        Solution s = new Solution();
        Object[][] data = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
        };

        for (Object[] d : data) {
            Assert.assertEquals(s.fib((Integer) d[0]), d[1]);
        }
    }
}