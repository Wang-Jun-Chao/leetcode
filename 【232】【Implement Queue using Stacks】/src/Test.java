/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 10:58
 **/
public class Test {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
