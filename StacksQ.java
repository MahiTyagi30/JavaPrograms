import java.util.*;

public class StacksQ {

  public static void pustAtBottom(Stack<Integer> s, int data) {
    if (s.isEmpty()) {
      s.push(data);
      return;
    }
    int top = s.pop();
    pustAtBottom(s, data);
    s.push(top);
  }

  public static String reverseString(String str) {
    Stack<Character> s = new Stack<>();
    int i = 0;
    while (i < str.length()) {
      s.push(str.charAt(i));
      i++;
    }
    StringBuilder result = new StringBuilder("");
    while (!s.isEmpty()) {
      result.append(s.pop());
    }
    return result.toString();

  }

  public static void reverseStack(Stack<Integer> s) {
    if (s.isEmpty()) {
      return;
    }
    int top = s.pop();
    reverseStack(s);
    pustAtBottom(s, top);
  }

  public static void print(Stack<Integer> s) {
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }

  public static void stockSpan(int stock[], int span[]) {
    Stack<Integer> s = new Stack<>();
    span[0] = 1;
    s.push(0);
    for (int i = 1; i < stock.length; i++) {
      int cur = stock[i];
      while (!s.isEmpty() && cur > stock[s.peek()]) {
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

  public static void nextGreaterElement(int arr[], int nextGreater[]) {
    Stack<Integer> s = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
        s.pop();
      }

      if (s.isEmpty()) {
        nextGreater[i] = -1;
      } else {
        nextGreater[i] = arr[s.peek()];
      }
      s.push(i);
    }
  }

  public static Boolean isValid(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(' || ch == '{' || ch == '[') {//opening brackets are inserted in stack
        s.push(ch);
      } else {
        if (s.isEmpty()) {
          return false;
        }
        if ((s.peek() == '(' && ch == ')') || (s.peek() == '[' && ch == ']') || (s.peek() == '{' && ch == '}')) {
          s.pop();//closing brackets are checked
        } else {
          return false;
        }
      }
    }
    if (s.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  public static Boolean validParenthesis(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == ')') {
        int c = 0;
        s.pop();
        c++;
        while (s.peek() != ')') {

        }
        if (c < 1) {
          return true;// duplicate exist
        } else {
          s.pop();// pop the matching
        }
      } else {
        s.push(ch);// push opening bracket or operand
      }
    }

    return false;

  }
  
  


  public static void main(String[] args) {
    // int stocks[]={100,80,60,70,60,85,100};
    // int span[]=new int[stocks.length];
    // stockSpan(stocks, span);
    int arr[] = { 2, 4, 1, 9, 5 };
    int nextGreater[] = new int[arr.length];
    nextGreaterElement(arr, nextGreater);
    for (int i = 0; i < nextGreater.length; i++) {
      System.out.print(nextGreater[i] + " ");
    }
    System.out.println(isValid("({[]})"));
    String str = "((a+b))";
    System.out.println(validParenthesis("((a+b))"));

  }

}
