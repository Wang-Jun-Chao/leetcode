import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-06-23
 * Time: 19:39
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * For example,
     * Given [1,3],[2,6],[8,10],[15,18],
     * return [1,6],[8,10],[15,18].
     *
     * 题目大意，
     * 给定一个区间集合，合并有重叠的区间
     *
     * 解题思路：
     * 先对区间进行排序，按开始点进行排序，再一个一个进行合并
     * </pre>
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();

        if (intervals == null || intervals.size() < 1) {
            return result;
        }

        // 先对区间进行排序，使用一个匿名内部类
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        // 排序后，后一个元素（记为next）的start一定是不小于前一个（记为prev）start的，
        // 对于新添加的区间，如果next.start大于prev.end就说明这两个区间是分开的，要添
        // 加一个新的区间，否则说明next.start在[prev.start, prev.end]内，则只要看
        // next.end是否是大于prev.end，如果大于就要合并区间（扩大）
        Interval prev = null;
        for (Interval item : intervals) {

            if (prev == null || prev.end < item.start) {
                result.add(item);
                prev = item;
            } else if (prev.end < item.end) {
                prev.end = item.end;
            }
        }

        return result;
    }
}
