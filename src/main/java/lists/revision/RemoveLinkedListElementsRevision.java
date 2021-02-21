package lists.revision;


import lists.ListNode;

/*
* LeetCode 203. Remove Linked List Elements
* https://leetcode.com/problems/remove-linked-list-elements/
* Remove all elements from a linked list of integers that have value val.
  Example: Input:  1->2->6->3->4->5->6, val = 6
           Output: 1->2->3->4->5
* */
public class RemoveLinkedListElementsRevision {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = head;
        ListNode prev = dummyHead;

        while (curr != null) {
            if (curr.val != val) {
                //iteracja
                prev = curr;
            } else {
                //przepinamy
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummyHead;
    }
}
