import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 *
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 11:16
 **/
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        binaryTreePaths(root, new LinkedList<>(), result);

        return result;
    }

    private void binaryTreePaths(TreeNode root, LinkedList<TreeNode> path, List<String> result) {

        if (root == null) {
            return;
        }

        path.add(root);

        if (root.left == null && root.right == null) {
            addResult(path, result);
        } else {
            binaryTreePaths(root.left, path, result);
            binaryTreePaths(root.right, path, result);
        }

        path.remove(path.size() - 1);
    }

    private void addResult(LinkedList<TreeNode> path, List<String> result) {
        StringBuilder builder = new StringBuilder();
        if (path != null) {
            for (TreeNode node : path) {
                builder.append("->").append(node.val);
            }
        }

        if (builder.length() > 0) {
            result.add(builder.substring(2));
        }
    }
}
