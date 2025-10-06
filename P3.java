import java.util.*;

class Process {
    int id, arrivalTime, burstTime, startTime, finishTime, waitingTime, turnAroundTime;
}

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];

        for (int i = 0; i < n; i++) {
            processes[i] = new Process();
            processes[i].id = i + 1;
            System.out.print("Enter Arrival Time for Process " + (i + 1) + ": ");
            processes[i].arrivalTime = sc.nextInt();
            System.out.print("Enter Burst Time for Process " + (i + 1) + ": ");
            processes[i].burstTime = sc.nextInt();
        }

        // Sort by Arrival Time first
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        List<Process> completed = new ArrayList<>();

        while (completed.size() < n) {
            List<Process> available = new ArrayList<>();

            for (Process p : processes) {
                if (!completed.contains(p) && p.arrivalTime <= currentTime) {
                    available.add(p);
                }
            }

            if (available.isEmpty()) {
                currentTime++;
                continue;
            }

            // Select process with shortest burst time
            Process next = Collections.min(available, Comparator.comparingInt(p -> p.burstTime));
            next.startTime = currentTime;
            next.finishTime = next.startTime + next.burstTime;
            next.waitingTime = next.startTime - next.arrivalTime;
            next.turnAroundTime = next.finishTime - next.arrivalTime;

            currentTime = next.finishTime;
            completed.add(next);
        }

        float totalWT = 0, totalTAT = 0;
        System.out.println("\nID  AT  BT  ST  FT  WT  TAT");
        for (Process p : completed) {
            System.out.printf("%2d  %2d  %2d  %2d  %2d  %2d   %2d\n",
                p.id, p.arrivalTime, p.burstTime, p.startTime, p.finishTime, p.waitingTime, p.turnAroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnAroundTime;
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT / n);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTAT / n);
    }
}