import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-14 13:21
 **/
public class Main {

    @Test
    public void test() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        Solution solution = new Solution();
        Assert.assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test3() {
        int[] nums1 = {6};
        int[] nums2 = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        Assert.assertEquals(3.5, solution.findMedianSortedArrays(nums1, nums2), 0.000001);
    }


}
