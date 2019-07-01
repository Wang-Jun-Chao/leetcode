import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-01 14:44
 **/
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        List<Node> currLayer = new LinkedList<>();
        List<Node> nextLayer = new LinkedList<>();


        if (root != null) {
            currLayer.add(root);
        }
        while (!currLayer.isEmpty()) {

            List<Integer> layer = new LinkedList<>();
            for (Node node : currLayer) {
                layer.add(node.val);
                if (node.children != null && !node.children.isEmpty()) {
                    nextLayer.addAll(node.children);
                }
            }

            result.add(layer);
            currLayer.clear();
            List<Node> temp = currLayer;
            currLayer = nextLayer;
            nextLayer = temp;
        }

        return result;
    }
}
