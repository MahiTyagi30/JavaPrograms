
import java.util.*;
public class ArraysCC {
   
    public static int linearSearch(int marks[],int key){//O(N)
        for(int i=0;i<marks.length;i++){
            if(marks[i]==key){
                return i;
            }
        }
            return -1;       
    }
    public static void getLargest(int numbers[]){
        int largest=Integer.MIN_VALUE;//Initialising with - infinity (smallest)
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>largest){
                largest=numbers[i];
            }
        }
        System.out.println("the largest no. is "+largest);
    }
    public static int binarySearch(int numbers[],int key){//O(LOGN)
        int start=0;
        int end=numbers.length-1;
       while(start<=end){
        int mid=(start+end)/2;
        if(numbers[mid]==key){
            return mid;
        }
        else if(numbers[mid]>key){
            end=mid-1;
        }
        else if(numbers[mid]<key){
            start=mid+1;
        }
       }
         return -1;

    }
    public static void reverseArray(int numbers[]){//O(N)
        int first=0,last=numbers.length-1;
        while(first<last){
            int temp=numbers[last];
            numbers[last]=numbers[first];
            numbers[first]=temp;
            first++;
            last--;
        }
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
    }
    public static void printPairs(int numbers[]){//O(N^2)
        int tp=0;
        for(int i=0;i<numbers.length;i++){
            int curr=numbers[i];
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+curr+","+numbers[j]+")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("the total no. of pairs are "+tp);
    }
    public static void printSubarrays(int numbers[]){//O(N^3)
        int ts=0;
       //int sum=0;
       int largest=Integer.MIN_VALUE;
       int smallest=Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                int sum=0;//sum 0 should be intialised here only
                for(int k=start;k<=end;k++){//this loop is only for printing
                     sum=sum+numbers[k];
                     if(sum>largest){
                        largest=sum;
                     }
                     else if(sum<smallest){
                        smallest=sum;
                     }
                     System.out.print(numbers[k]+" ");
                }
                System.out.print("sum is "+sum);
                ts++;
                System.out.println();
            }
        }
        System.out.println(" total no. of subarrays are"+ts);
        System.out.println("the sum of largest subarray is "+largest);
        System.out.println("the smallest sum is "+smallest);
    }
    public static void maximumSumSubarray(int numbers[]){//error coming O(N^2)
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];
        prefix[0]=numbers[0];
        for(int i=1;i<numbers.length;i++){
            prefix[i]=prefix[i-1]+numbers[i];
        }
        for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                if(start==0){
                    sum=prefix[end];
                }
                sum=prefix[end]-prefix[start-1];
                if(sum>maxSum){
                    maxSum=sum;
                }
            }
        }
        System.out.println(",aximum sum is "+maxSum);
    }
    public static void kadanes(int numbers[]){//O(N)
        int cs=0;
        int c=0;
        int ms=Integer.MIN_VALUE;
        int minelement=Integer.MIN_VALUE;//-infinity
        for(int i=0;i<numbers.length;i++){//Checking if array contains all negative elements
            if(numbers[i]<0){
                c++;
            }
            if(numbers[i]>minelement){
                minelement=numbers[i];
            }
        }
        for(int i=0;i<numbers.length;i++){
            if(c==numbers.length){
                ms=minelement;
                break;
            }
            cs=cs+numbers[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(ms,cs);
        }
        System.out.println("the maximum  subarray sum is "+ms);

    }
    public static int trappedWater(int height[]){//O(N)
        int n=height.length;
        //calculate left max boundary array
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }
        //caculate right max boundary array
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        //loop run
        int trappedWater=0;
        for(int i=0;i<n;i++){
             //water level=min(left max-right max)
            int waterLevel=Math.min(leftMax[i],rightMax[i]);
             //trapped=water level-height[i];
    
            trappedWater += waterLevel-height[i];
        }
        return trappedWater;
       
       }
       public static int buysellStock(int prices[]){//prices given are basically selling price
        int buyPrice=Integer.MAX_VALUE;//+infinity
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
                int profit=prices[i]-buyPrice;//todat's profit
                maxProfit=Math.max(profit,maxProfit);
            }
            else{
                buyPrice=prices[i];//buying stock on lowest price
            }
        }
        return maxProfit;
       }
       public static boolean question1(int arr[]){
        int c=0;
        boolean tag=false;
        int n=arr.length;
       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(arr[i]==arr[j]){
               return true;
            }
        }
       }
          return false;
       }
      
    public static void main(String args[]){
        int numbers[]={-4,-2,-3,-1};
        int height[]={4,2,0,6,3,2,5};
        int prices[]={7,1,5,3,6,4};
        int arr[]={-1,0,1,2,-1,-4};
        Scanner sc =new Scanner(System.in);
       // kadanes(numbers);
      // System.out.println(buysellStock(prices));
      // boolean b=question1(arr);
       //System.out.println(b);
       
}
}
