import java.util.*;
class LinearSearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.println("Enter length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element to be searched: ");
        int ele = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == ele) {
            System.out.println("Element found"); 
            flag = true;
            }
        }
        if(!flag)
        System.out.println("Element not found");
        
    }
}