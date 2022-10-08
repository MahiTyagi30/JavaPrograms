import java.util.*;
public class HashPrograms {
    
    public static boolean isAnagram(String s,String t){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(map.get(c)!=null){
                if(map.get(c)==1){
                    map.remove(c);
                }
                else{
                    map.put(c, map.get(c)-1);
                }
            }
            else{
                return false;
            }
        }
        if(map.isEmpty()){
            return true;
        }
        else{
            return false;
        }

    }


    public static void majorityElement(int ar[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<ar.length;i++){
            // if(map.containsKey(ar[i])){
            //     map.put(ar[i], map.get(ar[i])+1);
            // }
            // else{
            //     map.put(ar[i], 1);
            // }

            map.put(ar[i], map.getOrDefault(ar[i], 0)+1);
        }

    Set<Integer> keys=map.keySet();
    for(Integer k: keys){
        if(map.get(k)>ar.length/3){
            System.err.println(k);
        }
    }

    }
    public static void main(String[] args){
        int ar[]={1,3,2,5,1,3,1,5,1};
        majorityElement(ar);
        System.err.println(isAnagram("care", "race"));
    }
    
}
