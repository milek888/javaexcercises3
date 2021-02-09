package lists;

/*
*  LeetCode 83. Remove Duplicates from Sorted List
*  https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*  Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
*  Return the linked list sorted as well
*  Input: head = [1,1,2]
   Output: [1,2]
   Input: head = [1,1,2,3,3]
   Output: [1,2,3]
* */
public class RemoveDuplicatesFromList {

    /*
    * Znacznie prostsze rozwiazanie niz to moje
    * */
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode curr = head;
        ListNode next = null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (curr.next != null) {
            next = curr.next;//zapamietanie

            if (curr.val == next.val) {//usuwamy duplikat
                prev.next = next;
                curr.next = null;
                curr = next;
            } else {
                //iteracja
                prev = curr;
                curr = next;
            }

        }
        return dummyHead.next;
    }
}
