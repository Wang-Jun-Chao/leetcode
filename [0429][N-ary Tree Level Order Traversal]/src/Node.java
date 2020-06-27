import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-01 14:44
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
