package stack.stackfromqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class StackFrom2QueuesTest {

    StackFrom2Queues stackFrom2Queues;

    @BeforeEach
    void setUp() {
        stackFrom2Queues = new StackFrom2Queues();
    }

    @Test
    void popShouldThrowExceptionWhenPopEmptyStack() {
        Assertions.assertThrows(EmptyStackException.class, () -> stackFrom2Queues.pop(),
                "Expected pop() to throw, but it didn't");
    }

    @Test
    void pushManyTimesShouldPopCorrectOrder() {
        //given
        List<Integer> elements = List.of(1, 2, 3);
        elements.forEach(stackFrom2Queues::push);

        //when
        List<Integer> actualElements = IntStream.range(0, elements.size())
                .mapToObj(i -> stackFrom2Queues.pop())
                .collect(toList());

        //then
        List<Integer> expectedElements = List.of(3, 2, 1);
        assertIterableEquals(expectedElements, actualElements, () -> "Incorrect elements");
    }

    @Test
    void popPushInDifferentOrderShouldReturnFirstFromStack() {
        //given
        stackFrom2Queues.push(1);
        stackFrom2Queues.push(2);
        stackFrom2Queues.push(3);
        stackFrom2Queues.pop();
        stackFrom2Queues.push(4);

        //when
        List<Integer> actualElements = IntStream.range(0, 3)
                .mapToObj(i -> stackFrom2Queues.pop())
                .collect(toList());

        //then
        List<Integer> expectedElements = List.of(4, 2, 1);
        assertIterableEquals(expectedElements, actualElements, () -> "Incorrect elements");
    }

//----------------------------------------------------peek--------------------------------------------------------------

    @Test
    void peekShouldThrowExceptionWhenPopEmptyStack() {
        Assertions.assertThrows(EmptyStackException.class, () -> stackFrom2Queues.pop(),
                "Expected pop() to throw, but it didn't");
    }

    @Test
    void peekTwiceShouldReturnTheSame() {
        //given
        List<Integer> elements = List.of(1, 2, 3);
        elements.forEach(stackFrom2Queues::push);

        //when
        Integer actualElement = stackFrom2Queues.peek();
        Integer actualElement2 = stackFrom2Queues.peek();

        //then
        Integer expectedElement = 3;
        assertEquals(expectedElement, actualElement);
        assertEquals(expectedElement, actualElement2);
    }

}