
package test.pkgclass;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;
/**
 *
 * @author NoorAlMAllah
 *
 *
 */
    
 
class ID {
private int ID;
private int i=1;
double cost;

public ID(){
    }

 public void setID(int ID){
this .ID=ID;
}
 
 public int getID(){return ID;}
  
 public void seti(int i){this.i=i;}
public int geti(){return i;}
  }
 

class Permit{
 String Permit;
 double cost;
}

 class Car{
     private int Seats;
     public  ID  ID;
     private String Driver;//the name of the driver
     private double S_Price;//price of 1 seat
      Permit Permit;//for example : Jenin.qabatia
     private int Passengers;
     
    
     Car(){ };
     
     Car(int seats,int id ,String driver ,double S_Price,String permit){
         this.Seats=seats;
      ID=new ID ();
    Permit =new Permit();
     
      ID.setID(id);
      
        this.Driver=driver;
        this.S_Price=S_Price;
        Permit.Permit=permit;
         
     }
     public void setSeats(int Seats){this.Seats=Seats;}
     
     //public void setID(int ID){this.ID=ID;}
     
     public void setDriver(String Driver){this.Driver=Driver;}
     
     public void setPrice(double S_Price){this.S_Price=S_Price;}
     
     //public void setPermit(String Permit){this.Permit=Permit;}
      
 
     public int getSeats(){return Seats;}
     
     //public int getID(){return ID;}
     
     public String getDriver(){return Driver;}
     
     public double getPrice(){return S_Price;}
     
     //public String getPermit(){return Permit;}
       
     
     public void SetPassengers(int Passengers){this.Passengers=Passengers;}
     public int getPassengers(){return Passengers;}
     public double getCostCar(){return (getPassengers()*getPrice());}
     public void printDetails(){
         System.out.println("Car ID ="+ID.getID());
         System.out.println("Car #Seats ="+getSeats());
         System.out.println("Car Driver ="+getDriver());
         System.out.println("Car SeatPrice ="+getPrice());
         System.out.println("Car Permit ="+Permit.Permit);
         System.out.println("This Car have entered the Garrage for "+ID.geti()+"times");
         System.out.println("The ID cost is = to "+ID.cost);
         System.out.println("The Cost Permit have for the car have leaced"
                 + " =" +Permit.cost);
     }
     /*public boolean equals(Car c){
         if(this.Driver.equalsIgnoreCase(c.Driver) && this.Seats==c.Seats &&
                 this.S_Price==c.S_Price && this.Permit.equalsIgnoreCase(c.Permit) && this.ID==c.ID)return true;
         return false;
     }*/
     
     
     
     
}


class Garage {
Queue <Car> Gar= new LinkedList<Car>();
 Scanner keypord=new Scanner(System.in);

ArrayList<Car> a=new<Car> ArrayList();


double Total;

public Garage(){


Total=0;//total Cost
}

public boolean isFull(){return (Gar.size()==50);}
 
 public void Add( int Seats,int ID,String Driver,double Price,String Permit) {
  Car C1=new Car(Seats,ID,Driver,Price,Permit);
  
  if (isFull())System.out.print("Full Garrage");
      else
      while(SearchCar(C1.ID.getID())!=null){
System.out.println("Incorrect Entered Id enter anothor ");
  int id;
  id=keypord.nextInt();
  C1=new Car(Seats,id,Driver,Price,Permit);
  }//Gar =new LinkedList(q);
  Gar.offer(C1); 
  for (int i=0;i<a.size();i++){
             if(a.get(i).ID.getID()==C1.ID.getID()){C1.ID.seti(C1.ID.geti()+1);
   
             C1.ID.cost+=a.get(i).getCostCar();
             
             
 }
  
  if(a.get(i).Permit.Permit.equals(C1.Permit.Permit))C1.Permit.cost+=a.get(i).getCostCar();
          
 
 }}
 public void leave(){
 Car c;
     if(Gar.isEmpty())System.out.print("emptyGarrage");
     else{System.out.println("The car which have these Details");
        
         (c=Gar.poll()).printDetails();
         a.add(c);
         
         System.out.println("Have Leave The Garrage");
         int no;
          
 System.out.println("Enter # of Passengers which less than "+c.getSeats());
 no=keypord.nextInt();
 while(no>c.getSeats()){System.out.println("The # should be less than "+c.getSeats());
 no =keypord.nextInt();
 
 }
 c.SetPassengers(no);
 Total+=c.getCostCar();

        
     }
          
}
 
 public void RetriveCar(){
     if(Gar.isEmpty())System.out.print("emptyGarrage");
     else Gar.peek().printDetails();
      
 }
 
 void swap(int ID1, int ID2){
                 ArrayList<Car>l=new ArrayList<Car>(Gar);
               if(SearchCar(ID1)==null ||SearchCar(ID2)==null )System.out.print("Car Not Found ");
               else{
               
                Collections.swap(l, l.indexOf(SearchCar(ID1)), l.indexOf(SearchCar(ID2)));
                
                
               }Gar=new LinkedList(l);
               l.clear();
		}
	
 
 void ShiftRight(){
    ArrayList<Car>l=new ArrayList<Car>(Gar);
 
/* Car item;
Stack<Car>s1,s2;
s1=new Stack<Car>();
s2=new Stack<Car>();
while(!Gar.isEmpty()){
    item =Gar.peek();
    s1.push(item);
    Gar.poll();
   
}
if(s1.isEmpty()){
    item=s1.peek();
    Gar.add(item);
    s1.pop();
}
while (!s1.empty()){
   item= s1.peek();
   s2.push(item);
   s1.pop();
}
while (!s2.isEmpty()){
    item=s2.peek();
    Gar.add(item);
    s2.pop();
}*/
Collections.rotate(l, 1);
Gar=new LinkedList(l);
l.clear();

 }//End of 
 
 void shiftLeft(){
     ArrayList l=new ArrayList(Gar);
     
    Collections.rotate(l, -1);
    Gar=new LinkedList(l);
    l.clear();
 /*
    Queue<Car>q=new LinkedList<Car>();
    Queue<Car>q2=new LinkedList<Car>();
    if (!Gar.isEmpty())q2.add(Gar.peek());
    
    while (!Gar.isEmpty()){
        q.add(Gar.peek());
        Gar.poll();
    }
    
    while(!q.isEmpty())
        Gar.add(q.peek());
    
    while (!q.isEmpty())
    Gar.add(q.poll());
    
    
    while (!q2.isEmpty())Gar.add(q2.poll());
    
    }
        
   */
    }

 void InfoAll(){
     int i=1;
 
     Car c;
     Queue<Car> q =new LinkedList<Car>(Gar);
     
     while (!Gar.isEmpty()){
     c =Gar.peek();
     System.out.println("Car Number "+i+" Have These Details\n " );
     c.printDetails();
     Gar.poll();
     i++;
     }
     
     Gar = new LinkedList<Car>(q);
     q.clear();
 
 }
 
     
 
 public void printinfo(){
     
 int ID;
 System.out.println("Enter Id of The Car");
 ID =keypord.nextInt();
 Queue<Car>q=new LinkedList(Gar);
 
 

 while(!Gar.isEmpty()){
     if(Gar.peek().ID.getID()==ID)
         Gar.peek().printDetails();
     Gar.poll();
           
 }
Gar= new LinkedList<Car>(q);
q.clear();
 }
 
 
 public void getCostCarID(){
  int id;    
 System.out.println("Enter id");
id = keypord.nextInt();
 if(SearchCar(id)==null){System.out.print("id Not found");}
 else {
 Car c=SearchCar(id);
  System.out.println( c.getCostCar());}
 
 }
 
 
 
 public Car SearchCar(int ID){
     Car c;
     Queue<Car>q=new LinkedList(Gar);
     
     while(!Gar.isEmpty()){
     if((c=Gar.peek()).ID.getID()==ID){Gar =new LinkedList(q);q.clear();return c;} 
     Gar.poll();
           
 }
  Gar=new LinkedList<Car>(q);q.clear();   return null;
 }
 
 
 /*public void setPasCar(){
   int ID;
     Car C=null;
 System.out.println("Enter Id of The Car");
 ID =keypord.nextInt();
 Queue<Car>q=new LinkedList(Gar);
 
 

 while(!Gar.isEmpty()){
     if(Gar.peek().ID.getID()==ID)
         C =Gar.peek();
         
     Gar.poll();
           
 }
 
Gar= new LinkedList<Car>(q);
 q.clear();
 if(C==null)System.out.println("No Id found");
 else{ 
     int no;
          
 System.out.println("Enter # of Passengers which less than "+C.getSeats());
 no=keypord.nextInt();
 while(no>C.getSeats()){System.out.print("The # should be less than "+C.getSeats());
 no =keypord.nextInt();
 
 }
 C.SetPassengers(no);
 
 }//Gar=new LinkedList(q);
 }
 */
 
 
 
 /*double Totalcost(){
     Car item;
     Queue<Car> q=new<Car> LinkedList(Gar);
 
      while (!Gar.isEmpty())
     {item=Gar.peek();
     Total+=item.getCostCar();
     Gar.poll();
     
     }
     Gar =new LinkedList(q);
     q.clear();
     return Total;}*/
 
//End of The Class Garrage


 /*double CostForPermit(){
Car item;
String Permit;
double CostPermit=0;
Queue<Car> q=new <Car>LinkedList(Gar);
System.out.println("Enter Permit");
Permit=keypord.nextLine();




while (!Gar.isEmpty())
{if(Gar.peek().getPermit().equalsIgnoreCase(Permit))
CostPermit+=Gar.peek().getCostCar();
Gar.poll();
        }
Gar = new LinkedList(q);

return CostPermit; 

}*/
}

 
public class TestClass {
           int Seats;   Scanner input=new Scanner(System.in);  
        String name ;
        int ID;
        double Price;
        String Permit;
        
    
         Garage G = new Garage();
       Character ch = new Character(' ');
       
        
    /**
     * @param args the command line arguments
     */
    
    public void menu(){
        
     String s=ch.toString();
    
      
      do {
          
            System.out.println("Please enter your choice");
            System.out.println("Welcome");
            
          
      System.out.println("1 : Add Car\n2 Delete Car\n3 : Retrive Car\n4 : Swap\n5 : SeachInfo\n6 : AllInfo\n7 : ShiftRight\n8 : Shift Left\n9 :  AllCost\n10 : End\n");
      s = input.nextLine();
        switch(s){
       
            case "1" : {System.out.println("Enter ID ");
            ID = input.nextInt();
            
            System.out.println("Enter #seats ");
            Seats=input.nextInt();
            System.out.println("Enter Price of Seat");
            Price=input.nextDouble();
            System.out.println("enter Permit");
            Permit=input.next();
            System.out.println("Enter name ");
            name = input.next();
            G.Add(Seats, ID, name,Price, Permit);}
            break;
            
            case "2" :
           
                G.leave(); break;
                
         case "3" : G.RetriveCar(); break;
            
            case "4" :  int ID1,ID2;
                System.out.println("Enter ID 1");
                ID1=input.nextInt();
                System.out.println("Enter ID 2");
                ID2= input.nextInt();
            G.swap(ID1, ID2);break;
            case "5" :
                 G.printinfo();break;
            
            
            
            case "6": G.InfoAll();break;
              
            
            case "7": G.ShiftRight();break;
            
            case "8" :G.shiftLeft();break;
            
          
            
            case "9":System.out.print("Total Cost in the Garrage ="+G.Total); break;
            
          
            
         
            
            
            
            
        }  
                
    }while (!(s.equals("10")));
      System.out.println(" bbye");
    }
    public static void main(String[] args) {
     TestClass t= new TestClass();
      t.menu();
      
      
        
    }
    
}
