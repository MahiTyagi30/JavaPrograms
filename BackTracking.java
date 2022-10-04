public class BackTracking {


    public static void permutations(String str,String ans){//O(N*N!)
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newString=str.substring(0,i)+str.substring(i+1);//remove character from original strings
            permutations(newString, ans+curr);
        }

    }


    //NO.OF SUBSET QUESTION
    public static void findsubSets(String str,String ans,int i){//O(N*2^N)
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        //recursion
        //yes choice
        findsubSets(str, ans+str.charAt(i), i+1);
        //no choice
        findsubSets(str, ans, i+1);
    }



    public static void changeArray(int ar[],int i,int val){
        if(i==ar.length){
            print(ar);//array without backtracking step will be printed
            return;
        }
        ar[i]=val;
        changeArray(ar, i+1, val+1);
        ar[i]=ar[i]-1;//backtracking step
    }
    public static void print(int ar[]){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }

      //N-QUEENS QUESTION
    public static boolean isSafe(char board[][],int row,int col){
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonal left up
        for(int i=row-1, j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diagonal right up
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }

        }
        return true;
    }
    public static void nQueens(char board[][],int row){
        //int c=0;
        if(row==board.length){
            System.out.println("chess board");
            c++;
            printBoard(board);
            return;
        }

        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
            board[row][j]='Q';
            nQueens(board, row+1);//recursion
            board[row][j]='.';//backtracking step  to again empty the board for next solutions
            }
        }
    }
    public static void printBoard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int c=0;



//GRID WAYS QUESTIONS
    public static int gridWays(int i,int j,int n,int m){
        if(i==n-1&&j==m-1){
            return 1;
        }
        else if(i==n||j==m){
            return 0;
        }
        int w1=gridWays(i+1, j, n, m);
        int w2=gridWays(i, j+1, n, m);
        return w1+w2;
    }


    //KEYPAD COMBINATION QUESTION
    static String str[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void keypadCombo(String digit,String ans,String str[]){
      
        if(digit.length()==0){
            System.out.println(ans);
           return;
        }
        //int j=0;
        char ch=digit.charAt(0);
        String substr=digit.substring(0);
        String s=str[ch-'0'];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            keypadCombo(substr, ans+c,str);
        }

    }


    //RAT RACE QUESTION
    public static boolean isSafeToGo(int mat[][],int i,int j,int n){
        if(mat[i][j]==0){
            return false;
        }
        return true;
    }
    static int count=0;
    public static void ratRace(int mat[][],int i,int j,int n,String path){
        if(i==n-1&&j==n-1){
            System.out.println(path);
            count++;
            return;
        }
         if(i==n||j==n){
            return;
        }
        if(isSafeToGo(mat,i,j,n)){
            ratRace(mat, i+1, j, n,path+"V");
            ratRace(mat, i, j+1, n,path+"H");
    }
   
    }

//SUDOKO SOLVER QUESTION

    public static boolean isSafeSudoko(int[][] sudoko,int row,int col,int digit){
        //column check
        for(int i=0;i<=8;i++){
            if(sudoko[i][col]==digit){
                return false;
            }
        }
        //row check
        for(int j=0;j<=8;j++){
            if(sudoko[row][j]==digit){
                return false;
            }
        }
        //small grid check
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<(sr+3);i++){
            for(int j=sc;j<(sc+3);j++){
                if(sudoko[i][j]==digit){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean sudokoSolver(int sudoko[][],int row ,int col){
        if(row==9&&col==0){
            return true;
        }
    //    else if(row==9){
    //     return false;
    //    }

        int nextRow=row;int nextcol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextcol=0;
        }
        if(sudoko[row][col]!=0){
            return sudokoSolver(sudoko, nextRow, nextcol);
        }
        for(int i=0;i<=9;i++){
            if(isSafeSudoko(sudoko,row,col,i)){
                sudoko[row][col]=i;
                if(sudokoSolver(sudoko,nextRow,nextcol)){
                    return true;
                }
                sudoko[row][col]=0;//Backtracking
            }
        }
        return false;
    }


    //KNIGHT'S TOUR QUESTION
    static int a=0;
    public static void KnightsTour(int[][] chess,int i,int j,int move,int n){
        if(i<0||j<0||i>=n||j>=n||chess[i][j]>0){
            return;
        }
        if(move==chess.length*chess.length){
            a++;
            System.out.println("display");
            chess[i][j]=move;
            displayBoard(chess);
            chess[i][j]=0;
        }
        chess[i][j]=move;
        KnightsTour(chess, i-2, j+1, move+1, n);
        KnightsTour(chess, i-1, j+2, move+1, n);
        KnightsTour(chess, i+1, j+2, move+1, n);
        KnightsTour(chess, i+2, j+1, move+1, n);
        KnightsTour(chess, i+2, j-1, move+1, n);
        KnightsTour(chess, i+1, j-2, move+1, n);
        KnightsTour(chess, i-1, j-2, move+1, n);
        KnightsTour(chess, i-2, j-1, move+1, n);
       chess[i][j]=0;
        

    }
    public static void displayBoard(int[][] chess){
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }




    public static void main(String[] agrs){
       // int[] ar=new int[5];
      // findsubSets("abc", "", 0);
      //permutations("abc", "");
      int n=4;
      char[][] board=new char[n][n];
      //initialize
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j]='.';
        }
      }
      int ar[][]={{1,1,1,1},
                  {0,1,0,1},
                {1,1,1,1},
                {1,0,1,1}};
                int chess[][]=new int[5][5];
      //nQueens(board,0);
     // System.out.println("total ways to arrange n queens = "+c);
    // System.out.println(gridWays(0, 0, 3, 3));
  // keypadCombo("23", "",str);
  //ratRace(ar, 0, 0, 4,"");
  //System.out.println("total no.of ways are "+count);
  KnightsTour(chess, 2 ,2, 1, 5);
  displayBoard(chess);
  System.out.println("no.of solution= "+a);

    }
    
}