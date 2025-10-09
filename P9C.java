import java.util.*;
public class P9C {
    public static void main(String args[]) {
        Map <String, Integer> obj = new HashMap <String, Integer>();
        obj.put("Ferrari", 1);
        obj.put("Mercedes", 2);
        obj.put("Nissan", 3);
        obj.put("Pagani", 4);
        obj.put("Mazda", 5);
        System.out.println("map elements: " + obj);
        System.out.println("map size: " + obj.size());
        System.out.println("map values: " + obj.keySet());
        obj.remove("Mazda");
        System.out.println("after removing: " + obj);
        System.out.println("is set empty: " + obj.isEmpty());
        obj.clear();
        System.out.println("clear: " + obj);
    }    
}
