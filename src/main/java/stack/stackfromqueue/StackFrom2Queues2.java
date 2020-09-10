package stack.stackfromqueue;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Stack;

/*
 * In this implementation push is more complex then pop
 * https://www.techiedelight.com/implement-stack-using-queue-data-structure/
 * */
public class StackFrom2Queues2 {

    private ArrayDeque<Integer> queue1;
    private ArrayDeque<Integer> queue2;

    public StackFrom2Queues2() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    public Integer push(Integer element) {
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        queue1.add(element);

        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }

        return element;
    }

    public Integer pop() {
        if(queue1.isEmpty()) {
            throw new EmptyStackException();
        }
        return queue1.poll();
    }

    public Integer peek() {
        if(queue1.isEmpty()) {
            throw new EmptyStackException();
        }
        return queue1.peek();
    }
}
