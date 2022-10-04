import java.util.*;
public class PriorityQAssig {
    static  class Node {
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    
    
    public static void linkedListMerge(Node root1,Node root2){
         PriorityQueue<Integer> pq=new PriorityQueue<>();
         Node c1=root1;
         Node c2=root2;
         while(c1!=null&&c2!=null){
            if(c1.data<c2.data){
                pq.add(c1.data);
                c1=c1.next;
            }
            else{
                pq.add(c2.data);
                c2=c2.next;
            }
         }  
    }
}
    public static void main(String[] args){

    }
    
}
