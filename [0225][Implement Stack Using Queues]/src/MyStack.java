import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * Implement the following operations of a stack using queues.
 *   - push(x)  -- Push element x onto stack.
 *   - pop()    -- Removes the element on top of the stack.
 *   - top()    -- Get the top element.
 *   - empty()  -- Return whether the stack is empty.
 *
 * Notes:
 *   - You must use only standard operations of a queue -- which means only push
 *          to back, peek/pop from front, size, and is empty operations are valid.
 *   - Depending on your language, queue may not be supported natively. You may
 *          simulate a queue by using a list or deque (double-ended queue), as
 *          long as you use only standard operations of a queue.
 *   - You may assume that all operations are valid (for example, no pop or top
 *          operations will be called on an empty stack).
 *
 *  题目大意：
 *  使用队列实现栈操作
 *   - push(x)  -- 元素入栈
 *   - pop()    -- 元素出栈
 *   - top()    -- 取栈顶元素值
 *   - empty()  -- 判断栈是否为空
 *  注意：
 *   - 只能使用队列的标准操作，先进先出，求队列元素数，判断队列是否为空
 *   - 由于编程语言原因，有些语言不支抚摩队列，可以使用链表或双向链表代替，但仅能使用标准的队列操作
 *   - 你可以假设所有的操作都是合法的，即：当队列为空时不会有元素出栈和求栈顶元素的操作
 *
 * 解题思路：
 * 用两个队列来模拟一个栈
 * </pre>
 * <p>
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 20:45
 * Declaration: All Rights Reserved !!!
 */
public class MyStack {

    // 维持两个队列，其中总有一个队列为空，为pop和top操作准备
    private List<Integer> aList = new LinkedList<>();
    private List<Integer> bList = new LinkedList<>();


    // Push element x onto stack.
    public void push(int x) {
        // 如果aList非空，就将x添加到aList中
        if (!aList.isEmpty()) {
            aList.add(x);
        }
        // 否则总添加到bList中
        else {
            bList.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {

        // 两个队列中至少有一个为空，将aList设置非空
        if (aList.isEmpty()) {
            List<Integer> tmp = bList;
            bList = aList;
            aList = tmp;
        }

        // 除最后一个元素外都转移到bList中
        while (aList.size() > 1) {
            bList.add(aList.remove(0));
        }

        // 删除最后一个元素（对应就是入栈的栈顶元素）
        aList.clear();
    }

    // Get the top element.
    public int top() {

        // 两个队列中至少有一个为空，将aList设置非空
        if (aList.isEmpty()) {
            List<Integer> tmp = bList;
            bList = aList;
            aList = tmp;
        }

        // 除最后一个元素外都转移到bList中
        while (aList.size() > 1) {
            bList.add(aList.remove(0));
        }

        bList.add(aList.get(0));
        return aList.remove(0);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return aList.isEmpty() && bList.isEmpty();
    }
}
