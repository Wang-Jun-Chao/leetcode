import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-04 20:45
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void maximumProduct() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{-4, -3, -2, -1, 60}, 720},
        };

        for (Object[] d : data) {
            int result = s.maximumProduct((int[]) d[0]);
            Assert.assertEquals(d[1], result);
        }
    }
}