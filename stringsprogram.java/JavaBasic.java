import java.util.*;
public class JavaBasic{
  public static int Factorial(int n){//formal parameters
    int fact=1;
    for(int i=1;i<=n;i++){
      fact=fact*i;
    }
    return fact;
  }
  public static int binomialCalculate(int n,int r){
    int a=Factorial(n);
    int b=Factorial(r);
    int c=Factorial(n-r);
    int cal=a/(b*c);
    return cal;
  }
  public static int sum(int a,int b){
    return a+b;
  }
  public static int sum(int a,int b,int c){
    return a+b+c;
  }
  public static boolean isPrime(int a){
    if(a==2){
      return true;
    }
    boolean isPrime=true;
    for(int i=2;i<=Math.sqrt(a);i++){//optimized approach
      if(a%i==0){
        isPrime=false;
        break;
      }
    }
      return isPrime;
  }
  public  static void primeinRange(int n){
    for(int i=2;i<=n;i++){
      if(isPrime(i)){
        System.out.println(i+" ");
      }
    }
    System.out.println();
  }
  public static void binTodec(int n){
    int f=n;
    int pow=0;
    int dec=0;
    while(n>0){
      int lastdigit=n%10;
      dec=dec+(lastdigit*(int)Math.pow(2,pow));
      pow++;
      n=n/10;
    }
    System.out.println("the decimal ois"+dec);
  }
  public static void decTobin(int n){
    int f=n;
    int pow=0;
    int bin=0;
    while(n>0){
      int rem=n%2;
      bin=bin+(rem*(int)Math.pow(10,pow));
       pow++;
       n=n/10;
    }
    System.out.println(bin);
  }
  public static float average(int a,int b,int c){
    float avg=(a+b+c)/3;
    return avg;
  }
  public static boolean isEven(int n){
    if(n%2==0){
      return true;
    }
    return false;
  }
 
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      //isPalindrome(n);
        
        }
      }
    
        
