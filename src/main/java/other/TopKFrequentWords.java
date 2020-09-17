package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            frequencies.merge(word, 1, Integer::sum);
        }

        Comparator<Map.Entry<String, Integer>> frequencyComparator = Map.Entry.comparingByValue();
        Comparator<Map.Entry<String, Integer>> frequencyWordComparator = frequencyComparator
                .reversed()
                .thenComparing(Map.Entry::getKey);

        List<Map.Entry<String, Integer>> sortedWords = frequencies.entrySet().stream()
                .sorted(frequencyWordComparator)
                .collect(Collectors.toList());


        return sortedWords.stream()
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    //---------------------------------Inne rozwiazania---------------------------------
    /*
     * Heap
     * https://leetcode.com/problems/top-k-frequent-words/solution/
     * */

    public List<String> topKFrequentPriorityQueue(String[] words, int k) {
        HashMap<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            frequencies.merge(word, 1, Integer::sum);
        }

        PriorityQueue<String> topKFrequentWords = new PriorityQueue<>(
                (w1, w2) -> frequencies.get(w1).equals(frequencies.get(w2)) ?//TODO is it possible to make it more java 8
                        w2.compareTo(w1) : frequencies.get(w1) - frequencies.get(w2) );


        for(String word: frequencies.keySet()) {
            topKFrequentWords.add(word);
            if(topKFrequentWords.size() > k){
                topKFrequentWords.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!topKFrequentWords.isEmpty()){
            result.add(topKFrequentWords.poll());
        }
        Collections.reverse(result);
        return result;
    }


    /*
     *
     *https://www.hackerearth.com/practice/notes/heaps-and-priority-queues/
     * https://stackoverflow.com/questions/54501390/time-complexity-of-inserting-n-elements-in-a-java-util-priorityqueue-with-i
     *https://stackoverflow.com/questions/47420638/time-complexity-of-java-priorityqueue-heap-insertion-of-n-elements?answertab=votes#tab-top
     *
     * */
}
