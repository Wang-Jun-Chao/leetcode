import org.junit.Assert;
import org.junit.Test;


/**
 * Author: 王俊超
 * Time: 2020-07-02 08:12
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @Test
    public void checkRecord() {
        Solution s  = new Solution();
        Object[][] data = {
                {"PPALLP", true},
                {"PPALLL", false},
        };

        for (Object[] d : data) {
            Assert.assertEquals(d[1], s.checkRecord((String) d[0]));
        }
    }

}