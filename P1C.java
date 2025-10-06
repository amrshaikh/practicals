import java.util.*;
class test1 extends Thread {
    String name;
test1 (String threadname) {
    name = threadname;
}
public void run() {
evenodd();
}
public void evenodd() {
    System.out.println(name);
    try {
        for (int i = 0; i <= 10; i++) 
        {
            if(i%2==0) {
                System.out.println(i + " Even");
            } else 
            {
                System.out.println(i + " Odd");
            }
            this.sleep( 1000);
        }
        } catch (Exception e) {
        }
    }
}

class test2 extends Thread {
    String name;
    test2(String threadname){
        name=threadname;
    }
    public void run(){
        reverse();
    }
    public void reverse(){
        System.out.println(name);
        System.out.println("Enter Friend's Name:");
        Scanner sc = new Scanner(System.in);
        String friendname = sc.next(); 
        StringBuffer sb = new StringBuffer(friendname);
        System.out.println("Friend name reversed is: " + sb.reverse());
    }
}
public class P1C {
    public static void main(String[] args) {
      try{
          test1 t1=new test1("Thread1: EvenOdd");
          t1.start();
          t1.join();
          
          test2 t2=new test2("Thread2: Friend name reverse");
          t2.start();
          t2.join();
      }catch(Exception e){
          System.out.println(e);
        }
    }
}