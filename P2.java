import java.util.*;
public class P2 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        
        int n,AT[],BT[],WT[],TAT[],ST[],FT[];
        float AWT=0,AVGTAT=0;
        System.out.println("Enter No. Of Processes: ");
        n=sc.nextInt();
        
        AT=new int[n];
        BT=new int[n];
        FT=new int[n];
        ST=new int[n];
        WT=new int[n];
        TAT=new int[n];
        
        System.out.println("---------------");
        for (int i=0;i<n;i++)
        {
            System.out.println("Enter Burst Time for process"+(i+1)+":");
            BT[i]=sc.nextInt();
        }
        System.out.println("----------------");
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Arrival Time for process"+(i+1)+":");
            AT[i]=sc.nextInt();
        }
        WT[0]=0;
        for(int i=1;i<n;i++)
        {
            ST[i]=ST[i-1]+BT[i-1];
            WT[i]=ST[i]-AT[i];
 
        }
        for(int i=0;i<n;i++) {
            FT[i]=ST[i]+BT[i];
            TAT[i]=FT[i]-AT[i];
            AWT=AWT+WT[i];
            AVGTAT=AVGTAT+TAT[i];
        }  
        System.out.println("-----------------");
        System.out.println("PR BT ST FT WT TAT");
        for(int i=0;i<n;i++)
        {
            System.out.println(i+" "+BT[i]+" "+ST[i]+" "+FT[i]+" "+WT[i]+" "+TAT[i]);
        }
        AWT=AWT/n;
        AVGTAT=AVGTAT/n;
        System.out.println("--------------\n Avg. Waiting Time: "+AWT+"\n-----------");
        System.out.println("--------------\n Avg. Turn around time: "+AVGTAT+"\n-----------");
}
}