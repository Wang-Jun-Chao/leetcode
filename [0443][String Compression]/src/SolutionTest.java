import org.junit.Assert;
import org.junit.Test;

/**
 * Author: 王俊超
 * Time: 2020-06-26 07:51
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();
        Object[][] data = {
//                {null,null, 0},
//                {"","", 0},
//                {"a","a", 1},
//                {"aabbccc", "a2b2c3", 6},
//                {"abbbbbbbbbbbb","ab12", 4},
//                {"abcdefg","abcdefg", 7},
//                {"aaab","a3b", 3},
//                {"aaabcccc","a3bc4", 5},
                {"aaabbbccc", "a3b3c3", 6},
        };

        for (Object[] d : data) {

            if (d[0] == null) {
                Assert.assertNull(d[1]);
                Assert.assertEquals(0, d[2]);
                continue;
            }

            char[] arr = ((String) (d[0])).toCharArray();
            int length = s.compress(arr);
            Assert.assertEquals(length, d[2]);
            Assert.assertEquals(new String(arr, 0, length), d[1]);
        }
    }
}
