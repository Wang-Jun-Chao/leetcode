import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 19:35
 **/
public class Main {
    @Test
    public void test1() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{-1, 3, -1}, solution.nextGreaterElement(nums1, nums2));
    }

    @Test
    public void test2() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{3, -1}, solution.nextGreaterElement(nums1, nums2));
    }
}
