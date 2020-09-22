package sortowanie;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * LeetCode
 * 23. Merge k Sorted Lists
 * Fajne rozwiazanie
 * https://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
 * */
public class MergeKSortedLists {

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        Comparator<ListNode> nodeComparator = Comparator.comparingInt(n -> n.val);
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>(nodeComparator);

        listNodes.addAll(List.of(lists));

        ListNode head = new ListNode();
        ListNode p = head;

        while(!listNodes.isEmpty()) {
            ListNode n = listNodes.poll();
            /*(1)*/p.next = n;//to przyczepia |next|->z ostatniego el. do nowego el, a p = p.next przytrzymuje wskaznk do nowego el.
            // w rezultacie p to po prostu wskaznik do bierzacego elementu. nie mozemy zrobic w linijce (1) head.next = n bo head to sztywny wskazni  do poczatku listy
            p = p.next;//<==> p=n wyjdzie to samo

            if(n.next !=null) {
                listNodes.offer(n.next);
            }
        }
        return head.next;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

/*class ListNode {
    int data;
    ListNode next;

    ListNode() {
    }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}*/
/*
* https://www.youtube.com/watch?v=zLcNwcR6yO4
*
* */