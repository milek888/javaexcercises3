package lists;

/*
* LeetCode 203. Remove Linked List Elements
* https://leetcode.com/problems/remove-linked-list-elements/
* Remove all elements from a linked list of integers that have value val.
  Example: Input:  1->2->6->3->4->5->6, val = 6
           Output: 1->2->3->4->5
* */
public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (curr != null) {

            //rysunek
            ////jesli kasujemy prev sie nie zmienia bo wskazywalby na usuniety
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                //normalna iteracja iteracja
                prev = curr;
            }
                curr = curr.next;

        }

        return dummyHead.next;
    }
}
