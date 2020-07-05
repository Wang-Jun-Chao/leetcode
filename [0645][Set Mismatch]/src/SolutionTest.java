import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-05 17:19
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findErrorNums() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{1, 2, 2, 4}, new int[]{2, 3}},
                {new int[]{1, 3, 2, 4, 4}, new int[]{4, 5}},
        };

        for (Object[] d : data) {
            int[] result = s.findErrorNums((int[]) d[0]);
            Assert.assertArrayEquals((int[]) d[1], result);
        }
    }
}