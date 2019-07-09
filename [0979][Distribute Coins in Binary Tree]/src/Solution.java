/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 18:52
 **/
public class Solution {

    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        /**
         * <pre>
         * 一个节点有几种情况：
         * 1、没有左和右孩子
         *      1.1、自己的val为0，需要从上面借1个coin
         *      1.2、自己的val为1，不需要借coin
         *      1.3、自己的val>1，需要向父结点贡献 val-1个coin
         * 2、只有左或者右孩子
         *      2.1、自己的
         * </pre>
         */


        if (root == null) {
            return 0;
        }

        moves = 0;
        distributeCoins(root, null);
        return moves;
    }

    /**
     *
     * @param node
     * @param parent
     */
    private void distributeCoins(TreeNode node, TreeNode parent) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            distributeCoins(node.left, parent);
        }

        if (node.right != null) {
            distributeCoins(node.right, parent);
        }

        moves += Math.abs(node.val - 1);
        if (parent != null) {
            parent.val += node.val - 1;
        }
    }
}
