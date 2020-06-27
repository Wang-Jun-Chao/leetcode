/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 18:52
 **/
public class Solution {

    private int moves = 0;

    /**
     * <pre>
     * 解题思路：这个题目有点意思，我的方法是“借”的思想。对于任意一个叶子节点，如果val是0，
     * 那么表示要向其父节点取一个coin，那么parent.val -= 1, moves += 1；如果是叶子节点
     * 的val大于1，那么表示要给父节点val-1个coin，同时moves += (val-1)。当然这两种情况
     * 可以用通用的表达式：move += abs(node.val - 1), parent.val += (node.val - 1)。
     * 按照后序遍历的方式即可算出总的move次数。
     *
     * https://www.cnblogs.com/seyjs/p/10369614.html
     * </pre>
     *
     * @param root
     * @return
     */
    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }

        moves = 0;
        distributeCoins(root, null);
        return moves;
    }

    /**
     * 自底向上，对每一个节点，只能从父结点借，或者向父节点上交coin
     *
     * @param node
     * @param parent
     */
    private void distributeCoins(TreeNode node, TreeNode parent) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            distributeCoins(node.left, node);
        }

        if (node.right != null) {
            distributeCoins(node.right, node);
        }

        // 不论向父节点借还是上交都要移动Math.abs(node.val - 1)次
        moves += Math.abs(node.val - 1);
        if (parent != null) {
            // 标记父结点
            parent.val += node.val - 1;
        }
    }
}
