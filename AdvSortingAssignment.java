import java.util.*;
public class AdvSortingAssignment {
    public static void MS(String str[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=(ei-si)/2;
        MS(str,si,mid);
        MS(str,mid+1,ei);
        merge(str,si,ei,mid);
        
    }
    public static void merge(String str[],int si,int ei,int mid){
        String temp[]=new String[ei-si+1];
        int i=0,j=0,k=0;
        while(i<mid&&j<ei){
            if(str[i].compareTo(str[j])<0){
                temp[k]=str[i];
                k++;i++;
            }
            else{
                temp[k]=str[j];
                k++;j++;
            }
        }
        while(i<mid){
            temp[k++]=str[i++];
        }
        while(j<ei){
            temp[k++]=str[j++];
        }
        for(int m=0,n=si;m<temp.length;m++,n++){
            str[n]=temp[m];
        }

    }
    public static void print(String str[]){
        for(int i=0;i<str.length;i++){
            System.out.print(str[i]+" ");
        }
    }
    private static int count(int nums[],int si,int ei,int n){
        int res=0;
        for(int i=si;i<=ei;i++){
            if(nums[i]==n){
                res++;
            }
        }
        return res;
    }
    private static int majorityElementRec(int[] nums,int si,int ei) {
        if(si==ei){
            return nums[si];
        }
        int mid=(ei-si)/2;
        int l=majorityElementRec(nums,0,mid);
        int r=majorityElementRec(nums,mid+1,ei);
        if(l==r){
            return l;
        }
        else{
            if(count(nums,si,ei,l)>count(nums,si,ei,r)){
                return l;
            }
            else{
                return r;
            }
            
        } 
        
    }
    public static int majorityElement(int nums[]){
        return majorityElementRec(nums, 0, nums.length-1);
    }


    public static void main(String[]args){
        //String str[]={"sun","earth","mars","mercury"};
        int nums[]={2,2,0,0,0,2,2};
        int a=majorityElement(nums);
        System.out.println(a);
        //MS(str,0,str.length-1);
       // print(strr);
    }
    
}
