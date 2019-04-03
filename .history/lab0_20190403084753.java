/* I/O Libraries */
import java.io.*; 
import java.util.Scanner;
import java.util.Formatter;

class algorithms{
    public static void linearAlgorithm(long n){
        int startTimeLinear = System.nanoTime();
        int endTimeLinear = 0;
        for(int x = 1; x < n; x++){
            ;
        }
        endTimeLinear = System.nanoTime();
        System.out.println("RunTimeLinear: " + (endTimeLinear-startTimeLinear));
    }

    public static void quadraticAlgorithm(long n){
        int startTimeQuadratic = System.nanoTime();
        int endTimeQuadratic = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++)
                ;
        }
        endTimeQuadtric = System.nanoTime();
        System.out.println("RunTimeQuadratic:" + (endTimeQuadratic-startTimeQuadratic));
        
    }

    public static void cubicAlgorithm(long n){
        int startTimeCubic = System.nanoTime();
        int endTimeCubic = 0;
        for(int i = 1; i < n; i++)
            for(int j = 1; j < n; j++)
                for(int k = 1; k< n; k++)
                    ;
        endTimeCubic = System.nanoTime();
        System.out.println("RunTimeCubic:" + (endTimeCubic-startTimeCubic));
    }

    public static void logarithmicAlgorithm(long n){
        int startTimeLog = System.nanoTime();
        int endTimeLog = 0;
        int i = n;
        while(i!=1)
            i = i/2;
    }

    public static void NlogNAlgorithm(long n){
        int startTimeNlog = System.nanoTime();
        int endTimeNlog = 0;
        int j = n;
        for(int i = 1; i < n; i++)
            while(j!=1)
                j = j/2;
    }
}


class RunTimes{
    public int i;
    public int j;
    public int k;
    public  void main(String args[]) throws IOException, IllegalArgumentException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N Value: ");
        String userInput = sc.nextLine();

        long n;     // user input option                             

        /* loop until quit */
        while ((n = userInput.charAt(0)) != 'q') {

                System.out.println("Running with N: " + n);
                linearAlgorithm(n);
                quadraticAlgorithm(n);
                cubicAlgorithm(n);
                logarithimcAlgorithm(n);
                NlogNAlgorithm(n);
                //printRunTimes();
            userInput = sc.nextLine();
        }
        
        sc.close();
        
        System.exit(0);
    }

}