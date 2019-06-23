import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-24
 * Time: 19:33
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a set of non-overlapping intervals, insert a new interval into the intervals
     * (merge if necessary).
     *
     * You may assume that the intervals were initially sorted according to their start times.
     *
     * Example 1:
     * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
     *
     * Example 2:
     * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
     *
     * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     *
     * 题目大意：
     * 给定一系列非覆盖的区间，插入一个新的区间，有必要的时候进行区间合并
     * 区间开始是以起始时间进行合并的
     *
     * 解题思路：
     * 如果原来的区间比插入区间小就插入结果集，如果插入区间有重叠，更新插入区间，
     * 如果插入区间小于原来的区间，先插入插入区间，再添加大的区间
     * </pre>
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        // 保存结果的集合
        List<Interval> result = new LinkedList<>();

        // 输入集非空
        if (intervals != null) {
            // 遍历元素
            for (Interval item : intervals) {
                // newInterval == null 表示插入的区间已经处理完了
                // 将比插入区间小的区间加入结果集中
                if (newInterval == null || item.end < newInterval.start) {
                    result.add(item);
                }
                // 将比插入区间大的区间加入结果集中，同时将插入的区间加入结果集
                else if (item.start > newInterval.end) {
                    result.add(newInterval);
                    result.add(item);
                    newInterval = null;
                }
                // 插入区间有重叠，更新插入区间
                else {
                    newInterval.start = Math.min(newInterval.start, item.start);
                    newInterval.end = Math.max(newInterval.end, item.end);
                }
            }
        }

        // 如果插入区间非空说明插入区间还未被处理
        if (newInterval != null) {
            result.add(newInterval);
        }

        return result;
    }
}
