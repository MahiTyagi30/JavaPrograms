import java.util.*;

public class BasicSorting{

public static void bubbleSort(int ar[]){
    int swap=0;//to check sorted array
    for(int turn=0;turn<ar.length-1;turn++){//ar.length-1
        for(int j=0;j<ar.length-1-turn;j++){
            if(ar[j]>ar[j+1]){
                int temp=ar[j];
                ar[j]=ar[j+1];
                ar[j+1]=temp;
                swap++;
            }
            if(swap==0){//time taken is O(N)
                break;
            }
        }
    }

}
public static void selectionSort(int ar[]){//O(N)
    for(int turn=0;turn<ar.length;turn++){
        int minElement=turn;
        for(int j=turn+1;j<ar.length;j++){
            if(ar[minElement]>ar[j]){
                minElement=j;
            }
        }
        //swapping
        int temp=ar[turn];
        ar[turn]=ar[minElement];
        ar[minElement]=temp;
    }
}
public static void insertionSort(int ar[]){//O(N^2)
    for(int i=1;i<ar.length;i++){
        int curr=ar[i];
        int prev=i-1;
        while(prev>=0&&ar[prev]>curr){//for ascending
            ar[prev+1]=ar[prev];
            prev--;
        }
        //inserting
        ar[prev+1]=curr;
    }
}
 public static void countSort(int ar[]){//O(N)
    int n=ar.length;
    int largest=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        largest =Math.max(largest,ar[i]);
    }
    //creating the count array
    int count[]=new int[largest+1];
    for(int i=0;i<n;i++){
        count[ar[i]]++;
    }
    //sorting
    int j=0;
    for(int i=0;i<count.length;i++){
        while(count[i]>0){
        ar[j]=i;
        j++;
        count[i]--;
        }
    }

}
public static void mergeSort(int ar[],int si,int ei){
    if(si>=ei){
        return;
    }
    int mid=si+(ei-si)/2;
    mergeSort(ar, si, mid);
    mergeSort(ar, mid+1, ei);
    merge(ar,si,mid,ei);
}
public static void merge(int ar[],int si,int mid,int ei){
    int temp[]=new int[ei-si+1];
    int i=si;//for left part
    int j=mid+1;//for right part
    int k=0;//for temp array
    while(i<=mid&&j<=ei){
        if(ar[i]<ar[j]){
            temp[k]=ar[i];
            k++;i++;
        }
        else{
            temp[k]=ar[j];
            k++;j++;
        }
    }
    //for left part elements
    while(i<=mid){
        temp[k++]=ar[i++];
    }
    //for right part
    while(j<=ei){
        temp[k++]=ar[j++];

    }
    //copying temp values in original array
    for(int m=0,n=si;k<temp.length;m++,n++){
        ar[n]=temp[m];
    }
}
public static void printArray(int ar[]){
    int n=ar.length;
    for(int i=0;i<n;i++){
        System.out.print(ar[i]+" ");
    }
}
public static void main(String args[]){
    int ar[]={4,1,2,3,7};
   // countSort(ar);
    //Arrays.sort(ar,0,3);
    mergeSort(ar, 0, ar.length-1);
    printArray(ar);

}
}
