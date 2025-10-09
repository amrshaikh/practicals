public class P11 {
    static int score = 98;
    public static int sum(int x, int y) {
        return(x + y);
    }
    public static int multiply(int x, int y) {
        return(x * y);
    }
    public static int divide(int x, int y) {
        score++;
        if(y != 0)
            return(x / y);
        else
            return 0;
    }
    public static void main(String args[]) {
        P11 s = new P11();
        System.out.println("Score value is: " + score);
        System.out.println(s.sum(20, 40));
        System.out.println(s.multiply(2, 4));
        System.out.println(s.divide(20, 4));
        System.out.println("Score value is: " + score);
    }
}
