package sortowanie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {//TODO improve tests add generator provider

    @Test
    void mergeKLists2() {
        ListNode actualResult = MergeKSortedLists.mergeKLists2(getLists());
        List<Integer> actualResultList = new ArrayList<>();
        ListNode p = actualResult;
        while(p!=null){
            actualResultList.add(p.val);
            p = p.next;
        }
        List<Integer> expectedResultList = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                .boxed()
                .collect(toList());
        assertEquals(expectedResultList, actualResultList);
    }

        private ListNode[] getLists(){
        int k = 3; // Number of linked lists

        // An array to store the head nodes of the linked lists
        ListNode[] list = new ListNode[k];

        list[0] = new ListNode(1);
        list[0].next = new ListNode(5);
        list[0].next.next = new ListNode(7);

        list[1] = new ListNode(2);
        list[1].next = new ListNode(3);
        list[1].next.next = new ListNode(6);
        list[1].next.next.next = new ListNode(9);

        list[2] = new ListNode(4);
        list[2].next = new ListNode(8);
        list[2].next.next = new ListNode(10);

        return list;
    }
}