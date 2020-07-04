import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-04 19:32
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findUnsortedSubarray() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{2, 6, 4, 8, 10, 9, 15}, 5},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 0},
                {new int[]{7, 6, 5, 4, 3, 2, 1}, 7},
        };

        for (Object[] d : data) {
            Object result = s.findUnsortedSubarray((int[]) d[0]);
            Assert.assertEquals(d[1], result);
        }
    }
}