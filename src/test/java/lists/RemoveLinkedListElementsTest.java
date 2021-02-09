package lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveLinkedListElementsTest {

    @Test
    void removeElements() {
        ListNode head = ListUtils.createList();
        ListNode actualResult = RemoveLinkedListElements.removeElements(head, 3);
        System.out.println("--------------------------");
    }

    @Test
    void removeRepetedElements() {
        ListNode head = createListWithRepeatedElement();
        ListNode actualResult = RemoveLinkedListElements.removeElements(head, 3);
        System.out.println("--------------------------");
    }

    @Test
    void removeElementsFromHead() {
        ListNode head = ListUtils.createList();
        ListNode actualResult = RemoveLinkedListElements.removeElements(head, 1);
        System.out.println("--------------------------");
    }

    @Test
    void removeElementsFromTail() {
        ListNode head = ListUtils.createList();
        ListNode actualResult = RemoveLinkedListElements.removeElements(head, 5);
        System.out.println("--------------------------");
    }

    @Test
    void removeElementsOneElement() {
        ListNode head = new ListNode(1);
        ListNode actualResult = RemoveLinkedListElements.removeElements(head, 1);
        System.out.println("--------------------------");
    }

    @Test
    void removeNonExistingElement() {
        ListNode head = ListUtils.createList();
        ListNode actualResult = RemoveLinkedListElements.removeElements(head, 10);
        System.out.println("--------------------------");
    }

    @Test
    void removeFromEmptyList() {
        ListNode head = null;
        ListNode actualResult = RemoveLinkedListElements.removeElements(head, 10);
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
}