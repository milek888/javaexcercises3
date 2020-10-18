package datastructures;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapAlgos {

    public static void iterateTreeMap() {
        // Create a TreeMap
        TreeMap<String, String> treemap = new TreeMap<String, String>();

        // Add key-value pairs to the TreeMap
        treemap.put("Key3","Item3");
        treemap.put("Key1","Item1");
        treemap.put("Key4","Item4");
        treemap.put("Key5","Item5");
        treemap.put("Key2","Item2");

        // Get a set of the entries
        Set<Map.Entry<String, String>> set = treemap.entrySet();

        // Get an iterator
        Iterator<Map.Entry<String, String>> it = set.iterator();

        // Display elements
  /*      while(it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            System.out.print("Key is: "+me.getKey() + " & ");
            System.out.println("Value is: "+me.getValue());
        }*/

        treemap.values()
                .forEach(System.out::println);

    }
}
