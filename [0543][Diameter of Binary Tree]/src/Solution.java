/**
 * Author: 王俊超
 * Time: 2020-07-01 08:53
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return layerAndDiameter(root)[1];
    }

    /**
     * 解题思路：
     * 最大直径的三种情况：
     * 1、在左子树中
     * 2、在右子树中
     * 3、对过root节点，如果经过root节点，那么直径就是 Height(root.left) + Height(root.right) + 2
     * 对每个节点都是同样的。所以可以使用递归求解，先求左右子树的高度和最大直径，再求通过root的高度和直径，再找出最大的直径
     *
     *
     * 第一个反回参数表示root最大有多少层，
     * 第二个返回参数表示root的最大直径
     *
     * @param root
     * @return
     */
    public int[] layerAndDiameter(TreeNode root) {
        if (root == null) { // 边界条件
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) { // 边界条件
            return new int[]{0, 0};
        } else if (root.left != null && root.right == null) {
            int[] result = layerAndDiameter(root.left);
            result[0] += 1; // 层升高1
            result[1] = Math.max(result[0], result[1]); // 因为没有右子树，最大直径要么经过root，要么不经过

            return result;
        } else if (root.left == null && root.right != null) {
            int[] result = layerAndDiameter(root.right);
            result[0] += 1; // 层升高1
            result[1] = Math.max(result[0], result[1]); // 因为没有左子树，最大直径要么经过root，要么不经过
            return result;
        }

        int[] left = layerAndDiameter(root.left);
        int[] right = layerAndDiameter(root.right);

        int[] result = {0, 0};
        result[0] = 1 + Math.max(left[0], right[0]); // 层升高1

        result[1] = Math.max(left[1], right[1]); // 最大直径可能在左子树或者右子树中
        result[1] = Math.max(result[1], 2 + left[0] + right[0]); // 最大直径可能经过root

        return result;
    }
}
