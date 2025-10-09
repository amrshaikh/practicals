import java.util.*;
public class P10 {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 2 numbers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = a / b;
            System.out.println(a + " / " + b + " = " + c);
        }
        catch(Exception e) {
            System.out.println("Don't divide by 0 " + e);
        }
    }
}