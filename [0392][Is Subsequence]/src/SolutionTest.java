import org.junit.Assert;
import org.junit.Test;

/**
 * Author: 王俊超
 * Time: 2020-06-25 14:03
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {
    @Test
    public void test1() {
        Object[][] data = {

                {"", "", true},
                {"", "ahbgdc", true},
                {"ahbgdc", "", false},
                {"abc", "ahbgdc", true},
                {"axc", "ahbgdc", false},
                {"leetcode", "lleettccooddee", true},
        };

        for (Object[] datum : data) {
            Solution s = new Solution();
            Assert.assertEquals(s.isSubsequence((String) datum[0], (String) datum[1]), datum[2]);
        }
    }
}
