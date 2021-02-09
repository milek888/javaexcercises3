package lists;

/*
*  Leetcode 21. Merge Two Sorted Lists
*  https://leetcode.com/problems/merge-two-sorted-lists/
* */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (curr1 != null && curr2 != null) {

            if (curr1.val <= curr2.val) {
                prev.next = curr1;
                curr1 = curr1.next;
            } else {
                prev.next = curr2;
                curr2 = curr2.next;
            }

            prev = prev.next;
        }

        prev.next = curr1 == null ? curr2 : curr1;
        return prehead.next;
    }
}
