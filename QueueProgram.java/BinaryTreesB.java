import java.util.*;
import java.util.LinkedList;
import java.util.logging.Level;
public class BinaryTreesB {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int  idx=-1;
        public Node buildTree(int node[]){
            idx++;
            if(node[idx]==-1){
                return null;
            }
            Node newNode  =new Node(node[idx]);
            newNode.left=buildTree(node);
            newNode.right=buildTree(node);
            return newNode;
        }
        public static void preorder(Node root){
            if(root==null){
                System.out.print("-1"+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if(root==null){
               // System.out.print("-1"+" ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
        public static void levelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node curr=q.remove();
                if(curr==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(curr.data+" ");
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }

            }
        }

    
    public static int heeight(Node root){
        if(root==null){
            return 0;
        }
        int lH=heeight(root.left);
        int rH=heeight(root.right);
        return lH+rH+1;
    }
    public static int diameter(Node root){//O(n^2)
        if(root==null){
            return 0;
        }
        int ldia=diameter(root.left);
        int lH=heeight(root.left);
        int rdia=diameter(root.right);
        int rH=heeight(root.right);
        int self=lH+rH+1;
        return Math.max(self,Math.max(ldia,rdia));
    }
    static class Info{
        int dia;
        int ht;
        public Info(int dia,int ht){
            this.dia=dia;
            this.ht=ht;
        }
    }
    public static Info diameter2(Node root){//O(n)
        if(root==null){
            return new Info(0,0);
        }
       
        Info leftInfo=diameter2(root.left);
        Info rightInfo =diameter2(root.right);
        int dia=Math.max(Math.max(leftInfo.dia,rightInfo.dia),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(dia,ht);

    }
    public static boolean isIdentical(Node node,Node subRoot){
        if(node==null&&subRoot==null){
            return true;
        }
        if(node==null||subRoot==null||node.data!=subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot)){
            return false;
        }
        if(!isIdentical(node.right, subRoot)){
            return false;
        }
        return true;

    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(root==null){
            return false;
        }

        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot)||isSubtree(root.right, subRoot);
    }
    static class Information{
        Node node;
        int hd;
        public Information(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){
        Queue<Information> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<Integer,Node>();
        int min=0;int max=0;
        q.add(new Information(root,0));
        q.add(null);
        while(!q.isEmpty()){
           Information curr=q.remove();
           if(curr==null){
           if(q.isEmpty()){
            break;
           }
           else{
            q.add(null);
           }
        }
        else{
        if(!map.containsKey(curr.hd)){//first time a node is occuring
            map.put(curr.hd,curr.node);
            
        }
        if(curr.node.left!=null){
            q.add(new Information(curr.node.left, curr.hd-1));
            min=Math.min(min,curr.hd-1);
        }
        if(curr.node.left!=null){
            q.add(new Information(curr.node.left, curr.hd+1));
            max=Math.max(max,curr.hd+1);
        }

        }
    }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }
   public static void kLevel(Node root,int level,int k){
    if(root==null){
        return;
    }
    if(level==k){
        System.out.print(root.data+" ");
        return;
    }
    kLevel(root.left, level+1, k);
    kLevel(root.right, level+1, k);

   }
   public static boolean getPath(Node root,int n,ArrayList<Node> path){
    if(root==null){
        return false;
    }
    path.add(root);
    if(root.data==n){
        return true;
    }
    boolean leftFound=getPath(root.left, n, path);
    boolean rightFound=getPath(root.right, n, path);
    if(leftFound==true||rightFound==true){
        return true;
    }
    path.remove(path.size()-1);
    return false;

   }
   public static Node lca(Node root,int n,int m){
    ArrayList<Node> path1=new ArrayList<>();
    ArrayList<Node>path2=new ArrayList<>();
    getPath(root,n,path1);
    getPath(root,m,path2);
    int i=0;
    for(;i<path1.size()&&i<path2.size();i++){
        if(path1.get(i)!=path2.get(i)){
            break;
        }
    }
    Node lca=path1.get(i-1);
    return lca;

   }
   public static Node ancestors(Node root,int n,int m){//O(n)
    if(root==null||root.data==n||root.data==m){
        return root;
    }
    Node leftLca=ancestors(root.left, n, m);
    Node rightLca=ancestors(root.right, n, m);
    //if rightLca is nulll
    if(rightLca==null){
        return leftLca;
    }
    //if leftLca is null
    if(leftLca==null){
        return rightLca;
    }
    return root;
   }
   public static int lcaDist(Node root,int n){
    if(root==null){
        return -1;
    }
    if(root.data==n){
        return 0;
    }
    int left=lcaDist(root.left, n);
    int right=lcaDist(root.right, n);
    if(left==-1&&right==-1){
        return -1;
    }
    else if(left==-1){
        return (right+1);
    }
    else{
        return (left+1);
    }
   
   }
   public static int minDistance(Node root,int n1,int n2){
    Node lca=ancestors(root, n1, n2);
    int dist1=lcaDist(lca,n1);
    int dist2=lcaDist(lca,n2);
    return dist1+dist2;
   }
   public static int kthAncest(Node root,int n,int k){
    if(root==null){
        return -1;
    }
    if(root.data==n){
        return 0;
    }
    int left=kthAncest(root.left, n, k);
    int right=kthAncest(root.right, n, k);
    if(left==-1&&right==-1){
        return -1;
    }
    int max=Math.max(left, right);
    if(max+1==k){
        System.out.println(root.data);
    }
    return max+1;
   }
   
   public static boolean univalued(Node root){
  if(root==null){
    return true;
  }
  if(root.left!=null&&root.data!=root.left.data){
    return false;
  }
  if(root.right!=null&&root.data!=root.right.data){
    return false;
  }
    return univalued(root.left)&&univalued(root.right);
   }
   public static void invertTree(Node root){
    if(root==null){
        return;
    }
    invertTree(root.left);
    invertTree(root.right);
    Node temp=root.left;
    root.left=root.right;
    root.right=temp;
   
   }
   public static Node deleteNode(Node root,int key){
    if(root==null) return null;
    root.left=deleteNode(root.left, key);
    root.right=deleteNode(root.right, key);
    if(root.data==key&&root.left==null&&root.right==null){
        return null;
    }
    return root;
   }
 // static  int maxSum=0;
   public static int maxSumPath(Node root ,int maxSum){
   // int sum=0;
   
    if(root==null){
        return 0;
    }
    int l=Math.max(0,maxSumPath(root.left,maxSum));
    int r=Math.max(0,maxSumPath(root.right,maxSum));
   
    maxSum=Math.max(maxSum,(root.data+l+r));


    return (root.data+Math.max(l, r));
   }
  


    public static void main(String[] args){
       // Res res=new Res();
    //     int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    //     BinaryTree tree=new BinaryTree();
    //   Node root=  tree.buildTree(nodes);
    //  // System.out.println(root);
     //tree.levelOrder(root);
    Node root=new Node(1);
    root.left=new Node(2);
    root.right=new Node(3);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    root.right.left=new Node(6);
    root.right.right=new Node(7);
    
    Node root1=new Node(-10);
    root1.left=new Node(9);
    root1.right=new Node(20);
    root1.right.left=new Node(15);
    root1.right.right=new Node(7);

    Node root2=new Node(-4);
    root.left=new Node(2);
    root.right=new Node(7);

    System.out.println(maxSumPath(root2,0));

   // System.out.println(univalued(root));
  // invertTree(root);
  // levelOrder(root);
//deleteNode(root, 7);
//System.out.println();
//levelOrder(root);

  
   // System.out.println(kthAncest(root, 5, 2));
  // System.out.print(ancestors(root, 4, 7).data);
  // System.out.println(minDistance(root, 4, 6));
 // kLevel(root,1,3);
    // Node subroot=new Node(2);
    // subroot.left=new Node(4);
    // subroot.right=new Node(5);
   // System.out.println(isSubtree(root, subroot));
    }
    
}
