import java.util.HashMap;
import java.util.Map;

/**
 * Author: ������
 * Date: 2015-06-19
 * Time: 14:10
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * Given an array of integers and an integer k, find out whether there there are
     * two distinct indices i and j in the array such that nums[i] = nums[j] and the
     * difference between i and j is at most k.
     * <p>
     * ��Ŀ���⣺
     * ����һ����������nums��һ������k�����ҽ�������������ͬ���±�i��j����nums[i] = nums[j]
     * ����|i-j|<=kʱ����true�����򷵻�false��
     * <p>
     * ����˼·��
     * ��nums[0...n-1]������һ��map�У�(muns[i], i)�������nums[k]�Ѿ����ڣ�
     * ��Ƚ�֮ǰ���±�����ڵ��±�Ĳ�ֵ�������ֵ������k��˵��������������������ֵ��
     * ����ʹ���µ��±���Ϊֵ
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // ���������ж�
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            // ���û�ж�Ӧ��key��ӽ�ȥ
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            // �Ѿ��ж�Ӧ��key-value��
            else {
                // ԭ�������ֵ��Ӧ���±꣬��һ��С�����ڵ��±�
                int value = map.get(nums[i]);
                if (i - value <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
