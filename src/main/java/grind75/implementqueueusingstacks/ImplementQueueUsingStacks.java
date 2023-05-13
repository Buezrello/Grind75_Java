package grind75.implementqueueusingstacks;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public ImplementQueueUsingStacks() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        while (!stack.empty()) {
            tempStack.push(stack.pop());
        }
        stack.push(x);
        while (!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }
}
