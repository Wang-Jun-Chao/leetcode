/**
 * Author: 王俊超
 * Time: 2020-07-02 08:26
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 解题思路
     * 一个树的坡度等于=左子树的坡度+右子树的坡度+根节点的坡度
     * 子树同样适应
     *
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        return findTiltHelp(root)[0];
    }

    /**
     * 第一个返回值表示root的坡度
     * 第二个返回值表示root的为根的树的节点和
     *
     * @param root
     * @return
     */
    public int[] findTiltHelp(TreeNode root) {
        // 空结点或者左右孩子为都空的结点
        if (root == null) {
            return new int[]{0, 0};
        } else if (root.left == null && root.right == null) {
            return new int[]{0, root.val};
        }


        int[] left = findTiltHelp(root.left);
        int[] right = findTiltHelp(root.right);

        int[] result = {0, 0};

        result[0] = left[0] + right[0] + Math.abs(left[1] - right[1]);
        result[1] = left[1] + right[1] + root.val;

        return result;
    }
}
