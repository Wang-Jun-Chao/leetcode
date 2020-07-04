import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-04 16:23
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findRestaurant() {
        Solution s = new Solution();
        Object[][] data = {
                {
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"},
                        new String[]{"Shogun"},
                },
                {
                        new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                        new String[]{"KFC","Shogun","Burger King"},
                        new String[]{"Shogun"},
                }

        };

        for (Object[] d : data) {
            String[] result = s.findRestaurant((String[]) d[0], (String[]) d[1]);
            Assert.assertArrayEquals((String[]) d[2], result);
        }
    }
}