package com.ncepu;

import java.util.Stack;

public class Sol_232 {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public Sol_232() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        inToout();

        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        inToout();
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public void inToout(){
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }
}
