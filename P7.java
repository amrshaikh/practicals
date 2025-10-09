import java.util.Scanner;
class Department {
    int deptid;
    String deptname;
    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Department ID: ");
        deptid = sc.nextInt();
        System.out.println("Enter department name: ");
        deptname = sc.next();
    }
}
class Employee extends Department {
    static int empid, yrofexp, basicsalary;
    String empname, designation;
    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("- - - - -");
        System.out.println("Enter employee ID: ");
        empid = sc.nextInt();
        System.out.println("Enter employee name: ");
        empname = sc.next();
        System.out.println("Enter employee years of exp: ");
        yrofexp = sc.nextInt();
        System.out.println("Enter employee salary: ");
        basicsalary = sc.nextInt();
        System.out.println("Enter employee designation: ");
        designation = sc.next();
    }
}

class Commission extends Employee {
    int noofwrkhrs, commissionamt;
    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("- - - - -");
        System.out.println("Enter no of working hours: ");
        noofwrkhrs = sc.nextInt();
        commissionamt = noofwrkhrs * 500;
        System.out.println("- - - - -");
        int netsal = basicsalary + commissionamt;
        System.out.println("net salary: " + netsal);
    }
}
public class P7 {
    public static void main(String args[]) {
        Department obj = new Department();
        obj.getdata();
        obj = new Employee();
        obj.getdata();
        obj = new Commission();
        obj.getdata();
    }
}
