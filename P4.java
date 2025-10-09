public class P4 {
    public int sum(int x, int y) {
        return(x + y);
    }
    public int sum(int x, int y, int z) {
        return(x + y + z);
    }
    public double sum(double x, double y) {
        return(x + y);
    }
    
    public static void main(String args[]) {
    P4 s = new P4();
    System.out.println(s.sum(4, 5));
    System.out.println(s.sum(3, 5, 7));
    System.out.println(s.sum(13.2, 23.5));
}
}


