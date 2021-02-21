package string;

import java.util.HashMap;
import java.util.Map;

/*
* 242. Valid Anagram
* https://leetcode.com/problems/valid-anagram/
* */
public class ValidAnagram {

    /*Fajniejsze rozwiazanie od mojego - > dysscusion w leetcode
    * */
    public static boolean isAnagram2(String s, String t) {
        HashMap<Character,Integer> smap=new HashMap<>();
        int sl=s.length();
        int tl=t.length();
        if(sl!=tl){return false;}
        for(int i=0;i<sl;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
        }
        for(char c:smap.keySet()){
            if(smap.get(c)!=0){return false;}
        }

        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null ){
            return false;
        }
        Map<Character, Integer> frequncies = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            frequncies.merge(ch, 1, Integer::sum);
        }

        for (Character ch : t.toCharArray()) {
            int updatedFrequency = frequncies.merge(ch, -1, Integer::sum);
            if (updatedFrequency == 0) {
                frequncies.remove(ch);
            }
            if (updatedFrequency < 0) {
                return false;
            }
        }
        return  frequncies.isEmpty();
    }

}
