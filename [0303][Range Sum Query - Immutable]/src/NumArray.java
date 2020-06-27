/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-12 13:53
 **/
public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {

        if (i > j) {
            throw new IllegalArgumentException("i = " + i + ", j = " + j + ", i must not greater than j");
        }

        if (j < 0) {
            throw new IllegalArgumentException("i = " + i + ", j = " + j + ", i must not less than 0");
        }

        i = i < 0 ? 0 : i;
        j = j >= nums.length ? nums.length - 1 : j;

        int sum = 0;


        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }

        return sum;
    }
}
