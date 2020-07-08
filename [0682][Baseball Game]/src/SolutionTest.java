import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-07 12:53
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void calPoints() {
        Solution s = new Solution();
        Object[][] data = {
                {new String[]{"5", "2", "C", "D", "+"}, 30},
                {new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}, 27},
        };

        for (Object[] d : data) {
            int result = s.calPoints((String[]) d[0]);
            Assert.assertEquals(d[1], result);
        }
    }
}