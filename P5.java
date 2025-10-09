import java.util.*;
class Student {
    int rollno, m1, m2, m3;
    String sname;
    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter roll no, marks of 3 subjects, name: ");
        rollno = sc.nextInt();
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();
        sname = sc.next();
    }
    public Student(String a, int b, int c, int d, int e) {
        sname = a;
        m1 = b;
        m2 = c;
        m3 = d;
        rollno = 3;
    }
    public void calculate() {
        int avg;
        avg = (m1 + m2 + m3) / 3;
        System.out.println("name: " + sname);
        System.out.println("marks: " + m1 + " " + m2 + " " + m3);
        System.out.println("average: " + avg);
    }
}
public class P5 {
    public static void main(String args[]) {
        Student s1 = new Student();
        Student s2 = new Student("Max", 78, 98, 67, 33);
        s1.calculate();
        s2.calculate();
    }
}