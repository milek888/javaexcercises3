package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* https://stackoverflow.com/questions/4702036/take-n-random-elements-from-a-liste
* https://www.geeksforgeeks.org/randomly-select-items-from-a-list-in-java/
* https://www.baeldung.com/java-random-list-element
* */
public class ShowAllListElementInRandomOrder {
/*to jest to rozwiazanie
* https://jimblackler.net/blog/?p=59
* */

    /**
     * Create a new list which contains the specified number of elements from the source list, in a
     * random order but without repetitions.
     *
     * @param sourceList    the list from which to extract the elements.
     * @param itemsToSelect the number of items to select
     * @param random        the random number generator to use
     * @return a new list   containg the randomly selected elements
     */
    public static <T> List<T> chooseRandomly(List<T> sourceList, int itemsToSelect, Random random) {
        int sourceSize = sourceList.size();

        // Generate an array representing the element to select from 0... number of available
        // elements after previous elements have been selected.
        int[] selections = new int[itemsToSelect];

        // Simultaneously use the select indices table to generate the new result array
        ArrayList<T> resultArray = new ArrayList<T>();

        for (int i = 0; i < itemsToSelect; i++) {

            // An element from the elements *not yet chosen* is selected
            int selIdx = random.nextInt(sourceSize - i);
            selections[i] = selIdx;
            // Store original selection in the original range 0.. number of available elements


            // This selection is converted into actual array space by iterating through the elements
            // already chosen.
            for (int j = i - 1; j >= 0; j--) {
                if (selIdx >= selections[j]) {
                    selIdx++;
                }
            }
            // When the first selected element record is reached all selections are in the range
            // 0.. number of available elements, and free of collisions with previous entries.

            // Write the actual array entry to the results
            resultArray.add(sourceList.get(selIdx));
        }
        return resultArray;
    }



    public static void showElementsRandomOrder(List<Integer> numbers) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Random random = new Random();

        for (int i = 0; i < copyNumbers.size(); i++) {
            int randInt = random.nextInt(copyNumbers.size());
            System.out.println(copyNumbers.get(randInt));
            copyNumbers.remove(randInt);
        }
    }

}


/*
* How to shuffle LinkedList
* https://www.geeksforgeeks.org/how-to-shuffle-elements-in-linkedlist-in-java/?ref=rp
* */