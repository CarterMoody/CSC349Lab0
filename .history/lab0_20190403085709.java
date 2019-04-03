/* I/O Libraries */
import java.io.*; 
import java.util.Scanner;
import java.util.Formatter;

class algorithms{
    public static void linearAlgorithm(long n){
        long startTimeLinear = System.nanoTime();
        long endTimeLinear = 0;
        long runTime;
        for(long x = 1; x < n; x++){
            ;
        }
        endTimeLinear = System.nanoTime();
        runTime = (endTimeLinear-startTimeLinear) / 1000000;
        System.out.println("RunTimeLinear: " + (runtime));
    }

    public static void quadraticAlgorithm(long n){
        long startTimeQuadratic = System.nanoTime();
        long endTimeQuadratic = 0;
        long runTime;
        for(long i = 1; i < n; i++){
            for(long j = 1; j < n; j++)
                ;
        }
        endTimeQuadratic = System.nanoTime();
        runTime = (endTimeQuadratic-startTimeQuadratic) / 1000000;
        System.out.println("RunTimeQuadratic:" + runTime);
        
    }

    public static void cubicAlgorithm(long n){
        long startTimeCubic = System.nanoTime();
        long endTimeCubic = 0;
        long runTime;
        for(long i = 1; i < n; i++)
            for(long j = 1; j < n; j++)
                for(long k = 1; k< n; k++)
                    ;
        endTimeCubic = System.nanoTime();
        runTime = (endTimeCubic-startTimeCubic) / 1000000;        
        System.out.println("RunTimeCubic:" + runTime);
    }

    public static void logarithmicAlgorithm(long n){
        long startTimeLog = System.nanoTime();
        long endTimeLog = 0;
        long i = n;
        long runtime;
        while(i!=1)
            i = i/2;
        endTimeLog = System.nanoTime();
        runTime = (endTimeCubic-startTimeCubic) / 1000000;
        System.out.println("RunTimeLogN:" + (runtime));
    }

    public static void NlogNAlgorithm(long n){
        long startTimeNlog = System.nanoTime();
        long endTimeNlog = 0;
        long j = n;
        long runtime;
        for(long i = 1; i < n; i++)
            while(j!=1)
                j = j/2;
        endTimeNlog = System.nanoTime();
        runTime = (endTimeCubic-startTimeCubic) / 1000000;
        System.out.println("RunTimeNlogN:" + (runtime));
    }
}


class RunTimes{
    public long i;
    public long j;
    public long k;
    public static void main(String args[]) throws IOException, IllegalArgumentException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N Value: ");
        String userInput = sc.nextLine();

        long n;     // user input option                             

        /* loop until quit */
        while ((n = userInput.charAt(0)) != 'q') {

                //System.out.println("Running with N: ");
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