package lists;


/*
  206. Reverse Linked List
  https://leetcode.com/problems/reverse-linked-list/
* Input: 1->2->3->4->5->NULL
  Output: 5->4->3->2->1->NULL
*
* */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;//zapamietanie

            curr.next = prev;  //przepiecie

            //iteracja
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
