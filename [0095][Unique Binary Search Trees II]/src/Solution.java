import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 16:14
 **/
public class Solution {
    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new LinkedList<>();
        }

        return trees(1, n);
    }

    private List<TreeNode> trees(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = trees(start, i - 1);
            List<TreeNode> right = trees(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }

        return result;
    }


}
