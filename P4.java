import java.util.*;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n]; 
        int[] rt = new int[n]; 
        int[] wt = new int[n]; 
        int[] tat = new int[n]; 
        int[] ct = new int[n]; 

        System.out.println("Enter burst times:");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }

        System.out.print("Enter time quantum: ");
        int quantum = sc.nextInt();

        int time = 0;
        boolean done;

        System.out.println("\nGantt Chart:");
        System.out.print("0");

        while (true) {
            done = true;

            for (int i = 0; i < n; i++) {
                if (rt[i] > 0) {
                    done = false;

                    if (rt[i] > quantum) {
                        time += quantum;
                        rt[i] -= quantum;
                        System.out.print(" -> P" + (i + 1) + " -> " + time);
                    } else {
                        time += rt[i];
                        rt[i] = 0;
                        ct[i] = time;
                        System.out.print(" -> P" + (i + 1) + " -> " + time);
                    }
                }
            }

            if (done) break;
        }

        float totalWT = 0, totalTAT = 0;
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i]; // Since AT = 0
            wt[i] = tat[i] - bt[i];
            totalWT += wt[i];
            totalTAT += tat[i];
        }

        System.out.println("\n\nProcess  BT  CT  WT  TAT");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%-7d%-4d%-4d%-4d%-4d\n", (i + 1), bt[i], ct[i], wt[i], tat[i]);
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT / n);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTAT / n);

        sc.close();
    }
}