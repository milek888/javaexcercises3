package lists.revision;


import lists.ListNode;

public class ReverseLinkedListRevision {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;//zapamietanie

            curr.next = prev;//przepiecie

            //iteracja
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
