import org.junit.Assert;
import org.junit.Test;

/**
 * Author: 王俊超
 * Time: 2020-06-29 07:46
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @Test
    public void test1() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{5, 4, 3, 2, 1}, new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}},
                {new int[]{1, 2, 3, 4, 5}, new String[]{"5", "4", "Bronze Medal", "Silver Medal", "Gold Medal"}},
        };

        for (Object[] d: data) {
            Assert.assertArrayEquals(s.findRelativeRanks((int[]) d[0]), (Object[]) d[1]);
        }
    }
}
