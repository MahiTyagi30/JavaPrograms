
public class OOPS {

    public static void main(String[] args){
        Students s1=new Students();
        s1.school="IIEMS";
        Students s2=new Students();
        System.out.println(s2.school);
        // Horse h =new Horse();
        // h.eat();
        // h.walking();
        // System.out.println(h.color);
        // Chicken c=new Chicken();
        // c.eat();
        // c.walking();
      //  Deer d=new Deer();
        //d.eat();
        // Calculator cal=new Calculator();
        // System.out.println(cal.sum(1,2));
        // System.out.println(cal.sum((float)1.5,(float)2.5));
        // System.out.println(cal.sum(1,2,3));
        // Dogs dobby=new Dogs();
        // dobby.eat();
        // dobby.legs=4;
        // System.out.println(dobby.legs);

        //Fish shark=new Fish();
       // shark.eat();

       // Pen P1=new Pen();
        //P1.setColor("red");
       // System.out.println(P1.getColor());
    //    Student s1=new Student();
    //    s1.name="Mahi";
    //    s1.roll=23;
    //    s1.psaaword="abcd";
    //    s1.marks[0]=100;
    //    s1.marks[1]=80;
    //    s1.marks[2]=60;
    //    Student s2=new Student(s1);
    //    s2.psaaword="xyz";
    //    s1.marks[0]=12;
    //    for(int i=0;i<3;i++){
    //     System.out.println(s2.marks[i]);
    //    }
       
    }  
}
//static keyword
class Students{
    int rollno;
    String name;
    static String school;
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }

}
//Interface
interface chessPlayer{
    void moves();
}
class Queens implements chessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal");
    }
}
class Rook implements chessPlayer{
    public void move(){
    System.out.println("up ,down,left,right");
    }

    @Override
    public void moves() {
        // TODO Auto-generated method stub
        
    }
}
class pawn implements chessPlayer{
    public void move(){
    System.out.println("up ,down,left,right");
    }

    @Override
    public void moves() {
        // TODO Auto-generated method stub
        
    }
}


//Abstraction
abstract class Animall{//abstract class can have both abs. and non abs. functions
    String color;
    Animall(){//can have contructor
         color="brown";
    }
    void eat(){
        System.out.println("eats");
    }
    abstract void walking();//here we did not give the implementation
}
class Horse extends Animall{//now we have to implement walking funtion in this sub class
    public String color;
    void changeColor(){
         color = "dark brown";
    }
    void walking(){
        System.out.println("horse walks on 4 feets");
    }
}
class Chicken extends Animall{
    void changeColor(){
       color=" black";
    }
    void walking(){
        System.out.println(" walks on 2 legs");
    }
}
//function overriding
class Animals{
    void eat(){
        System.out.println("eats");
    }
} 
class Deer extends Animals{
    void eat(){
        System.out.println("eats grass");
    }
}

class Student{
    String name;
    int roll;
    String psaaword;
    int marks[];
    //shallow constructor
    //Student(Student s1){//copy constructor
      //  this.name=s1.name;
        //this.roll=s1.roll;
        //this.marks=s1.marks;
    //}
    //deep constructor
    Student(Student s1){//copy constructor
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0;i<3;i++){
            this.marks[i]=s1.marks[i];
        }
    }

    Student(){
        System.out.println("constructor is called:");
    }
}

class Pen{
   private String color;//attributes
  private  int tip;//attribute
  String getColor(){//getters functions
        return this.color;
    }
    int getTip(){
        return this.tip;
    }
    void setColor(String newColor){//functions or setters
         color=newColor;
    }
    void setTip(int newTip){//functions
        tip=newTip;
    }
}
//Inheritance
//Base class
class Animal{
    String color;
    void eat(){
        System.out.println("animal eats");
    }
    void breathing(){
        System.out.println("amimal also breathes");
    }
}
class Mammal extends Animal{
    int legs;
}
class Dogs extends Mammal{
    String breed;
}
//derived class
class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("animal also swims");
    }
}
//function overLoading
class Calculator{
    int sum(int d,int e){
        return d+e;
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }
    float sum(float a,float b){
        return a+b;
    }
}