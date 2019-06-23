/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 12:56
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an array where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     *
     * 题目大意：
     * 给定一个升序排序数组，将它转换成一个高度平衡二叉树
     *
     * 解题思路：
     * 采用递归分治法
     * </pre>
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 参数检验
        if (nums == null || nums.length < 1) {
            return null;
        }

        // 递归分治法求解
        return solve(nums, 0, nums.length - 1);
    }

    /**
     * 递归分治求解方法
     *
     * @param nums  升序排序数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 根结点
     */
    public TreeNode solve(int[] nums, int start, int end) {
        // 还有未处理的数据
        if (start <= end) {
            // 找蹭位置
            int mid = start + ((end - start) >> 1);
            // 构造根结点
            TreeNode root = new TreeNode(nums[mid]);
            // 求左子树
            root.left = solve(nums, start, mid - 1);
            // 求右子树
            root.right = solve(nums, mid + 1, end);
            // 返回结果
            return root;
        }

        return null;
    }
}
