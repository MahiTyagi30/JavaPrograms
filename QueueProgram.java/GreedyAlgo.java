import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GreedyAlgo {

public static int activitySelection(int start[],int e[]){
    ArrayList<Integer> a=new ArrayList<>();
    int max=1;
    a.add(0);
    int lastAct=e[0];
    for(int i=1;i<e.length;i++){
        if(lastAct<=start[i]){
            max++;
            a.add(i);
            lastAct=e[i];
        }
    }
    return max;

}
public static int minDifference(int A[],int B[]){
    Arrays.sort(A);
    Arrays.sort(B);
    int mindiff=0;

    for(int i=0;i<A.length;i++){
        mindiff=mindiff+Math.abs(A[i]-B[i]);
        
    }
    return mindiff;
}
public static int fractionalKnapsack(int val[],int weight[],int capacity){
    double ratio[][]=new double[val.length][2];
    //0th col for index and 1st col. for ratio
    for(int i=0;i<val.length;i++){
        ratio[i][0]=i;
        ratio[i][1]=val[i]/(double)weight[i];
    }
    //ascendind order
    Arrays.sort(ratio,Comparator.comparingDouble(o ->o[1]));
    int finalVal=0;
    for(int i=ratio.length-1;i>=0;i--){
        int idx=(int)ratio[i][0];
        if(capacity>=weight[idx]){
            finalVal=finalVal+val[idx];
            capacity=capacity-weight[idx];

        }
        else{
            finalVal=(int) (finalVal+(capacity*ratio[i][1]));
            capacity=0;
            break;
        }
    }
    return finalVal;
}public static void chainLength(int pair[][]){
    Arrays.sort(pair,Comparator.comparingDouble(o->o[1]));
    int chainCount=1;
    int chainEnd=pair[0][1];
    for(int i=0;i<pair.length;i++){
        if(pair[i][0]>chainEnd){
            chainCount++;
            chainEnd=pair[i][1];
        }
    }
    System.out.println("max length of chain"+chainCount);
}
public static void indianCoin(Integer coins[]){
    Arrays.sort(coins,Comparator.reverseOrder());
    int countCoins=0;
    int amount=590;
    for(int i=0;i<coins.length;i++){
        if(coins[i]<amount){
            while(coins[i]<amount){
                countCoins++;
                amount=amount-coins[i];
            }
        }
    }
    System.out.println("the total no.of coins"+countCoins);
}
static class Jobs{
    int deadline;
    int profit;
    int id;
    public Jobs(int i,int d,int p){
        id=i;
        deadline=d;
        profit=p;
    }
}
public static void chocoLaProblem(Integer[] costhor,Integer[] costver){
    Arrays.sort(costver,Collections.reverseOrder());
    Arrays.sort(costhor,Collections.reverseOrder());
    int h=0;int v=0;
    int hp=1;int vp=1;
    int cost=0;
    while(h<costhor.length&&v<costver.length){
        if(costhor[h]<costver[v]){
            cost=cost+(costver[v]*hp);
            v++;
            vp++;
        }
        else{
            cost=cost+(costhor[v]*vp);
            h++;
            hp++;

        }
    }
    while(h<costhor.length){
        cost=cost+(costhor[h]*vp);
        h++;
        hp++;
    }
    while(v<costver.length){
        cost=cost+(costhor[v]*hp);
        v++;
        vp++;
    }
    System.out.println("the total minimum cost is "+cost);

}
public static void kthMaxElement(int l,int r,int k){
    int s=r-l+1;
    int largest=0;
    Integer ar[]=new Integer[s];
    for(int j=0;j<ar.length;j++){
        if(l<=r){
        ar[j]=l;
        l++;
        }
    }
    Arrays.sort(ar,Collections.reverseOrder());
    for(int i=0;i<s;i++){
        k--;
        if(k==0){
            largest=ar[i];
            break;
        }
    }
    System.out.println("the kth largest element is "+largest);
}
public static void maxSubarrays(int ar[],int p){
     int c=0;
    for(int i=0;i<ar.length;i++){
        int s=i;
        
        for(int j=i;j<ar.length;j++){
            int e=j;
            int sum=0;
            for(int k=s;k<=e;k++){
                sum=sum+ar[k];
            }
            if(sum<=p){
                c++;
            }
        }
    }
    System.out.println("max. no. of subarrays are "+c );
}
public static int balancedString(String str){
    int l=0;int r=0;
    int res=0;
    for(int i=0;i<str.length();i++){
        if(str.charAt(i)=='R'){
            r++;
        }
        else if(str.charAt(i)=='L'){
            l++;
        }
        if(l==r){
            res++;
        }
    }
    return res;
}
    public static void main(String[] args){
        // int start[]={1,3,0,5,8,5};
        // int end[]={2,4,6,7,9,9};
        // System.out.println(activitySelection(start, end));
        // int val[]={60,100,120};
        // int weight[]={10,20,30};
        //System.out.println(fractionalKnapsack(val, weight, 50));
        // int pair[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        // chainLength(pair);
      System.out.println(balancedString("LLRRRLLRRL"));
       //kthMaxElement(1, 6, 3);
        // int n=4;int m=6;
        // Integer costver[]={2,1,3,1,4};
        // Integer costhor[]={4,1,2};
        // chocoLaProblem(costhor, costver);
        // Integer coins[]={1,2,5,10,20,50,100,500,2000};
        // indianCoin(coins);
    //     int A[]={4,1,8,7};
    //     int B[]={2,1,6,5};
    //    System.out.println(minDifference(A, B));
        //  int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        //  ArrayList<Jobs> job=new ArrayList<>();
        //  for(int i=0;i<jobInfo.length;i++){
        //     job.add(new Jobs(i, jobInfo[i][0], jobInfo[i][1]));
        //     Collections.sort(job,(obj1,obj2)->obj2.profit-obj1.profit);

        //  }
    
}
}
