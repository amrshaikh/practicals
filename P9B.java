import java.util.*;
public class P9B {
    public static void main(String args[]) {
        Set <String> obj1 = new HashSet <String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 stuff");
        for(int i = 0; i < 4; i++) {
            String x = sc.nextLine();
            obj1.add(x);
        }
        System.out.println("set: " + obj1);
        System.out.println("size of set: " + obj1.size());
        
        Set <String> obj2 = new TreeSet <String>(obj1);
        System.out.println("sorted set: " + obj2);
        System.out.println("which element to remove: ");
        String z = sc.nextLine();
        obj2.remove(z);
        System.out.println("after removing: " + obj2);
        obj2.clear();
        System.out.println("clear: " + obj2);
    }
}
