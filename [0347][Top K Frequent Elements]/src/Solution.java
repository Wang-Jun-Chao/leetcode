import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 21:03
 **/
public class Solution {
    /**
     * <pre>
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * Note:
     *
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     *
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 用于记录每个数出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 按出现次数降序，统计出现X的数字有哪些
        SortedMap<Integer, List<Integer>> counter = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 记录每个数字出现的次数
        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }

        // 记录出现X次的数字有哪些
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = counter.get(entry.getValue());
            if (list == null) {
                list = new LinkedList<>();
                list.add(entry.getKey());
                counter.put(entry.getValue(), list);
            } else {
                list.add(entry.getKey());
            }
        }

        // 取K个结果
        List<Integer> result = new LinkedList<>();
        for (List<Integer> list : counter.values()) {
            if (result.size() < k) {
                int size = Math.min(k - result.size(), list.size());
                result.addAll(list.subList(0, size));
            } else {
                break;
            }
        }

        return result;
    }
}
