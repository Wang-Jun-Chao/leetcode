import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-06 08:38
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void checkPossibility() {
        Solution s = new Solution();
        Object[][] data = {
//                {new int[]{1, 2, 3, 4, 6, 5, 7, 8, 9}, true},
//                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, true},
//                {new int[]{4, 2, 3}, true},
//                {new int[]{4, 2, 1}, false},
                {new int[]{-1, 4, 2, 3}, false},
        };

        for (Object[] d : data) {
            boolean result = s.checkPossibility((int[]) d[0]);
            Assert.assertEquals(d[1], result);
        }
    }
}