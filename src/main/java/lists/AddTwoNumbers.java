package lists;

/*
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
   //ListNode p = l1, q = l2 powinnismy iterowac po pomocniczych wskaznikach. Bo inaczej po zakonczeniu procedury l1 i l2 beda wskazywaly na koncowki list. A w programowaniu nie powinnismy zmieniac parametrow wejsciowych - to jest side effect
        //bo jak ktos bedzie je chcial wykorzystac jako wskazniki do poczatku list w dalszej czesci programu to sie troche zdziwi ze sa pzresuniete.
        int reminder = 0;
        ListNode head = new ListNode();
        ListNode current = head;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + reminder; //  Jak tak damy to nie bedziemy musieli robic pod spodem drugiego while :      int x = (p != null) ? p.val : 0;  int y = (q != null) ? q.val : 0;

            if (sum < 10) {
                current.val = sum;
                reminder = 0;
            } else {
                current.val = sum % 10; //zastapienie tym  carry = sum / 10; pozwala pozbyc sie if-elsa
                reminder = 1;
            }
            l1 = l1.next; //        if (p != null) p = p.next; if (q != null) q = q.next;
            l2 = l2.next;

            if (l1 != null || l2 != null) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        ListNode l = l1 != null ? l1 : l2;
        while (l != null) {
            int sum = l.val + reminder;
            if (sum < 10) {
                current.val = sum;
                reminder = 0;
            } else {
                current.val = sum % 10;
                reminder = 1;
            }
            l = l.next;
            if (l != null) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        if (reminder != 0) {
            current.next = new ListNode(1);
        }

        return head; // return dummyHead.next;
    }


}
