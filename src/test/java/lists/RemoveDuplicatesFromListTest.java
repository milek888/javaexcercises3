package lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromListTest {

    @Test
    void shouldNotRemoveWhenNoDuplicates() {
        ListNode head = ListUtils.createList();
        ListNode actualResult = RemoveDuplicatesFromList.deleteDuplicates(head);
        System.out.println("--------------------------");
    }

    @Test
    void shouldNotRemoveFromTheMiddleOfList() {
        ListNode head = createListWithRepeatedElement();
        ListNode actualResult = RemoveDuplicatesFromList.deleteDuplicates(head);
        System.out.println("--------------------------");
    }

    @Test
    void shouldNotRemoveTwiceFromTheMiddleOfList() {
        ListNode head = createListWithRepeatedElement2();
        ListNode actualResult = RemoveDuplicatesFromList.deleteDuplicates(head);
        System.out.println("--------------------------");
    }

    @Test
    void removeDuplicateFromTail() {
        ListNode head = createListWithRepeatedElement3();
        ListNode actualResult = RemoveDuplicatesFromList.deleteDuplicates(head);
        System.out.println("--------------------------");
    }



    @Test
    void removeFromEmptyList() {
        ListNode head = null;
        ListNode actualResult = RemoveDuplicatesFromList.deleteDuplicates(head);
        System.out.println("--------------------------");
    }

    private ListNode createListWithRepeatedElement() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(3);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        return node1;
    }

    private ListNode createListWithRepeatedElement2() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(3);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(3);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        return node1;
    }

    private ListNode createListWithRepeatedElement3() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(5);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(3);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        return node1;
    }
}