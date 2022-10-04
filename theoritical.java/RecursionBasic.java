public class RecursionBasic {
    public static void printNumbers(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        printNumbers(n-1);
    }
    public static void printInc(int n){
        if(n==1){
            System.out.print(n+" ");
            return ;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }
    public static int Factorial(int n){
        if(n==0){
            return 1;
        }
       int f=Factorial(n-1);
       int fact=n*f;
       return fact;

    }
    public static int printSum(int n){//time compl and space=O(N)
        if(n==1){
            return 1;
        }
        int s=printSum(n-1);
        int sum=n+s;
        return sum;
    }
    public static int Fibonacci(int n){
        if(n==0||n==1){
            return n;
        }
        int fnm1=Fibonacci(n-1);
        int fnm2=Fibonacci(n-2);
        int fn=fnm1+fnm2;
        return fn;
    }
    public static boolean isSorted(int ar[],int i){
        if(i==ar.length-1){
            return true;
        }
        if(ar[i]>ar[i+1]){
            return false;
        }
        return isSorted(ar, i+1);
    }
    public static int firstOccurence(int ar[],int key,int i){
        if(i==ar.length){
            return -1;
        }
        if(ar[i]==key){
            return i;
        }
        return firstOccurence(ar, key, i+1);
    }
    public static int lastOccurence(int ar[],int key,int i){
        if(i==ar.length){return -1;}
        int isFound=lastOccurence(ar, key,i+1);
        if(isFound==-1&&ar[i]==key){
            return i;
        }
        return isFound;
    }
    public static int powerOfX(int x,int n){
        if(n==0){
            return 1;
        }
        int p=powerOfX(x, n/2);//to reduce one extra function call
        int halfPowsq=p*p;
        if(n%2!=0){
        halfPowsq=x*halfPowsq;
        }
        return halfPowsq;
        // int xnm1=powerOfX(x, n-1);
        // int xn=x*xnm1;
        // return xn;
    }
    public static int TillingProblem(int n){//size of floor is 2xn
        //base case
        if(n==1||n==0){
            return 1;
        }
        //kaam
        //vetical choice
        int fnm1=TillingProblem(n-1);
        //horizontal choice
        int fnm2=TillingProblem(n-2);
        int total =fnm1+fnm2;
        return total;
    }
    public static void removeDuplicate(String str,int idx,StringBuilder sb,boolean[] map){
        //base
        if(idx==str.length()){
            System.out.println(sb);
            return;
        }
        //kaam
        char currchar=str.charAt(idx);
        if(map[currchar-'a'] == true){
            //duplicate
            removeDuplicate(str, idx+1, sb, map);
        }
        else{
            map[currchar-'a']=true;
            removeDuplicate(str, idx+1, sb.append(currchar), map);
        }
    }
    public static int friendsPair(int n){
        if(n==1||n==2){
            return n;
        }
        //choice
        //single
        int fnm1=friendsPair(n-1);
        //pair
        int fnm2=friendsPair(n-2);
        int pairway=fnm2*(n-1);
        int totalways=fnm1+pairway;
        return totalways;
        }
        public static void printBinaryString(int n,int lastIndex,String sb){
            if(n==0){
                System.out.println(sb);
                return;
            }
            if(lastIndex==0){
                printBinaryString(n-1, 0, sb+"0");
                printBinaryString(n-1, 1 , sb+"1");
            }
            else{
                printBinaryString(n-1  , 0, sb+"0");
            }
        }
        public static void OccurrenceIndices(int ar[],int key,int i){
            if(i==ar.length){
                return;
            }
            if(ar[i]==key){
                System.out.print(i+" ");
            }
                OccurrenceIndices(ar, key, i+1);
        }
        public static void DigitsToString(int n){
            String sb[]={"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
            if(n==0){
                return;
            }
            int last=n%10;
            DigitsToString(n/10);//this will first keep call function till it reach base condition
            System.out.println(sb[last]+" ");
           
        }
        public static int SubstringCount(int s,int e,String str ,int n){
            if(n==1){
                return 1;
            }
            if(n<=0){
                return 0;
            }
            int res=SubstringCount(s+1, e, str, n-1)+SubstringCount(s, e-1, str, n-1)-SubstringCount(s+1, e-1, str, n-2);
            if(str.charAt(e)==str.charAt(s)){
                res++;
            }
            return res;
           
        }
        public static void towerOfHanoi(int n,String src,String helper,String Dest){
            if(n==1){
                System.out.println("transfer disk"+n+"from"+src+"to"+Dest);
                return;
            }
            towerOfHanoi(n-1, src, Dest, helper);
            System.out.println("transfer disk"+n+"from"+src+"to"+Dest);
            towerOfHanoi(n-1, helper, src, Dest);
        }
    public static void main(String[] args){
        String str="abc";
        int n=str.length();;
        int ar[]={3,2,4,5,6,2,7,2,2};
        towerOfHanoi(2,"S","H","D");
        //String str="appnacollege";
        //System.out.println(SubstringCount(0, n-1,str,n));
       // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
       //DigitsToString(124);
       //OccurrenceIndices(ar, 2, 0);
    //System.out.println(friendsPair(3));
   // printBinaryString(3,1, " ");
        //System.out.println(TillingProblem(4));
        //System.out.println(isSorted(ar, 0));
       // System.out.println(lastOccurence(ar, 5, 0));
       // System.out.println(powerOfX(2, 10));
        //printNumbers(n);
       // printInc(10);
      //System.out.println(Factorial(n));
      //System.out.println(printSum(n));
      //System.out.println(Fibonacci(n));
    }
    
}
