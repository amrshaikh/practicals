import java.util.*;
class vehicle {
    vehicle() {
        System.out.println("this is a vehicle");
    }
}
class car extends vehicle {
    car() {
        System.out.println("this is car");
    }
}
public class P6 {
    public static void main(String args[]) {
        car obj = new car();
    }
}
