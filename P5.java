import java.util.*;

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();
        int[] pages = new int[n];

        System.out.println("Enter the page numbers:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        int frameSize = 4;
        int[] frame = new int[frameSize];
        Arrays.fill(frame, -1);

        int hit = 0, fault = 0, pointer = 0;

        for (int page : pages) {
            boolean isHit = false;

            for (int f : frame) {
                if (f == page) {
                    hit++;
                    isHit = true;
                    break;
                }
            }

            if (!isHit) {
                frame[pointer] = page;
                pointer = (pointer + 1) % frameSize;
                fault++;
            }
        }

        System.out.println("\nTotal Hits: " + hit);
        System.out.println("Total Faults: " + fault);

        sc.close();
    }
}