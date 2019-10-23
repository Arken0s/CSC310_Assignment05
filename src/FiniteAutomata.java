import java.util.Scanner;

public class FiniteAutomata {

    public static void main(String[] args) {

//        *********************************
//        ********     Part #1     ********
//        *********************************
/*
        int[][] finAuto1_table = new int[6][3];
        int[] finAuto1_acceptStates = {3,5};
        finAuto1_table[0][0] = 2;
        finAuto1_table[0][1] = 4;
        finAuto1_table[0][2] = 6;

        finAuto1_table[1][0] = 3;
        finAuto1_table[1][1] = 4;
        finAuto1_table[1][2] = 2;

        finAuto1_table[2][0] = 4;
        finAuto1_table[2][1] = 2;
        finAuto1_table[2][2] = 2;

        finAuto1_table[3][0] = 3;
        finAuto1_table[3][1] = 1;
        finAuto1_table[3][2] = 5;

        finAuto1_table[4][0] = 1;
        finAuto1_table[4][1] = 4;
        finAuto1_table[4][2] = 6;

        finAuto1_table[5][0] = 1;
        finAuto1_table[5][1] = 5;
        finAuto1_table[5][2] = 4;


        if (RunProgram(finAuto1_table, "cabcabbc", 4, finAuto1_acceptStates)) {
            System.out.println("The program ended in an accepting state!");
        } else {
            System.out.println("The program did not end in an accepting state!");
        }
*/
//        *********************************
//        ********     Part #2     ********
//        *********************************

        int[][] finAuto2_table = new int[4][3];
        int[] finAuto2_acceptStates = {3};

        finAuto2_table[0][0] = 2;
        finAuto2_table[0][1] = 4;
        finAuto2_table[0][2] = 4;

        finAuto2_table[1][0] = 3;
        finAuto2_table[1][1] = 3;
        finAuto2_table[1][2] = 4;

        finAuto2_table[2][0] = 3;
        finAuto2_table[2][1] = 3;
        finAuto2_table[2][2] = 4;

        finAuto2_table[3][0] = 4;
        finAuto2_table[3][1] = 4;
        finAuto2_table[3][2] = 4;

        Scanner kb = new Scanner(System.in);
        String javaVariable;

        while (true) {
            System.out.println("Type the word you'd like to test and press enter:");
            javaVariable = kb.next();
            System.out.println("**********************");
            if (RunProgram(finAuto2_table, ConvertVariable(javaVariable), 1, finAuto2_acceptStates)) {
                System.out.println("The program ended in an accepting state!");
            } else {
                System.out.println("The program did not end in an accepting state!");
            }
            System.out.println("**********************");
        }
    }

    public static String ConvertVariable (String javaVariable) {
        String convertedInput = "";

        for (char c:javaVariable.toCharArray()) {
            int charASCII = c;
            if (    ((charASCII >= 65) && (charASCII <= 90)) ||
                    ((charASCII >= 97) && (charASCII <= 122)) ||
                    (charASCII == 36) ||
                    (charASCII == 95)) {
                convertedInput = convertedInput + "a";
            } else if ((charASCII >= 48) && (charASCII <= 57)) {
                convertedInput = convertedInput + "b";
            } else {
                convertedInput = convertedInput + "c";
            }
        }
        return convertedInput;
    }

    public static Boolean RunProgram(int[][] stateTable, String inputWord, int initialState, int[] acceptingStates) {
        int currentState = initialState;
        Boolean validEntry = false;


        for (char inputChar:inputWord.toCharArray()) {
            int symbol = (int)inputChar - (int)'a'; //Convert character to int by subtracting a's ASCII value from the characters value. a = 0, b = 1, c = 2, ...
//            System.out.println("current state: " + currentState + ". Symbol: " + symbol);
            currentState = stateTable[currentState - 1][symbol];
        }

        for (int i:acceptingStates) {
            if (currentState == i) {
                validEntry = true;
            }
        }
        return validEntry;
    }

}
