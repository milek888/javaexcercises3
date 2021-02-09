package lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @Test
    void mergeTwoLists() {
        ListNode l1 = createList();
        ListNode l2 = createList2();

      /*  ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);*/

        ListNode result = MergeTwoSortedLists.mergeTwoLists(l1, l2);
        System.out.println("----------------------------------------");
    }

    public static ListNode createList() {
        ListNode node5 = new ListNode(8);
        ListNode node4 = new ListNode(7);
        node4.next = node5;
        ListNode node3 = new ListNode(5);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        return node1;
    }

    public static ListNode createList2() {
     /*   ListNode node6 = new ListNode(8);
        ListNode node5 = new ListNode(7);
        node5.next = node6;*/
        ListNode node4 = new ListNode(6);
        node4.next = null;/*node5;*/
        ListNode node3 = new ListNode(4);
        node3.next = node4;
        ListNode node2 = new ListNode(4);
        node2.next = node3;
        ListNode node1 = new ListNode(3);
        node1.next = node2;
        return node1;
    }
}