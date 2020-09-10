package stack.stackfromqueue;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Stack;

/*
* Bardzo ciekawe wykorzystanie stosu rekurencyjnego.
* https://www.techiedelight.com/implement-stack-using-queue-data-structure/
* */
public class StackFromOneQueue {

    private ArrayDeque<Integer> queue;

    public StackFromOneQueue() {
        this.queue = new ArrayDeque<>();
    }

    private void reverseQueue() {
        if(queue.isEmpty()) {
            return;
        }

        Integer topElement = queue.poll();//hold it in recurency stack
        reverseQueue();
        queue.add(topElement);//take it from stack and add to queue
    }

    public Integer pop() {
        reverseQueue();

        if(queue.isEmpty()) {
            throw new EmptyStackException();
        }
        Integer result = queue.poll();

        reverseQueue();
        return result;
    }

    public Integer push(Integer element) {
        queue.add(element);
        return element;
    }
}
