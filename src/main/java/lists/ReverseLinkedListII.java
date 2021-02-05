package lists;


/*
* 92. Reverse Linked List II
* https://leetcode.com/problems/reverse-linked-list-ii/
* Reverse a linked list from position m to n. Do it in one-pass.
* Input: 1->2->3->4->5->NULL, m = 2, n = 4
  Output: 1->4->3->2->5->NULL
* */
public class ReverseLinkedListII {
//Istotne bedzie zapamietanie wskaznikow: m-1, m, n, n+1
    //Doiterowujemy do wskaznika m-1
    //Zapamietujemy wskazniki: m-1, m
    //Iterujemy  m-n razy jednoczesnie obracajac listezmiana warunku iteracji z (curr != null) -> (n-m) X iteration
    //Zapamietujemy wskazniki: n, n+1
    //Przepinamy wskazniki m-1 -> n, m -> n+1
    //Musimy jeszcze zapamietac head zeby go zwrocic
        //Przypadek kiedy head moze sie zmienic bo przekrecamy cala liste m = 1 n = last

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode next = null;

        //Doiterowujemy do wskaznika m-1
        ListNode curr = head;
        for (int i = 0; i < m-1; i++) {
            prev = curr;
            curr = curr.next;
        }

        //Zapamietujemy wskazniki: m-1, m
        ListNode nodePrevM = prev;//m-1
        ListNode nodeM = curr;//m

        //Iterujemy  m-n razy jednoczesnie obracajac liste, zmiana warunku iteracji z (curr != null) -> (n-m) X iteration
        for (int i = 0; i < n - m+1; i++) {
            next = curr.next;//zapamietanie
            curr.next = prev;//przepiecie
            //iteracja
            prev = curr;
            curr = next;
        }

        //Zapamietujemy wskazniki: n, n+1
        ListNode nodeN = prev;//n
        ListNode nodeNextN = curr;//n+1

        //Przepinamy wskazniki m-1 -> n, m -> n+1
        if(m > 1) {
            nodePrevM.next = nodeN;//m-1 -> n
        }
        nodeM.next = nodeNextN;//m -> n+1

        return m > 1 ? head : nodeN;
    }
}
