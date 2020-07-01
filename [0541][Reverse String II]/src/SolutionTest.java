import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-06-30 12:54
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void reverseStr() {
        Solution s = new Solution();
        Object[][] data = {
                {"abcdefg", 2, "bacdfeg"},
                {"abcdefgh", 2, "bacdfegh"},
        };

        for (Object[] d : data) {
            Assert.assertEquals(d[2], s.reverseStr((String) d[0], (Integer) d[1]));
        }
    }
}