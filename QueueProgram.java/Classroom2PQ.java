import java.util.*;
public class Classroom2PQ {
     static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;
        public Point(int x,int y,int distSq,int idx){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.idx=idx;
        }
        @Override
        public int compareTo(Point p2) {
            return this.distSq-p2.distSq;
        }
     }

     static class pair implements Comparable<pair>{
        int val;int idx;
        public pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(pair p2){
            return p2.val-this.val;
        }
     }

     public static void main(String[] args){
        int pts[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        PriorityQueue<Point> pq=new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int distSq=pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0],pts[i][1],distSq,i));

        }
        //k nearest
        for(int i=0;i<k;i++){
            System.out.print("c"+pq.remove().idx+" ");
        }
        System.out.println();
   int ropes[]={2,3,3,4,6};
  PriorityQueue<Integer> p=new PriorityQueue<>();
  for(int i=0;i<ropes.length;i++){
    p.add(ropes[i]);
  }
  int cost=0;
  while(p.size()>1){
    int min=p.remove();
    int min2=p.remove();
    cost=min+min2;
    p.add(min+min2);
  }
  System.out.println(" the minimum costis"+cost);
  System.out.println();

  int a[]={1,3,-1,-3,5,3,6,7};
  int ke=3;
  int r[]=new int[a.length-ke+1];
  PriorityQueue<pair> pQ=new PriorityQueue<>();
  for(int i=0;i<ke;i++){
    pQ.add(new pair(a[i],i));
  }
  r[0]=pQ.peek().val;
  for(int i=k;i<a.length;i++){
    while(pQ.size()>0&&pQ.peek().idx<=(i-k)){
        pQ.remove();
    }
    pQ.add(new pair(a[i],i));
    r[i-k+1]=pQ.peek().val;
  }

  //print 
  System.out.println("the resulting array is");
  for(int i=0;i<r.length;i++){
    System.out.print(r[i]+" ");
  }


     }
}
