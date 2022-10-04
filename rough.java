import java.util.*;

public class rough {
    public class Node {
        char data;
        Node next;

        Node(int data) {
            this.data = (char) data;
            this.next = null;
        }
    }

    public static boolean isQueenSafe(char[][] board, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void nqueens(char[][] board, int row) {
        if (row == board.length) {
            System.out.println("chess board");
            printBoard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isQueenSafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    public static boolean isSafe(int[][] sudoko, int row, int col, int digit) {
        for (int i = 0; i <= 8; i++) {
            if (sudoko[i][col] == digit) {
                return false;
            }
        }
        for (int i = 0; i <= 8; i++) {
            if (sudoko[row][i] == digit) {
                return false;
            }
        }
        int sr = row * 3 / 3;
        int sc = col * 3 / 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoko[i][j] == digit)
                    return false;
            }
        }
        return true;
    }

    public static boolean sudoko(int[][] sudoko, int row, int col) {
        if (row == 9 && col == 0) {
            return true;
        }
        int nextrow = row;
        int nextcol = col + 1;
        if (col + 1 == 9) {
            nextcol = 0;
            nextrow = row + 1;
        }
        if (sudoko[row][col] != 0) {
            sudoko(sudoko, nextrow, nextcol);
        }
        for (int i = 0; i <= 9; i++) {
            if (isSafe(sudoko, row, col, i)) {
                sudoko[row][col] = i;
                if (sudoko(sudoko, nextrow, nextcol)) {
                    return true;
                }
                sudoko[row][col] = 0;
            }
        }
        return false;
    }

    public static void pushAtBottom(int data) {
        Stack<Integer> s = new Stack<>();
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data);
        s.push(top);
    }

    public static String revString(String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            s.push(ch);
            i++;
        }
        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            res.append(s.pop());
        }
        return res.toString();

    }

    public static void stockspan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < stock.length; i++) {
            int curr = stock[i];
            while (!s.isEmpty() && curr >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static int[] nextGreater(int ar[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = ar.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && ar[s.peek()] < ar[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = ar[s.peek()];
            }
            s.push(i);
        }
        return nextGreater;
    }

    public static boolean isPalin(Node head) {
        Stack<Character> s = new Stack<>();
        Boolean ispalindrome = true;
        Node slow = head;
        while (slow != null) {
            s.push(slow.data);
            slow = slow.next;
        }
        while (head != null) {
            int i = s.pop();
            if (i == head.data) {
                ispalindrome = true;
            } else {
                ispalindrome = false;
                break;
            }
            head = head.next;
        }
        return ispalindrome;
    }

    public static String decodeString(String str) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        // int c=0;
        String res = "";
        int i = 0;
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                int c = 0;
                while (Character.isDigit(str.charAt(i))) {
                    c = c * 10 + str.charAt(i) - '0';
                    i++;
                }
                count.push(c);
            } else if (str.charAt(i) == ']') {
                result.push(res);
                res = " ";
                i++;
            } else if (str.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int c = count.pop();
                for (int j = 0; j < c; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            } else {
                res = res + str.charAt(i);
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Node x= new Node('A');
        // Node y=new Node('B');
        // Node z=new Node('C');
        // Node w=new Node('D');
        // x.next=y;
        // y.next=z;
        // z.next=w;
        // isPalin(x);
        System.out.println(decodeString("3[a]2[bc]"));

        // int n=4;
        // char[][] board=new char[n][n];
        // //initialize
        // for(int i=0;i<n;i++){
        // for(int j=0;j<n;j++){
        // board[i][j]='X';
        // }
        // nqueens(board, 0);

    }
}
