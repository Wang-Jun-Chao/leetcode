import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Author: 王俊超
 * Time: 2020-07-07 08:58
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * @param root
     * @return
     */

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null){
            return -1;
        }
        return help(root, root.val);
    }

    private int help(TreeNode root, int min) {
        if (root == null){
            return -1;
        }
        if (root.val > min) {
            return root.val;
        }
        int left = help(root.left, min);
        int right = help(root.right, min);

        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }

        return Math.min(left, right);
    }

    public int findSecondMinimumValue2(TreeNode root) {
        SortedSet<Integer> result = new TreeSet<>();
        findSecondMinimumValue(root, result);

        if (result.size() < 2) {
            return -1;
        }

        result.remove(result.first());
        return result.first();
    }

    /**
     * @param root
     * @param result 是一个从小到大的size=2的有序数组
     */
    private void findSecondMinimumValue(TreeNode root, SortedSet<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        findSecondMinimumValue(root.left, result);
        findSecondMinimumValue(root.right, result);
    }
}
