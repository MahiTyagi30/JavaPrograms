
import java.util.*;
public class AdvancedSorting {
    public static void printArray(int ar[]){
        int n=ar.length;
        for(int i=0;i<n;i++){
            System.out.print(ar[i]+" ");
        }
    }

    public static void quickSort(int ar[],int si,int ei){
        int pIdx=partition(ar,si,ei);
        quickSort(ar, si, pIdx-1);
        quickSort(ar, pIdx+1, ei);
    }
    public static int partition(int ar[],int si,int ei){
        int pivot=ar[ei];//pivot is always last element
        int i=si-1;//to make space for elements smaller than pivot
        for(int j=si;j<ei;j++){
            if(ar[j]<=pivot){
                i++;
                int temp=ar[j];
                ar[j]=ar[i];
                ar[i]=temp;
            }
        }
          i++;
        int temp=pivot;
          ar[ei]=ar[i];
        ar[i]=temp;
        return i;

    }
    public static int searchInSortedRotatedArray(int ar[],int tar,int si,int ei){//originally array ws sorted in ascd.order
        if(si>ei){
            return -1;
        }
        

        int mid=si+(ei-si)/2;
        //case found
        if(ar[mid]==tar){
            return mid;
        }
        //mid on line 1
        if(ar[si]<ar[mid]){
            //case a:
            if(ar[si]<=tar&&tar<=ar[mid]){
               return searchInSortedRotatedArray(ar, tar, si, mid-1);
            }
            else{
              return   searchInSortedRotatedArray(ar, tar, mid+1, ei);
            }
        }
        //mid on line 2
        else{
            //case c:
            if(ar[mid]<=tar&&tar<=ar[ei]){
                 return searchInSortedRotatedArray(ar, tar, mid+1, ei);
            }
            //case d:
            else{
                return searchInSortedRotatedArray(ar, tar, si, mid-1);
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
        merge(ar,si,ei,mid);
    }
    public static void merge(int ar[],int si,int ei,int mid){
        int temp[]=new int[ei-si+1];
        int i=si,j=mid+1,k=0;
        while(i<=mid&&j<=ei){
            if(ar[i]<=ar[j]){
                temp[k]=ar[i];
                i++;k++;
            }
            else{
                temp[k]=ar[j];
                j++;k++;
            }
        }
        while(i<=mid){
            temp[k++]=ar[i++];
        }
        while(j<=ei){
            temp[k++]=ar[j++];
        }
     //copying the temp array into original 
     for(int m=0,n=si;m<temp.length;m++,n++){
        ar[n]=temp[m];
     }
    }
    public static int countInversion(int ar[]){
        int c=0;
        for(int i=0;i<ar.length;i++){
            for(int j=i+1;j<ar.length;j++){
                if(ar[i]>ar[j]){
                    c++;
                }
            }
        }
        return c;
    }
    private static int mergeSortcount(int ar[],int si,int ei){
        int count=0;
        if(si<ei){
        int mid=si+(ei-si)/2;
        count= count+ mergeSortcount(ar, si, mid);
        count= count+ mergeSortcount(ar, mid+1, ei);
        count = count+ mergecount(ar,si,ei,mid);
        }
        return count;
    }
    public static int mergecount(int ar[],int si,int ei,int mid){
        int c=0;
        int temp[]=new int[ei-si+1];
        int i=si,j=mid+1,k=0;
        while((i<=mid)&&(j<=ei)){
            if(ar[i]<ar[j]){
                temp[k]=ar[i];
                i++;k++;
            }
            else{
                temp[k]=ar[j];
                c=c+(mid-i);
                j++;k++;
            }
        }
        while(i<=mid){
            temp[k++]=ar[i++];
        }
        while(j<=ei){
            temp[k++]=ar[j++];
        }
     //copying the temp array into original 
     for(int m=0,n=si;m<temp.length;m++){
        ar[n]=temp[m];
     }
     return c;
    }
    public static int getInversion(int ar[]){
        int n=ar.length;
        return mergeSortcount(ar, 0, n-1);
    }
   
    public static void main(String[] args){
        int ar[]={5,4,3,2,1};
       System.out.println(getInversion(ar));
       // System.out.println(countInversion(ar));
       mergeSort(ar, 0, ar.length-1);
        //quickSort(ar, 0, ar.length-1);
      // int a= searchInSortedRotatedArray(ar, 2, 0,ar.length-1);
      // System.out.println(a);
      printArray(ar);
    }
    
}