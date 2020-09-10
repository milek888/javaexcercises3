package stack.stackfromqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class StackFrom2Queues2Test {

    StackFrom2Queues2 stackFrom2Queues2;

    @BeforeEach
    void setUp() {
        stackFrom2Queues2 = new StackFrom2Queues2();
    }

    @Test
    void popShouldThrowExceptionWhenPopEmptyStack() {
        Assertions.assertThrows(EmptyStackException.class, () -> stackFrom2Queues2.pop(),
                "Expected pop() to throw, but it didn't");
    }

    @Test
    void popManyTimesShouldPushCorrectOrder() {
        //given
        List<Integer> elements = List.of(1, 2, 3);
        elements.forEach(stackFrom2Queues2::push);

        //when
        List<Integer> actualElements = IntStream.range(0, elements.size())
                .mapToObj(i -> stackFrom2Queues2.pop())
                .collect(toList());

        //then
        List<Integer> expectedElements = List.of(3, 2, 1);
        assertIterableEquals(expectedElements, actualElements, () -> "Incorrect elements");
    }

    @Test
    void popPushInDifferentOrderShouldReturnFirstFromStack() {
        //given
        stackFrom2Queues2.push(1);
        stackFrom2Queues2.push(2);
        stackFrom2Queues2.push(3);
        stackFrom2Queues2.pop();
        stackFrom2Queues2.push(4);

        //when
        List<Integer> actualElements = IntStream.range(0, 3)
                .mapToObj(i -> stackFrom2Queues2.pop())
                .collect(toList());

        //then
        List<Integer> expectedElements = List.of(4, 2, 1);
        assertIterableEquals(expectedElements, actualElements, () -> "Incorrect elements");
    }

    //----------------------------------------------------peek--------------------------------------------------------------

    @Test
    void peekShouldThrowExceptionWhenPopEmptyStack() {
        Assertions.assertThrows(EmptyStackException.class, () -> stackFrom2Queues2.pop(),
                "Expected pop() to throw, but it didn't");
    }

    @Test
    void peekTwiceShouldReturnTheSame() {
        //given
        List<Integer> elements = List.of(1, 2, 3);
        elements.forEach(stackFrom2Queues2::push);

        //when
        Integer actualElement = stackFrom2Queues2.peek();
        Integer actualElement2 = stackFrom2Queues2.peek();

        //then
        Integer expectedElement = 3;
        assertEquals(expectedElement, actualElement);
        assertEquals(expectedElement, actualElement2);
    }

}