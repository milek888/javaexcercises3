package stack.stackfromqueue;

import java.util.ArrayDeque;
import java.util.EmptyStackException;

/*
* In this implementation pop is more complex then push
* https://www.techiedelight.com/implement-stack-using-queue-data-structure/
* */
public class StackFrom2Queues {

    private ArrayDeque<Integer> queue1;
    private ArrayDeque<Integer> queue2;

    public StackFrom2Queues() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    public Integer pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        if (queue1.isEmpty()) {
            throw new EmptyStackException();
        }

        Integer result = queue1.poll();
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }


        return result;
    }

    public void push(Integer element) {
        queue1.add(element);
    }

    public Integer peek() {
        Integer result = null;

        if (queue1.isEmpty()) {
            throw new EmptyStackException();
        }

        while (!queue1.isEmpty()) {
            if(queue1.size() == 1) {
                result = queue1.peek();
            }
            queue2.add(queue1.poll());
        }
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return result;
    }

}
