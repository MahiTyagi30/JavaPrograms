import java.util.*;
public class prg {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter n");
        n = sc.nextInt();
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        if(n >= 3) {
            int first = (arr[0][1] + arr[0][2] - arr[1][2])/2;
            System.out.print(first + " ");
            for(int i = 1; i < n; i++)
            {
                System.out.print((arr[0][i] - first) + " ");
            }
        }
        
        

    }
}
