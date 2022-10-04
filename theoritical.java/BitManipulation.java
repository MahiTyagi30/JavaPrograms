import java.util.*;
public class BitManipulation {
    public static void EvenOdd(int n){
        int bitMask=1;
        if((n&bitMask)==0){
            System.out.println("no.is even");
        }
        else{
            System.out.println("no. is odd");
        }
    }
    public static int getBit(int n,int i){
        int bitMask=1<<i;
        if((n&bitMask)==0){
            return 0;
        }
        else{
            return 1;
        }
    } 
    public static int setBit(int n,int i){
        int bitMask=1<<i;
        return (n|bitMask);
    }
    public static int clearBit(int n,int i){
        int bitMask=~(1<<i);
        return n&bitMask;
    }
    public static int cleariBits(int n,int i){
        int bitMask=(-1)<<i;
        return n&bitMask;
    }
    public static int clearBitsinRange(int n,int i,int j){
        int a=((~0)<<j+1);
        int b=(1<<i)-1;
        int BitMask=a|b;
        return n&BitMask;
    }
    public static  boolean isPowerOfTwo(int n){
        return (n&(n-1))==0;
    }
    public static int countSetBits(int n){
        int count =0;
        while(n>0){
            if((n&(1<<0))!=0){//check LSB
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public static int FastExponention(int a,int b){
        int ans=1;
        while(b>0){
            if((b&1)!=0){//check LSB
                ans=ans*a;
            }
                a=a*a;
                b=b>>1;
        }
        return ans;
    }
    public static int adding1ToNumber(int n){
    int m=1;
    while((n&m)>=1){
        n=n^m;
        m=(m<<1);
    }
    n=n^m;
    return n;
}
    public static void ConvertCharacters(){
        for(char ch='A';ch<='Z';ch++){
            System.out.print((char)(ch|' '));
        }
    }
    
    public static void main(String[] args){
       // System.out.println(6>>1);
       // EvenOdd(10);
        //System.out.println(FastExponention(3,5));
        System.out.println(adding1ToNumber(9));
       // ConvertCharacters();
}
}
