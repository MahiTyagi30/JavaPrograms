import java.util.*;
public class patterns {
    public  static void hollowRectangle(int rows,int col){
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=col;j++){
                if(i==1||i==rows||j==1||j=col){//checking boundary condition//==
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void invertedPyramid(int r){
        for(int i=1;i<=r;i++){
            for(int j=1;j<=r-i;j++){//loop to print spaces
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){//loop to print stars
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void invertedNumbers(int n){//12345
        for(int i=1;i<=n;i++){                //1234
            for(int j=1;j<=n-i+1;j++){        //123
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void floydTriangle(int n){//1
        int counter=1;                      //23
        for(int i=1;i<=n;i++){              //456
            for(int j=1;j<=i;j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println();
        }
    }
    public static void Triangle(int n){
        int sum;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                sum=i+j;
                if(sum%2==0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
    public static void Butterfly(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){//first print stars
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){//print space
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){//again print stars
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){//lower half
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void solidRhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");//spaces are printed
            }
            for(int j=1;j<=n;j++){//stars printed
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollowRhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
          for(int j=1;j<=n;j++){
            if(i==1||i==n||j==1||j==n){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }

          }
          System.out.println();

        }

    }
    public static void Diamond(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){//first space wiil be printed
               System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){//then star will be printed
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
               System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void numberPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void palindromePyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){//decreasing
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){//increasing
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
       // int r=sc.nextInt();
        //int c=sc.nextInt();
       // hollowRectangle(10,7);
       // invertedPyramid(4);
       // invertedNumbers(5);
     //floydTriangle(5);
        //Triangle(5);
       // Butterfly(16);
       //solidRhombus(5);
      // hollowRhombus(10);
       //Diamond(8);
      // numberPyramid(9);
      palindromePyramid(5);

    }
    
}

