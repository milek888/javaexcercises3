package lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListIITest {

    @Test
    void reverseBetween() {
        ListNode head = ListUtils.createList();
        ListNode result = ReverseLinkedListII.reverseBetween(head, 1, 5);
        System.out.println("---------------");
    }


}