import java.util.*;
import java.util.Map.Entry;

public class Clasroom1 {

    public static void main(String[] args){
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India",100);
        hm.put("china", 150);
        hm.put("Japan", 50);
        hm.put("Indonesia",70);
        hm.put("US", 60);
        hm.put("Dubai", 60);
       Set<String> key=hm.keySet();
       Set<Entry<String, Integer>> keys=hm.entrySet();
       System.out.println(keys);
       for (String k: key) {
        System.out.println(k+"->"+hm.get(k));
        
       }
    //    for (Entry<String, Integer> k : keys) {
    //     System.out.println("->"+hm.entrySet());
        
    //    }
    // }
    
}
