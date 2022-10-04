import java.util.*;
import java.util.LinkedList;
public class ClassRoom {
    public static void printNonRepeatingCharacters(String str){
        Queue<Character> q=new LinkedList<>();
        int freq[]=new int[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty()&&freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
    }
    public static void interLeaveQueue(Queue<Integer> q){
        Queue<Integer> firstHalf=new LinkedList<>();
        int size=q.size();
        for(int i=0;i<(size/2);i++){
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void reverseQueue(Queue<Integer> q){//O(N)
        Stack<Integer> s=new Stack<>();
        while(!q.isEmpty()){
            s.push((q.remove()));
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void reverseKnodes(Queue<Integer> q,int k){
       Stack<Integer> s=new Stack<>();
       int size=q.size();
       for(int i=0;i<k;i++){
        s.push(q.remove());
       }
       while(!s.isEmpty()){
        q.add(s.pop());
       }
       for(int i=0;i<(size-k);i++){
        q.add(q.remove());
       }
    }
    public static int minimumCost(int ar[]){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<ar.length;i++){
            pq.add(ar[i]);
        }
        int ans=0;
        while(pq.size()>1){
            int f=pq.remove();
            int s=pq.remove();
            int sum=f+s;
            ans=ans+sum;
            pq.add(sum);
        }
        return ans;
    }
    public static void maxSum(int ar[],int k){
        Deque<Integer> q=new LinkedList<>();
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<ar.length;i++){
            q.addLast(ar[i]);
        }
        int j=0;
        int largest=Integer.MIN_VALUE;
        while(j<k){
            if(q.()>largest){
                largest=q.peek();
            }
           
            j++;
        }
        q.removeFirst();
        a.add(largest);
        
        System.out.print(largest+" ");
    }
    public static void main(String[] args){
        String str="aabccxb";
        //printNonRepeatingCharacters(str);
        System.out.println();
        int ar[]={1,2,3,4,5,6,7,8,9};
        maxSum(ar,3);
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        //reverseQueue(q);
        //interLeaveQueue(q);
       // reverseKnodes(q, 5);
        // while(!q.isEmpty()){
        //     System.out.print(q.peek()+" ");
        //     q.remove();
        // }
    }
    
}
