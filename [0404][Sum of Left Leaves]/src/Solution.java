/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-30 14:11
 **/
public class Solution {
    /**
     * <pre>
     * Find the sum of all left leaves in a given binary tree.
     *
     * Example:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     * </pre>
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int[] result = new int[1];
        sumOfLeftLeaves(root, false, result);
        return result[0];
    }

    /**
     * 计算所有左叶子的和
     *
     * @param root
     * @param result
     */
    private void sumOfLeftLeaves(TreeNode root, boolean isLeftLeaf, int[] result) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && isLeftLeaf) {
            result[0] += root.val;
            return;
        }

        sumOfLeftLeaves(root.left, true, result);
        sumOfLeftLeaves(root.right, false, result);
    }
}
