package sortowanie;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/
 * https://medium.com/outco/how-to-merge-k-sorted-arrays-c35d87aa298e <---- bardzo fajnie wytlumaczone
 * https://www.hackerearth.com/practice/notes/heaps-and-priority-queues/ <---- operacje na Heap-ie fajnie wytlumaczone
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 *
 * */
public class MergeKsortedArrays {

    //-----------------------------------------Sposob 1---------------------------------------

    //-------------------------------------------------------------------------------------------------------------

    static int[] mergeKSortedArrays(int[][] arr, int start, int end) {

        int mid = start + (end - start) / 2;
        int[] left = arr[start];
        int[] right = arr[end];

        if (mid - start > 0) {
            left = mergeKSortedArrays(arr, start, mid);
        }
        if (end - (mid + 1) > 0) {
            right = mergeKSortedArrays(arr, mid + 1, end);
        }

        int[] result = mergeTwoArrays(left, right);
        return result;
    }

    //-----------------------------------------Sposob 2---------------------------------------

    static private int[] mergeTwoArrays(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int result[] = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[i + j] = arr1[i];
                i++;
            } else {
                result[i + j] = arr2[j];
                j++;
            }
        }
        if (i < arr1.length) {
            //https://stackoverflow.com/questions/40100953/the-java-way-to-copy-a-subarray-into-an-initialized-array
            System.arraycopy(arr1, i, result, i + j, arr1.length - i);
        }
        if (j < arr2.length) {
            System.arraycopy(arr2, j, result, i + j, arr2.length - j);
        }
        return result;
    }

    //-----------------------------------------Sposob 3---------------------------------------

/*    static int[] mergeKSortedArraysBottomUp2(int[][] arr, int k) {
        int i = 0;
        int j = k - 1;
        if (k == 1) {
            return arr[0];
        }
        while (i < j) {
            arr[i] = mergeTwoArrays(arr[i], arr[j]);
            j++;
            i--;
        }
        if (k > 1) {
            mergeKSortedArraysBottomUp2(arr, k / 2);
        }
        return arr[0];
    }*/

    //-----------------------------------------Sposob 4---------------------------------------

    static int[] mergeKSortedArraysBottomUp(int[][] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            arr[0] = mergeTwoArrays(arr[i], arr[0]);
        }
        return arr[0];
    }

    //!!! bardzo fajnie wytlumaczone
    //https://medium.com/outco/how-to-merge-k-sorted-arrays-c35d87aa298e
    //I tu fajne zrozumiale rozwiazanie https://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/
    static int[] mergeKSortedArraysUsingHeap(int[][] arr) {

        Comparator<ArrayNode> comparator = Comparator.comparingInt(n -> n.arr[n.index]);
        PriorityQueue<ArrayNode> arrayNodes = new PriorityQueue<>(comparator);

        int totalElements = 0;
        for (int[] array : arr) {
            arrayNodes.add(new ArrayNode(array, 0));
            totalElements += array.length;
        }
        int[] result = new int[totalElements];

        int i = 0;
        while (!arrayNodes.isEmpty()) {
            ArrayNode node = arrayNodes.poll();
            result[i++] = node.arr[node.index];
            if (node.getIndex() < node.arr.length - 1) {
                arrayNodes.add(new ArrayNode(node.arr, node.index + 1));
            }
        }

        return result;
    }

    //TODO --------------------------------------------------Powtorka---skasowac------------------------------------------------

    //TODO powtorka skasowac
    static int[] mergeKSortedArraysUsingHeapRevision(int[][] arr) {
        int K = arr.length;
        int N = arr[0].length;
        Comparator<ArrayNode> comparator = Comparator.comparing(ArrayNode::getIndex);
        PriorityQueue<ArrayNode> heap = new PriorityQueue<>(comparator);
        for (int i = 0; i < arr.length; i++) {
            heap.add(new ArrayNode(arr[i], 0));
        }

        int[] result = new int[N * K];
        int i = 0;
        while (!heap.isEmpty()) {
            ArrayNode minNode = heap.poll();
            result[i++] = minNode.arr[minNode.index];

            if (minNode.index < N-1) {
                minNode.index++;
                heap.add(minNode);
            }
        }

        return result;
    }

    //TODO------------------------------------------Powtorka end--------------------------------------------------------

    static class ArrayNode {
        public int[] arr;
        public int index;

        public ArrayNode(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        public int[] getArr() {
            return arr;
        }

        public int getIndex() {
            return index;
        }
    }

}
