package lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class ShowAllListElementInRandomOrderTest {

    @Test
    void showElementsRandomOrder() {
        ArrayList<Integer> arrayList = new ArrayList();
        LinkedList<Integer> linkedList = new LinkedList<>();

        List<Integer> list = Arrays.asList(1,2,3,4,5);
/*        Collections.shuffle(list);
        list.forEach(System.out::println);*/

 /*       Random random = new Random();
        int randInt = random.nextInt(list.size());//ThreadLocalRandom.current().nextInt(list.size());
        System.out.println(randInt);*/
        Random random = new Random();
        List<Integer> result = ShowAllListElementInRandomOrder.chooseRandomly(list, 5, random);
        result.forEach(System.out::println);
    }
}