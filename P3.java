import java.util.*;
public class P3 {
  public static void main(String args[]) {
    int A[] = new int[10];
    System.out.println("Enter 10 numbers: ");
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < 10; i++) {
      A[i] = sc.nextInt();
    }
    Arrays.sort(A);
    System.out.println("Smallest value is: " + A[0]);
    System.out.println("Largest value is: " + A[9]);
  }
}