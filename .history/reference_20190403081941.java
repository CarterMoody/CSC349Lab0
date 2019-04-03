/*
    Name:         Robert Hensley, Carter Moody
    Section:      09
    Description:  MIPS simulator (with pipelines)
*/

/* I/O Libraries */
import java.io.*; 
import java.util.Scanner;

/* Objects */
import java.lang.String;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

class pipe {
    public String opcode;
    public Boolean oneSquash = false;
    public Boolean threeSquash = false;
    public Boolean stall = false;
    public int pc = 0;

    pipe(String opcode, int pc) {
        this.opcode = opcode;
        this.pc = pc;
    }
}

class Globals {
    /* Constants */

    public static final String ARGS_ERROR = "\nUse the following command line arguments -> java lab4 file.asm";
    public static final String LABEL_ERROR = "\nLabel incorrectly formatted (must be alphanumeric): ";
    public static final int MEMORY_SIZE = 8192;

    /* Variables */
    /* Note: order of register placement matters for dumping */
    public static Map<String, Integer> registerMap = new LinkedHashMap<String, Integer>() {{
        
        put("pc", 0);   // pc register

        put("$0", 0);   // zero register

        /* return registers */
        put("$v0", 0);
        put("$v1", 0);

        /* function arguments */
        for(int i = 0; i < 4; i++)
            put("$a" + i, 0);  

        /* temporary registers */
        for(int i = 0; i < 8; i++)
            put("$t" + i, 0);  

        /* saved registers */
        for(int i = 0; i < 8; i++)
            put("$s" + i, 0);  

        /* more temporary registers */
        put("$t8", 0);
        put("$t9", 0);     

        put("$sp", 0);  // stack pointer

        put("$ra", 0);  // return address
        
    }};

    public static LinkedList<pipe> pipelineList = 
        new LinkedList<pipe>(Arrays.asList(
            new pipe("empty", 0),
            new pipe("empty", 0),
            new pipe("empty", 0)
        ));
        
    public static Map<String, Integer> labelMap = new HashMap<String, Integer>();
    /* Lab 3 Objects */
    public static int[] memory = new int[MEMORY_SIZE];
    public static ArrayList<inst> instList = new ArrayList<inst>();

    public static int Cycles = 1;
    public static int Instructions = 0; // Used instead of 
    public static int pipePC = 0;

    public static int totalBranches;
    public static int takenBranches;
    public static int GHRSize;
    public static int[] GHR;
    public static Map<Integer, Integer> predictionTable = new HashMap<Integer, Integer>() {{
    }};
    public static int correctPredictions = 0;
    public static int incorrectPredictions = 0;



}

class lab5 {

    /* Methods */

    // parses an asm file
    private static void read_asm(String asm_file) throws IOException {

        ArrayList<String> code = new ArrayList<String>();

        /* File I/O */
        File file = new File(asm_file);
        Scanner sc = null;

        /* Pass 1 Objects */
        String line;
        String labelList[];

        /* Pass 2 Objects */
        String opcode;
        String commandLine[];
        int lineNo = 1;

        try { 
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Caught IOException: " + e.getMessage());
            System.exit(1);
        }

        /* Pass 1 

            - loop through file
                - remove whitespace and remove comment lines
                - search if colon exists in each line
                    - if it exists, get contents before colon (remove space)
                    - create label object and append it to the label array

        */ 

        while (sc.hasNextLine()) {

            /* read in a line while removing comments */
            line = sc.nextLine();
            
            if(line.equals("#")) {
                line = "";
            } else {
                line = line.split("#")[0];
            }

            /* add labels to HashMap */
            if(line.contains(":")) {
                labelList = line.split(":");

                labelList[0] = labelList[0].replaceAll("\\s", "");
            
                if(!labelList[0].matches("[a-zA-Z0-9]+")) {
                    throw new IOException(Globals.LABEL_ERROR + labelList[0]);
                }
                
                Globals.labelMap.put(labelList[0], code.size() + 1);
                
                if(labelList.length == 2) {
                    line = labelList[1];
                } else {
                    line = "";
                }
            } 
            
            /* add line if it's not blank */
            if(!line.replaceAll("\\s", "").equals("")) {
                code.add(line);
            }
        }

        sc.close();

        /* Pass 2: loop through array of instructions and create instruction objects */

        for(String inst : code) {
            inst = inst.trim();             // trim Leading and Trailing Whitespace
            if(inst.charAt(0) == 'j') {
                commandLine = inst.split("\\s");
                opcode = commandLine[0];
                commandLine = Arrays.copyOfRange(commandLine, 1, commandLine.length);     // Remove first element (opcode) from Command Line Array
            } else {
                commandLine = inst.replaceAll("\\s", "").split(",");
                opcode = commandLine[0].split("\\$")[0];
                commandLine[0] = '$' + commandLine[0].split("\\$")[1];
            }

            Globals.instList.add(new inst(opcode, commandLine, lineNo));

            lineNo++;
        }
    }

    public static void main(String args[]) throws IOException, IllegalArgumentException {

        int intTest;

        if(!(args.length == 1 || args.length == 2 || args.length == 3)) {
            throw new IllegalArgumentException(Globals.ARGS_ERROR);
        }

        read_asm(args[0]);      // build instruction objects

        /* select mode */
        if (args.length == 3) {
            Globals.GHRSize = Integer.parseInt(args[2]);
            interactive.runScript(args[1]);
        }
        
        if (args.length == 2) {
            try{
                intTest = Integer.parseInt(args[1]);
                Globals.GHRSize = intTest;
                interactive.interactiveLoop();
            } catch (NumberFormatException nfe){
                Globals.GHRSize = 2;
                interactive.runScript(args[1]);
            }
        } else {
            Globals.GHRSize = 2;
            interactive.interactiveLoop();
        }

    }  
    
}