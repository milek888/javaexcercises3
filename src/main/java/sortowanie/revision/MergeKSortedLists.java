package sortowanie.revision;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
*
* */
public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        Comparator<ListNode> comparator = Comparator.comparingInt(n -> n.val);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        int k = lists.length;

        for (int i = 0; i < k; i++) {
            queue.add(lists[i]);
        }

        ListNode head = new ListNode();
        ListNode temp = head;
        while (!queue.isEmpty()) {

            ListNode node = queue.poll();
            temp.next = node;
            temp = node;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }
    }
}
