import java.util.*;
public class P9A {
    public static void main(String args[]) {
        List <String> li = new ArrayList <String>();
        li.add("Max");
        li.add("Charles");
        li.add("Lewis");
        li.add("Oscar");
        System.out.println("list: " + li);
        System.out.println("index 1: " + li.get(1));
        li.set(1, "George");
        System.out.println("updated: " + li);
        li.remove("Oscar");
        System.out.println("after removing: " + li);
        li.clear();
        System.out.println("clear: " + li);
    }
}