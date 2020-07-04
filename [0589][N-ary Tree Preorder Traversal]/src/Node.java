import java.util.List;

/**
 * Author: 王俊超
 * Time: 2020-07-03 10:20
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
