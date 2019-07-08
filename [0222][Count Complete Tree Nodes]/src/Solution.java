/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-08 20:52
 **/
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int h1 = leftestHeight(root);
        int h2 = rightestHeight(root);

        if (h1 == h2) {
            return ((1 << h1) - 1);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 最右路径的长度
     *
     * @param node
     * @return
     */
    private int rightestHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + rightestHeight(node.right);
    }

    /**
     * 最左路径的长度
     *
     * @param node
     * @return
     */
    private int leftestHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + leftestHeight(node.left);
    }
}
