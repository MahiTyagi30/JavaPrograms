import java.util.*;
public class assingment {
    public static void count(int ar[][]){
        int c=0;
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar[0].length;j++){
                if(ar[i][j]==7){
                    c++;
                }
            }
        }
        System.out.println("the total no of 7's in array are "+c);
    }
    public static void sum(int ar[][]){
        int sum=0;
        for(int j=0;j<ar[0].length;j++){
            sum=sum+ar[1][j];
        }
        System.out.println("the sum of the 2nd row is "+sum);
    }
    public static void transpose(int ar[][]){
        int m=ar.length;
        int n=ar.length;
        int transpose[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               transpose[i][j]=ar[j][i];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void spiralMatrix(int ar[][]){
        int sr=0; 
        int er=ar.length-1;
        int sc=0;
        int ec=ar.length-1;
        while(sr<=er&&sc<=ec){
        //top
        for(int j=sc;j<=ec;j++){
            System.out.print(ar[0][j]+" ");
        }
        //left
        for(int i=sr+1;i<=er;i++){
            System.out.print(ar[i][ec]+" ");
        }
        //bottom
        for(int j=ec-1;j>=sc;j--){
            if(sr==er){
                break;
            }
            System.out.print(ar[er][j]+" ");
        }
        for(int i=er-1;i>=sr+1;i--){
            if(sc==ec){
                break;
            }
            System.out.print(ar[i][sc]+" ");
        }
        sc++;
        sr++;
        er--;
        ec--;
    }
    }
    public static void DiagnolSum(int ar[][]){
        int sum=0;
        for(int i=0;i<ar.length;i++){
            sum=sum+ar[i][i];
            if(i!=ar.length-1-i){
                sum=sum+ar[i][ar.length-1-i];
            }
        }
        System.out.println("the sum of two diagonals are "+sum);
    }
    public static void search(int ar[][],int key){
        int row=ar.length-1;
        int col=0;
        int flag=0;
        while(row>=0&&col<ar.length){
            if(ar[row][col]==key){
                flag=1;
                System.out.print("key found at ("+row+","+col+")");
                break;
            }
            else if(key<ar[row][col]){
                row--;
            }
            else if(key>ar[row][col]){
                col++;
            }
        }
        if(flag==0){
        System.out.println("key has not been found ");
    }
}
public static void vowelCount(String str){
    int c=0;
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            c++;
        }
    }
    System.out.println("the total no.of vowels are "+c);
}
public static void anagramSting(String str1,String str2){
    
   if(str1.length()==str2.length()){
    char[] a1=str1.toCharArray();
    char[] a2=str2.toCharArray();
    Arrays.sort(a1);
    Arrays.sort(a2);
    boolean r=Arrays.equals(a1, a2);
    if(r){
        System.out.println("anagram strings");
    }
    else{
        System.out.println("not anagram strings");
    }

   }
   else{
    System.out.println("not anagram strings");
   }
    
}

    public static void main(String[] args){
        int ar1[][]={{1,4,9},
                    {11,4,3},
                     {2,2,3}};
                     int ar[][]={{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                         {32,33,39,50}};
                         String str1="haie";
                         String str2="race";
                         anagramSting(str1, str2);
                    
                    
    }
    
}
