import java.util.*;
public class Matrices {
    public static boolean search(int matrix[][],int key){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    System.out.println("the no. fount at ("+i+","+j+")");
                    return true;
                }
            }
        }
        return false;
    }
    public static void spiralMatrix(int matrix[][]){
        int startRow=0;
        int endRow=matrix.length-1;
        int startCol=0;
        int endCol=matrix.length-1;
        while(startRow<=endRow&& startCol<=endCol){
            //top
            for(int j=startCol;j<=endCol;j++){//
                System.out.print(matrix[startRow][j]+" ");
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol]+" ");
            }
            //bottom
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow==endRow){//special condition
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }
    public static void DiagnolSum(int matrix[][]){
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            //PD
            sum=sum+matrix[i][i];
            //SD
            if(i!=matrix.length-1-i){//to avoid overlapping element in odd n array
            sum=sum +matrix[i][matrix.length-1-i];
            }
        }
        System.out.println(" the sum is"+sum);
       
    }
    public static boolean stairCase(int matrix[][],int key){
        int row=0,col=matrix.length-1;
        while(row<matrix.length&&col>=0){
            if(matrix[row][col]==key){
                System.out.println("key fount at ("+row+","+col+")");
                return true;
            }
           else if(key<matrix[row][col]){
                col--;
            }
            else if(key>matrix[row][col]){
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args){
        int matrix[][]={{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                         {32,33,39,50}};
        stairCase(matrix,33);
       
        }
       
       
    
}
