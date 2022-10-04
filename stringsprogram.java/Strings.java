import java.util.*;
public class Strings {
    public static void printchar(String s){
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            System.out.print(ch+" ");
        }
    }
    public static boolean isPlindrome(String s){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public static float getShortestpath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);
            if(dir=='E'){
                x++;
            }
            else if(dir=='W'){
                x--;
            }
            else if(dir=='N'){
                y++;
            }
            else if(dir=='S'){
                y--;
            }

        }
        int X2=x*x;
        int Y2=y*y;
        float d=(float)Math.sqrt(X2+Y2);
        return d;

    }
    public static String substring(String str,int si,int ei){
        String s=" ";
        for(int i=si;i<ei;i++){
            s=s+str.charAt(i);
        }
        return s;
    }
    public static String toUpperCase(String str){
        StringBuilder sb=new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==' '&&i<str.length()-1){
                sb.append(ch);
                i++;
                char ch2=str.charAt(i);
                sb.append(Character.toUpperCase(ch2));
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static String compressedString(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            //char ch=str.charAt(i);
            Integer count=1;
            while(i<str.length()-1 &&str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
      String str="abcd";
      System.out.println(compressedString(str));
}
}
