/* I/O Libraries */
import java.io.*; 
import java.util.Scanner;
import java.util.Formatter;

class algorithms{
    public static void linearAlgorithm(long n){
        long startTimeLinear = System.nanoTime();
        long endTimeLinear = 0;
        long runTime;
        long someVariable;
        for(long x = 1; x < n; x++){
            someVariable = 1;
        }
        endTimeLinear = System.nanoTime();
        runTime = (endTimeLinear-startTimeLinear) / 1000000;
        System.out.println("RunTimeLinear: " + (runTime));
    }

    public static void quadraticAlgorithm(long n){
        long startTimeQuadratic = System.nanoTime();
        long endTimeQuadratic = 0;
        long runTime;
        long someVariable;
        for(long i = 1; i < n; i++){
            for(long j = 1; j < n; j++)
                someVariable = 1;
        }
        endTimeQuadratic = System.nanoTime();
        runTime = (endTimeQuadratic-startTimeQuadratic) / 1000000;
        System.out.println("RunTimeQuadratic:" + runTime);
        
    }

    public static void cubicAlgorithm(long n){
        long startTimeCubic = System.nanoTime();
        long endTimeCubic = 0;
        long runTime;
        long someVariable;
        for(long i = 1; i < n; i++)
            for(long j = 1; j < n; j++)
                for(long k = 1; k< n; k++)
                    someVariable = 1;
        endTimeCubic = System.nanoTime();
        runTime = (endTimeCubic-startTimeCubic) / 1000000;        
        System.out.println("RunTimeCubic:" + runTime);
    }

    public static void logarithmicAlgorithm(long n){
        long startTimeLog = System.nanoTime();
        long endTimeLog = 0;
        long i = n;
        long runTime;
        long someVariable;
        while(i!=1){
            someVariable = 1;
            i = i/2;
        }
            
        endTimeLog = System.nanoTime();
        runTime = (endTimeLog-startTimeLog) / 1000000;
        System.out.print("RunTimeLogN:");
        System.out.println(runTime);
    }

    public static void NlogNAlgorithm(long n){
        long startTimeNlog = System.nanoTime();
        long endTimeNlog = 0;
        long j = n;
        long runTime;
        long someVariable;
        for(long i = 1; i < n; i++){
            j = n;
            while(j!=1){
                j = j/2;
                someVariable = 1;
            }
        }
        endTimeNlog = System.nanoTime();
        //System.out.println("StartTime: " + System.nanoTime());
        //System.out.println("EndTime: " + System.nanoTime());
        runTime = (endTimeNlog-startTimeNlog) / 1000000;
        System.out.println("RunTimeNlogN:" + (runTime));
    }
}


class RunTimes{
    public long i;
    public long j;
    public long k;
    public static void main(String args[]) throws IOException, IllegalArgumentException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N Value: ");
        //String userInput = sc.nextLine();

        long n;     // user input option                             

        /* loop until quit */
        //while ((n = sc.nextInt() != 'q')) {
        while (1){
                n = sc.nextInt();

                System.out.print("Running with N: ");
                System.out.println(n);
                algorithms.linearAlgorithm(n);
                algorithms.quadraticAlgorithm(n);
                algorithms.cubicAlgorithm(n);
                algorithms.logarithmicAlgorithm(n);
                algorithms.NlogNAlgorithm(n);
                //printRunTimes();
            System.out.print("Enter N Value: ");
            userInput = sc.nextLine();
        }
        
        sc.close();
        
        System.exit(0);
    }

}