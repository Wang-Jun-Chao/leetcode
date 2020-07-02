/**
 * Author: 王俊超
 * Time: 2020-07-02 07:58
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }

        int max = 0;

        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }

        return 1 + max;
    }
}

