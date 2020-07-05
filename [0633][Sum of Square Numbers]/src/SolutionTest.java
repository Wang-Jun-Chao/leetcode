import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-05 17:00
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void judgeSquareSum() {
        Solution s = new Solution();
        Object[][] data = {
                {0, true},
                {1, true},
                {2, true},
                {3, false},
                {4, true},
                {5, true},
                {1000, true},
        };

        for (Object[] d : data) {
            Object result = s.judgeSquareSum((int) d[0]);
            Assert.assertEquals(d[1], result);
        }
    }
}