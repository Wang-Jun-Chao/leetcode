import java.util.HashSet;
import java.util.Set;

/**
 * Author: 王俊超
 * Date: 2015-06-18
 * Time: 09:40
 * Declaration: All Rights Reserved !!!
 */
public class Solution {


    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the
     * array, and it should return false if every element is distinct.
     * <p>
     * 题目大意：给定一个整数数组，判断数组中是否包含重复元素。如果数组中任意一个数字出现了至少两次，
     * 你的函数应该返回true，如果每一个元素都是唯一的，返回false。
     *
     * 解题思路：用set数据结构
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        // 元素个数大于1才进行下面的操作
        if (nums != null && nums.length > 1) {
            //创建一个hashSet
            Set<Integer> set = new HashSet<>(nums.length);
            for(int i : nums) {
                // 如果元素已经存在就返回true
                if (set.contains(i)) {
                    return true;
                }
                // 没有就添加到元素集合中
                else {
                    set.add(i);
                }
            }
        }

        return false;
    }
}
