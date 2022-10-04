import java.util.*;

public class arraylist {
    public static void reverse(ArrayList<Integer> list){//O(n)
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    public static void maxElement(ArrayList<Integer> list){//O(n)
        int max=Integer.MIN_VALUE;
        for(int i=list.size()-1;i>=0;i--){
            max=Math.max(max,list.get(i));
        }
        System.out.println("the max. element is = "+max);
    }

    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public static int storeWater(ArrayList<Integer> height){
        int maxW=0;

        int lp=0;int rp=height.size()-1;
        while(lp<rp){
            int h=Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int water=h*width;
            maxW=Math.max(maxW, water);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        // for(int i=0;i<height.size();i++){
        //     for(int j=i+1;j<height.size();j++){
        //         int h=Math.min(height.get(i),height.get(j));
        //         int width=j-i;
        //         int water=width*h;
        //         maxW=Math.max(maxW, water);
        //     }
        // }
        return maxW;
    }
    public static boolean pairSum(ArrayList<Integer> list,int tar){
        int lp=0;
        int rp=list.size()-1;
        while(lp<rp){
            int sum=list.get(lp)+list.get(rp);
            if(sum==tar){
                return true;
            }
            else if(sum<tar){
                lp++;
            }
            else if(sum>tar){
                rp--;
            }
        }
        return false;
    }
    public static boolean pairSum1(ArrayList<Integer> list, int tar){
        //find out the breaking point
        int bp=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp=bp+1;int rp=bp;
        int n=list.size();
        while(lp!=rp){
            int sum=list.get(lp)+list.get(rp);
            if(sum==tar){
                return true;
            }
            else if(sum<tar){
                lp=(lp+1)%n;;
            }
            else if(sum>tar){
                rp=(rp=n-1)%n;
            }

        }
        return false;
    }
    public static ArrayList<Integer>  aloneNumber(ArrayList<Integer> a){
        ArrayList<Integer> c=new ArrayList<>();
        int count=0;
        Collections.sort(a);
        if(a.size()==1){
            c.add(a.get(0));
        }
        if(a.size()>1){
            if(a.get(0)+1<a.get(1)){
                c.add(a.get(0));
            }
            if(a.get(a.size()-2)+1<a.get(a.size()-1)){
                c.add(a.get(a.size()-1));

            }
        }
       
        for(int i=1;i<a.size()-1;i++){
            if(a.get(i-1)+1<a.get(i)&&a.get(i)+1<a.get(i+1)){
                c.add(a.get(i));
            }
        }
       
        return c;
    }
   public static boolean monotone(ArrayList<Integer> ll){
     boolean inc=true;boolean dec=true;     
     for(int i=0;i<ll.size()-1;i++){
        if(ll.get(i)>ll.get(i+1)){
             inc=false;
         }
         else if(ll.get(i)<ll.get(i+1)){
          dec=false;
         }
     }
    return inc||dec;
   }
   public static int maxOccurrence(ArrayList<Integer> l,int k){
    int c=0;int tar=-1;int c2=0;
    for(int i=0;i<l.size();i++){
        for(int j=0;j<l.size();j++){
            if(l.get(i)==l.get(j)){
                c++;
        }
        if(c>l.get(2)){
            tar=l.get(i);
        }
    }
}
    return tar;

}

    public static void main(String[] args){
       ArrayList<Integer> l=new ArrayList<>();
       l.add(2);
       l.add(2);
       l.add(2);
       l.add(2);
       l.add(3);
       System.out.println(maxOccurrence(l, 2));
    }
    
}