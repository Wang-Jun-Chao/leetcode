import java.util.*;

/**
 * Author: 王俊超
 * Time: 2020-06-29 10:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 解题思路
     * root提个二叉搜索树
     * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> s = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int prev = 0;
        boolean first = true;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);//先访问再入栈
                root = root.left;
            }
            root = s.pop();

            if (first) {
                first = false;
            } else {
                min = Math.min(min, root.val - prev);
            }

            prev = root.val;
            root = root.right;//如果是null，出栈并处理右子树
        }

        return min;
    }

}
