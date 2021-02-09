package lists;

public class ListUtils {

    public static ListNode createList() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        return node1;
    }

    public static ListNode createList2() {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        node5.next = node6;
        ListNode node4 = new ListNode(4);
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
