import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-04 19:52
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void canPlaceFlowers() {
        Solution s = new Solution();
        Object[][] data = {
                {new int[]{1, 0, 0, 0, 1}, 1, true},
                {new int[]{1, 0, 0, 0, 1}, 2, false},
                {new int[]{1, 0, 1, 0, 1}, 1, false},
                {new int[]{1, 0, 1, 0, 0}, 2, false},
                {new int[]{0, 0, 0, 0, 0}, 3, true},
                {new int[]{1, 0, 0, 0, 0, 1}, 2, false},
                {new int[]{1, 0, 0, 0, 0, 1}, 2, false},
                {new int[]{ 0, 0, 1, 0, 1}, 1, true},
        };

        for (Object[] d : data) {
            Object result = s.canPlaceFlowers((int[]) d[0], (Integer) d[1]);
            Assert.assertEquals(d[2], result);
        }
    }
}