/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:25
 * Declaration: All Rights Reserved !!!
 */
public class MinStack {
    private final static int DEFAULT_SIZE = 1000;
    private int[] stack;
    private int[] minIndex; // 用于保存前n个数据的栈中最小元素的下标
    private int min = Integer.MAX_VALUE; // 用于记录插入过程中的最小数据
    private int index = -1; // 记录最小元素在stack中的位置
    private int current = -1;

    /**
     * <pre>
     * 原题
     * Design a stack that supports push, pop, top, and retrieving
     * the minimum element in constant time.
     * push(x) – Push element x onto stack.
     * pop() – Removes the element on top of the stack.
     * top() – Get the top element.
     * getMin() – Retrieve the minimum element in the stack.
     *
     * 题目大意
     * 设计一个栈，支持push，pop，top，和查找最小的元素操作（常量时间）
     *
     * 解题思路
     * 使用一个辅助栈来保存栈中的最小元素。
     * </pre>
     */
    public MinStack() {
        stack = new int[DEFAULT_SIZE];
        minIndex = new int[DEFAULT_SIZE];
    }

    public MinStack(int size) {
        stack = new int[size];
        minIndex = new int[size];
    }

    public void push(int x) {
        current++; // 移动到要插入的位置

        if (current >= stack.length) { // 扩容
            int[] tmp = new int[current * 2];
            System.arraycopy(stack, 0, tmp, 0, stack.length);
            stack = tmp;

            tmp = new int[current * 2];
            System.arraycopy(minIndex, 0, tmp, 0, minIndex.length);
            minIndex = tmp;
        }

        stack[current] = x; // 插入数据

        if (x < min) { // 保存插入的最小值
            min = x;
            index = current; // 记录[0, current]中最小的元素下标是index
        }

        minIndex[current] = index;
    }

    public void pop() {
        current--;
        if (current >= 0) {
            min = stack[minIndex[current]]; // 重新设置栈中的最小值
            index = minIndex[current]; // 重置最小值的索引
        }
    }

    public int top() {

        if (current < 0) {
            throw new RuntimeException("No more data");
        }

        return stack[current];
    }

    public int getMin() {
        if (current < 0) {
            throw new RuntimeException("No more data");
        }

        return stack[minIndex[current]];
    }
}
