import java.util.Arrays;
import java.util.Random;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 15:51
 **/
public class Solution {

    private int[] original;

    /**
     * <pre>
     * // Init an array with set 1, 2, and 3.
     * int[] nums = {1,2,3};
     * Solution solution = new Solution(nums);
     *
     * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3]
     * must equally likely to be returned.
     * solution.shuffle();
     *
     * // Resets the array back to its original configuration [1,2,3].
     * solution.reset();
     *
     * // Returns the random shuffling of array [1,2,3].
     * solution.shuffle();
     * </pre>
     *
     * @param nums
     */
    public Solution(int[] nums) {
        original = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return Arrays.copyOf(original, original.length);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] copy = Arrays.copyOf(original, original.length);

        Random random = new Random();
        for (int i = 0; i < copy.length - 1; i++) {
            swap(copy, i, i + random.nextInt(copy.length - i));
        }

        return copy;
    }

    private void swap(int[] copy, int i, int j) {
        int t = copy[i];
        copy[i] = copy[j];
        copy[j] = t;
    }
}
