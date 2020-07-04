import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Time: 2020-07-04 16:32
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> curr = new LinkedList<>();
        Deque<TreeNode> next = new LinkedList<>();
        curr.addFirst(root);

        while (!curr.isEmpty()) {

            double count = curr.size();
            double sum = 0;
            while (!curr.isEmpty()) {
                TreeNode node = curr.removeFirst();
                sum += node.val;

                if (node.left != null) {
                    next.addLast(node.left);
                }
                if (node.right != null) {
                    next.addLast(node.right);
                }
            }

            result.add(sum / count);
            curr = next;
            next = new LinkedList<>();
        }

        return result;
    }
}
