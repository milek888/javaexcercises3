package lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* Input: l1 = [2,4,3], l2 = [5,6,4]
  Output: [7,0,8]
  Explanation: 342 + 465 = 807.
* */

/*
* [9,9,9,9,9,9,9]
[9,9,9,9]
*
* */
class AddTwoNumbersTest {

    @Test
    void addTwoNumbers1() {
        ListNode head1 = new ListNode(9);
        ListNode current1 = head1;

        current1.next = new ListNode(9);
        current1 = current1.next;
        current1.next = new ListNode(9);
        current1 = current1.next;
        current1.next = new ListNode(9);
        current1 = current1.next;
        current1.next = new ListNode(9);
        current1 = current1.next;
        current1.next = new ListNode(9);
        current1 = current1.next;
        current1.next = new ListNode(9);

        ListNode head2 = new ListNode(9);
        ListNode current2 = head2;
        current2.next = new ListNode(9);
        current2 = current2.next;
        current2.next = new ListNode(9);
        current2 = current2.next;
        current2.next = new ListNode(9);


        ListNode result = AddTwoNumbers.addTwoNumbers(head1, head2);
        System.out.println();
    }

    @Test
    void addTwoNumbers2() {
        ListNode head1 = new ListNode(2);
        ListNode current1 = head1;

        current1.next = new ListNode(4);
        current1 = current1.next;
        current1.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        ListNode current2 = head2;
        current2.next = new ListNode(6);
        current2 = current2.next;
        current2.next = new ListNode(4);

        ListNode result = AddTwoNumbers.addTwoNumbers(head1, head2);
        System.out.println();
    }
}