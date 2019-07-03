/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 04:50
 **/

public class Solution {

    // 自身不作为结果的部分，为了防止向上冒泡出错
    public int pathSum(TreeNode root, int sum) {
        return pathSumHelp(root, sum, false);
    }

    /**
     * @param root
     * @param sum
     * @param withParent 父节点是否是结果的一部分
     * @return
     */
    private int pathSumHelp(TreeNode root, int sum, boolean withParent) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        if (sum == root.val) {
            // 到不当前不向下走，是一种方案
            result++;
            if (root.left == null && root.right == null) {
                return result;
            }
        }

        if (withParent) {
            if (root.left != null) {
                result += pathSumHelp(root.left, sum - root.val, true);
            }

            if (root.right != null) {
                result += pathSumHelp(root.right, sum - root.val, true);
            }
        } else {
            if (root.left != null) {
                result += pathSumHelp(root.left, sum - root.val, true);
                result += pathSumHelp(root.left, sum, false);
            }

            if (root.right != null) {
                result += pathSumHelp(root.right, sum - root.val, true);
                result += pathSumHelp(root.right, sum, false);
            }
        }
        return result;
    }

}
