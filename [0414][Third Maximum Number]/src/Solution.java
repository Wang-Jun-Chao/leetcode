import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 08:09
 **/
public class Solution {
    /**
     * <pre>
     * Given a non-empty array of integers, return the third maximum number in this array.
     * If it does not exist, return the maximum number. The time complexity must be in O(n).
     *
     * Example 1:
     * Input: [3, 2, 1]
     *
     * Output: 1
     *
     * Explanation: The third maximum is 1.
     * Example 2:
     * Input: [1, 2]
     *
     * Output: 2
     *
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     * Input: [2, 2, 3, 1]
     *
     * Output: 1
     *
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     * </pre>
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        SortedSet<Integer> result = new TreeSet<>();

        for (int i : nums) {
            addResult(i, result);
        }

        return result.size() == 3 ? result.first() : result.last();
    }

    private void addResult(int i, SortedSet<Integer> result) {
        if (result.size() < 3) {
            result.add(i);
        } else if (result.size() == 3 && result.first() < i && !result.contains(i)) {
            result.remove(result.first());
            result.add(i);
        }
    }
}
