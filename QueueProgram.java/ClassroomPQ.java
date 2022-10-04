import java.util.*;
public class ClassroomPQ {
    static class Heap{
        static ArrayList<Integer> ar=new ArrayList<>();
        public static void insert(int data){//O(logn)
            //add at last index
            ar.add(data);
            int x=ar.size()-1;//index of child
            int parent=(x-1)/2;//idx of parent
            while(ar.get(x)<ar.get(parent)){
                //swapping 
                int temp=ar.get(x);
                ar.set(x,ar.get(parent));
                ar.set(parent,temp);
                x=parent;
                parent=(x-1)/2;
            }

        }
        public int peek(){
            return ar.get(0);
        }
        private void heapify(int i){
            int min=i;
            int left=2*i+1;
            int right=2*i+2;
            if(left<ar.size()&&ar.get(left)<ar.get(min)){
                min=left;
            }
            if(right<ar.size()&&ar.get(right)<ar.get(min)){
                min=right;
            }
            while(min!=i){
                //swap;
                int temp=ar.get(i);
                ar.set(i, ar.get(min));
                ar.set(min, temp);
                heapify(min);
            }
        }
        public  int delete(){
            int data=ar.get(0);
            //swap first and last
            int temp=ar.get(0);
            ar.set(0, ar.get(ar.size()-1));
            ar.set(ar.size()-1,temp);


            //delete last element
            ar.remove(ar.size()-1);


            ///heapify
            heapify(0);
            return data;
        }
        public static boolean isEmpty(){
            return ar.size()==0;
        }
    }

    public static void heapifyy(int arr[],int i,int size){
        int maxIdx=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<size&&arr[left]>arr[maxIdx]){
            maxIdx=left;
        }
        if(right<size&&arr[right]>arr[maxIdx]){
            maxIdx=right;
        }

        while(maxIdx!=i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapifyy(arr, maxIdx, size);
        }
    }
    public static void heapSort(int arr[]){
        //build max-heap
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapifyy(arr,i,n);
        }
        //push largest at the end

        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapifyy(arr,0,i);
        }
    }
   
    
    public static void main(String[] args){
        // Heap h=new Heap();
        // h.insert(4);
        // h.insert(3);
        // h.insert(5);
        // h.insert(8);
        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.delete();
        // }


        int arr[]={1,2,4,5,3};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
