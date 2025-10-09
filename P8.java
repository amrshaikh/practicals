import java.io.*;
interface mycalc {
    int Add(int x, int y);
    int Sub(int x, int y);
    int Mul(int x, int y);
    int Div(int x, int y);
}
class test implements mycalc {
    public int Add(int x, int y) {
        return x + y;
    }
    public int Sub(int x, int y) {
        return x - y;
    }
    public int Mul(int x, int y) {
        return x * y;
    }
    public int Div(int x, int y) {
        return x / y;
    }
}

class P8 {
    public static void main(String args[]) {
        test obj = new test();
        System.out.println("Add: " + obj.Add(5,8));
        System.out.println("Subtract: " + obj.Sub(5,8));
        System.out.println("Multiply: " + obj.Mul(5,8));
        System.out.println("Divide: " + obj.Div(5,2));
    }
}
