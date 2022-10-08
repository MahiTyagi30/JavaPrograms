import java.util.*;
public class HashSetPrograms {

    public static void distinctElement(int ar[])
{
    HashSet<Integer> set =new HashSet<>();
       for(int i=0;i<ar.length;i++){
        set.add(ar[i]);
    }
    System.out.println(" the no.of distinct elements are "+set.size());
}
public static void intersection(int ar1[],int ar2[]){
    int c=0;
    HashSet<Integer> set=new HashSet<>();
    for(int i=0;i<ar1.length;i++){
        set.add(ar1[i]);
    }
    for(int i=0;i<ar2.length;i++){
        if(set.contains(ar2[i])){
            c++;
            set.remove(ar2[i]);
        }
    }
    System.out.println("the total no. of elements in intersection of sets are "+c);
}
public static String getStart(HashMap<String,String> map){
    HashMap<String,String> revMap=new HashMap<>();
    for(String key:map.keySet()){
        revMap.put(map.get(key), key);
    }
    for(String key:map.keySet()){
        if(!revMap.containsKey(key)){
            return key;
        }
    }
    return null;
}
public static void largestSubarray(int ar[]){
    HashMap<Integer,Integer> map=new HashMap<>();
    int sum=0;int len=0;
    for(int j=0;j<ar.length;j++){
        sum=sum+ar[j];
        if(map.containsKey(sum)){
            len=Math.max(len,(j-map.get(sum)));
        }
        else{
            map.put(sum, j);
        }
    }
    System.out.println("the largest subaray with sum 0 is of size  "+len);
}
public static void kSumSubarrays(int ar[],int k){
    HashMap<Integer,Integer> hm=new HashMap<>();
    int sum=0;int ans=0;
    hm.put(0, 1);
    for(int j=0;j<ar.length;j++){
        sum=sum+ar[j];
        if(hm.containsKey(sum-k)){
            ans=ans+hm.get(sum-k);
        }
        hm.put(sum, hm.getOrDefault(sum, 0)+1);
    }
    System.out.println("the total subarrays of length k are "+ans);
}
public static void frequency(String str){//DOUBTTTTTTT
    TreeMap<Character,Integer> m=new TreeMap<>();
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        m.put(ch,m.getOrDefault(ch, 0)+1);
    }
    String s="";

    for(Character k:m.keySet()){
        int t=m.get(k);
        while(t>=0){
        s=s+k;
        t--;
        }
    }
    System.out.println(s);
}
public static ArrayList<Integer> targetSum(int ar[],int target){
    HashMap<Integer,Integer> map=new HashMap<>();
    ArrayList<Integer> list=new ArrayList<>();
    for(int i=0;i<ar.length;i++){
        if(map.containsKey(target-ar[i])){
            list.add(map.get(target-ar[i]));
            list.add(i);
            break;
        }
        else{
            map.put(ar[i], i);
        }
    }
    return list;
}
    public static void main(String[] args){
    //     HashSet<Integer> hs=new HashSet<>();
    //     hs.add(2);
    //     hs.add(3);
    //     hs.add(4);
    //     hs.add(6);
    //     hs.add(2);
    //    Iterator it=hs.iterator();
    //    while(it.hasNext()){
    //     System.out.println(it.next());
    //    }
    // }
    // int num[]={4,2,3,5,6,7,3,4,2,1};
    // distinctElement(num);
    // int ar1[]={7,3,9};
    // int ar2[]={6,3,9,2,9,4};
    // intersection(ar1, ar2);

    // HashMap<String,String> map=new HashMap<>();
    // map.put("chennai", "Bengaluru");
    // map.put("mumbai", "delhi");
    // map.put("goa", "chennai");
    // map.put("delhi", "goa");
    // String start=getStart(map);
    // System.out.print(start);
    // for( String key:map.keySet()){
    //     System.out.print("->"+map.get(start)+" ");
    //     start=map.get(start);
    // }
    // //System.out.println();
    // }
    // int ar[]={15,-2,2,-8,1,7,10,23};
    // largestSubarray(ar);
    // int ar[]={10,2,-2,-20,10};
    // kSumSubarrays(ar, -10);
    //frequency("tree");
    int arr[]={3,2,4};
    System.out.println(targetSum(arr, 6));
}
}
