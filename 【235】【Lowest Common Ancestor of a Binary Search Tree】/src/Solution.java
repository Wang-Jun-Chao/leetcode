import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) { val = x; }
 * }
 * </pre>
 *
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 11:32
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        search(pPath, root, p);
        search(qPath, root, q);

        TreeNode ancestor = pPath.get(0);

        int idx = 1;
        while (idx < pPath.size() && idx < qPath.size()) {
            p = pPath.get(idx);
            q = qPath.get(idx);
            if (p != null && q != null && p.val == q.val) {
                ancestor = pPath.get(idx);
                idx++;
            } else {
                break;
            }
        }

        return ancestor;
    }

    public void search(List<TreeNode> path, TreeNode root, TreeNode node) {
        path.add(root);

        if (root != null) {
            if (root.val > node.val) {
                search(path, root.left, node);
            }
            if (root.val < node.val) {
                search(path, root.right, node);
            }
        }
    }
}
