package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
 * 496. Next Greater Element I
 *https://leetcode.com/problems/next-greater-element-i/
 * */
public class NextGreaterElement {
    /*
     * Wystarczy na stos wkladac tylko elementy z nums2 bo nims1 jest i tak podzbiorem nums2
     * 1. Wkladamy pierwszy element z nums2 na stos
     * 2. Przesuwamy wskaznik do drugiego elementu w tablicy nums2
     * 3. Porownujemy drugi element t z nums2 z elementem s ze stosu. Jesli t > s to:
     *    - hashmap.put(s, t)
     *    - sciagamy s ze stosu
     *    - i wrzucamy na stos t
     *    - Jesli tak nie jest wrzucamy tylko t na stos.
     * 4. Przesuwamy wskaznik w tablicy nums2 do 3-ciego elementu i powtarzamy procedure
     *    Uwaga jesli dla kolejnych elementow z tablicy elementy t beda <= elementow ze stosu to po prostu bedziemy je kolejnow
     *    wrzucali na stos bez usuwania az znajdziemy pierwszy wiekszy. Wtedy bedzmy sciagac kolejno ze stosu tyle elementow s od
     *    ktorych jest on wiekszy i dawac je z nim jako pary do mapy.
     * 5. Jak wyczerpiemy wszystkie elementy z tablicy to dla wszystkich elementow pozostalych na stosie przypisujemy w mapie pare -1.
     * */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> pairs = new HashMap<>();

        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                pairs.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            pairs.put(stack.pop(), -1);
        }

        return Arrays.stream(nums1)
                .map(pairs::get)
                .toArray();
    }
}
