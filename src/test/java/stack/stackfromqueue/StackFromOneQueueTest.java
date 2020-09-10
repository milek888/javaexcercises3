package stack.stackfromqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class StackFromOneQueueTest {

    StackFromOneQueue stackFromOneQueue;

    @BeforeEach
    void setUp() {
        stackFromOneQueue = new  StackFromOneQueue();
    }

    @Test
    void popShouldThrowExceptionWhenPopEmptyStack() {
        Assertions.assertThrows(EmptyStackException.class, () -> stackFromOneQueue.pop(),
                "Expected pop() to throw, but it didn't");
    }

    @Test
    void popManyTimesShouldPushCorrectOrder() {
        //given
        List<Integer> elements = List.of(1, 2, 3);
        elements.forEach(stackFromOneQueue::push);

        //when
        List<Integer> actualElements = IntStream.range(0, elements.size())
                .mapToObj(i -> stackFromOneQueue.pop())
                .collect(toList());

        //then
        List<Integer> expectedElements = List.of(3, 2, 1);
        assertIterableEquals(expectedElements, actualElements, () -> "Incorrect elements");
    }

    @Test
    void popPushInDifferentOrderShouldReturnFirstFromStack() {
        //given
        stackFromOneQueue.push(1);
        stackFromOneQueue.push(2);
        stackFromOneQueue.push(3);
        stackFromOneQueue.pop();
        stackFromOneQueue.push(4);

        //when
        List<Integer> actualElements = IntStream.range(0, 3)
                .mapToObj(i -> stackFromOneQueue.pop())
                .collect(toList());

        //then
        List<Integer> expectedElements = List.of(4, 2, 1);
        assertIterableEquals(expectedElements, actualElements, () -> "Incorrect elements");
    }

}